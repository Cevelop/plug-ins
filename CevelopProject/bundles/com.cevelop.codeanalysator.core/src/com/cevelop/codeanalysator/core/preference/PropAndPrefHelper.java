package com.cevelop.codeanalysator.core.preference;

import org.eclipse.jface.preference.IPreferenceStore;

import ch.hsr.ifs.iltis.core.preferences.PropertyAndPreferenceHelper;

import com.cevelop.codeanalysator.core.helper.CoreIdHelper;


public class PropAndPrefHelper extends PropertyAndPreferenceHelper {

    private final IPreferenceStore workspacePreferences;

    public PropAndPrefHelper(IPreferenceStore workspacePreferences) {
        this.workspacePreferences = workspacePreferences;
    }

    @Override
    public IPreferenceStore getWorkspacePreferences() {
        return workspacePreferences;
    }

    @Override
    public String getPreferenceIdQualifier() {
        return CoreIdHelper.DEFAULT_QUALIFIER;
    }
}
