/*******************************************************************************
 * Copyright (c) 2010 Institute for Software, HSR Hochschule fuer Technik
 * Rapperswil, University of applied sciences and others
 * All rights reserved.
 *
 * Contributors:
 * Institute for Software - initial API and implementation
 ******************************************************************************/
package com.cevelop.includator.tests.helpertests;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.cevelop.includator.preferences.IncludatorPropertyManager;
import com.cevelop.includator.tests.base.IncludatorTest;


public class HelperTest13IncludePathSubDirProperty extends IncludatorTest {

    @Test
    public void runTest() throws Throwable {
        Assert.assertEquals("", IncludatorPropertyManager.getParseIndexUpfrontSubdirsDefaultProperty(getCurrentCProject()));
        Assert.assertEquals("[]", IncludatorPropertyManager.getIncludePathSubDirs(getCurrentCProject()).toString());

        Set<String> subDirs = new LinkedHashSet<>();
        subDirs.add("aaaa/bb");
        subDirs.add("ccc");
        IncludatorPropertyManager.addIncludePathSubDirs(subDirs, getCurrentCProject());
        Assert.assertEquals("[aaaa/bb, ccc]", IncludatorPropertyManager.getIncludePathSubDirs(getCurrentCProject()).toString());

        IncludatorPropertyManager.resetIncludePathSubDirs(getCurrentCProject());
        Assert.assertEquals("[]", IncludatorPropertyManager.getIncludePathSubDirs(getCurrentCProject()).toString());
    }
}
