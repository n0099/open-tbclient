package com.kuaishou.weapon.p0;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class ct {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public ct() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && Engine.loadSuccess && !b) {
            boolean b2 = cr.b();
            int i = Build.VERSION.SDK_INT;
            if (b2 && i < 29 && i > 22) {
                a = Engine.off();
            }
            b = true;
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (b && a > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c()) {
                long a2 = cq.b.a();
                long a3 = cq.a.a();
                if (a == a2) {
                    return (int) a3;
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private int a(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, method)) == null) {
            try {
                if (a > 1 && method != null) {
                    return Engine.mmo(method, a, method.getModifiers());
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public int a(int i, Class cls, String str, Object... objArr) {
        Method a2;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), cls, str, objArr})) == null) {
            try {
                if (c() && (a2 = dh.a(cls, str, objArr)) != null) {
                    return Engine.mqc(a2, i);
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public int a(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, objArr)) == null) {
            try {
                if (c()) {
                    return a(dh.a(cls, str, objArr));
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLLL.intValue;
    }
}
