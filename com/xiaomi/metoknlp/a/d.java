package com.xiaomi.metoknlp.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes3.dex */
public class d {
    private static TelephonyManager a;
    private static Context b;

    public static String a() {
        if (a != null) {
            return a.getNetworkOperator();
        }
        return null;
    }

    public static void a(Context context) {
        b = context;
        a = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
    }

    public static String b() {
        String str = null;
        try {
            if (b != null && b.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", b.getPackageName()) == 0 && a != null) {
                str = a.getDeviceId();
            }
        } catch (Exception e) {
        }
        return str != null ? str : "UNKNOWN";
    }
}
