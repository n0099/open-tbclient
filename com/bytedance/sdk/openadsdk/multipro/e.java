package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f7414a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f7415b = "content://" + f7414a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f7414a = p.a().getPackageName();
            f7415b = "content://" + f7414a + ".TTMultiProvider";
        }
    }
}
