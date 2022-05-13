package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a73 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return new a73(g() ? bk2.A0().beginFlow(str) : null, zf4.d(str));
        }
        return (a73) invokeL.objValue;
    }

    public static void b(@NonNull a73 a73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, a73Var) == null) {
            if (g()) {
                bk2.A0().b(a73Var.b());
            }
            Flow a = a73Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull a73 a73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, a73Var) == null) {
            if (g()) {
                bk2.A0().c(a73Var.b());
            }
            Flow a = a73Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull a73 a73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, a73Var, str, str2) == null) {
            if (g()) {
                bk2.A0().a(a73Var.b(), str, str2);
            }
            Flow a = a73Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void e(@NonNull a73 a73Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{a73Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                bk2.A0().g(a73Var.b(), str, str2, j);
            }
            Flow a = a73Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull a73 a73Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, a73Var, str) == null) {
            if (g()) {
                bk2.A0().h(a73Var.b(), str);
            }
            Flow a = a73Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? bk2.A0().e() : invokeV.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                bk2.A0().i(str, str2);
            }
            zf4.h(str, str2);
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                bk2.A0().f(str, jSONObject);
            }
            zf4.l(str2, jSONObject);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                bk2.A0().d(str, map);
            }
            zf4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                bk2.A0().f(str, jSONObject);
            }
            zf4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            bk2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            bk2.A0().f(str, jSONObject);
        }
    }
}
