package com.kwai.video.hodor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes7.dex */
public class NetworkMonitor {
    public static final int HodorMobileType_MOBILE_2G = 1;
    public static final int HodorMobileType_MOBILE_3G = 2;
    public static final int HodorMobileType_MOBILE_4G = 3;
    public static final int HodorMobileType_MOBILE_5G = 4;
    public static final int HodorMobileType_UNKNOWN = 0;

    public static String emptyStringIfNull(String str) {
        return str == null ? "" : str;
    }

    public static Pair<Integer, String> getMobileType(Context context) {
        int i2;
        String str;
        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        Timber.d("[NetworkMonitor.getMobileType]mobileType:%d", Integer.valueOf(networkType));
        if (networkType != 20) {
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i2 = 1;
                    str = "2G";
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    i2 = 2;
                    str = g.f3985b;
                    break;
                case 13:
                    i2 = 3;
                    str = "4G";
                    break;
                default:
                    i2 = 0;
                    str = RomUtils.UNKNOWN;
                    break;
            }
        } else {
            i2 = 4;
            str = "5G";
        }
        return Pair.create(i2, str);
    }

    public static void initNetworkChangeReceiver(Context context) {
        if (context != null) {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.kwai.video.hodor.NetworkMonitor.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    NetworkMonitor.onNetworkChange(context2, intent);
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            Timber.e("initNetworkChangeReceiver fail, context is null", new Object[0]);
        }
    }

    public static void onNetworkChange(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Pair<Integer, String> mobileType = getMobileType(context);
        if (connectivityManager == null) {
            onNetworkInvalidated();
            Timber.e("[onNetworkChange], get ConnectivityManager fail, current supportMobileType:%s", mobileType.second);
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Timber.w("[onNetworkChange], get ConnectivityManager ok, get getActiveNetworkInfo fail, current supportMobileType:%s", mobileType.second);
            onNetworkInvalidated();
            return;
        }
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(activeNetworkInfo.isConnected());
        objArr[1] = Boolean.valueOf(activeNetworkInfo.getType() == 1);
        objArr[2] = activeNetworkInfo.getTypeName();
        objArr[3] = activeNetworkInfo.getState().toString();
        objArr[4] = activeNetworkInfo.getExtraInfo();
        objArr[5] = mobileType.second;
        Timber.d("[onNetworkChange], get ConnectivityManager ok, get getActiveNetworkInfo ok, isConnected:%b, isWifi:%b, netTypeName:%s, connectionState:%s, getExtraInfo:%s, supportMobileType:%s", objArr);
        onNewActiveNetwork(activeNetworkInfo.isConnected(), activeNetworkInfo.getType() == 1, emptyStringIfNull(activeNetworkInfo.getTypeName()), emptyStringIfNull(activeNetworkInfo.getState().toString()), emptyStringIfNull(activeNetworkInfo.getExtraInfo()), ((Integer) mobileType.first).intValue());
    }

    public static native void onNetworkInvalidated();

    public static native void onNewActiveNetwork(boolean z, boolean z2, String str, String str2, String str3, @HodorMobileType int i2);
}
