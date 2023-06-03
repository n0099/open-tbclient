package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;
/* loaded from: classes10.dex */
public final class ae {
    public static int anO;
    public static boolean anP;

    public static int T(Context context, String str) {
        if (context == null || anO > 0 || anP) {
            return anO;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 22) {
                String simOperator = telephonyManager.getSimOperator();
                char c = 65535;
                int hashCode = simOperator.hashCode();
                if (hashCode != 49679502) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                c = 7;
                                break;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 49679475:
                                    if (simOperator.equals("46005")) {
                                        c = '\b';
                                        break;
                                    }
                                    break;
                                case 49679476:
                                    if (simOperator.equals("46006")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                                case 49679477:
                                    if (simOperator.equals("46007")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 49679478:
                                    if (simOperator.equals("46008")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 49679479:
                                    if (simOperator.equals("46009")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                            }
                    }
                } else if (simOperator.equals("46011")) {
                    c = '\t';
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        anO = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        anO = 3;
                        break;
                    case 7:
                    case '\b':
                    case '\t':
                        anO = 2;
                        break;
                    default:
                        anO = 0;
                        break;
                }
            }
            if (anO == 0 && !TextUtils.isEmpty(str)) {
                if (!str.startsWith("46000") && !str.startsWith("46002")) {
                    if (str.startsWith("46001")) {
                        anO = 3;
                    } else if (str.startsWith("46003")) {
                        anO = 2;
                    }
                }
                anO = 1;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        anP = anO == 0;
        return anO;
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo cv(Context context) {
        ConnectivityManager connectivityManager;
        if (SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static int cw(Context context) {
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, com.kuaishou.weapon.p0.h.c)) {
            try {
                NetworkInfo cv = cv(context);
                if (!(cv != null && cv.isConnected())) {
                    return 0;
                }
                if (1 == cv.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int g = g(context, telephonyManager.getNetworkType());
                    if (g != 20) {
                        switch (g) {
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
                                return 3;
                            case 13:
                                return 4;
                            default:
                                return 0;
                        }
                    }
                    return 5;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static boolean dM(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean dN(String str) {
        return m(str, 3000);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[Catch: Exception -> 0x0075, TRY_ENTER, TryCatch #1 {Exception -> 0x0075, blocks: (B:6:0x0012, B:9:0x001d, B:11:0x0026, B:20:0x004d, B:22:0x0053, B:24:0x0063, B:25:0x0069, B:12:0x002b, B:14:0x0035), top: B:33:0x0012 }] */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 26 || !SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId != -1 && (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29)) {
                try {
                    serviceState = (ServiceState) q.a((Object) telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                }
                if (serviceState != null) {
                    return i;
                }
                if (ap.zP()) {
                    Integer num = (Integer) q.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                    return num != null ? num.intValue() : i;
                } else if (dM(serviceState.toString())) {
                    return 20;
                } else {
                    return i;
                }
            }
            serviceState = telephonyManager.getServiceState();
            if (serviceState != null) {
            }
        } catch (Exception unused2) {
            return i;
        }
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cv = cv(context);
            if (cv == null) {
                return -1;
            }
            return cv.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cv = cv(context);
            if (cv != null && cv.isConnected()) {
                if (cv.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cv = cv(context);
            if (cv != null) {
                if (cv.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo cv = cv(context);
            if (cv != null && cv.isConnected()) {
                return 1 == cv.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @WorkerThread
    public static boolean m(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
