package com.kwad.sdk.api.loader;

import android.content.Context;
/* loaded from: classes7.dex */
public final class t {
    public static String a = "kssdk_api_pref";

    public static String a(Context context, String str) {
        return d(context, str, "");
    }

    public static void a(Context context, String str, long j) {
        context.getSharedPreferences(a, 0).edit().putLong(str, j).commit();
    }

    public static void a(Context context, String str, boolean z) {
        context.getSharedPreferences(a, 0).edit().putBoolean(str, z).commit();
    }

    public static void c(Context context, String str, String str2) {
        context.getSharedPreferences(a, 0).edit().putString(str, str2).commit();
    }

    public static String d(Context context, String str, String str2) {
        return context.getSharedPreferences(a, 0).getString(str, str2);
    }

    public static boolean q(Context context, String str) {
        return context.getSharedPreferences(a, 0).getBoolean(str, false);
    }

    public static long r(Context context, String str) {
        return context.getSharedPreferences(a, 0).getLong(str, 0L);
    }
}
