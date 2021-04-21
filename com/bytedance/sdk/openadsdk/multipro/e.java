package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f29590a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f29591b = "content://" + f29590a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f29590a = p.a().getPackageName();
            f29591b = "content://" + f29590a + ".TTMultiProvider";
        }
    }
}
