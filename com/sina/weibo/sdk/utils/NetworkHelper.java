package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.util.List;
/* loaded from: classes2.dex */
public class NetworkHelper {
    public static boolean hasInternetPermission(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isWifiValid(Context context) {
        if (context != null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static boolean isMobileNetwork(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static int getWifiState(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return 4;
        }
        return wifiManager.getWifiState();
    }

    public static NetworkInfo.DetailedState getWifiConnectivityState(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 1);
        return networkInfo == null ? NetworkInfo.DetailedState.FAILED : networkInfo.getDetailedState();
    }

    public static boolean wifiConnection(Context context, String str, String str2) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str3 = "\"" + str + "\"";
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null && (str.equals(connectionInfo.getSSID()) || str3.equals(connectionInfo.getSSID()))) {
            return true;
        }
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults != null && scanResults.size() != 0) {
            for (int size = scanResults.size() - 1; size >= 0; size--) {
                String str4 = scanResults.get(size).SSID;
                if (str.equals(str4) || str3.equals(str4)) {
                    WifiConfiguration wifiConfiguration = new WifiConfiguration();
                    wifiConfiguration.SSID = str3;
                    wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                    wifiConfiguration.status = 2;
                    return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), false);
                }
            }
        }
        return false;
    }

    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append("__");
        sb.append("weibo");
        sb.append("__");
        sb.append("sdk");
        sb.append("__");
        try {
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", BaseRequestAction.SPLITE));
        } catch (Exception e) {
            sb.append("unknown");
        }
        return sb.toString();
    }
}
