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
import com.repackage.gl2;
/* loaded from: classes7.dex */
public class x63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755219684, "Lcom/repackage/x63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755219684, "Lcom/repackage/x63;");
                return;
            }
        }
        a = tg1.a;
        b = false;
        c = false;
        qj2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(jq2 jq2Var, String str, an1 an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jq2Var, str, an1Var) == null) {
            e(jq2Var, str, an1Var, null);
        }
    }

    public static void e(jq2 jq2Var, String str, an1 an1Var, String str2) {
        j03 a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, jq2Var, str, an1Var, str2) == null) && d && (a0 = j03.a0()) != null) {
            gl2.a V = a0.V();
            m73 m73Var = new m73();
            m73Var.a = c73.n(V.G());
            m73Var.f = V.H();
            if (ay1.d()) {
                m73Var.c = "remote-debug";
            } else if (iw2.D()) {
                m73Var.c = "local-debug";
            } else {
                m73Var.c = V.T();
            }
            m73Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                m73Var.e = str;
            }
            if (jq2Var != null) {
                m73Var.a("path", jq2Var.a);
                m73Var.a("routeType", jq2Var.e);
                m73Var.a("routeid", jq2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                m73Var.a("errcode", str2);
            }
            if (an1Var != null && an1Var.c > 0) {
                m73Var.a("valuetype", an1Var.g);
            }
            Bundle P = V.P();
            if (P != null) {
                m73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            m73Var.b(c73.k(V.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + m73Var.f());
            }
            c73.onEvent(m73Var);
        }
    }

    public static jq2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            sz1 V = wl2.U().V();
            jq2 jq2Var = null;
            if (V == null) {
                return null;
            }
            pz1 j = V.j((V.k() - i) - 1);
            if (j instanceof rz1) {
                jq2Var = ((rz1) j).l3();
                jq2Var.e = "1";
                jq2Var.f = str;
            }
            g(jq2Var);
            return jq2Var;
        }
        return (jq2) invokeLI.objValue;
    }

    public static void g(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(jq2Var, null, null);
        }
    }

    public static void h(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, jq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(jq2Var, null, null);
        }
    }

    public static void i(jq2 jq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, jq2Var) == null) {
            j(jq2Var, null);
        }
    }

    public static void j(jq2 jq2Var, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, jq2Var, cc3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + jq2Var + " errCode=" + cc3Var);
            }
            if (c) {
                if (cc3Var == null) {
                    cc3Var = new cc3();
                    cc3Var.k(5L);
                    cc3Var.i(58L);
                    cc3Var.d("route check fail");
                }
                e(jq2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(cc3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (x63.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (x63.class) {
                b = z;
            }
        }
    }
}
