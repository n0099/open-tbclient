package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes3.dex */
public class i {
    public static String a(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a.a ? (String) a.b : ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
    }
}
