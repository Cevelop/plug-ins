package com.cevelop.gslator.tests.tests.checkers.C30ToC37DestructorRules;

import com.cevelop.gslator.ids.IdHelper;
import com.cevelop.gslator.tests.tests.checkers.BaseCheckerTest;

import ch.hsr.ifs.iltis.cpp.core.ast.checker.helper.IProblemId;


public class C31_03DestructorWithMissingDeleteStatementsCheckerTest extends BaseCheckerTest {

    @Override
    protected IProblemId<?> getProblemId() {
        return IdHelper.ProblemId.P_C31_03;
    }

}
