package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class u implements c {
    private static String a = "SpCache";
    private static String b = "com.vivo.push.cache";
    private SharedPreferences c;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = context.getSharedPreferences(b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        String string = this.c.getString(str, str2);
        m.d(a, "getString " + str + " is " + string);
        return string;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.putString(str, str2).apply();
            m.d(a, "putString by " + str);
            return;
        }
        m.b(a, "putString error by " + str);
    }

    public final void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear().apply();
        }
        m.d(a, "system cache is cleared");
    }
}
