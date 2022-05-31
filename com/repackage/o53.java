package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n53 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return new n53(g() ? oi2.A0().beginFlow(str) : null, me4.d(str));
        }
        return (n53) invokeL.objValue;
    }

    public static void b(@NonNull n53 n53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, n53Var) == null) {
            if (g()) {
                oi2.A0().b(n53Var.b());
            }
            Flow a = n53Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull n53 n53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, n53Var) == null) {
            if (g()) {
                oi2.A0().c(n53Var.b());
            }
            Flow a = n53Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull n53 n53Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, n53Var, str, str2) == null) {
            if (g()) {
                oi2.A0().a(n53Var.b(), str, str2);
            }
            Flow a = n53Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void e(@NonNull n53 n53Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{n53Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                oi2.A0().g(n53Var.b(), str, str2, j);
            }
            Flow a = n53Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull n53 n53Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, n53Var, str) == null) {
            if (g()) {
                oi2.A0().h(n53Var.b(), str);
            }
            Flow a = n53Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? oi2.A0().e() : invokeV.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                oi2.A0().i(str, str2);
            }
            me4.h(str, str2);
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                oi2.A0().f(str, jSONObject);
            }
            me4.l(str2, jSONObject);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                oi2.A0().d(str, map);
            }
            me4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                oi2.A0().f(str, jSONObject);
            }
            me4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            oi2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            oi2.A0().f(str, jSONObject);
        }
    }
}
