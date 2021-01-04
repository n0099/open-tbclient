package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7697a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7698b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f7697a = true;
        f7698b = true;
    }

    public static boolean b() {
        if (!f7698b) {
            f7697a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f7698b = true;
        }
        return f7697a;
    }
}
