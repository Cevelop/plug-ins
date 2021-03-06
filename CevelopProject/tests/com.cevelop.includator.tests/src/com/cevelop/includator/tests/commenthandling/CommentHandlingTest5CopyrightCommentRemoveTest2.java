/*******************************************************************************
 * Copyright (c) 2010 Institute for Software, HSR Hochschule fuer Technik
 * Rapperswil, University of applied sciences and others
 * All rights reserved.
 *
 * Contributors:
 * Institute for Software - initial API and implementation
 ******************************************************************************/
package com.cevelop.includator.tests.commenthandling;

import java.util.List;
import java.util.Properties;

import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.internal.core.dom.rewrite.commenthandler.NodeCommentMap;
import org.junit.Assert;
import org.junit.Test;

import com.cevelop.includator.helpers.IncludatorCommentHelper;
import com.cevelop.includator.optimizer.Suggestion;
import com.cevelop.includator.optimizer.organizeincludes.OrganizeIncludesAlgorithm;
import com.cevelop.includator.tests.base.IncludatorTest;


@SuppressWarnings("restriction")
public class CommentHandlingTest5CopyrightCommentRemoveTest2 extends IncludatorTest {

    private int expectedCommentCountOnInclude;
    private int expectedCommentCountOnIncludeStartOffset;

    @Test
    public void runTest() throws Throwable {
        List<IASTPreprocessorIncludeStatement> includes = getActiveIncludatorFile().getIncludes();
        Assert.assertEquals((Object) 1, (Object) includes.size());
        IASTTranslationUnit tu = getActiveIncludatorFile().getTranslationUnit();
        NodeCommentMap commentedNodeMap = IncludatorCommentHelper.getCommentedNodeMap(tu);
        Assert.assertEquals((Object) expectedCommentCountOnInclude, (Object) commentedNodeMap.getAllCommentsForNode(includes.get(0)).size());
        Assert.assertEquals((Object) 0, (Object) commentedNodeMap.getAllCommentsForNode(tu).size());

        List<Suggestion<?>> suggestions = runAlgorithm(new OrganizeIncludesAlgorithm());
        Assert.assertEquals((Object) 1, (Object) suggestions.size());
        String msg = "The include statement '#include \"foo.h\"' is unneeded. No reference requires include.";
        assertSuggestion(suggestions.get(0), "main.cpp", msg, expectedCommentCountOnIncludeStartOffset, 94);
    }

    @Override
    protected void configureTest(Properties properties) {
        expectedCommentCountOnInclude = Integer.parseInt(properties.getProperty("expectedCommentCountOnInclude", "1"));
        expectedCommentCountOnIncludeStartOffset = Integer.parseInt(properties.getProperty("expectedCommentCountOnIncludeStartOffset", "0"));
        super.configureTest(properties);
    }
}
