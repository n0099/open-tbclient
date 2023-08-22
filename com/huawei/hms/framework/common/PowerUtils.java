package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PowerUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PowerUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class PowerMode {
        public static /* synthetic */ Interceptable $ic = null;
        public static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        public static int POWER_SAVER_MODE = 4;
        public static String SMART_MODE_STATUS = "SmartModeStatus";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1423485017, "Lcom/huawei/hms/framework/common/PowerUtils$PowerMode;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1423485017, "Lcom/huawei/hms/framework/common/PowerUtils$PowerMode;");
            }
        }

        public PowerMode() {
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
    }

    public PowerUtils() {
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

    public static boolean isAppIdleMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context != null) {
                String packageName = context.getPackageName();
                UsageStatsManager usageStatsManager = null;
                int i = Build.VERSION.SDK_INT;
                if (i >= 21) {
                    if (i >= 22) {
                        Object systemService = context.getSystemService("usagestats");
                        if (!(systemService instanceof UsageStatsManager)) {
                            return false;
                        }
                        usageStatsManager = (UsageStatsManager) systemService;
                    }
                } else {
                    Logger.i(TAG, "isAppIdleMode statsManager is null!");
                }
                if (usageStatsManager != null) {
                    if (Build.VERSION.SDK_INT < 23) {
                        return false;
                    }
                    return usageStatsManager.isAppInactive(packageName);
                }
                Logger.i(TAG, "isAppIdleMode statsManager is null!");
                return false;
            }
            Logger.i(TAG, "isAppIdleMode Context is null!");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isDozeIdleMode(Context context) {
        InterceptResult invokeL;
        PowerManager powerManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                if (systemService instanceof PowerManager) {
                    powerManager = (PowerManager) systemService;
                } else {
                    powerManager = null;
                }
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            return powerManager.isDeviceIdleMode();
                        } catch (RuntimeException e) {
                            Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                            return false;
                        }
                    }
                    Logger.i(TAG, "isDozeIdleMode is version control state!");
                    return false;
                }
                Logger.i(TAG, "isDozeIdleMode powerManager is null!");
                return false;
            }
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isInteractive(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context != null) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                if (systemService instanceof PowerManager) {
                    PowerManager powerManager = (PowerManager) systemService;
                    if (Build.VERSION.SDK_INT >= 20) {
                        try {
                            return powerManager.isInteractive();
                        } catch (RuntimeException e) {
                            Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context != null) {
                Object systemService = context.getSystemService("connectivity");
                if (systemService instanceof ConnectivityManager) {
                    connectivityManager = (ConnectivityManager) systemService;
                } else {
                    connectivityManager = null;
                }
                if (connectivityManager != null) {
                    if (Build.VERSION.SDK_INT < 16 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                        return 0;
                    }
                    if (connectivityManager.isActiveNetworkMetered()) {
                        if (Build.VERSION.SDK_INT < 24) {
                            return 0;
                        }
                        return connectivityManager.getRestrictBackgroundStatus();
                    }
                    Logger.v(TAG, "ConnectType is not Mobile Network!");
                    return 0;
                }
                Logger.i(TAG, "readDataSaverMode Context is null!");
                return 0;
            }
            Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
        return invokeL.intValue;
    }

    public static int readPowerSaverMode(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context != null) {
                int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), PowerMode.SMART_MODE_STATUS, PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
                if (systemInt == PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE) {
                    PowerManager powerManager = null;
                    Object systemService = ContextCompat.getSystemService(context, "power");
                    if (systemService instanceof PowerManager) {
                        powerManager = (PowerManager) systemService;
                    }
                    if (powerManager != null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            try {
                                if (powerManager.isPowerSaveMode()) {
                                    i = PowerMode.POWER_SAVER_MODE;
                                } else {
                                    i = PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
                                }
                                return i;
                            } catch (RuntimeException e) {
                                Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                                return systemInt;
                            }
                        }
                        Logger.i(TAG, "readPowerSaverMode is control by version!");
                        return systemInt;
                    }
                    return systemInt;
                }
                return systemInt;
            }
            Logger.i(TAG, "readPowerSaverMode Context is null!");
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isWhilteList(Context context) {
        InterceptResult invokeL;
        PowerManager powerManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context != null) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                if (systemService instanceof PowerManager) {
                    powerManager = (PowerManager) systemService;
                } else {
                    powerManager = null;
                }
                String packageName = context.getPackageName();
                if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                    try {
                        return powerManager.isIgnoringBatteryOptimizations(packageName);
                    } catch (RuntimeException e) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
