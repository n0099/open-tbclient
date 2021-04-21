package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29570a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29571b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29570a = true;
        f29571b = true;
    }

    public static boolean b() {
        if (!f29571b) {
            f29570a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29571b = true;
        }
        return f29570a;
    }
}
