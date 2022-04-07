package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class xk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Method b;
    public Object c;

    public xk3(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 4099;
        if (cls == null) {
            return;
        }
        try {
            Object k = n44.k(cls, "getInstance", new Object[0]);
            this.c = k;
            if (k != null) {
                Object h = n44.h(k, "UNIPERF_EVENT_APP_START");
                this.a = h == null ? this.a : ((Integer) h).intValue();
            }
            Method i3 = n44.i(cls, "uniPerfEvent", Integer.TYPE, String.class, int[].class);
            this.b = i3;
            if (i3 != null) {
                i3.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static xk3 b(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = n44.b("android.iawareperf.UniPerf", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new xk3(cls);
        }
        return (xk3) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.c == null || this.b == null) ? false : true : invokeV.booleanValue;
    }

    public int d(int i, String str, int... iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, iArr)) == null) {
            if (c()) {
                try {
                    Object invoke = this.b.invoke(this.c, Integer.valueOf(i), str, iArr);
                    if (invoke == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeILL.intValue;
    }
}
