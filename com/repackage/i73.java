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
import com.repackage.rl2;
/* loaded from: classes6.dex */
public class i73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755665588, "Lcom/repackage/i73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755665588, "Lcom/repackage/i73;");
                return;
            }
        }
        a = eh1.a;
        b = false;
        c = false;
        bk2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(uq2 uq2Var, String str, ln1 ln1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uq2Var, str, ln1Var) == null) {
            e(uq2Var, str, ln1Var, null);
        }
    }

    public static void e(uq2 uq2Var, String str, ln1 ln1Var, String str2) {
        u03 a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, uq2Var, str, ln1Var, str2) == null) && d && (a0 = u03.a0()) != null) {
            rl2.a V = a0.V();
            x73 x73Var = new x73();
            x73Var.a = n73.n(V.G());
            x73Var.f = V.H();
            if (ly1.d()) {
                x73Var.c = "remote-debug";
            } else if (tw2.D()) {
                x73Var.c = "local-debug";
            } else {
                x73Var.c = V.T();
            }
            x73Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                x73Var.e = str;
            }
            if (uq2Var != null) {
                x73Var.a("path", uq2Var.a);
                x73Var.a("routeType", uq2Var.e);
                x73Var.a("routeid", uq2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                x73Var.a("errcode", str2);
            }
            if (ln1Var != null && ln1Var.c > 0) {
                x73Var.a("valuetype", ln1Var.g);
            }
            Bundle P = V.P();
            if (P != null) {
                x73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            x73Var.b(n73.k(V.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + x73Var.f());
            }
            n73.onEvent(x73Var);
        }
    }

    public static uq2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            d02 V = hm2.U().V();
            uq2 uq2Var = null;
            if (V == null) {
                return null;
            }
            a02 j = V.j((V.k() - i) - 1);
            if (j instanceof c02) {
                uq2Var = ((c02) j).l3();
                uq2Var.e = "1";
                uq2Var.f = str;
            }
            g(uq2Var);
            return uq2Var;
        }
        return (uq2) invokeLI.objValue;
    }

    public static void g(uq2 uq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, uq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(uq2Var, null, null);
        }
    }

    public static void h(uq2 uq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, uq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(uq2Var, null, null);
        }
    }

    public static void i(uq2 uq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, uq2Var) == null) {
            j(uq2Var, null);
        }
    }

    public static void j(uq2 uq2Var, nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, uq2Var, nc3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + uq2Var + " errCode=" + nc3Var);
            }
            if (c) {
                if (nc3Var == null) {
                    nc3Var = new nc3();
                    nc3Var.k(5L);
                    nc3Var.i(58L);
                    nc3Var.d("route check fail");
                }
                e(uq2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(nc3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (i73.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (i73.class) {
                b = z;
            }
        }
    }
}
