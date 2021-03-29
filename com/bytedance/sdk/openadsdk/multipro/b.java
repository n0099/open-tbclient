package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29877a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29878b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29877a = true;
        f29878b = true;
    }

    public static boolean b() {
        if (!f29878b) {
            f29877a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29878b = true;
        }
        return f29877a;
    }
}
