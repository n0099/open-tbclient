package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
/* loaded from: classes12.dex */
final class v implements c {
    private ContentResolver a;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (k.b()) {
            this.a = context.getContentResolver();
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.a, str);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "getString error by " + str);
            return str2;
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.a, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "putString error by " + str);
        }
    }
}
