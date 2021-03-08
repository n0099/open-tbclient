package com.thunder.livesdk.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes6.dex */
public class ThunderNetStateService {
    private static final String INTERNET_PERMISSION = "android.permission.INTERNET";
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    public static NetworkInfo.DetailedState lastDetailedState = NetworkInfo.DetailedState.IDLE;
    private Context mContext;
    private BroadcastReceiver mNetReceiver = new BroadcastReceiver() { // from class: com.thunder.livesdk.system.ThunderNetStateService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagSdk, "NetworkStateService onReceive pid %d", Long.valueOf(Thread.currentThread().getId()));
            }
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(ThunderLog.kLogTagSdk, "current network connectivity action");
                }
                ThunderNetStateService.updateNetInfo(context);
            }
        }
    };

    /* loaded from: classes6.dex */
    public static final class NetState {
        public static final int SYSNET_2G = 3;
        public static final int SYSNET_3G = 4;
        public static final int SYSNET_4G = 5;
        public static final int SYSNET_5G = 7;
        public static final int SYSNET_CONNECTING = 20;
        public static final int SYSNET_DISCONNECT = 2;
        public static final int SYSNET_MOBILE = 1;
        public static final int SYSNET_RECONNECTING = 21;
        public static final int SYSNET_UNKNOWN = 127;
        public static final int SYSNET_WIFI = 0;
        public static final int SYSNET_WLAN = 6;
    }

    public ThunderNetStateService(Context context) {
        this.mContext = context;
    }

    public void init() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.mContext.registerReceiver(this.mNetReceiver, intentFilter);
        } catch (Exception e) {
            ThunderLog.warn(ThunderLog.kLogTagSdk, "ThunderNetStateService registerReceiver failed, error:" + e);
        }
    }

    public void fini() {
        this.mContext.unregisterReceiver(this.mNetReceiver);
    }

    private static boolean checkHasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private static int getMobileNetworkState(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            ThunderLog.warn(ThunderLog.kLogTagSdk, "cannot get TelephonyManager");
            return 1;
        }
        int networkType = telephonyManager.getNetworkType();
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 3;
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
                return 4;
            case 13:
            case 18:
                return 5;
            default:
                ThunderLog.warn(ThunderLog.kLogTagSdk, "unknown mobile network type:" + networkType);
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateNetInfo(Context context) {
        int i;
        if (context != null) {
            try {
                if (!checkHasPermission(context, INTERNET_PERMISSION) || !checkHasPermission(context, NETWORK_PERMISSION)) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(ThunderLog.kLogTagSdk, "cannot get permission INTERNET or ACCESS_NETWORK_STATE!!");
                        return;
                    }
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(ThunderLog.kLogTagSdk, "cannot get ConnectivityManager!!");
                        return;
                    }
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    NetworkInfo.DetailedState detailedState = activeNetworkInfo.getDetailedState();
                    lastDetailedState = detailedState;
                    if (activeNetworkInfo.isAvailable()) {
                        int type = activeNetworkInfo.getType();
                        if (type == 0) {
                            i = getMobileNetworkState(context);
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagSdk, "current network TYPE_MOBILE, netState: %d", Integer.valueOf(i));
                            }
                        } else if (type == 1) {
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagSdk, "current network wifi");
                                i = 0;
                            } else {
                                i = 0;
                            }
                        } else {
                            ThunderLog.warn(ThunderLog.kLogTagSdk, "current network %s is omitted", activeNetworkInfo.getTypeName());
                            return;
                        }
                    } else {
                        if (detailedState != NetworkInfo.DetailedState.CONNECTING) {
                            i = 2;
                        } else if (lastDetailedState.ordinal() == NetworkInfo.DetailedState.FAILED.ordinal() || lastDetailedState.ordinal() == NetworkInfo.DetailedState.BLOCKED.ordinal()) {
                            i = 21;
                        } else {
                            i = 20;
                        }
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(ThunderLog.kLogTagSdk, "current network No usable network!!");
                        }
                    }
                } else {
                    i = 2;
                }
                ThunderNative.notifyNetState(i);
            } catch (Exception e) {
                ThunderLog.warn(ThunderLog.kLogTagSdk, "update net info error:" + e);
            }
        }
    }
}
