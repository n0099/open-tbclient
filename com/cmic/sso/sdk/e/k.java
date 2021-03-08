package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes14.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f5223a;

    public static void a(Context context) {
        f5223a = context.getApplicationContext();
    }

    public static int a(String str, int i) {
        return f5223a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long a(String str, long j) {
        return f5223a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f5223a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static String b(String str, String str2) {
        return f5223a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static a erM() {
        return new a(f5223a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f5224a;

        a(SharedPreferences.Editor editor) {
            this.f5224a = editor;
        }

        public void a(String str, String str2) {
            this.f5224a.putString(d.a(str), str2);
        }

        public void a(String str, long j) {
            this.f5224a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f5224a.putInt(d.a(str), i);
        }

        public void a() {
            this.f5224a.apply();
        }

        public void b() {
            this.f5224a.commit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str) {
            this.f5224a.remove(d.a(str));
        }
    }
}
