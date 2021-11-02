package com.yy.gslbsdk.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
/* loaded from: classes2.dex */
public class DeviceMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DeviceMgr";
    public static NetStatusInfo cur_network;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1780719942, "Lcom/yy/gslbsdk/device/DeviceMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1780719942, "Lcom/yy/gslbsdk/device/DeviceMgr;");
                return;
            }
        }
        cur_network = new NetStatusInfo();
    }

    public DeviceMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static NetworkInfo getActiveNetwork(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return null;
            }
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e2) {
                LogTools.printError(TAG, String.format(Locale.US, "getActiveNetwork error. msg: %s", e2.getMessage()));
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static int getISP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if ("CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE) && context != null) {
                try {
                    String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                    if (simOperator != null) {
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
                    }
                    return 0;
                } catch (Exception e2) {
                    LogTools.printError(TAG, "getISP() exception:" + e2.getMessage());
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static NetStatusInfo getNetworkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            NetStatusInfo netStatusInfo = new NetStatusInfo();
            netStatusInfo.setNetType(getNetworkType(context));
            netStatusInfo.setIsp(getISP(context));
            netStatusInfo.setSsid(getWiFiSsid(context));
            netStatusInfo.setNetworkStatus(NetworkStatus.getInstanceClone());
            return netStatusInfo;
        }
        return (NetStatusInfo) invokeL.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
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
                        if (activeNetworkInfo.getType() == 0) {
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
                        return 1;
                    }
                    return 0;
                } catch (Exception e2) {
                    LogTools.printError(TAG, "getNetworkType() exception:" + e2.getMessage());
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static String getWiFiSsid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? IpVersionController.getInstance().getCurrIpVerStr() : (String) invokeL.objValue;
    }

    public static boolean isChangeNetworkStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            NetStatusInfo networkInfo = getNetworkInfo(context);
            boolean z = !networkInfo.getNetStatusID().equals(cur_network.getNetStatusID());
            cur_network = networkInfo;
            return z;
        }
        return invokeL.booleanValue;
    }
}
