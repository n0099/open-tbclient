package com.sdk.base.framework.f.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.i.c;
import java.nio.charset.Charset;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35754a = "com.sdk.base.framework.f.b.a";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f35755b = Boolean.valueOf(f.f35733b);

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            str2 = context.getSharedPreferences("ZzxCache", 0).getString(str, "");
            return new String(c.a(str2), Charset.defaultCharset());
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
            return str2;
        }
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, c.a(str2.getBytes(Charset.defaultCharset())));
            return edit.commit();
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
            return false;
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
            return "";
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, str2);
            return edit.commit();
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
            return false;
        }
    }

    public static Long c(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0L);
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f35754a, e2.getMessage(), f35755b);
        }
        return Long.valueOf(j);
    }

    public static void d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ZzxCache", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str2 : sharedPreferences.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
