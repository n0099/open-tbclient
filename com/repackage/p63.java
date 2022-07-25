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
public class p63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o63 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return new o63(g() ? pj2.A0().beginFlow(str) : null, mf4.d(str));
        }
        return (o63) invokeL.objValue;
    }

    public static void b(@NonNull o63 o63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, o63Var) == null) {
            if (g()) {
                pj2.A0().b(o63Var.b());
            }
            Flow a = o63Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull o63 o63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, o63Var) == null) {
            if (g()) {
                pj2.A0().c(o63Var.b());
            }
            Flow a = o63Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull o63 o63Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, o63Var, str, str2) == null) {
            if (g()) {
                pj2.A0().a(o63Var.b(), str, str2);
            }
            Flow a = o63Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void e(@NonNull o63 o63Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{o63Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                pj2.A0().g(o63Var.b(), str, str2, j);
            }
            Flow a = o63Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull o63 o63Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, o63Var, str) == null) {
            if (g()) {
                pj2.A0().h(o63Var.b(), str);
            }
            Flow a = o63Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? pj2.A0().e() : invokeV.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                pj2.A0().i(str, str2);
            }
            mf4.h(str, str2);
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                pj2.A0().f(str, jSONObject);
            }
            mf4.l(str2, jSONObject);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                pj2.A0().d(str, map);
            }
            mf4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                pj2.A0().f(str, jSONObject);
            }
            mf4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            pj2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            pj2.A0().f(str, jSONObject);
        }
    }
}
