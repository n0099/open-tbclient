package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
/* loaded from: classes15.dex */
final class v implements c {

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f4710a;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (k.b()) {
            this.f4710a = context.getContentResolver();
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.f4710a, str);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "getString error by " + str);
            return str2;
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.f4710a, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            p.b("SettingsCache", "putString error by " + str);
        }
    }
}
