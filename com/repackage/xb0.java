package com.repackage;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xb0 implements Cloneable, Comparable<xb0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext a;
    public ub0 b;
    public tb0 c;
    public rb0 d;
    public vb0 e;
    public boolean f;
    public qb0 g;
    public wb0 h;
    public int i;
    public boolean j;

    public xb0(EGLContext eGLContext, int i, boolean z) {
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
        this.b = new ub0();
        this.c = new tb0();
        this.d = new sb0();
        this.e = new vb0();
        this.f = false;
        this.g = null;
        this.h = new wb0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public xb0 clone() {
        xb0 xb0Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                xb0Var = (xb0) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                xb0Var = null;
            }
            if (xb0Var != null) {
                xb0Var.m(this.e.clone());
                xb0Var.p(this.h.clone());
            }
            return xb0Var;
        }
        return (xb0) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(xb0 xb0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xb0Var)) == null) ? this.i < xb0Var.d() ? -1 : 1 : invokeL.intValue;
    }

    public vb0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (vb0) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.intValue;
    }

    public rb0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (rb0) invokeV.objValue;
    }

    public EGLContext f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (EGLContext) invokeV.objValue;
    }

    public qb0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (qb0) invokeV.objValue;
    }

    public wb0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (wb0) invokeV.objValue;
    }

    public tb0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (tb0) invokeV.objValue;
    }

    public ub0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (ub0) invokeV.objValue;
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

    public void m(vb0 vb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vb0Var) == null) {
            this.e = vb0Var;
        }
    }

    public void n(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.a = eGLContext;
        }
    }

    public void o(qb0 qb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qb0Var) == null) {
            this.g = qb0Var;
        }
    }

    public void p(wb0 wb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, wb0Var) == null) {
            this.h = wb0Var;
        }
    }

    public void q(ub0 ub0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ub0Var) == null) {
            this.b = ub0Var;
        }
    }
}
