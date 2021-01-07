package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public final class x implements c {

    /* renamed from: a  reason: collision with root package name */
    private static String f14003a = "SpCache";

    /* renamed from: b  reason: collision with root package name */
    private static String f14004b = "com.vivo.push.cache";
    private SharedPreferences c;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (this.c == null) {
            this.c = context.getSharedPreferences(f14004b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        String string = this.c.getString(str, str2);
        p.d(f14003a, "getString " + str + " is " + string);
        return string;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            a.a(edit);
            p.d(f14003a, "putString by " + str);
            return;
        }
        p.b(f14003a, "putString error by " + str);
    }

    public final void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear();
            a.a(edit);
        }
        p.d(f14003a, "system cache is cleared");
    }
}
