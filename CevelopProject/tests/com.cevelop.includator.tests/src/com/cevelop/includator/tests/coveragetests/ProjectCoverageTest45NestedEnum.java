/*******************************************************************************
 * Copyright (c) 2010 Institute for Software, HSR Hochschule fuer Technik
 * Rapperswil, University of applied sciences and others
 * All rights reserved.
 *
 * Contributors:
 * Institute for Software - initial API and implementation
 ******************************************************************************/
package com.cevelop.includator.tests.coveragetests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cevelop.includator.optimizer.Suggestion;
import com.cevelop.includator.optimizer.staticcoverage.StaticCoverageProjectAnalysisAlgorithm;
import com.cevelop.includator.tests.base.IncludatorTest;


public class ProjectCoverageTest45NestedEnum extends IncludatorTest {

    @Test
    public void runTest() throws Throwable {
        List<Suggestion<?>> suggestions = runAlgorithm(new StaticCoverageProjectAnalysisAlgorithm());

        Assert.assertEquals((Object) 4, (Object) suggestions.size());

        String inUseText = "This declaration is in use through the file main.cpp.";
        int i = 0;
        assertSuggestion(suggestions.get(i++), "main.cpp", inUseText, 1, 10); // struct Dot
        assertSuggestion(suggestions.get(i++), "main.cpp", inUseText, 23, 35); // enum Color {
        assertSuggestion(suggestions.get(i++), "main.cpp", inUseText, 60, 12); // Color color;
        assertSuggestion(suggestions.get(i++), "main.cpp", inUseText, 77, 85); // int main(int argc, char **argv) { {
    }
}
