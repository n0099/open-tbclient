package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f30495a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f30496b = "content://" + f30495a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f30495a = p.a().getPackageName();
            f30496b = "content://" + f30495a + ".TTMultiProvider";
        }
    }
}
