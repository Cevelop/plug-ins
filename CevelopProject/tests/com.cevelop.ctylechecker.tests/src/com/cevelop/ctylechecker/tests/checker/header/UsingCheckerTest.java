package com.cevelop.ctylechecker.tests.checker.header;

import com.cevelop.ctylechecker.ids.IdHelper.ProblemId;
import com.cevelop.ctylechecker.tests.checker.CheckerTest;

import ch.hsr.ifs.iltis.cpp.core.ast.checker.helper.IProblemId;


public class UsingCheckerTest extends CheckerTest {

    @Override
    protected IProblemId<?> getProblemId() {
        return ProblemId.USING_DIRECTIVE;
    }
}
