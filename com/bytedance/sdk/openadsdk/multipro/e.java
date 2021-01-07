package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f7712a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f7713b = "content://" + f7712a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f7712a = p.a().getPackageName();
            f7713b = "content://" + f7712a + ".TTMultiProvider";
        }
    }
}
