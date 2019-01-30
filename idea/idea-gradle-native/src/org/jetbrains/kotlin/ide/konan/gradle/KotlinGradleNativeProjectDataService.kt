/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ide.konan.gradle

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.vfs.VfsUtil
import org.jetbrains.kotlin.konan.library.info.LiteKonanLibraryInfoProvider

/**
 * Adds names for Kotlin/Native libraries imported as file dependencies from Gradle project.
 */
class KotlinGradleNativeProjectDataService : AbstractProjectDataService<ProjectData, Void>() {

    override fun getTargetDataKey() = ProjectKeys.PROJECT

    override fun postProcess(
        toImport: MutableCollection<DataNode<ProjectData>>,
        projectData: ProjectData?,
        project: Project,
        modelsProvider: IdeModifiableModelsProvider
    ) {
        modelsProvider.allLibraries.forEach { library ->
            fixLibraryNameIfNeeded(library, modelsProvider)
        }

        if (projectData == null) return

        modelsProvider.getModules(projectData).forEach { module ->
            val rootModel = modelsProvider.getModifiableRootModel(module)
            val libraryTable = rootModel.moduleLibraryTable

            libraryTable.libraries.forEach inner@{ library ->
                fixLibraryNameIfNeeded(library, modelsProvider)
            }
        }
    }
}

private fun fixLibraryNameIfNeeded(
    library: Library,
    modelsProvider: IdeModifiableModelsProvider
) {
    val libraryModel = modelsProvider.getModifiableLibraryModel(library)

    val libraryName = libraryModel.name.orEmpty()
    if (libraryName.isNotEmpty() && !libraryName.startsWith("Gradle: Kotlin/Native"))
        return

    val libraryUrl = modelsProvider.getLibraryUrls(library, OrderRootType.CLASSES).singleOrNull() ?: return
    val libraryPath = VfsUtil.urlToPath(libraryUrl)

    val libraryInfo = LiteKonanLibraryInfoProvider.getDistributionLibraryInfo(libraryPath) ?: return

    val platformNamePart = libraryInfo.platform?.let { " [$it]" }.orEmpty()
    val newLibraryName = "Kotlin/Native ${libraryInfo.shortVersion} - ${libraryInfo.name}$platformNamePart"

    libraryModel.name = newLibraryName
}
