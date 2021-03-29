package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static String f36700a = "";

    public static int a(@NonNull Context context, int i) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getInt("profile_guide_times", i);
    }

    public static long a(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L);
    }

    public static void a(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
    }

    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences("ksadsdk_download_package_md5", 0).edit().putString(str, str2).apply();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_slide_left", true);
    }

    public static long b(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_download_package_length", 0).getLong(str, 0L);
    }

    public static void b(Context context) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_slide_left", false).apply();
    }

    public static void b(@NonNull Context context, int i) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putInt("profile_guide_times", i).apply();
    }

    public static void b(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
    }

    public static String c(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "");
    }

    public static boolean c(Context context) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_slideup", true);
    }

    public static void d(Context context) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_slideup", false).apply();
    }

    public static void d(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
    }

    public static String e(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "");
    }

    public static void e(@NonNull Context context, String str) {
        context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
    }

    public static String f(@NonNull Context context) {
        return context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "");
    }

    public static void f(Context context, String str) {
        f36700a = str;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
    }

    public static String g(Context context) {
        return !TextUtils.isEmpty(f36700a) ? f36700a : context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "");
    }

    public static void g(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("oaid", str).apply();
    }

    public static String h(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("oaid", "");
    }
}
