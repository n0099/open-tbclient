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
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class HiAnalyticsUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static HiAnalyticsUtil b;
    public static HiAnalyticsUtils c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1810970541, "Lcom/huawei/hms/support/hianalytics/HiAnalyticsUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1810970541, "Lcom/huawei/hms/support/hianalytics/HiAnalyticsUtil;");
                return;
            }
        }
        a = new Object();
    }

    public HiAnalyticsUtil() {
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

    public static HiAnalyticsUtil getInstance() {
        InterceptResult invokeV;
        HiAnalyticsUtil hiAnalyticsUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a) {
                if (b == null) {
                    b = new HiAnalyticsUtil();
                    c = HiAnalyticsUtils.getInstance();
                }
                hiAnalyticsUtil = b;
            }
            return hiAnalyticsUtil;
        }
        return (HiAnalyticsUtil) invokeV.objValue;
    }

    @Deprecated
    public boolean hasError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!SystemUtils.isChinaROM()) {
                HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            String packageName = context.getPackageName();
            return "01||" + packageName + "|" + Util.getAppId(context) + "|60500300|" + str;
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public Map<String, String> getMapForBi(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            HashMap hashMap = new HashMap();
            String[] split = str.split("\\.");
            if (split.length >= 2) {
                String str2 = split[0];
                String str3 = split[1];
                String appId = Util.getAppId(context);
                hashMap.put("transId", TransactionIdCreater.getId(appId, str));
                hashMap.put("appid", appId);
                hashMap.put("service", str2);
                hashMap.put("apiName", str3);
                hashMap.put("package", context.getPackageName());
                hashMap.put("version", "6.5.0.300");
                hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader responseHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, responseHeader)) == null) {
            HashMap hashMap = new HashMap();
            if (responseHeader == null) {
                return hashMap;
            }
            hashMap.put("transId", responseHeader.getTransactionId());
            hashMap.put("appid", responseHeader.getActualAppID());
            hashMap.put("service", responseHeader.getSrvName());
            hashMap.put("apiName", responseHeader.getApiName());
            hashMap.put("package", responseHeader.getPkgName());
            hashMap.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
            hashMap.put("result", String.valueOf(responseHeader.getErrorCode()));
            hashMap.put("errorReason", responseHeader.getErrorReason());
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> getMapFromRequestHeader(ResponseHeader responseHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, responseHeader)) == null) {
            HashMap hashMap = new HashMap();
            if (responseHeader == null) {
                return hashMap;
            }
            hashMap.put("transId", responseHeader.getTransactionId());
            hashMap.put("appid", responseHeader.getActualAppID());
            hashMap.put("service", responseHeader.getSrvName());
            String apiName = responseHeader.getApiName();
            if (!TextUtils.isEmpty(apiName)) {
                String[] split = apiName.split("\\.");
                if (split.length >= 2) {
                    hashMap.put("apiName", split[1]);
                }
            }
            hashMap.put("package", responseHeader.getPkgName());
            hashMap.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
            hashMap.put("result", String.valueOf(responseHeader.getErrorCode()));
            hashMap.put("errorReason", responseHeader.getErrorReason());
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String versionCodeToName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return HiAnalyticsUtils.versionCodeToName(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean hasError(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return c.hasError(context);
        }
        return invokeL.booleanValue;
    }

    public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader requestHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestHeader)) == null) {
            HashMap hashMap = new HashMap();
            if (requestHeader == null) {
                return hashMap;
            }
            hashMap.put("transId", requestHeader.getTransactionId());
            hashMap.put("appid", requestHeader.getActualAppID());
            hashMap.put("service", requestHeader.getSrvName());
            hashMap.put("apiName", requestHeader.getApiName());
            hashMap.put("package", requestHeader.getPkgName());
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public Map<String, String> getMapFromRequestHeader(RequestHeader requestHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestHeader)) == null) {
            HashMap hashMap = new HashMap();
            if (requestHeader == null) {
                return hashMap;
            }
            hashMap.put("transId", requestHeader.getTransactionId());
            hashMap.put("appid", requestHeader.getActualAppID());
            hashMap.put("service", requestHeader.getSrvName());
            String apiName = requestHeader.getApiName();
            if (!TextUtils.isEmpty(apiName)) {
                String[] split = apiName.split("\\.");
                if (split.length >= 2) {
                    hashMap.put("apiName", split[1]);
                }
            }
            hashMap.put("package", requestHeader.getPkgName());
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) {
            c.onBuoyEvent(context, str, str2);
        }
    }

    public void onEvent(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, context, str, str2) == null) && context != null) {
            onEvent2(context, str, a(context, str2));
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, str2) == null) {
            c.onEvent2(context, str, str2);
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, str, map) == null) {
            c.onNewEvent(context, str, map);
        }
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, map) == null) {
            c.onEvent(context, str, map);
        }
    }
}
