package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
/* loaded from: classes7.dex */
public final class v implements c {

    /* renamed from: a  reason: collision with root package name */
    public ContentResolver f39570a;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (k.b()) {
            this.f39570a = context.getContentResolver();
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.f39570a, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("SettingsCache", "putString error by " + str);
        }
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.f39570a, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("SettingsCache", "getString error by " + str);
            return str2;
        }
    }
}
