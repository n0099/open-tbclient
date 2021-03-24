package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29876a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29877b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29876a = true;
        f29877b = true;
    }

    public static boolean b() {
        if (!f29877b) {
            f29876a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29877b = true;
        }
        return f29876a;
    }
}
