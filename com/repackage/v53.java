package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
/* loaded from: classes7.dex */
public class v53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755280227, "Lcom/repackage/v53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755280227, "Lcom/repackage/v53;");
                return;
            }
        }
        a = rf1.a;
        b = false;
        c = false;
        oi2.g0().getSwitch("swan_app_use_route_statistic", false);
        d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + c);
            }
            boolean z = c;
            k(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + b);
            }
            boolean z = b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : invokeV.booleanValue;
    }

    public static void d(hp2 hp2Var, String str, yl1 yl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hp2Var, str, yl1Var) == null) {
            e(hp2Var, str, yl1Var, null);
        }
    }

    public static void e(hp2 hp2Var, String str, yl1 yl1Var, String str2) {
        hz2 a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, hp2Var, str, yl1Var, str2) == null) && d && (a0 = hz2.a0()) != null) {
            ek2.a V = a0.V();
            k63 k63Var = new k63();
            k63Var.a = a63.n(V.G());
            k63Var.f = V.H();
            if (yw1.d()) {
                k63Var.c = "remote-debug";
            } else if (gv2.D()) {
                k63Var.c = "local-debug";
            } else {
                k63Var.c = V.T();
            }
            k63Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                k63Var.e = str;
            }
            if (hp2Var != null) {
                k63Var.a("path", hp2Var.a);
                k63Var.a("routeType", hp2Var.e);
                k63Var.a("routeid", hp2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                k63Var.a("errcode", str2);
            }
            if (yl1Var != null && yl1Var.c > 0) {
                k63Var.a("valuetype", yl1Var.g);
            }
            Bundle P = V.P();
            if (P != null) {
                k63Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            k63Var.b(a63.k(V.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + k63Var.f());
            }
            a63.onEvent(k63Var);
        }
    }

    public static hp2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            qy1 V = uk2.U().V();
            hp2 hp2Var = null;
            if (V == null) {
                return null;
            }
            ny1 j = V.j((V.k() - i) - 1);
            if (j instanceof py1) {
                hp2Var = ((py1) j).l3();
                hp2Var.e = "1";
                hp2Var.f = str;
            }
            g(hp2Var);
            return hp2Var;
        }
        return (hp2) invokeLI.objValue;
    }

    public static void g(hp2 hp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, hp2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(hp2Var, null, null);
        }
    }

    public static void h(hp2 hp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hp2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(hp2Var, null, null);
        }
    }

    public static void i(hp2 hp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, hp2Var) == null) {
            j(hp2Var, null);
        }
    }

    public static void j(hp2 hp2Var, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, hp2Var, ab3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + hp2Var + " errCode=" + ab3Var);
            }
            if (c) {
                if (ab3Var == null) {
                    ab3Var = new ab3();
                    ab3Var.k(5L);
                    ab3Var.i(58L);
                    ab3Var.d("route check fail");
                }
                e(hp2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(ab3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (v53.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (v53.class) {
                b = z;
            }
        }
    }
}
