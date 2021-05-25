package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29649a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29650b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29649a = true;
        f29650b = true;
    }

    public static boolean b() {
        if (!f29650b) {
            f29649a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29650b = true;
        }
        return f29649a;
    }
}
