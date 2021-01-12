package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f7412a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f7413b = "content://" + f7412a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (p.a() != null) {
            f7412a = p.a().getPackageName();
            f7413b = "content://" + f7412a + ".TTMultiProvider";
        }
    }
}
