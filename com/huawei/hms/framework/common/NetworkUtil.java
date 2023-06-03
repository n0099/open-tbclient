package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class NetworkUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_RSSI = -127;
    public static final String STR_NSA = "5G_NSA";
    public static final String STR_SA = "5G_SA";
    public static final String TAG = "NetworkUtil";
    public static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(752804303, "Lcom/huawei/hms/framework/common/NetworkUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(752804303, "Lcom/huawei/hms/framework/common/NetworkUtil;");
        }
    }

    public static int groupNetworkType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i)) == null) {
            if (i != -1) {
                if (i != 1) {
                    return (i == 2 || i == 3 || i == 4 || i == 5) ? 6 : 0;
                }
                return 1;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes9.dex */
    public static final class NetType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public NetType() {
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
    }

    /* loaded from: classes9.dex */
    public static final class SignalType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
        public transient /* synthetic */ FieldHolder $fh;

        public SignalType() {
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
    }

    public NetworkUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getDnsServerIps(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            if (context != null) {
                return getNetworkType(getNetworkInfo(context), context);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getPrimaryNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            return groupNetworkType(getNetworkType(getNetworkInfo(context), context));
        }
        return invokeL.intValue;
    }

    public static int getWifiRssiLevel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            return ActivityUtil.isForeground(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return true;
            }
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSimReady(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            Object systemService = ContextCompat.getSystemService(context, "phone");
            if (systemService instanceof TelephonyManager) {
                telephonyManager = (TelephonyManager) systemService;
            } else {
                telephonyManager = null;
            }
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUserUnlocked(Context context) {
        InterceptResult invokeL;
        UserManager userManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24 && (userManager = (UserManager) ContextCompat.getSystemService(context, "user")) != null) {
                try {
                    return userManager.isUserUnlocked();
                } catch (RuntimeException e) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            return getNetworkStatus(context);
        }
        return (NetworkInfo.DetailedState) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static String[] getDnsServerIpsFromConnectionManager(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Network[] allNetworks;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            LinkedList linkedList = new LinkedList();
            if (Build.VERSION.SDK_INT >= 21 && context != null && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        for (Network network : connectivityManager.getAllNetworks()) {
                            if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                                for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                                    linkedList.add(inetAddress.getHostAddress());
                                }
                            }
                        }
                    }
                } catch (SecurityException e) {
                    Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName());
                } catch (RuntimeException e2) {
                    Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e2.getClass().getSimpleName());
                }
            }
            if (linkedList.isEmpty()) {
                return new String[0];
            }
            return (String[]) linkedList.toArray(new String[linkedList.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    public static String getMNC(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context == null || !isSimReady(context)) {
                return "unknown";
            }
            TelephonyManager telephonyManager = null;
            Object systemService = ContextCompat.getSystemService(context, "phone");
            if (systemService instanceof TelephonyManager) {
                telephonyManager = (TelephonyManager) systemService;
            }
            if (telephonyManager == null) {
                Logger.e(TAG, "getSubscriptionOperatorType: other error!");
                return "unknown";
            }
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!"46001".equals(networkOperator) && !"46006".equals(networkOperator) && !"46009".equals(networkOperator)) {
                if (!"46000".equals(networkOperator) && !"46002".equals(networkOperator) && !"46004".equals(networkOperator) && !"46007".equals(networkOperator)) {
                    if (!"46003".equals(networkOperator) && !"46005".equals(networkOperator) && !"46011".equals(networkOperator)) {
                        return "other";
                    }
                    return "China_Telecom";
                }
                return "China_Mobile";
            }
            return "China_Unicom";
        }
        return (String) invokeL.objValue;
    }

    public static int getMobileSingalStrengthUpPPlatfrom(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        int dbm;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            int i = Integer.MAX_VALUE;
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            int networkType = getNetworkType(context);
            try {
                if (networkType != 3) {
                    if (networkType != 4) {
                        if (networkType != 5) {
                            return Integer.MAX_VALUE;
                        }
                        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
                        if (cellSignalStrengths.size() <= 0) {
                            return Integer.MAX_VALUE;
                        }
                        dbm = ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getDbm();
                    } else {
                        List cellSignalStrengths2 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                        if (cellSignalStrengths2.size() <= 0) {
                            return Integer.MAX_VALUE;
                        }
                        dbm = ((CellSignalStrengthLte) cellSignalStrengths2.get(0)).getDbm();
                    }
                } else {
                    List cellSignalStrengths3 = signalStrength.getCellSignalStrengths(CellSignalStrengthCdma.class);
                    if (cellSignalStrengths3.size() > 0) {
                        dbm = ((CellSignalStrengthCdma) cellSignalStrengths3.get(0)).getDbm();
                    } else {
                        List cellSignalStrengths4 = signalStrength.getCellSignalStrengths(CellSignalStrengthTdscdma.class);
                        if (cellSignalStrengths4.size() > 0) {
                            dbm = ((CellSignalStrengthTdscdma) cellSignalStrengths4.get(0)).getDbm();
                        } else {
                            List cellSignalStrengths5 = signalStrength.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                            if (cellSignalStrengths5.size() <= 0) {
                                return Integer.MAX_VALUE;
                            }
                            dbm = ((CellSignalStrengthWcdma) cellSignalStrengths5.get(0)).getDbm();
                        }
                    }
                }
                i = dbm;
                return i;
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getMobileSingalStrength: throwable:" + th.getClass());
                return i;
            }
        }
        return invokeL.intValue;
    }

    public static String getHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new URI(str).getHost();
            } catch (URISyntaxException e) {
                Logger.w(TAG, e.getClass().getSimpleName());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static SignalStrength getSignalStrength(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 28) {
                Object systemService = ContextCompat.getSystemService(context, "phone");
                if (systemService instanceof TelephonyManager) {
                    return ((TelephonyManager) systemService).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength();
                }
                return null;
            }
            return null;
        }
        return (SignalStrength) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static int getHwNetworkType(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        ServiceState serviceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!ReflectionUtils.checkCompatible(EmuiUtil.BUILDEX_VERSION) || context == null || (telephonyManager = (TelephonyManager) ContextCompat.getSystemService(context, "phone")) == null) {
                return 0;
            }
            try {
                if (BuildEx.VERSION.EMUI_SDK_INT < 21 || (serviceState = telephonyManager.getServiceState()) == null) {
                    return 0;
                }
                return ServiceStateEx.getConfigRadioTechnology(serviceState);
            } catch (NoClassDefFoundError unused) {
                Logger.w(TAG, "NoClassDefFoundError occur in method getHwNetworkType.");
                return 0;
            } catch (NoSuchMethodError unused2) {
                Logger.w(TAG, "NoSuchMethodError occur in method getHwNetworkType.");
                return 0;
            } catch (SecurityException unused3) {
                Logger.w(TAG, "requires permission maybe missing.");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int getLteCqi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteCqi: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
                }
                return Integer.MAX_VALUE;
            }
            return getInfoWithReflect(signalStrength, "getLteCqi");
        }
        return invokeL.intValue;
    }

    public static int getLteRsrp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRsrp: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
                }
                return Integer.MAX_VALUE;
            }
            return getInfoWithReflect(signalStrength, "getLteRsrp");
        }
        return invokeL.intValue;
    }

    public static int getLteRsrq(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRsrq: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
                }
                return Integer.MAX_VALUE;
            }
            return getInfoWithReflect(signalStrength, "getLteRsrq");
        }
        return invokeL.intValue;
    }

    public static int getLteRssi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                    }
                }
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRssi: throwable:" + th.getClass());
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getLteRssnr(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRssnr: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
                }
                return Integer.MAX_VALUE;
            }
            return getInfoWithReflect(signalStrength, "getLteRssnr");
        }
        return invokeL.intValue;
    }

    public static int getMobileRsrp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return Integer.MAX_VALUE;
            }
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    return getMobileSingalStrengthUpPPlatfrom(context);
                }
                return getInfoWithReflect(signalStrength, "getDbm");
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getDbm: throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return invokeL.intValue;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null) {
                return null;
            }
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (RuntimeException e) {
                String str = TAG;
                Logger.i(str, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static int getNrCsiRsrp(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrCsiRsrp: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getNrCsiRsrq(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrCsiRsrq: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getNrCsiSinr(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrCsiSinr: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getNrSsRsrp(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrSsRsrp: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getNrSsRsrq(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrSsRsrq: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getNrSsSinr(Context context) {
        InterceptResult invokeL;
        SignalStrength signalStrength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getNrSsSinr: throwable:" + th.getClass());
            }
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public static int getWifiRssi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (context == null) {
                return -127;
            }
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (!(systemService instanceof WifiManager)) {
                return -127;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                    return -127;
                }
                return connectionInfo.getRssi();
            } catch (RuntimeException e) {
                String str = TAG;
                Logger.i(str, "getWifiRssiLevel did not has permission!" + e.getClass().getSimpleName() + e.getMessage());
                return -127;
            }
        }
        return invokeL.intValue;
    }

    public static int netWork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            int networkType = getNetworkType(context);
            String str = TAG;
            Logger.v(str, "newWorkType " + networkType);
            if (networkType == 4) {
                if (TextUtils.equals(STR_NSA, getNetWorkNSAorSA())) {
                    return 7;
                }
                return networkType;
            } else if (networkType == 5 && TextUtils.equals(STR_SA, getNetWorkNSAorSA())) {
                return 8;
            } else {
                return networkType;
            }
        }
        return invokeL.intValue;
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            int i = 0;
            if (context != null && Build.VERSION.SDK_INT >= 24 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                Object systemService = ContextCompat.getSystemService(context, "connectivity");
                if (systemService instanceof ConnectivityManager) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                    try {
                        if (connectivityManager.isActiveNetworkMetered()) {
                            i = connectivityManager.getRestrictBackgroundStatus();
                        } else {
                            Logger.v(TAG, "ConnectType is not Mobile Network!");
                        }
                    } catch (RuntimeException e) {
                        Logger.e(TAG, "SystemServer error:", e);
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, signalStrength, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    Method declaredMethod = SignalStrength.class.getDeclaredMethod(str, new Class[0]);
                    AccessController.doPrivileged(new PrivilegedAction(declaredMethod) { // from class: com.huawei.hms.framework.common.NetworkUtil.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Method val$method;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {declaredMethod};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$method = declaredMethod;
                        }

                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                this.val$method.setAccessible(true);
                                return null;
                            }
                            return invokeV.objValue;
                        }
                    });
                    return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
                }
                return Integer.MAX_VALUE;
            } catch (IllegalAccessException unused) {
                String str2 = TAG;
                Logger.i(str2, str + " : cannot access");
                return Integer.MAX_VALUE;
            } catch (NoSuchMethodException unused2) {
                String str3 = TAG;
                Logger.i(str3, str + " : function not found");
                return Integer.MAX_VALUE;
            } catch (InvocationTargetException unused3) {
                String str4 = TAG;
                Logger.i(str4, str + " : InvocationTargetException");
                return Integer.MAX_VALUE;
            } catch (Throwable th) {
                String str5 = TAG;
                Logger.i(str5, str + " : throwable:" + th.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return invokeLL.intValue;
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, networkInfo, context)) == null) {
            if (networkInfo != null && networkInfo.isConnected()) {
                int type = networkInfo.getType();
                if (1 == type || 13 == type) {
                    return 1;
                }
                if (type == 0) {
                    int hwNetworkType = getHwNetworkType(context);
                    String str = TAG;
                    Logger.v(str, "getHwNetworkType return is: " + hwNetworkType);
                    if (hwNetworkType == 0) {
                        hwNetworkType = networkInfo.getSubtype();
                    }
                    if (hwNetworkType != 20) {
                        switch (hwNetworkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                i = 2;
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
                                i = 3;
                                break;
                            case 13:
                                i = 4;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    } else {
                        i = 5;
                    }
                    if (i == 0 && Build.VERSION.SDK_INT >= 25) {
                        if (hwNetworkType != 16) {
                            if (hwNetworkType == 17) {
                                return 3;
                            }
                        } else {
                            return 2;
                        }
                    } else {
                        return i;
                    }
                }
                return 0;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            HashMap hashMap = new HashMap();
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return hashMap;
            }
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                    if (cellSignalStrengths.size() > 0) {
                        hashMap.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                        hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp()));
                        hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq()));
                        hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr()));
                        hashMap.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi()));
                        hashMap.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi()));
                    }
                } else {
                    hashMap.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(signalStrength, "getDbm")));
                    hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrp")));
                    hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrq")));
                    hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRssnr")));
                    hashMap.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteCqi")));
                }
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRssi: throwable:" + th.getClass());
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            HashMap hashMap = new HashMap();
            SignalStrength signalStrength = getSignalStrength(context);
            if (signalStrength == null) {
                return hashMap;
            }
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
                    if (cellSignalStrengths.size() > 0) {
                        hashMap.put(SignalType.NR_DBM, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getDbm()));
                        hashMap.put(SignalType.NR_CSIRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp()));
                        hashMap.put(SignalType.NR_CSIRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq()));
                        hashMap.put(SignalType.NR_CSISINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr()));
                        hashMap.put(SignalType.NR_SSRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp()));
                        hashMap.put(SignalType.NR_SSRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq()));
                        hashMap.put(SignalType.NR_SSSINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr()));
                    }
                }
            } catch (Throwable th) {
                String str = TAG;
                Logger.i(str, "getLteRssi: throwable:" + th.getClass());
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String getNetWorkNSAorSA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
                int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
                String str = TAG;
                Logger.v(str, "phoneId " + default4GSlotId);
                boolean isNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
                String str2 = TAG;
                Logger.v(str2, "isNsa " + isNsaState);
                if (isNsaState) {
                    return STR_NSA;
                }
                return STR_SA;
            } catch (Throwable unused) {
                Logger.v(TAG, "isNsaState error");
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
            if (context != null) {
                Object systemService = ContextCompat.getSystemService(context, "connectivity");
                if (systemService instanceof ConnectivityManager) {
                    try {
                        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                            return detailedState;
                        }
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            detailedState = activeNetworkInfo.getDetailedState();
                        } else {
                            Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                        }
                    } catch (RuntimeException e) {
                        String str = TAG;
                        Logger.i(str, "getNetworkStatus exception" + e.getClass().getSimpleName() + e.getMessage());
                    }
                } else {
                    Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
                }
            }
            return detailedState;
        }
        return (NetworkInfo.DetailedState) invokeL.objValue;
    }

    public static String getWifiGatewayIp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                return " ";
            }
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (!(systemService instanceof WifiManager)) {
                return " ";
            }
            try {
                int i = ((WifiManager) systemService).getDhcpInfo().gateway;
                return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}).getHostAddress();
            } catch (RuntimeException | UnknownHostException e) {
                String str = TAG;
                Logger.i(str, "getWifiGatewayIp error!" + e.getClass().getSimpleName() + e.getMessage());
                return " ";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, networkInfo)) == null) {
            return getNetworkType(networkInfo, null);
        }
        return invokeL.intValue;
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, networkInfo)) == null) {
            return groupNetworkType(getNetworkType(networkInfo));
        }
        return invokeL.intValue;
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, networkInfo, networkInfo2)) == null) {
            if ((networkInfo == null || !networkInfo.isConnected()) && networkInfo2.isConnected()) {
                Logger.v(TAG, "Find network state changed to connected");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, networkInfo, networkInfo2)) == null) {
            if (networkInfo != null && networkInfo.isConnected() && networkInfo2.isConnected() && getPrimaryNetworkType(networkInfo) != getPrimaryNetworkType(networkInfo2)) {
                Logger.v(TAG, "Find activity network changed");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
