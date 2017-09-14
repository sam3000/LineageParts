/*
 * Copyright (C) 2016 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.lineageparts;

import android.content.Context;
import android.os.Bundle;

import cyanogenmod.providers.LineageSettings;

/**
 * Privacy settings
 */
public class PrivacySettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.privacy_settings);
    }

    public static final SummaryProvider SUMMARY_PROVIDER = new SummaryProvider() {
        @Override
        public String getSummary(Context context, String key) {
            if (LineageSettings.Secure.getInt(context.getContentResolver(),
                    LineageSettings.Secure.PRIVACY_GUARD_DEFAULT, 0) == 1) {
                return context.getString(R.string.privacy_guard_default_summary_on);
            }
            return null;
        }
    };
}
