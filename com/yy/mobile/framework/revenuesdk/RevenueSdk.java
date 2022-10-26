package com.yy.mobile.framework.revenuesdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class RevenueSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RevenueSdk";
    public static Map iRevenueMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1259207915, "Lcom/yy/mobile/framework/revenuesdk/RevenueSdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1259207915, "Lcom/yy/mobile/framework/revenuesdk/RevenueSdk;");
                return;
            }
        }
        iRevenueMap = new HashMap();
    }

    public RevenueSdk() {
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

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iRLogDelegate) == null) {
            RLog.addLogDelegate(iRLogDelegate);
        }
    }

    public static synchronized IRevenue addRevenueConfig(int i, int i2, RevenueConfig revenueConfig) {
        InterceptResult invokeIIL;
        IRevenue iRevenue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, revenueConfig)) == null) {
            synchronized (RevenueSdk.class) {
                String revenueMapKey = getRevenueMapKey(i, i2);
                RLog.info(TAG, "initRevenue: appId =" + i + " userchanel=" + i2 + " mapKey=" + revenueMapKey);
                if (iRevenueMap.get(revenueMapKey) == null) {
                    try {
                        Revenue revenue = new Revenue(i, i2);
                        revenue.initConfig(revenueConfig);
                        RevenueDataParser.INSTANCE.registerDataReceivers(revenue);
                        iRevenueMap.put(revenueMapKey, revenue);
                    } catch (Exception e) {
                        RLog.error(TAG, "initRevenue error.", e);
                        return null;
                    }
                } else {
                    RevenueConfigCenter.addConfig(i, i2, revenueConfig);
                }
                iRevenue = (IRevenue) iRevenueMap.get(revenueMapKey);
            }
            return iRevenue;
        }
        return (IRevenue) invokeIIL.objValue;
    }

    public static synchronized List getAllRevenue() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (RevenueSdk.class) {
                arrayList = new ArrayList();
                for (int i = 0; i < iRevenueMap.size(); i++) {
                    arrayList.add(iRevenueMap.get(Integer.valueOf(i)));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static synchronized IRevenue getRevenue(int i, int i2) {
        InterceptResult invokeII;
        IRevenue iRevenue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            synchronized (RevenueSdk.class) {
                String revenueMapKey = getRevenueMapKey(i, i2);
                iRevenue = (IRevenue) iRevenueMap.get(revenueMapKey);
                if (iRevenue == null) {
                    RLog.error(TAG, "getRevenue == null,mapKey = %d", revenueMapKey);
                }
            }
            return iRevenue;
        }
        return (IRevenue) invokeII.objValue;
    }

    public static String getRevenueMapKey(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    public static synchronized void removeRevenueConfig(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            synchronized (RevenueSdk.class) {
                String revenueMapKey = getRevenueMapKey(i, i2);
                if (iRevenueMap.get(revenueMapKey) == null) {
                    RLog.error(TAG, "removeRevenueConfig buy get null mapKey:" + revenueMapKey, new Object[0]);
                    return;
                }
                iRevenueMap.remove(revenueMapKey);
                RLog.info(TAG, "removeRevenueConfig: appId =" + i + " userchanel=" + i2 + " mapKey=" + revenueMapKey + " mapSize:" + iRevenueMap.size());
                RevenueConfigCenter.removeConfig(i, i2);
            }
        }
    }
}
