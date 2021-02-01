package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes6.dex */
public class x {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
        }
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int b(Context context) {
        int c = c(context);
        switch (c) {
            case 1:
                return 0;
            case 2:
            case 3:
            default:
                return c;
            case 4:
                return 1;
            case 5:
                return 4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r0.equalsIgnoreCase("CDMA2000") != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return 0;
            }
            switch (activeNetworkInfo.getType()) {
                case 0:
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                        case 19:
                            return 5;
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (!TextUtils.isEmpty(subtypeName)) {
                                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                    break;
                                }
                                return 3;
                            }
                            return 1;
                    }
                case 1:
                    return 4;
                default:
                    return 1;
            }
        } catch (Throwable th) {
            return 1;
        }
    }

    public static boolean d(Context context) {
        return c(context) == 4;
    }

    public static boolean e(Context context) {
        return c(context) == 5;
    }

    public static String f(Context context) {
        switch (c(context)) {
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "wifi";
            case 5:
                return "4g";
            default:
                return "mobile";
        }
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }
}
