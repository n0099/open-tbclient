package com.meizu.cloud.pushsdk.common.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.util.d;
/* loaded from: classes3.dex */
class c {
    private static d.c<String> a;

    public static synchronized d.c<String> a() {
        d.c<String> cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new d.c<>();
            }
            if (!a.a || TextUtils.isEmpty(a.b)) {
                a = d.a("android.telephony.MzTelephonyManager").b("getDeviceId").a();
            }
            cVar = a;
        }
        return cVar;
    }
}
