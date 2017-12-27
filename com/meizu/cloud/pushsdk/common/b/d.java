package com.meizu.cloud.pushsdk.common.b;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.b.e;
/* loaded from: classes2.dex */
class d {
    private static e.c<String> a;

    public static synchronized e.c<String> a() {
        e.c<String> cVar;
        synchronized (d.class) {
            if (a == null) {
                a = new e.c<>();
            }
            if (!a.a || TextUtils.isEmpty(a.b)) {
                a = e.a("android.telephony.MzTelephonyManager").b("getDeviceId").a();
            }
            cVar = a;
        }
        return cVar;
    }
}
