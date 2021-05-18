package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static String f34087a = "";

    public static long a(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L);
    }

    public static String a(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "");
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
        return context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "");
    }

    public static void b(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
    }

    public static String c(Context context) {
        return !TextUtils.isEmpty(f34087a) ? f34087a : context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "");
    }

    public static String c(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "");
    }

    public static String d(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("oaid", "");
    }

    public static void d(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
    }

    public static void e(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
    }

    public static void f(Context context, String str) {
        f34087a = str;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
    }

    public static void g(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("oaid", str).apply();
    }
}
