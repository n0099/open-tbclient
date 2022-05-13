package com.repackage;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bd0 implements Cloneable, Comparable<bd0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext a;
    public yc0 b;
    public xc0 c;
    public vc0 d;
    public zc0 e;
    public boolean f;
    public uc0 g;
    public ad0 h;
    public int i;
    public boolean j;

    public bd0(EGLContext eGLContext, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eGLContext;
        this.i = i;
        this.j = z;
        this.b = new yc0();
        this.c = new xc0();
        this.d = new wc0();
        this.e = new zc0();
        this.f = false;
        this.g = null;
        this.h = new ad0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public bd0 clone() {
        bd0 bd0Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                bd0Var = (bd0) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                bd0Var = null;
            }
            if (bd0Var != null) {
                bd0Var.m(this.e.clone());
                bd0Var.p(this.h.clone());
            }
            return bd0Var;
        }
        return (bd0) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(bd0 bd0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bd0Var)) == null) ? this.i < bd0Var.d() ? -1 : 1 : invokeL.intValue;
    }

    public zc0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (zc0) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.intValue;
    }

    public vc0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (vc0) invokeV.objValue;
    }

    public EGLContext f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (EGLContext) invokeV.objValue;
    }

    public uc0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (uc0) invokeV.objValue;
    }

    public ad0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (ad0) invokeV.objValue;
    }

    public xc0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (xc0) invokeV.objValue;
    }

    public yc0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (yc0) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void m(zc0 zc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zc0Var) == null) {
            this.e = zc0Var;
        }
    }

    public void n(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.a = eGLContext;
        }
    }

    public void o(uc0 uc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uc0Var) == null) {
            this.g = uc0Var;
        }
    }

    public void p(ad0 ad0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ad0Var) == null) {
            this.h = ad0Var;
        }
    }

    public void q(yc0 yc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yc0Var) == null) {
            this.b = yc0Var;
        }
    }
}
