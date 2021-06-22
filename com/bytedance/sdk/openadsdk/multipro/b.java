package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29834a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29835b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29834a = true;
        f29835b = true;
    }

    public static boolean b() {
        if (!f29835b) {
            f29834a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29835b = true;
        }
        return f29834a;
    }
}
