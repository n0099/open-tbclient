package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d {
    public static String a(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public static long b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0L;
        }
        return context.getSharedPreferences(str, 0).getLong(str2, 0L);
    }
}
