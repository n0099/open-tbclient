package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.telephony.TelephonyManager;
/* loaded from: classes8.dex */
public class i {
    public static String a(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a.a ? (String) a.b : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}
