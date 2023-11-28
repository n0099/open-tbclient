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
public final class ag {
    public static int aNO;
    public static boolean aNP;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo cj(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean fU(@NonNull String str) {
        if (!str.contains("nrState=NOT_RESTRICTED") && !str.contains("nrState=CONNECTED")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public static boolean fV(String str) {
        return t(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj == null) {
                return -1;
            }
            return cj.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                if (cj.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null) {
                if (cj.isConnected()) {
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
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                if (1 != cj.getType()) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int ck(Context context) {
        boolean z;
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, com.kuaishou.weapon.p0.g.c)) {
            try {
                NetworkInfo cj = cj(context);
                if (cj != null && cj.isConnected()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return 0;
                }
                if (1 == cj.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int m = m(context, telephonyManager.getNetworkType());
                    if (m != 20) {
                        switch (m) {
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

    public static int d(Context context, String str, boolean z) {
        if (context != null && aNO <= 0 && !aNP) {
            boolean z2 = true;
            try {
                if (!z) {
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
                                aNO = 1;
                                break;
                            case 4:
                            case 5:
                            case 6:
                                aNO = 3;
                                break;
                            case 7:
                            case '\b':
                            case '\t':
                                aNO = 2;
                                break;
                            default:
                                aNO = 0;
                                break;
                        }
                    }
                } else {
                    aNO = 0;
                }
                if (aNO == 0 && !TextUtils.isEmpty(str)) {
                    if (!str.startsWith("46000") && !str.startsWith("46002")) {
                        if (str.startsWith("46001")) {
                            aNO = 3;
                        } else if (str.startsWith("46003")) {
                            aNO = 2;
                        }
                    }
                    aNO = 1;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            if (aNO != 0) {
                z2 = false;
            }
            aNP = z2;
            return aNO;
        }
        return aNO;
    }

    public static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    @SuppressLint({"MissingPermission"})
    public static int m(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT >= 26 && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return i;
                }
                int subId = getSubId();
                if (subId == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    serviceState = (ServiceState) s.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                }
                if (serviceState == null) {
                    return i;
                }
                if (at.KB()) {
                    Integer num = (Integer) s.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                    if (num != null) {
                        return num.intValue();
                    }
                    return i;
                } else if (fU(serviceState.toString())) {
                    return 20;
                } else {
                    return i;
                }
            } catch (Exception unused) {
                return i;
            }
        }
        return i;
    }

    @WorkerThread
    public static boolean t(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
