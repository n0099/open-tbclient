package com.meizu.cloud.pushsdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.meizu.cloud.pushinternal.DebugLogger;
/* loaded from: classes9.dex */
public class c {
    public static String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = !a() ? d(context) : b(context);
            return a;
        }
        return a;
    }

    public static boolean a() {
        String a2 = i.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            DebugLogger.i("DeviceUtils", "current product is phone");
            return true;
        }
        DebugLogger.i("DeviceUtils", "current product is " + a2);
        return false;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String b(Context context) {
        String deviceId;
        try {
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
            if (!a2.a || TextUtils.isEmpty((CharSequence) a2.b)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
            } else {
                deviceId = (String) a2.b;
            }
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        return null;
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        DebugLogger.i("DeviceUtils", "device serial " + str);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            String c = c(context);
            DebugLogger.e("DeviceUtils", "mac address " + c);
            if (!TextUtils.isEmpty(c)) {
                sb.append(c.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }
}
