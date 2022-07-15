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
import com.baidu.sofire.utility.PermissionChecker;
import java.net.InetAddress;
/* loaded from: classes5.dex */
public final class ac {
    public static int a;
    public static boolean b;

    public static int a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[Catch: Exception -> 0x0075, TRY_ENTER, TryCatch #1 {Exception -> 0x0075, blocks: (B:6:0x0012, B:9:0x001d, B:11:0x0026, B:20:0x004d, B:22:0x0053, B:24:0x0063, B:25:0x0069, B:12:0x002b, B:14:0x0035), top: B:33:0x0012 }] */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 26 || !SystemUtil.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int a2 = a();
            if (a2 != -1 && (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29)) {
                try {
                    serviceState = (ServiceState) q.a((Object) telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(a2));
                } catch (Throwable unused) {
                }
                if (serviceState != null) {
                    return i;
                }
                if (am.a()) {
                    Integer num = (Integer) q.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                    return num != null ? num.intValue() : i;
                } else if (b(serviceState.toString())) {
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

    public static int a(Context context, String str) {
        if (context == null || a > 0 || b) {
            return a;
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
                        a = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        a = 3;
                        break;
                    case 7:
                    case '\b':
                    case '\t':
                        a = 2;
                        break;
                    default:
                        a = 0;
                        break;
                }
            }
            if (a == 0 && !TextUtils.isEmpty(str)) {
                if (!str.startsWith("46000") && !str.startsWith("46002")) {
                    if (str.startsWith("46001")) {
                        a = 3;
                    } else if (str.startsWith("46003")) {
                        a = 2;
                    }
                }
                a = 1;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        b = a == 0;
        return a;
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        if (SystemUtil.a(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @WorkerThread
    public static boolean a(String str) {
        return a(str, 3000);
    }

    @WorkerThread
    public static boolean a(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null) {
                if (a2.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isConnected()) {
                return 1 == a2.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isConnected()) {
                if (a2.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int e(Context context) {
        try {
            NetworkInfo a2 = a(context);
            if (a2 == null) {
                return -1;
            }
            return a2.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int f(Context context) {
        if (context != null && SystemUtil.a(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.a(context, PermissionChecker.READ_PHONE_STATE)) {
            try {
                NetworkInfo a2 = a(context);
                if (!(a2 != null && a2.isConnected())) {
                    return 0;
                }
                if (1 == a2.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int a3 = a(context, telephonyManager.getNetworkType());
                    if (a3 != 20) {
                        switch (a3) {
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
}
