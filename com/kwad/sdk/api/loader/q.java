package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static String f31888a = "kssdk_api_pref";

    public static String a(Context context, String str) {
        return b(context, str, "");
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j) {
        context.getSharedPreferences(f31888a, 0).edit().putLong(str, j).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences(f31888a, 0).edit().putString(str, str2).commit();
    }

    public static long b(Context context, String str) {
        return b(context, str, 0L);
    }

    public static long b(Context context, String str, long j) {
        return context.getSharedPreferences(f31888a, 0).getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences(f31888a, 0).getString(str, str2);
    }
}
