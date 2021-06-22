package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes6.dex */
public class k {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f30756a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final SharedPreferences.Editor f30757a;

        public a(SharedPreferences.Editor editor) {
            this.f30757a = editor;
        }

        public void a(String str, String str2) {
            this.f30757a.putString(d.a(str), str2);
        }

        public void b() {
            this.f30757a.commit();
        }

        public void a(String str, long j) {
            this.f30757a.putLong(d.a(str), j);
        }

        public void a(String str, int i2) {
            this.f30757a.putInt(d.a(str), i2);
        }

        public void a() {
            this.f30757a.apply();
        }

        public void a(String str) {
            this.f30757a.remove(d.a(str));
        }
    }

    public static void a(Context context) {
        f30756a = context.getApplicationContext();
    }

    public static String b(String str, String str2) {
        return f30756a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static int a(String str, int i2) {
        return f30756a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i2);
    }

    public static long a(String str, long j) {
        return f30756a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f30756a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static a a() {
        return new a(f30756a.getSharedPreferences("ssoconfigs", 0).edit());
    }
}
