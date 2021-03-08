package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4917a;
    public static boolean b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f4917a = true;
        b = true;
    }

    public static boolean b() {
        if (!b) {
            f4917a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            b = true;
        }
        return f4917a;
    }
}
