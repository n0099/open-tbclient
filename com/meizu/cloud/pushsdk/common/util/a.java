package com.meizu.cloud.pushsdk.common.util;

import com.meizu.cloud.pushsdk.common.util.d;
/* loaded from: classes3.dex */
class a {
    private static String a = "android.os.BuildExt";
    private static d.c<Boolean> b;

    public static synchronized d.c<Boolean> a() {
        d.c<Boolean> cVar;
        synchronized (a.class) {
            if (b == null) {
                b = new d.c<>();
            }
            if (!b.a) {
                b = d.a(a).b("isProductInternational").a();
            }
            cVar = b;
        }
        return cVar;
    }
}
