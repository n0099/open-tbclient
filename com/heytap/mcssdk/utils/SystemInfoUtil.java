package com.heytap.mcssdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes6.dex */
public class SystemInfoUtil {
    public static final String MODEL_NULL = "0";
    public static final int SDK_INT_21 = 21;

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getCarrierName(Context context) {
        char c2;
        String lowerCase = getOperator(context).toLowerCase();
        switch (lowerCase.hashCode()) {
            case -42227884:
                if (lowerCase.equals("china net")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 278980793:
                if (lowerCase.equals("chinamobile")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 394699659:
                if (lowerCase.equals("china mobile")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 507293352:
                if (lowerCase.equals("chinaunicom")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 618558396:
                if (lowerCase.equals("中国电信")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 618596989:
                if (lowerCase.equals("中国移动")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 618663094:
                if (lowerCase.equals("中国联通")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 623012218:
                if (lowerCase.equals("china unicom")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1661280486:
                if (lowerCase.equals("chinanet")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
                return "China Mobile";
            case 3:
            case 4:
            case 5:
                return "China Unicom";
            case 6:
            case 7:
            case '\b':
                return "China Net";
            default:
                return "none";
        }
    }

    public static String getModel() {
        if (isEmpty(Build.MODEL)) {
            LogUtil.w("No MODEL.");
            return "0";
        }
        return Build.MODEL.toUpperCase();
    }

    public static String getOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Exception e2) {
            LogUtil.e(e2);
            return "";
        }
    }

    public static String getRomVersion() {
        return SystemProperties.get("ro.build.display.id", "");
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equals(str);
    }
}
