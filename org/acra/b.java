package org.acra;

import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        boolean b;
        if ("acra.disable".equals(str) || "acra.enable".equals(str)) {
            b = a.b(sharedPreferences);
            a.a().a(!b);
        }
    }
}
