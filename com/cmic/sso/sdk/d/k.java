package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes6.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f31409a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public SharedPreferences.Editor f31410a;

        public a(SharedPreferences.Editor editor) {
            this.f31410a = editor;
        }

        public void a(String str, String str2) {
            this.f31410a.putString(d.a(str), str2);
        }

        public void b() {
            this.f31410a.commit();
        }

        public void a(String str, long j) {
            this.f31410a.putLong(d.a(str), j);
        }

        public void a(String str, int i2) {
            this.f31410a.putInt(d.a(str), i2);
        }

        public void a() {
            this.f31410a.apply();
        }

        public void a(String str) {
            this.f31410a.remove(d.a(str));
        }
    }

    public static void a(Context context) {
        f31409a = context.getApplicationContext();
    }

    public static String b(String str, String str2) {
        return f31409a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static int a(String str, int i2) {
        return f31409a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i2);
    }

    public static long a(String str, long j) {
        return f31409a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f31409a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static a a() {
        return new a(f31409a.getSharedPreferences("ssoconfigs", 0).edit());
    }
}
