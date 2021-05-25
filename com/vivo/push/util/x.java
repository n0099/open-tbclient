package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class x implements c {

    /* renamed from: a  reason: collision with root package name */
    public static String f36736a = "SpCache";

    /* renamed from: b  reason: collision with root package name */
    public static String f36737b = "com.vivo.push.cache";

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f36738c;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (this.f36738c == null) {
            this.f36738c = context.getSharedPreferences(f36737b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f36738c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            a.a(edit);
            String str3 = f36736a;
            p.d(str3, "putString by " + str);
            return;
        }
        String str4 = f36736a;
        p.b(str4, "putString error by " + str);
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        String string = this.f36738c.getString(str, str2);
        String str3 = f36736a;
        p.d(str3, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f36738c.edit();
        if (edit != null) {
            edit.clear();
            a.a(edit);
        }
        p.d(f36736a, "system cache is cleared");
    }
}
