package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "android.permission.INTERNET";
    public static final String b = "android.permission.ACCESS_NETWORK_STATE";
    public static final String c = "android.permission.READ_PHONE_STATE";
    public static final String d = "android.permission.ACCESS_WIFI_STATE";
    public static final String e = "android.permission.GET_TASKS";
    public static final String f = "android.permission.GET_ACCOUNTS";
    public static final String g = "android.permission.ACCESS_FINE_LOCATION";
    public static final String h = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String i = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String j = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String k = "android.permission.BIND_ACCESSIBILITY_SERVICE";
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null || str == null) {
                return -1;
            }
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return invokeLL.intValue;
    }

    public static boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, strArr)) == null) {
            if (strArr != null) {
                try {
                    for (String str : strArr) {
                        if (a(context, str) != 0) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
