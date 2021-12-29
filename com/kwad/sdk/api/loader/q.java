package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
/* loaded from: classes3.dex */
public class q {
    public static String a = "kssdk_api_pref";

    public static String a(Context context, String str) {
        return b(context, str, "");
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j2) {
        context.getSharedPreferences(a, 0).edit().putLong(str, j2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences(a, 0).edit().putString(str, str2).commit();
    }

    public static long b(Context context, String str) {
        return b(context, str, 0L);
    }

    public static long b(Context context, String str, long j2) {
        return context.getSharedPreferences(a, 0).getLong(str, j2);
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences(a, 0).getString(str, str2);
    }
}
