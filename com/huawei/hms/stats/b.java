package com.huawei.hms.stats;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static HiAnalyticsInstance a;
    public transient /* synthetic */ FieldHolder $fh;

    public static HiAnalyticsInstance a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
            a = analyticsInstance;
            return analyticsInstance;
        }
        return (HiAnalyticsInstance) invokeL.objValue;
    }

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65537, null, context, i) == null) && a(context) != null) {
            a.onReport(i);
        }
    }

    public static void a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, context, i, str, linkedHashMap) == null) && a(context) != null) {
            a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) && a(context) != null) {
            a.onEvent(context, str, str2);
        }
    }
}
