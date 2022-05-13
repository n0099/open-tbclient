package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class jg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kg5 a;

    public jg5(Context context, qg5 qg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qg5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        kg5 kg5Var = new kg5(2);
        this.a = kg5Var;
        kg5Var.A = context;
        kg5Var.a = qg5Var;
    }

    public vg5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new vg5(this.a) : (vg5) invokeV.objValue;
    }

    public jg5 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.a.T = z;
            return this;
        }
        return (jg5) invokeZ.objValue;
    }

    public jg5 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.a.R = z;
            return this;
        }
        return (jg5) invokeZ.objValue;
    }

    public jg5 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a.P = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.H = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.L = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 g(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) {
            this.a.e = calendar;
            return this;
        }
        return (jg5) invokeL.objValue;
    }

    public jg5 h(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            this.a.y = viewGroup;
            return this;
        }
        return (jg5) invokeL.objValue;
    }

    public jg5 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.a.O = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 j(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            kg5 kg5Var = this.a;
            kg5Var.l = str;
            kg5Var.m = str2;
            kg5Var.n = str3;
            kg5Var.o = str4;
            kg5Var.p = str5;
            kg5Var.q = str6;
            return this;
        }
        return (jg5) invokeCommon.objValue;
    }

    public jg5 k(int i, lg5 lg5Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, lg5Var)) == null) {
            kg5 kg5Var = this.a;
            kg5Var.x = i;
            kg5Var.c = lg5Var;
            return this;
        }
        return (jg5) invokeIL.objValue;
    }

    public jg5 l(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            this.a.Q = f;
            return this;
        }
        return (jg5) invokeF.objValue;
    }

    public jg5 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.a.N = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.a.M = i;
            return this;
        }
        return (jg5) invokeI.objValue;
    }

    public jg5 o(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            kg5 kg5Var = this.a;
            kg5Var.r = i;
            kg5Var.s = i2;
            kg5Var.t = i3;
            kg5Var.u = i4;
            kg5Var.v = i5;
            kg5Var.w = i6;
            return this;
        }
        return (jg5) invokeCommon.objValue;
    }

    public jg5 p(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zArr)) == null) {
            this.a.d = zArr;
            return this;
        }
        return (jg5) invokeL.objValue;
    }
}
