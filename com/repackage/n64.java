package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public Drawable e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public long j;
    public l64 k;
    public r64 l;

    public n64(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.c = -1;
        this.f = true;
        this.g = true;
        this.h = 0;
        this.i = 0;
        this.j = 0L;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.g = z;
    }

    public static n64 k(n64 n64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n64Var)) == null) {
            if (n64Var == null) {
                return null;
            }
            return new n64(n64Var.a, n64Var.b, n64Var.c, n64Var.g);
        }
        return (n64) invokeL.objValue;
    }

    public static n64 l(n64 n64Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, n64Var, z)) == null) {
            if (n64Var == null) {
                return null;
            }
            return new n64(n64Var.a, n64Var.b, n64Var.c, z);
        }
        return (n64) invokeLZ.objValue;
    }

    public Drawable a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Drawable drawable = this.e;
            if (drawable != null) {
                return drawable;
            }
            if (this.c <= 0) {
                return null;
            }
            return context.getResources().getDrawable(this.c);
        }
        return (Drawable) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public r64 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (r64) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.intValue;
    }

    public l64 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (l64) invokeV.objValue;
    }

    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            String str = this.d;
            if (str != null) {
                return str;
            }
            if (this.b <= 0) {
                return null;
            }
            return context.getResources().getString(this.b);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.j = j;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.i = i;
        }
    }

    public void p(l64 l64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l64Var) == null) {
            this.k = l64Var;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b = i;
        }
    }
}
