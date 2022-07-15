package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class cb {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 200;

    /* renamed from: a  reason: collision with other field name */
    public static long f878a = 52428800;

    /* renamed from: a  reason: collision with other field name */
    public static String f879a = "MessageInfo.db";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56377919, "Lcom/xiaomi/push/cb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56377919, "Lcom/xiaomi/push/cb;");
        }
    }
}
