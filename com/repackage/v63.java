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
import com.repackage.el2;
/* loaded from: classes7.dex */
public class v63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755279266, "Lcom/repackage/v63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755279266, "Lcom/repackage/v63;");
                return;
            }
        }
        a = rg1.a;
        b = false;
        c = false;
        oj2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(hq2 hq2Var, String str, ym1 ym1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hq2Var, str, ym1Var) == null) {
            e(hq2Var, str, ym1Var, null);
        }
    }

    public static void e(hq2 hq2Var, String str, ym1 ym1Var, String str2) {
        h03 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, hq2Var, str, ym1Var, str2) == null) && d && (b0 = h03.b0()) != null) {
            el2.a W = b0.W();
            k73 k73Var = new k73();
            k73Var.a = a73.n(W.G());
            k73Var.f = W.H();
            if (yx1.d()) {
                k73Var.c = "remote-debug";
            } else if (gw2.D()) {
                k73Var.c = "local-debug";
            } else {
                k73Var.c = W.T();
            }
            k73Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                k73Var.e = str;
            }
            if (hq2Var != null) {
                k73Var.a("path", hq2Var.a);
                k73Var.a("routeType", hq2Var.e);
                k73Var.a("routeid", hq2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                k73Var.a("errcode", str2);
            }
            if (ym1Var != null && ym1Var.c > 0) {
                k73Var.a("valuetype", ym1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                k73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            k73Var.b(a73.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + k73Var.f());
            }
            a73.onEvent(k73Var);
        }
    }

    public static hq2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            qz1 V = ul2.U().V();
            hq2 hq2Var = null;
            if (V == null) {
                return null;
            }
            nz1 j = V.j((V.k() - i) - 1);
            if (j instanceof pz1) {
                hq2Var = ((pz1) j).m3();
                hq2Var.e = "1";
                hq2Var.f = str;
            }
            g(hq2Var);
            return hq2Var;
        }
        return (hq2) invokeLI.objValue;
    }

    public static void g(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, hq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(hq2Var, null, null);
        }
    }

    public static void h(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(hq2Var, null, null);
        }
    }

    public static void i(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, hq2Var) == null) {
            j(hq2Var, null);
        }
    }

    public static void j(hq2 hq2Var, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, hq2Var, ac3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + hq2Var + " errCode=" + ac3Var);
            }
            if (c) {
                if (ac3Var == null) {
                    ac3Var = new ac3();
                    ac3Var.k(5L);
                    ac3Var.i(58L);
                    ac3Var.d("route check fail");
                }
                e(hq2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(ac3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (v63.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (v63.class) {
                b = z;
            }
        }
    }
}
