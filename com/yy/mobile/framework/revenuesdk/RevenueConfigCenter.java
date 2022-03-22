package com.yy.mobile.framework.revenuesdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class RevenueConfigCenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RevenueConfigCenter";
    public static Map<String, RevenueConfig> configMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-72918128, "Lcom/yy/mobile/framework/revenuesdk/RevenueConfigCenter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-72918128, "Lcom/yy/mobile/framework/revenuesdk/RevenueConfigCenter;");
                return;
            }
        }
        configMap = new HashMap();
    }

    public RevenueConfigCenter() {
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

    public static void addConfig(int i, int i2, RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, null, i, i2, revenueConfig) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
            RLog.info(TAG, "addConfig mapKey:" + revenueConfigMapKey);
            configMap.put(revenueConfigMapKey, revenueConfig);
        }
    }

    public static RevenueConfig getConfig(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
            RLog.debug(TAG, "getConfig mapKey:" + revenueConfigMapKey);
            return configMap.get(revenueConfigMapKey);
        }
        return (RevenueConfig) invokeII.objValue;
    }

    public static String getRevenueConfigMapKey(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    public static void removeConfig(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65541, null, i, i2) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i, i2);
            RLog.info(TAG, "removeConfig mapKey:" + revenueConfigMapKey);
            configMap.remove(revenueConfigMapKey);
        }
    }
}
