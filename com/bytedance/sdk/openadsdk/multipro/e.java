package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f29582a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f29583b = "content://" + f29582a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f29582a = p.a().getPackageName();
            f29583b = "content://" + f29582a + ".TTMultiProvider";
        }
    }
}
