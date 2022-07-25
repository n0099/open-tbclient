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
import com.repackage.fl2;
/* loaded from: classes7.dex */
public class w63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755249475, "Lcom/repackage/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755249475, "Lcom/repackage/w63;");
                return;
            }
        }
        a = sg1.a;
        b = false;
        c = false;
        pj2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(iq2 iq2Var, String str, zm1 zm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iq2Var, str, zm1Var) == null) {
            e(iq2Var, str, zm1Var, null);
        }
    }

    public static void e(iq2 iq2Var, String str, zm1 zm1Var, String str2) {
        i03 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, iq2Var, str, zm1Var, str2) == null) && d && (b0 = i03.b0()) != null) {
            fl2.a W = b0.W();
            l73 l73Var = new l73();
            l73Var.a = b73.n(W.G());
            l73Var.f = W.H();
            if (zx1.d()) {
                l73Var.c = "remote-debug";
            } else if (hw2.D()) {
                l73Var.c = "local-debug";
            } else {
                l73Var.c = W.T();
            }
            l73Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                l73Var.e = str;
            }
            if (iq2Var != null) {
                l73Var.a("path", iq2Var.a);
                l73Var.a("routeType", iq2Var.e);
                l73Var.a("routeid", iq2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                l73Var.a("errcode", str2);
            }
            if (zm1Var != null && zm1Var.c > 0) {
                l73Var.a("valuetype", zm1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                l73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            l73Var.b(b73.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + l73Var.f());
            }
            b73.onEvent(l73Var);
        }
    }

    public static iq2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            rz1 V = vl2.U().V();
            iq2 iq2Var = null;
            if (V == null) {
                return null;
            }
            oz1 j = V.j((V.k() - i) - 1);
            if (j instanceof qz1) {
                iq2Var = ((qz1) j).m3();
                iq2Var.e = "1";
                iq2Var.f = str;
            }
            g(iq2Var);
            return iq2Var;
        }
        return (iq2) invokeLI.objValue;
    }

    public static void g(iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(iq2Var, null, null);
        }
    }

    public static void h(iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(iq2Var, null, null);
        }
    }

    public static void i(iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, iq2Var) == null) {
            j(iq2Var, null);
        }
    }

    public static void j(iq2 iq2Var, bc3 bc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, iq2Var, bc3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + iq2Var + " errCode=" + bc3Var);
            }
            if (c) {
                if (bc3Var == null) {
                    bc3Var = new bc3();
                    bc3Var.k(5L);
                    bc3Var.i(58L);
                    bc3Var.d("route check fail");
                }
                e(iq2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(bc3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (w63.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (w63.class) {
                b = z;
            }
        }
    }
}
