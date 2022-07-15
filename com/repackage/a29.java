package com.repackage;

import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k29;
import com.repackage.z19;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b29 a;

    public a29(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b29.Q(context);
    }

    public void A(List<p19> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a.Z(list);
        }
    }

    public void B(r19 r19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r19Var) == null) {
            this.a.a0(r19Var);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b0();
        }
    }

    public boolean D(List<l19> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) ? this.a.c0(list) : invokeL.booleanValue;
    }

    public void E(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            this.a.d0(str, i, str2);
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.a.e0(str);
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.a.f0(str, str2);
        }
    }

    public void a(n29 n29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, n29Var) == null) {
            this.a.a(n29Var);
        }
    }

    public void b(n29 n29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n29Var) == null) {
            this.a.b(n29Var);
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            this.a.h(str, z);
        }
    }

    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            this.a.k(str, i);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.m();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.n();
        }
    }

    public boolean g(n29 n29Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, n29Var, str)) == null) ? this.a.o(n29Var, str) : invokeLL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.v() : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.w();
        }
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? this.a.x(str) : invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.y();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.a.z(str);
        }
    }

    public void m(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            this.a.B(str, i, j, jSONArray);
        }
    }

    public int n(n29 n29Var, n29 n29Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, n29Var, n29Var2)) == null) ? this.a.E(n29Var, n29Var2) : invokeLL.intValue;
    }

    public HashMap<String, String> o(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, arrayList)) == null) ? this.a.H(arrayList) : (HashMap) invokeL.objValue;
    }

    public l19 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? this.a.I(str) : (l19) invokeL.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.J() : invokeV.intValue;
    }

    public int r(ArrayList<String> arrayList, boolean z, n29 n29Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{arrayList, Boolean.valueOf(z), n29Var})) == null) {
            n29Var.M(10485760);
            return this.a.K(arrayList, z, n29Var);
        }
        return invokeCommon.intValue;
    }

    public k29.d s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a.R() : (k29.d) invokeV.objValue;
    }

    public int t(ArrayList<String> arrayList, boolean z, n29 n29Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{arrayList, Boolean.valueOf(z), n29Var})) == null) ? this.a.K(arrayList, z, n29Var) : invokeCommon.intValue;
    }

    public int u(n29 n29Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, n29Var)) == null) ? this.a.S(n29Var) : invokeL.intValue;
    }

    public Map<String, z19.a> v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) ? this.a.T(i) : (Map) invokeI.objValue;
    }

    public q19 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? this.a.U(str) : (q19) invokeL.objValue;
    }

    public void x(SparseArray<ArrayList> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, sparseArray) == null) {
            this.a.V(sparseArray);
        }
    }

    public void y(h19 h19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, h19Var) == null) {
            this.a.W(h19Var);
        }
    }

    public void z(p19 p19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, p19Var) == null) {
            this.a.Y(p19Var);
        }
    }
}
