/**
 * ownCloud Android client application
 *
 * @author David Crespo Ríos
 * Copyright (C) 2022 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.owncloud.android.presentation.viewmodels.releasenotes

import androidx.lifecycle.ViewModel
import com.owncloud.android.MainApp
import com.owncloud.android.MainApp.Companion.versionCode
import com.owncloud.android.R
import com.owncloud.android.data.preferences.datasources.SharedPreferencesProvider
import com.owncloud.android.presentation.ui.releasenotes.ReleaseNote
import com.owncloud.android.presentation.ui.releasenotes.ReleaseNoteType
import com.owncloud.android.providers.ContextProvider

class ReleaseNotesViewModel(
    private val preferencesProvider: SharedPreferencesProvider,
    private val contextProvider: ContextProvider
) : ViewModel() {

    fun getReleaseNotes(): List<ReleaseNote> {
        return releaseNotesList
    }

    fun updateVersionCode() {
        preferencesProvider.putInt(MainApp.PREFERENCE_KEY_LAST_SEEN_VERSION_CODE, versionCode)
    }

    fun shouldWhatsNewSectionBeVisible(): Boolean {
        return contextProvider.getBoolean(R.bool.release_notes_enabled) && getReleaseNotes().isNotEmpty()
    }

    companion object {
        val releaseNotesList = listOf<ReleaseNote>(
            ReleaseNote(R.string.release_notes_2_21_2_title1, R.string.release_notes_2_21_2_subtitle1, ReleaseNoteType.ENHANCEMENT),
        )
    }
}
