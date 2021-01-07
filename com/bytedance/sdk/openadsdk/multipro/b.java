package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7698a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7699b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f7698a = true;
        f7699b = true;
    }

    public static boolean b() {
        if (!f7699b) {
            f7698a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f7699b = true;
        }
        return f7698a;
    }
}
