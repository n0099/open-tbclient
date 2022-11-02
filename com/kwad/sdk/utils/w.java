package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes8.dex */
public final class w {
    public static String sAppTag = "";

    public static long A(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long B(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String C(Context context, String str) {
        return context == null ? "" : d(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void D(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void E(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void F(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void G(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        av.Ax();
    }

    public static void H(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void I(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        av.At();
    }

    public static void J(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        av.Av();
    }

    public static void K(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void L(Context context, String str) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_pref", "appTag", str);
    }

    public static void M(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void N(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        av.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void O(Context context, String str) {
        if (context == null) {
            return;
        }
        e("ksadsdk_splash_local_rotate_active_count", "key_splash_local_info", str);
    }

    public static void P(Context context, String str) {
        if (context == null) {
            return;
        }
        e("ksadsdk_splash_local_ad_force_active", "key_splash_slide_local_info", str);
    }

    public static void Q(Context context, String str) {
        if (context == null) {
            return;
        }
        e("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (v.zt()) {
            aw.a(context, str, str2, i);
        } else {
            com.kwad.sdk.utils.kwai.e.ej(str).putInt(str2, i);
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (v.zt()) {
            aw.a(context, str, str2, j);
        } else {
            com.kwad.sdk.utils.kwai.e.ej(str).putLong(str2, j);
        }
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (v.zt()) {
            aw.a(context, str, str2, str3, z);
            if (com.kwad.b.kwai.a.aw.booleanValue()) {
                com.kwad.sdk.core.e.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.ej(str).putString(str2, str3);
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        v.P(str2, str3);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return 0;
        }
        return v.zt() ? aw.b(context, str, str2, 0) : com.kwad.sdk.utils.kwai.e.ej(str).getInt(str2, 0);
    }

    public static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return 0L;
        }
        return v.zt() ? aw.b(context, str, str2, 0L) : com.kwad.sdk.utils.kwai.e.ej(str).getLong(str2, 0L);
    }

    public static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        h("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, z);
    }

    public static void c(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (v.zt()) {
            aw.c(context, str, str2, str3);
            if (com.kwad.b.kwai.a.aw.booleanValue()) {
                com.kwad.sdk.core.e.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.ej(str).putString(str2, str3);
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        v.P(str2, str3);
    }

    public static void c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (v.zt()) {
            aw.c(context, str, str2, z);
        } else {
            com.kwad.sdk.utils.kwai.e.ej(str).putBoolean(str2, z);
        }
    }

    public static String cl(@NonNull Context context) {
        return context == null ? "" : d(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long cm(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int cn(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String co(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String d = d(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        aw.g(d, "ksadsdk_model", "KEY_SDK_MODEL");
        return d;
    }

    public static String cp(@NonNull Context context) {
        return context == null ? "" : d(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cq(Context context) {
        if (context == null) {
            return "";
        }
        String f = f("ksadsdk_pref", "webview_ua", "");
        aw.g(f, "ksadsdk_pref", "webview_ua");
        return f;
    }

    @WorkerThread
    public static String cr(Context context) {
        if (context == null) {
            return "";
        }
        if (av.Ar()) {
            return av.ac(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String f = aw.f("ksadsdk_sdk_config_data", "config_str", "");
        av.h(context.getApplicationContext(), "ksadsdk_sdk_config_data", f);
        return f;
    }

    public static String cs(Context context) {
        if (context == null) {
            return null;
        }
        return f("ksadsdk_splash_local_rotate_active_count", "key_splash_local_info", (String) null);
    }

    public static String ct(Context context) {
        if (context == null) {
            return null;
        }
        return f("ksadsdk_splash_local_ad_force_active", "key_splash_slide_local_info", (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context, String str, String str2, String str3) {
        String string;
        StringBuilder sb;
        if (context == null) {
            return str3;
        }
        if (v.zt()) {
            string = aw.d(context, str, str2, str3);
            if (com.kwad.b.kwai.a.aw.booleanValue()) {
                sb = new StringBuilder("getString From Sp key:");
                sb.append(str2);
                sb.append(" value:");
                sb.append(string);
                com.kwad.sdk.core.e.b.d("Ks_UnionUtils", sb.toString());
            }
            return !com.kwad.sdk.core.a.c.bP(string) ? com.kwad.sdk.core.a.c.bO(string) : string;
        }
        string = com.kwad.sdk.utils.kwai.e.ej(str).getString(str2, str3);
        v.Q(str2, string);
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            sb = new StringBuilder("getString key:");
            sb.append(str2);
            sb.append(" value:");
            sb.append(string);
            com.kwad.sdk.core.e.b.d("Ks_UnionUtils", sb.toString());
        }
        if (!com.kwad.sdk.core.a.c.bP(string)) {
        }
    }

    public static void d(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static boolean d(Context context, String str, String str2, boolean z) {
        return context == null ? z : v.zt() ? aw.d(context, str, str2, z) : com.kwad.sdk.utils.kwai.e.ej(str).getBoolean(str2, z);
    }

    public static void dH(String str) {
        e("ksadsdk_splash_local_ad_force_active", "key_local_info", str);
    }

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static void e(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, str3);
    }

    public static String f(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : d(context, str, str2, str3);
    }

    public static void f(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static void f(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static void f(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        c(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static void g(String str, String str2, String str3) {
        if (v.zt()) {
            aw.g(str, str2, str3);
        }
    }

    public static boolean g(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        return i("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, false);
    }

    @Nullable
    public static Context getContext() {
        try {
            com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
            if (dVar == null) {
                return null;
            }
            return dVar.getContext();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void h(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, z);
    }

    public static boolean i(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return d(context, str, str2, false);
    }

    public static String zA() {
        Context context = getContext();
        return context == null ? "" : d(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String zB() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return d(context, av.Au() ? "ksadsdk_splash_local_ad_force_active" : "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String zC() {
        Context context = getContext();
        return context == null ? "" : av.Aw() ? f("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "") : d(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String zD() {
        if (TextUtils.isEmpty(sAppTag)) {
            Context context = getContext();
            return context == null ? "" : d(context, "ksadsdk_pref", "appTag", "");
        }
        return sAppTag;
    }

    public static String zE() {
        Context context = getContext();
        return context == null ? "" : cl(context);
    }

    public static String zF() {
        return f("ksadsdk_splash_local_ad_force_active", "key_local_info", (String) null);
    }

    public static String zG() {
        return getContext() == null ? "" : f("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static String zy() {
        Context context = getContext();
        return context == null ? "" : d(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String zz() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return d(context, av.Ay() ? "ksadsdk_interstitial_daily_show_count" : "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }
}
