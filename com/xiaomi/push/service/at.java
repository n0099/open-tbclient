package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class at {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f905a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071162643, "Lcom/xiaomi/push/service/at;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071162643, "Lcom/xiaomi/push/service/at;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f905a)) {
                f905a = com.xiaomi.push.bm.a(4);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f905a);
            long j2 = a;
            a = 1 + j2;
            sb.append(j2);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
