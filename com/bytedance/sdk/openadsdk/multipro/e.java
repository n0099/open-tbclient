package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f4928a = "com.bytedance.openadsdk";
    public static String b = "content://" + f4928a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f4928a = p.a().getPackageName();
            b = "content://" + f4928a + ".TTMultiProvider";
        }
    }
}
