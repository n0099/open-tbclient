package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class as {
    public static String a = "";

    public static long a(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L);
    }

    public static String a(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "");
    }

    public static void a(@NonNull Context context, String str, int i) {
        context.getSharedPreferences("ksadsdk_data_flow_auto_start", 0).edit().putInt(str, i).apply();
    }

    public static void a(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
    }

    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences("ksadsdk_download_package_md5", 0).edit().putString(str, str2).apply();
    }

    public static long b(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_download_package_length", 0).getLong(str, 0L);
    }

    public static String b(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_model", 0).getString("KEY_SDK_MODEL", "");
    }

    public static void b(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
    }

    public static String c(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "");
    }

    public static String c(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "");
    }

    public static String d(Context context) {
        return !TextUtils.isEmpty(a) ? a : context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "");
    }

    public static void d(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
    }

    public static String e(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("oaid", "");
    }

    public static void e(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_model", 0).edit().putString("KEY_SDK_MODEL", str).apply();
    }

    public static int f(@NonNull Context context, String str) {
        return context.getSharedPreferences("ksadsdk_data_flow_auto_start", 0).getInt(str, -1);
    }

    public static String f(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("webview_ua", "");
    }

    public static void g(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
    }

    public static void h(Context context, String str) {
        a = str;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
    }

    public static void i(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("oaid", str).apply();
    }

    public static void j(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("webview_ua", str).apply();
    }
}
