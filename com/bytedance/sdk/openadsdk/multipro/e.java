package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f29669a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f29670b = "content://" + f29669a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f29669a = p.a().getPackageName();
            f29670b = "content://" + f29669a + ".TTMultiProvider";
        }
    }
}
