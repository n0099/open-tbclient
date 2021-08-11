package com.yy.mobile.framework.revenuesdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addConfig(int i2, int i3, RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, null, i2, i3, revenueConfig) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
            RLog.info(TAG, "addConfig mapKey:" + revenueConfigMapKey);
            configMap.put(revenueConfigMapKey, revenueConfig);
        }
    }

    public static RevenueConfig getConfig(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
            RLog.debug(TAG, "getConfig mapKey:" + revenueConfigMapKey);
            return configMap.get(revenueConfigMapKey);
        }
        return (RevenueConfig) invokeII.objValue;
    }

    public static String getRevenueConfigMapKey(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) {
            return i2 + "-" + i3;
        }
        return (String) invokeII.objValue;
    }

    public static void removeConfig(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3) == null) {
            String revenueConfigMapKey = getRevenueConfigMapKey(i2, i3);
            RLog.info(TAG, "removeConfig mapKey:" + revenueConfigMapKey);
            configMap.remove(revenueConfigMapKey);
        }
    }
}
