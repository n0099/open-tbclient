package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class bl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public Method b;
    public Method c;
    public Method d;
    public Method e;
    public Method f;
    public Method g;
    public Method h;
    public boolean i;

    public bl3(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
    }

    @SuppressLint({"WrongConstant"})
    public static bl3 a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Object obj = null;
            try {
                obj = context.getSystemService("mtk-perfservice");
                if (obj != null) {
                    k44.c(obj.getClass());
                }
            } catch (Throwable unused) {
            }
            return new bl3(obj);
        }
        return (bl3) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c()) {
                if (this.i) {
                    return this.b != null;
                }
                try {
                    this.i = true;
                    if (this.b == null) {
                        Method i = m44.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.b = i;
                        if (i != null) {
                            i.setAccessible(true);
                        }
                    }
                } catch (Throwable unused) {
                }
                return this.b != null;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && c()) {
            try {
                if (this.f == null) {
                    Method i2 = m44.i(this.a.getClass(), "userDisable", Integer.TYPE);
                    this.f = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.f != null) {
                    this.f.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) && c()) {
            try {
                if (this.e == null) {
                    Method i3 = m44.i(this.a.getClass(), "userEnableTimeoutMs", Integer.TYPE, Integer.TYPE);
                    this.e = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.e != null) {
                    this.e.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i, i2, i3, i4)) == null) {
            if (c()) {
                try {
                    if (this.b == null) {
                        Method i5 = m44.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.b = i5;
                        if (i5 != null) {
                            i5.setAccessible(true);
                        }
                    }
                    if (this.b == null || (invoke = this.b.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))) == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeIIII.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (c()) {
                try {
                    if (this.c == null) {
                        Method i = m44.i(this.a.getClass(), "userRegScn", new Class[0]);
                        this.c = i;
                        if (i != null) {
                            i.setAccessible(true);
                        }
                    }
                    Object invoke = this.c != null ? this.c.invoke(this.a, new Object[0]) : null;
                    if (invoke != null) {
                        return ((Integer) invoke).intValue();
                    }
                } catch (Throwable unused) {
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) && c()) {
            try {
                if (this.d == null) {
                    Method i7 = m44.i(this.a.getClass(), "userRegScnConfig", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                    this.d = i7;
                    if (i7 != null) {
                        i7.setAccessible(true);
                    }
                }
                if (this.d != null) {
                    this.d.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && c()) {
            try {
                if (this.g == null) {
                    Method i2 = m44.i(this.a.getClass(), "userUnreg", Integer.TYPE);
                    this.g = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.g != null) {
                    this.g.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && c()) {
            try {
                if (this.h == null) {
                    Method i2 = m44.i(this.a.getClass(), "userUnregScn", Integer.TYPE);
                    this.h = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.h != null) {
                    this.h.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
