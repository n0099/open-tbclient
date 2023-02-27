package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class HiAnalyticsUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Object c;
    public static final Object d;
    public static HiAnalyticsUtils e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(305513718, "Lcom/huawei/hms/support/hianalytics/HiAnalyticsUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(305513718, "Lcom/huawei/hms/support/hianalytics/HiAnalyticsUtils;");
                return;
            }
        }
        c = new Object();
        d = new Object();
    }

    public HiAnalyticsUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = c.a();
    }

    public static HiAnalyticsUtils getInstance() {
        InterceptResult invokeV;
        HiAnalyticsUtils hiAnalyticsUtils;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (c) {
                if (e == null) {
                    e = new HiAnalyticsUtils();
                }
                hiAnalyticsUtils = e;
            }
            return hiAnalyticsUtils;
        }
        return (HiAnalyticsUtils) invokeV.objValue;
    }

    public void enableLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HMSLog.i("HiAnalyticsUtils", "Enable Log");
            if (!this.b) {
                HmsHiAnalyticsUtils.enableLog();
            } else {
                HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
            }
        }
    }

    public boolean getInitFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.b) {
                return HmsHiAnalyticsUtils.getInitFlag();
            }
            return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        return invokeV.booleanValue;
    }

    public static LinkedHashMap<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
        return (LinkedHashMap) invokeL.objValue;
    }

    public static String versionCodeToName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
                try {
                    Integer.parseInt(str);
                    return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
                } catch (NumberFormatException unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (d) {
                if (this.a < 60) {
                    this.a++;
                } else {
                    this.a = 0;
                    if (!this.b) {
                        HmsHiAnalyticsUtils.onReport();
                    } else {
                        com.huawei.hms.stats.b.a(context, 0);
                        com.huawei.hms.stats.b.a(context, 1);
                    }
                }
            }
        }
    }

    public void enableLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            HMSLog.i("HiAnalyticsUtils", "Enable Log");
            if (!this.b) {
                HmsHiAnalyticsUtils.enableLog();
            } else {
                HiAnalyticTools.enableLog(context);
            }
        }
    }

    public boolean hasError(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return com.huawei.hms.stats.a.c(context);
        }
        return invokeL.booleanValue;
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) && !hasError(context) && context != null) {
            onEvent2(context, str, str2);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, context, str, str2) == null) && !hasError(context) && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            } else {
                com.huawei.hms.stats.b.a(context, str, str2);
            }
        }
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, context, str, map) == null) && !hasError(context) && map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            } else {
                com.huawei.hms.stats.b.a(context, 0, str, a(map));
                com.huawei.hms.stats.b.a(context, 1, str, a(map));
            }
            a(context);
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, map) == null) && !hasError(context) && map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            } else {
                com.huawei.hms.stats.b.a(context, 0, str, a(map));
                com.huawei.hms.stats.b.a(context, 1, str, a(map));
            }
            a(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, context, str, map) == null) && !hasError(context) && map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(0, str, a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, a(map));
                HmsHiAnalyticsUtils.onReport();
                return;
            }
            com.huawei.hms.stats.b.a(context, 0, str, a(map));
            com.huawei.hms.stats.b.a(context, 1, str, a(map));
            com.huawei.hms.stats.b.a(context, 0);
            com.huawei.hms.stats.b.a(context, 1);
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048585, this, context, str, map, i) != null) || hasError(context)) {
            return;
        }
        if (i != 0 && i != 1) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
        } else if (map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(i, str, a(map));
            } else {
                com.huawei.hms.stats.b.a(context, i, str, a(map));
            }
            a(context);
        }
    }

    public void onReport(Context context, String str, Map map, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048587, this, context, str, map, i) != null) || hasError(context)) {
            return;
        }
        if (i != 0 && i != 1) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
        } else if (map != null && !map.isEmpty() && context != null && getInitFlag()) {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(i, str, a(map));
                HmsHiAnalyticsUtils.onReport();
                return;
            }
            com.huawei.hms.stats.b.a(context, i, str, a(map));
            com.huawei.hms.stats.b.a(context, i);
        }
    }
}
