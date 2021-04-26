package com.bytedance.sdk.openadsdk.multipro;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30475a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30476b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        f30475a = true;
        f30476b = true;
    }

    public static boolean b() {
        if (!f30476b) {
            f30475a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f30476b = true;
        }
        return f30475a;
    }
}
