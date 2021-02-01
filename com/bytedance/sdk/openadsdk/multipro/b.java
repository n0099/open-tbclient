package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7400a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7401b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f7400a = true;
        f7401b = true;
    }

    public static boolean b() {
        if (!f7401b) {
            f7400a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f7401b = true;
        }
        return f7400a;
    }
}
