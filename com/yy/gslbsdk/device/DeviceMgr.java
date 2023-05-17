package com.yy.gslbsdk.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
/* loaded from: classes10.dex */
public class DeviceMgr {
    public static final String TAG = "DeviceMgr";
    public static NetStatusInfo cur_network = new NetStatusInfo();

    public static NetworkInfo getActiveNetwork(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            LogTools.printError(TAG, String.format(Locale.US, "getActiveNetwork error. msg: %s", e.getMessage()));
            return null;
        }
    }

    public static NetStatusInfo getNetworkInfo(Context context) {
        NetStatusInfo netStatusInfo = new NetStatusInfo();
        netStatusInfo.setNetType(getNetworkType(context));
        netStatusInfo.setIsp(getISP(context));
        netStatusInfo.setSsid(getWiFiSsid(context));
        netStatusInfo.setNetworkStatus(NetworkStatus.getInstanceClone());
        return netStatusInfo;
    }

    public static String getWiFiSsid(Context context) {
        return IpVersionController.getInstance().getCurrIpVerStr();
    }

    public static boolean isChangeNetworkStatus(Context context) {
        NetStatusInfo networkInfo = getNetworkInfo(context);
        boolean z = !networkInfo.getNetStatusID().equals(cur_network.getNetStatusID());
        cur_network = networkInfo;
        return z;
    }

    public static int getISP(Context context) {
        if (!"CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE) || context == null) {
            return 0;
        }
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return 0;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007") && !simOperator.equals("46020")) {
                if (!simOperator.equals("46001") && !simOperator.equals("46006")) {
                    if (!simOperator.equals("46003")) {
                        if (!simOperator.equals("46005")) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 2;
            }
            return 3;
        } catch (Exception e) {
            LogTools.printError(TAG, "getISP() exception:" + e.getMessage());
            return 0;
        }
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return 1;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 2;
                    }
                    if (activeNetworkInfo.getType() != 0) {
                        return 1;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 3;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 15:
                            return 4;
                        case 12:
                        case 14:
                        default:
                            return 1;
                        case 13:
                            return 5;
                    }
                }
                return 0;
            } catch (Exception e) {
                LogTools.printError(TAG, "getNetworkType() exception:" + e.getMessage());
            }
        }
        return 1;
    }
}
