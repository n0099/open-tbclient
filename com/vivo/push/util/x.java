package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class x implements c {

    /* renamed from: a  reason: collision with root package name */
    public static String f39572a = "SpCache";

    /* renamed from: b  reason: collision with root package name */
    public static String f39573b = "com.vivo.push.cache";

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f39574c;

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        if (this.f39574c == null) {
            this.f39574c = context.getSharedPreferences(f39573b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f39574c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            a.a(edit);
            String str3 = f39572a;
            p.d(str3, "putString by " + str);
            return;
        }
        String str4 = f39572a;
        p.b(str4, "putString error by " + str);
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        String string = this.f39574c.getString(str, str2);
        String str3 = f39572a;
        p.d(str3, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f39574c.edit();
        if (edit != null) {
            edit.clear();
            a.a(edit);
        }
        p.d(f39572a, "system cache is cleared");
    }
}
