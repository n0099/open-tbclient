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
/* loaded from: classes6.dex */
public class gl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;
    public Object b;

    public gl3(Class<?> cls) {
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
        if (cls == null) {
            return;
        }
        try {
            this.b = x44.m(cls);
            Method i3 = x44.i(cls, "perfEvent", Integer.TYPE, String.class, int[].class);
            this.a = i3;
            if (i3 != null) {
                i3.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static gl3 a(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = x44.b("com.hisi.perfhub.PerfHub", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new gl3(cls);
        }
        return (gl3) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.b == null || this.a == null) ? false : true : invokeV.booleanValue;
    }

    public int c(int i, String str, int... iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, iArr)) == null) {
            if (b()) {
                try {
                    Object invoke = this.a.invoke(this.b, Integer.valueOf(i), str, iArr);
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
