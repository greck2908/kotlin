/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.folding;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class KotlinFoldingTestGenerated extends AbstractKotlinFoldingTest {
    @TestMetadata("idea/testData/folding/noCollapse")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class NoCollapse extends AbstractKotlinFoldingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInNoCollapse() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/folding/noCollapse"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("class.kt")
        public void testClass() throws Exception {
            runTest("idea/testData/folding/noCollapse/class.kt");
        }

        @TestMetadata("function.kt")
        public void testFunction() throws Exception {
            runTest("idea/testData/folding/noCollapse/function.kt");
        }

        @TestMetadata("imports.kt")
        public void testImports() throws Exception {
            runTest("idea/testData/folding/noCollapse/imports.kt");
        }

        @TestMetadata("kdocComments.kt")
        public void testKdocComments() throws Exception {
            runTest("idea/testData/folding/noCollapse/kdocComments.kt");
        }

        @TestMetadata("multilineComments.kt")
        public void testMultilineComments() throws Exception {
            runTest("idea/testData/folding/noCollapse/multilineComments.kt");
        }

        @TestMetadata("object.kt")
        public void testObject() throws Exception {
            runTest("idea/testData/folding/noCollapse/object.kt");
        }

        @TestMetadata("oneImport.kt")
        public void testOneImport() throws Exception {
            runTest("idea/testData/folding/noCollapse/oneImport.kt");
        }

        @TestMetadata("singleLineString.kt")
        public void testSingleLineString() throws Exception {
            runTest("idea/testData/folding/noCollapse/singleLineString.kt");
        }
    }

    @TestMetadata("idea/testData/folding/checkCollapse")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class CheckCollapse extends AbstractKotlinFoldingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doSettingsFoldingTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInCheckCollapse() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/folding/checkCollapse"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("collectionFactoryFunctions.kt")
        public void testCollectionFactoryFunctions() throws Exception {
            runTest("idea/testData/folding/checkCollapse/collectionFactoryFunctions.kt");
        }

        @TestMetadata("collectionFactoryFunctionsEmptyOneLine.kt")
        public void testCollectionFactoryFunctionsEmptyOneLine() throws Exception {
            runTest("idea/testData/folding/checkCollapse/collectionFactoryFunctionsEmptyOneLine.kt");
        }

        @TestMetadata("collectionFactoryFunctionsFewArguments.kt")
        public void testCollectionFactoryFunctionsFewArguments() throws Exception {
            runTest("idea/testData/folding/checkCollapse/collectionFactoryFunctionsFewArguments.kt");
        }

        @TestMetadata("customRegions.kt")
        public void testCustomRegions() throws Exception {
            runTest("idea/testData/folding/checkCollapse/customRegions.kt");
        }

        @TestMetadata("customRegionsNotFullBlock.kt")
        public void testCustomRegionsNotFullBlock() throws Exception {
            runTest("idea/testData/folding/checkCollapse/customRegionsNotFullBlock.kt");
        }

        @TestMetadata("doubleImportListsError.kt")
        public void testDoubleImportListsError() throws Exception {
            runTest("idea/testData/folding/checkCollapse/doubleImportListsError.kt");
        }

        @TestMetadata("functionLiteral.kt")
        public void testFunctionLiteral() throws Exception {
            runTest("idea/testData/folding/checkCollapse/functionLiteral.kt");
        }

        @TestMetadata("headerKDoc.kt")
        public void testHeaderKDoc() throws Exception {
            runTest("idea/testData/folding/checkCollapse/headerKDoc.kt");
        }

        @TestMetadata("headerMultilineComment.kt")
        public void testHeaderMultilineComment() throws Exception {
            runTest("idea/testData/folding/checkCollapse/headerMultilineComment.kt");
        }

        @TestMetadata("imports.kt")
        public void testImports() throws Exception {
            runTest("idea/testData/folding/checkCollapse/imports.kt");
        }

        @TestMetadata("multilineStrings.kt")
        public void testMultilineStrings() throws Exception {
            runTest("idea/testData/folding/checkCollapse/multilineStrings.kt");
        }

        @TestMetadata("primaryConstructor.kt")
        public void testPrimaryConstructor() throws Exception {
            runTest("idea/testData/folding/checkCollapse/primaryConstructor.kt");
        }
    }
}
