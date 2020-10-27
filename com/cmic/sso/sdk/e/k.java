package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes8.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f4023a;

    public static void a(Context context) {
        f4023a = context.getApplicationContext();
    }

    public static int a(String str, int i) {
        return f4023a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long P(String str, long j) {
        return f4023a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f4023a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static String b(String str, String str2) {
        return f4023a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static a eff() {
        return new a(f4023a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f4024a;

        a(SharedPreferences.Editor editor) {
            this.f4024a = editor;
        }

        public void a(String str, String str2) {
            this.f4024a.putString(d.a(str), str2);
        }

        public void a(String str, long j) {
            this.f4024a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f4024a.putInt(d.a(str), i);
        }

        public void a() {
            this.f4024a.apply();
        }

        public void b() {
            this.f4024a.commit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str) {
            this.f4024a.remove(d.a(str));
        }
    }
}
