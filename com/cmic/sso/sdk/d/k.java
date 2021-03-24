package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes6.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f30698a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public SharedPreferences.Editor f30699a;

        public a(SharedPreferences.Editor editor) {
            this.f30699a = editor;
        }

        public void a(String str, String str2) {
            this.f30699a.putString(d.a(str), str2);
        }

        public void b() {
            this.f30699a.commit();
        }

        public void a(String str, long j) {
            this.f30699a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f30699a.putInt(d.a(str), i);
        }

        public void a() {
            this.f30699a.apply();
        }

        public void a(String str) {
            this.f30699a.remove(d.a(str));
        }
    }

    public static void a(Context context) {
        f30698a = context.getApplicationContext();
    }

    public static String b(String str, String str2) {
        return f30698a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static int a(String str, int i) {
        return f30698a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long a(String str, long j) {
        return f30698a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f30698a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static a a() {
        return new a(f30698a.getSharedPreferences("ssoconfigs", 0).edit());
    }
}
