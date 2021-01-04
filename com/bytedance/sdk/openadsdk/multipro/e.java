package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f7711a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f7712b = "content://" + f7711a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f7711a = p.a().getPackageName();
            f7712b = "content://" + f7711a + ".TTMultiProvider";
        }
    }
}
