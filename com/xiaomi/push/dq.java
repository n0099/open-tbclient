package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class dq {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    @Deprecated

    /* renamed from: a  reason: collision with other field name */
    public static final String f222a;
    @Deprecated
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56376493, "Lcom/xiaomi/push/dq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56376493, "Lcom/xiaomi/push/dq;");
                return;
            }
        }
        a = new Object();
        f222a = String.valueOf(hl.o.a());
        b = String.valueOf(hl.p.a());
    }
}
