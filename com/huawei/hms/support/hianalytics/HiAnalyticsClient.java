package com.huawei.hms.support.hianalytics;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;
import java.util.Map;
/* loaded from: classes9.dex */
public class HiAnalyticsClient extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HiAnalyticsClient() {
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

    @Deprecated
    public static String reportEntry(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            return reportEntry(context, str, Util.getAppId(context), 0);
        }
        return (String) invokeLL.objValue;
    }

    public static String reportEntry(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, str, i)) == null) {
            return reportEntry(context, str, Util.getAppId(context), i);
        }
        return (String) invokeLLI.objValue;
    }

    public static String reportEntry(Context context, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, context, str, str2, i)) == null) {
            String id = TransactionIdCreater.getId(str2, str);
            Map<String, String> mapForBi = a.getMapForBi(context, str);
            mapForBi.put("appid", str2);
            mapForBi.put("transId", id);
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i)));
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
            return id;
        }
        return (String) invokeLLLI.objValue;
    }

    public static void reportExit(Context context, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            reportExit(context, str, str2, Util.getAppId(context), i, i2, 0);
        }
    }

    public static void reportExit(Context context, String str, String str2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            reportExit(context, str, str2, Util.getAppId(context), i, i2, i3);
        }
    }

    public static void reportExit(Context context, String str, String str2, String str3, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            Map<String, String> mapForBi = a.getMapForBi(context, str);
            mapForBi.put("appid", str3);
            mapForBi.put("transId", str2);
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapForBi.put("statusCode", String.valueOf(i));
            mapForBi.put("result", String.valueOf(i2));
            mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i3)));
            mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
        }
    }
}
