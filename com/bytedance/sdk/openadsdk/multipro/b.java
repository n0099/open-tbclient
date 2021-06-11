package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29752a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29753b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29752a = true;
        f29753b = true;
    }

    public static boolean b() {
        if (!f29753b) {
            f29752a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29753b = true;
        }
        return f29752a;
    }
}
