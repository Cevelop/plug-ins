/*******************************************************************************
 * Copyright (c) 2010 Institute for Software, HSR Hochschule fuer Technik
 * Rapperswil, University of applied sciences and others
 * All rights reserved.
 *
 * Contributors:
 * Institute for Software - initial API and implementation
 ******************************************************************************/
package com.cevelop.includator.tests.datastructure;

import org.junit.Assert;
import org.junit.Test;

import com.cevelop.includator.tests.base.IncludatorTest;


public class DataStructureReferenceTest33HiddenFile extends IncludatorTest {

    @Test
    public void runTest() throws Throwable {
        Assert.assertEquals((Object) 0, (Object) getActiveProject().getAffectedFiles().size());
    }
}