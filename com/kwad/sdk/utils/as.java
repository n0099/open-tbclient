package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes5.dex */
public final class as {
    public static String a = "";

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0L);
    }

    public static String a() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a2 == null ? "" : a2.getSharedPreferences("ksadsdk_interstitial_daily_show_count", 0).getString("KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String a(@NonNull Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_egid", 0).getString("KEY_SDK_EGID", "");
    }

    public static void a(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_gidExpireTimeMs", 0).edit().putLong("KEY_SDK_EGID", j).apply();
    }

    public static void a(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_download_package_md5", 0).edit().putString(str, str2).apply();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_solder", 0).edit();
        edit.putBoolean("solder_is_success_loaded_" + str + str2, z).apply();
    }

    public static long b(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences("ksadsdk_gidExpireTimeMs", 0).getLong("KEY_SDK_EGID", 0L);
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences("ksadsdk_download_package_length", 0).getLong(str, 0L);
    }

    public static String b() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a2 == null ? "" : a2.getSharedPreferences("ksadsdk_interstitial_aggregate_daily_show_count", 0).getString("KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String b(Context context, String str, String str2, String str3) {
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void b(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_download_package_length", 0).edit().putLong(str, j).apply();
    }

    public static boolean b(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_solder", 0);
        return sharedPreferences.getBoolean("solder_is_success_loaded_" + str + str2, false);
    }

    public static String c() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a2 == null ? "" : a2.getSharedPreferences("ksadsdk_splash_daily_show_count", 0).getString("KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String c(@NonNull Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_model", 0).getString("KEY_SDK_MODEL", "");
    }

    public static String c(Context context, String str) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_download_package_md5", 0).getString(str, "");
    }

    public static String d() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a2 == null ? "" : a2.getSharedPreferences("ksadsdk_reward_auto_call_app_card_show_count", 0).getString("KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String d(@NonNull Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_device_sig", 0).getString("KEY_SDK_DEVICE_SIG", "");
    }

    public static void d(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_egid", 0).edit().putString("KEY_SDK_EGID", str).apply();
    }

    public static String e() {
        if (TextUtils.isEmpty(a)) {
            Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
            return a2 == null ? "" : a2.getSharedPreferences("ksadsdk_pref", 0).getString("appTag", "");
        }
        return a;
    }

    public static String e(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_pref", 0).getString("webview_ua", "");
    }

    public static void e(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_model", 0).edit().putString("KEY_SDK_MODEL", str).apply();
    }

    public static String f() {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return a2 == null ? "" : a(a2);
    }

    public static String f(Context context) {
        return context == null ? "" : context.getSharedPreferences("ksadsdk_sdk_config_data", 0).getString("config_str", "");
    }

    public static void f(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_interstitial_daily_show_count", 0).edit().putString("KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str).apply();
    }

    public static String g(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_splash_local_rotate_active_count", 0).getString("key_splash_local_info", null);
    }

    public static void g(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_interstitial_aggregate_daily_show_count", 0).edit().putString("KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str).apply();
    }

    public static String h(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_splash_local_rotate_active_count", 0).getString("key_splash_slide_local_info", null);
    }

    public static void h(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_splash_daily_show_count", 0).edit().putString("KEY_SPLASH_DAILY_SHOW_COUNT", str).apply();
    }

    public static void i(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_reward_auto_call_app_card_show_count", 0).edit().putString("KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str).apply();
    }

    public static void j(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_device_sig", 0).edit().putString("KEY_SDK_DEVICE_SIG", str).apply();
    }

    public static void k(Context context, String str) {
        a = str;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("appTag", str).apply();
    }

    public static void l(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("webview_ua", str).apply();
    }

    public static void m(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        context.getSharedPreferences("ksadsdk_sdk_config_data", 0).edit().putString("config_str", str).apply();
    }

    public static void n(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_splash_local_rotate_active_count", 0).edit().putString("key_splash_local_info", str).apply();
    }

    public static void o(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_splash_local_rotate_active_count", 0).edit().putString("key_splash_slide_local_info", str).apply();
    }
}
