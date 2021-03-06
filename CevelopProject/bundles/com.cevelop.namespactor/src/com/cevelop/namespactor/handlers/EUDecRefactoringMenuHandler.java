package com.cevelop.namespactor.handlers;

import java.util.Optional;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.jface.text.ITextSelection;

import ch.hsr.ifs.iltis.cpp.core.ui.refactoring.WizardRefactoringStarterMenuHandler;

import com.cevelop.namespactor.refactoring.NSRefactoringWizard;
import com.cevelop.namespactor.refactoring.eudec.EUDecRefactoring;


public class EUDecRefactoringMenuHandler extends WizardRefactoringStarterMenuHandler<NSRefactoringWizard, EUDecRefactoring> {

    @Override
    protected EUDecRefactoring getRefactoring(ICElement element, Optional<ITextSelection> selection) {
        return new EUDecRefactoring(element, selection, element.getCProject());
    }

    @Override
    protected NSRefactoringWizard getRefactoringWizard(EUDecRefactoring refactoring) {
        return new NSRefactoringWizard(refactoring);
    }
}
