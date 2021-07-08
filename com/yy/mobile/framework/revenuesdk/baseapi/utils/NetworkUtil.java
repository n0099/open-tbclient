package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes6.dex */
public class NetworkUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetworkUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static NetworkInfo getActiveNetworkFromService(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        return connectivityManager.getActiveNetworkInfo();
                    }
                    return null;
                } catch (Throwable th) {
                    RLog.error("NetworkUtils", "error on getActiveNetworkInfo " + th, new Object[0]);
                    return null;
                }
            }
            return null;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean isNetworkStrictlyAvailable(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (context == null) {
                    RLog.error("NetworkUtil", "isNetworkStrictlyAvailable context is NULL", new Object[0]);
                    return false;
                }
                NetworkInfo activeNetworkFromService = getActiveNetworkFromService(context);
                if (activeNetworkFromService != null && activeNetworkFromService.isAvailable() && activeNetworkFromService.isConnected()) {
                    return true;
                }
                if (activeNetworkFromService != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("network type = ");
                    sb.append(activeNetworkFromService.getType());
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(activeNetworkFromService.isAvailable() ? "available" : "inavailable");
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    String str2 = "";
                    sb.append(activeNetworkFromService.isConnected() ? "" : "not");
                    sb.append(" connected, ");
                    if (!activeNetworkFromService.isConnectedOrConnecting()) {
                        str2 = "not";
                    }
                    sb.append(str2);
                    sb.append(" isConnectedOrConnecting");
                    str = sb.toString();
                } else {
                    str = "no active network";
                }
                RLog.error("NetworkUtil", "isNetworkStrictlyAvailable network info" + str, new Object[0]);
                return false;
            } catch (Throwable th) {
                RLog.error("NetworkUtils", th.getLocalizedMessage(), new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
