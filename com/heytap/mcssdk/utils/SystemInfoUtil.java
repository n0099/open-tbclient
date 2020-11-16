package com.heytap.mcssdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes12.dex */
public class SystemInfoUtil {
    private static final String MODEL_NULL = "0";
    private static final int SDK_INT_21 = 21;

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getCarrierName(Context context) {
        String lowerCase = getOperator(context).toLowerCase();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -42227884:
                if (lowerCase.equals("china net")) {
                    c = 7;
                    break;
                }
                break;
            case 278980793:
                if (lowerCase.equals("chinamobile")) {
                    c = 2;
                    break;
                }
                break;
            case 394699659:
                if (lowerCase.equals("china mobile")) {
                    c = 1;
                    break;
                }
                break;
            case 507293352:
                if (lowerCase.equals("chinaunicom")) {
                    c = 5;
                    break;
                }
                break;
            case 618558396:
                if (lowerCase.equals("中国电信")) {
                    c = 6;
                    break;
                }
                break;
            case 618596989:
                if (lowerCase.equals("中国移动")) {
                    c = 0;
                    break;
                }
                break;
            case 618663094:
                if (lowerCase.equals("中国联通")) {
                    c = 3;
                    break;
                }
                break;
            case 623012218:
                if (lowerCase.equals("china unicom")) {
                    c = 4;
                    break;
                }
                break;
            case 1661280486:
                if (lowerCase.equals("chinanet")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
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
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Exception e) {
            LogUtil.e(e);
        }
        return "";
    }

    public static String getRomVersion() {
        return SystemProperties.get(RomUtils.PROP_RO_BUILD_DISPLAY_ID, "");
    }

    private static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str);
    }
}
