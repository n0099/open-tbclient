package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
/* loaded from: classes10.dex */
public final class y {
    public static String sAppTag = "";

    public static String Kc() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Kd() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.Ln()) {
            return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String Ke() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Kf() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.Lj()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Kg() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.Ll()) {
            return i("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Kh() {
        return i("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Ki() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_pref", "appTag", "");
    }

    public static String Kj() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return bZ(context);
    }

    public static long Kk() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String Kl() {
        if (getContext() == null) {
            return "";
        }
        return i("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void Km() {
        a("ksadsdk_perf", "image_load_total", b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void Kn() {
        a("ksadsdk_perf", "image_load_suc", b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void Ko() {
        a("ksadsdk_perf", "image_load_failed", b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double Kp() {
        int b = b("ksadsdk_perf", "image_load_complete_count", 0);
        long b2 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        a("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (b == 0) {
            return 0.0d;
        }
        return b2 / b;
    }

    public static int Kq() {
        int b = b("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadTotal:" + b);
        a("ksadsdk_perf", "image_load_total", 0);
        return b;
    }

    public static int Kr() {
        int b = b("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadSuccess:" + b);
        a("ksadsdk_perf", "image_load_suc", 0);
        return b;
    }

    public static int Ks() {
        int b = b("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadFailed:" + b);
        a("ksadsdk_perf", "image_load_failed", 0);
        return b;
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.Jn();
    }

    public static long T(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long U(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String V(Context context, String str) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void W(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void X(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void Y(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        be.Lm();
    }

    public static void aa(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ab(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void ac(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        be.Li();
    }

    public static void ad(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        be.Lk();
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void af(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void ag(Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            g.execute(new ay() { // from class: com.kwad.sdk.utils.y.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    y.ah(ServiceProvider.getContext(), str);
                }
            });
        }
    }

    public static void ah(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void aj(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        be.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void ak(Context context, String str) {
        if (context == null) {
            return;
        }
        h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static Map<String, ?> al(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (x.JV()) {
            SharedPreferences gg = bf.gg(str);
            if (gg == null) {
                return null;
            }
            return gg.getAll();
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getAll();
    }

    public static void as(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        h(context, str, str2);
    }

    public static void d(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static void k(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static void l(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.a(str, str2, i);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putInt(str2, i);
        }
    }

    public static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (x.JV()) {
            return bf.b(str, str2, i);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getInt(str2, i);
    }

    public static boolean c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (x.JV()) {
            return bf.m(str, str2, z);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getBoolean(str2, z);
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.a(str, str2, j);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putLong(str2, j);
        }
    }

    public static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (x.JV()) {
            return bf.b(str, str2, j);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getLong(str2, j);
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.h(str, str2, str3);
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.aq(str2, str3);
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.a(str, str2, str3, z);
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.aq(str2, str3);
    }

    public static void a(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static int b(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static void f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.as(str, str2);
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).remove(str2);
        x.aq(str2, "");
    }

    public static String i(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return str3;
        }
        return b(context, str, str2, str3);
    }

    public static void j(String str, String str2, String str3) {
        if (!x.JV()) {
            return;
        }
        bf.j(str, str2, str3);
    }

    public static void l(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, true);
    }

    public static boolean m(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return c(context, str, str2, false);
    }

    public static void a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j);
    }

    public static long b(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return j;
        }
        return b(context, str, str2, j);
    }

    public static void h(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (x.JV()) {
            bf.l(str, str2, z);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putBoolean(str2, z);
        }
    }

    public static void ax(long j) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    public static void ay(long j) {
        a("ksadsdk_perf", "image_load_complete_count", b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    public static String bZ(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long ca(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int cb(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String cc(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bf.j(b, "ksadsdk_model", "KEY_SDK_MODEL");
        return b;
    }

    public static int cd(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String ce(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String cf(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cg(Context context) {
        if (context == null) {
            return "";
        }
        String i = i("ksadsdk_pref", "webview_ua", "");
        bf.j(i, "ksadsdk_pref", "webview_ua");
        return i;
    }

    @WorkerThread
    public static String ch(Context context) {
        if (be.Lg()) {
            return be.au(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String i = bf.i("ksadsdk_sdk_config_data", "config_str", "");
        be.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", i);
        return i;
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (x.JV()) {
            string = bf.i(str, str2, str3);
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            com.kwad.sdk.utils.a.e.av(context, str);
            string = com.kwad.sdk.utils.a.e.av(context, str).getString(str2, str3);
            x.ar(str2, string);
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        if (com.kwad.sdk.core.a.c.dl(string)) {
            return com.kwad.sdk.core.a.c.dk(string);
        }
        return string;
    }
}
