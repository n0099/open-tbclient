package com.kuaishou.weapon.un;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "android.permission.INTERNET";

    /* renamed from: b  reason: collision with root package name */
    public static final String f55286b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c  reason: collision with root package name */
    public static final String f55287c = "android.permission.READ_PHONE_STATE";

    /* renamed from: d  reason: collision with root package name */
    public static final String f55288d = "android.permission.ACCESS_WIFI_STATE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f55289e = "android.permission.GET_TASKS";

    /* renamed from: f  reason: collision with root package name */
    public static final String f55290f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g  reason: collision with root package name */
    public static final String f55291g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h  reason: collision with root package name */
    public static final String f55292h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i  reason: collision with root package name */
    public static final String f55293i = "android.permission.READ_EXTERNAL_STORAGE";

    /* renamed from: j  reason: collision with root package name */
    public static final String f55294j = "android.permission.BIND_ACCESSIBILITY_SERVICE";
    public transient /* synthetic */ FieldHolder $fh;

    public s() {
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
                } catch (Throwable th) {
                    x0.a(th);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
