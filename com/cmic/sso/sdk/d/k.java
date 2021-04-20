package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes5.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f30384a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public SharedPreferences.Editor f30385a;

        public a(SharedPreferences.Editor editor) {
            this.f30385a = editor;
        }

        public void a(String str, String str2) {
            this.f30385a.putString(d.a(str), str2);
        }

        public void b() {
            this.f30385a.commit();
        }

        public void a(String str, long j) {
            this.f30385a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f30385a.putInt(d.a(str), i);
        }

        public void a() {
            this.f30385a.apply();
        }

        public void a(String str) {
            this.f30385a.remove(d.a(str));
        }
    }

    public static void a(Context context) {
        f30384a = context.getApplicationContext();
    }

    public static String b(String str, String str2) {
        return f30384a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static int a(String str, int i) {
        return f30384a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long a(String str, long j) {
        return f30384a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f30384a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static a a() {
        return new a(f30384a.getSharedPreferences("ssoconfigs", 0).edit());
    }
}
