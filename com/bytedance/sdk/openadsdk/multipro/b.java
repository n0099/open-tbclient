package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29562a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29563b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f29562a = true;
        f29563b = true;
    }

    public static boolean b() {
        if (!f29563b) {
            f29562a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f29563b = true;
        }
        return f29562a;
    }
}
