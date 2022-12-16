package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class bd {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f946a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071163108, "Lcom/xiaomi/push/service/bd;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071163108, "Lcom/xiaomi/push/service/bd;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f946a)) {
                f946a = com.xiaomi.push.bp.a(4);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f946a);
            long j = a;
            a = 1 + j;
            sb.append(j);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
