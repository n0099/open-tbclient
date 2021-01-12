package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7398a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7399b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f7398a = true;
        f7399b = true;
    }

    public static boolean b() {
        if (!f7399b) {
            f7398a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f7399b = true;
        }
        return f7398a;
    }
}
