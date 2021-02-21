package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes15.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f7732a;

    public static void a(Context context) {
        f7732a = context.getApplicationContext();
    }

    public static int a(String str, int i) {
        return f7732a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long a(String str, long j) {
        return f7732a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f7732a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static String b(String str, String str2) {
        return f7732a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static a erD() {
        return new a(f7732a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f7733a;

        a(SharedPreferences.Editor editor) {
            this.f7733a = editor;
        }

        public void a(String str, String str2) {
            this.f7733a.putString(d.a(str), str2);
        }

        public void a(String str, long j) {
            this.f7733a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f7733a.putInt(d.a(str), i);
        }

        public void a() {
            this.f7733a.apply();
        }

        public void b() {
            this.f7733a.commit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str) {
            this.f7733a.remove(d.a(str));
        }
    }
}
