package com.sdk.base.framework.f.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.j.c;
import java.nio.charset.Charset;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13130a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static final Boolean f13131b = Boolean.valueOf(f.f13118b);

    public static String a(Context context, String str) {
        String string;
        String str2 = "";
        try {
            string = context.getSharedPreferences("ZzxCache", 0).getString(str, "");
        } catch (Exception e) {
            e = e;
        }
        try {
            return new String(c.a(string), Charset.defaultCharset());
        } catch (Exception e2) {
            e = e2;
            str2 = string;
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
            return str2;
        }
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, c.a(str2.getBytes(Charset.defaultCharset())));
            return edit.commit();
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
            return false;
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
            return "";
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, str2);
            return edit.commit();
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
            return false;
        }
    }

    public static Long c(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0L);
        } catch (Exception e) {
            com.sdk.base.framework.a.a.c.b(f13130a, e.getMessage(), f13131b);
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
