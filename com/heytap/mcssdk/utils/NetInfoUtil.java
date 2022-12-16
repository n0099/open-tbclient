package com.heytap.mcssdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes8.dex */
public class NetInfoUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNAVAILABLE = -1;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = -101;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNAVAILABLE = -1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = -101;
    public transient /* synthetic */ FieldHolder $fh;

    public NetInfoUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String getNetType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null) {
                    String upperCase = activeNetworkInfo.getTypeName().toUpperCase();
                    if (upperCase.equals("MOBILE")) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        return !TextUtils.isEmpty(extraInfo) ? extraInfo.toUpperCase() : upperCase;
                    }
                    return upperCase;
                }
                return "0";
            } catch (Exception e) {
                LogUtil.e(e);
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkClassByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = -101;
            if (i != -101) {
                i2 = -1;
                if (i != -1) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 3;
                        default:
                            return 0;
                    }
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static String getNetworkType(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int i = 0;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        i = -101;
                    } else if (type == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        i = telephonyManager.getNetworkType();
                    }
                } else {
                    i = -1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int networkClassByType = getNetworkClassByType(i);
            return networkClassByType != -101 ? (networkClassByType == -1 || networkClassByType == 0) ? RomUtils.UNKNOWN : networkClassByType != 1 ? networkClassByType != 2 ? networkClassByType != 3 ? RomUtils.UNKNOWN : "4G" : "3G" : "2G" : "WIFI";
        }
        return (String) invokeL.objValue;
    }

    public static boolean is2GNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                String netType = getNetType(context);
                if (!netType.equals("UNINET") && !netType.equals("UNIWAP") && !netType.equals("CMNET") && !netType.equals("CMWAP") && !netType.equals("CTNET")) {
                    if (!netType.equals("CTWAP")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                LogUtil.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean is3GNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                String netType = getNetType(context);
                if (!netType.equals("3GNET")) {
                    if (!netType.equals("3GWAP")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                LogUtil.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isConnectNet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception e) {
                LogUtil.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isWapNet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String netType = getNetType(context);
            return netType.equals("CMWAP") || netType.equals("3GWAP") || netType.equals("UNIWAP");
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiNetWork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return getNetType(context).equals("WIFI");
            } catch (Exception e) {
                LogUtil.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
