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
import com.repackage.pk2;
/* loaded from: classes6.dex */
public class g63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755726131, "Lcom/repackage/g63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755726131, "Lcom/repackage/g63;");
                return;
            }
        }
        a = cg1.a;
        b = false;
        c = false;
        zi2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(sp2 sp2Var, String str, jm1 jm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sp2Var, str, jm1Var) == null) {
            e(sp2Var, str, jm1Var, null);
        }
    }

    public static void e(sp2 sp2Var, String str, jm1 jm1Var, String str2) {
        sz2 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, sp2Var, str, jm1Var, str2) == null) && d && (b0 = sz2.b0()) != null) {
            pk2.a W = b0.W();
            v63 v63Var = new v63();
            v63Var.a = l63.n(W.G());
            v63Var.f = W.H();
            if (jx1.d()) {
                v63Var.c = "remote-debug";
            } else if (rv2.D()) {
                v63Var.c = "local-debug";
            } else {
                v63Var.c = W.T();
            }
            v63Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                v63Var.e = str;
            }
            if (sp2Var != null) {
                v63Var.a("path", sp2Var.a);
                v63Var.a("routeType", sp2Var.e);
                v63Var.a("routeid", sp2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                v63Var.a("errcode", str2);
            }
            if (jm1Var != null && jm1Var.c > 0) {
                v63Var.a("valuetype", jm1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                v63Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            v63Var.b(l63.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + v63Var.f());
            }
            l63.onEvent(v63Var);
        }
    }

    public static sp2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            bz1 V = fl2.U().V();
            sp2 sp2Var = null;
            if (V == null) {
                return null;
            }
            yy1 j = V.j((V.k() - i) - 1);
            if (j instanceof az1) {
                sp2Var = ((az1) j).m3();
                sp2Var.e = "1";
                sp2Var.f = str;
            }
            g(sp2Var);
            return sp2Var;
        }
        return (sp2) invokeLI.objValue;
    }

    public static void g(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, sp2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(sp2Var, null, null);
        }
    }

    public static void h(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, sp2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(sp2Var, null, null);
        }
    }

    public static void i(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, sp2Var) == null) {
            j(sp2Var, null);
        }
    }

    public static void j(sp2 sp2Var, lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sp2Var, lb3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + sp2Var + " errCode=" + lb3Var);
            }
            if (c) {
                if (lb3Var == null) {
                    lb3Var = new lb3();
                    lb3Var.k(5L);
                    lb3Var.i(58L);
                    lb3Var.d("route check fail");
                }
                e(sp2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(lb3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (g63.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (g63.class) {
                b = z;
            }
        }
    }
}
