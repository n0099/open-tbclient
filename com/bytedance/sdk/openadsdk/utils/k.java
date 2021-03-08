package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class k {
    public static void a(String str) {
        a("any_door_id", str);
    }

    public static String a() {
        return b("any_door_id", (String) null);
    }

    public static void a(long j, String str) {
        a("last_load_splash_ad_time" + str, j);
    }

    public static long b(String str) {
        return b("last_load_splash_ad_time" + str, 0L);
    }

    public static void a(int i) {
        a("splash_storage_from", i);
    }

    public static void a(long j) {
        a("save_dpl_success_time", j);
    }

    public static long b() {
        return b("save_dpl_success_time", 0L);
    }

    public static void c(String str) {
        a("save_dpl_success_ad_tag", str);
    }

    public static String c() {
        return b("save_dpl_success_ad_tag", "");
    }

    public static void d(String str) {
        a("save_dpl_success_materialmeta", str);
    }

    public static String d() {
        return b("save_dpl_success_materialmeta", "");
    }

    public static void e(String str) {
        a("save_playable_screen_shot_materialmeta", str);
    }

    public static String e() {
        return b("save_playable_screen_shot_materialmeta", "");
    }

    public static void a(boolean z) {
        a("is_landing_page_open_market", z);
    }

    public static boolean f() {
        return b("is_landing_page_open_market", false);
    }

    private static void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Integer.valueOf(i));
                } else {
                    ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).a(str, i);
                }
            } catch (Throwable th) {
            }
        }
    }

    private static void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Boolean.valueOf(z));
                } else {
                    ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).a(str, z);
                }
            } catch (Throwable th) {
            }
        }
    }

    private static boolean b(String str, boolean z) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                z = com.bytedance.sdk.openadsdk.multipro.d.a.a(str, z);
            } else {
                z = ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).b(str, z);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    private static void a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(str, Long.valueOf(j));
                } else {
                    ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).a(str, j);
                }
            } catch (Throwable th) {
            }
        }
    }

    private static long b(String str, long j) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a(str, j);
            } else {
                j = ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).b(str, j);
            }
        } catch (Throwable th) {
        }
        return j;
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(str, str2);
                } else {
                    ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).a(str, str2);
                }
            } catch (Throwable th) {
            }
        }
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                str2 = com.bytedance.sdk.openadsdk.multipro.d.a.b(str, str2);
            } else {
                str2 = ae.a("", com.bytedance.sdk.openadsdk.core.p.a()).b(str, str2);
            }
            return str2;
        } catch (Throwable th) {
            return str2;
        }
    }
}
