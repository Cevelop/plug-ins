/*******************************************************************************
 * Copyright (c) 2010 Institute for Software, HSR Hochschule fuer Technik
 * Rapperswil, University of applied sciences and others
 * All rights reserved.
 *
 * Contributors:
 * Institute for Software - initial API and implementation
 ******************************************************************************/
package com.cevelop.includator.tests.suppresssuggestiontest;

import java.util.List;

import org.eclipse.core.runtime.MultiStatus;
import org.junit.Assert;
import org.junit.Test;

import com.cevelop.includator.IncludatorPlugin;
import com.cevelop.includator.optimizer.AlgorithmScope;
import com.cevelop.includator.optimizer.Suggestion;
import com.cevelop.includator.optimizer.organizeincludes.OrganizeIncludesAlgorithm;
import com.cevelop.includator.preferences.IncludatorPropertyManager;
import com.cevelop.includator.tests.base.IncludatorTest;
import com.cevelop.includator.ui.helpers.ResourceWrapperStore;


public class SuppressSuggestionTest9IgnoredSubDirInclude extends IncludatorTest {

    @Test
    public void runTest() throws Throwable {
        ResourceWrapperStore store = new ResourceWrapperStore();
        store.setResource(getActiveProject().getCProject().getProject());
        store.setValue(IncludatorPropertyManager.SUPPRESSED_SUGGESTIONS_PROPERTY_NAME, "main.cpp: foo/foo.h");

        MultiStatus status = runAlgorithmsAsAction(new OrganizeIncludesAlgorithm(), AlgorithmScope.FILE_SCOPE);
        String expectedMsg =
                           "Prevented adding of suggestion 'The include statement '#include \"foo/foo.h\"' is unneeded. No reference requires include.' " +
                             "caused by entry in Suppress-Suggestion list (see project properties).";
        assertStatus(status, expectedMsg);

        List<Suggestion<?>> suggestions = IncludatorPlugin.getSuggestionStore().getAllSuggestions();
        Assert.assertEquals((Object) 0, (Object) suggestions.size());
    }
}
