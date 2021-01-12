package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes6.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f7730a;

    public static void a(Context context) {
        f7730a = context.getApplicationContext();
    }

    public static int a(String str, int i) {
        return f7730a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static long a(String str, long j) {
        return f7730a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f7730a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static String b(String str, String str2) {
        return f7730a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static a epc() {
        return new a(f7730a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f7731a;

        a(SharedPreferences.Editor editor) {
            this.f7731a = editor;
        }

        public void a(String str, String str2) {
            this.f7731a.putString(d.a(str), str2);
        }

        public void a(String str, long j) {
            this.f7731a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.f7731a.putInt(d.a(str), i);
        }

        public void a() {
            this.f7731a.apply();
        }

        public void b() {
            this.f7731a.commit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str) {
            this.f7731a.remove(d.a(str));
        }
    }
}
