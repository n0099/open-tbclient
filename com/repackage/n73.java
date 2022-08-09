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
import com.repackage.wl2;
/* loaded from: classes6.dex */
public class n73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755516633, "Lcom/repackage/n73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755516633, "Lcom/repackage/n73;");
                return;
            }
        }
        a = jh1.a;
        b = false;
        c = false;
        gk2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(zq2 zq2Var, String str, qn1 qn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zq2Var, str, qn1Var) == null) {
            e(zq2Var, str, qn1Var, null);
        }
    }

    public static void e(zq2 zq2Var, String str, qn1 qn1Var, String str2) {
        z03 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, zq2Var, str, qn1Var, str2) == null) && d && (b0 = z03.b0()) != null) {
            wl2.a W = b0.W();
            c83 c83Var = new c83();
            c83Var.a = s73.n(W.G());
            c83Var.f = W.H();
            if (qy1.d()) {
                c83Var.c = "remote-debug";
            } else if (yw2.D()) {
                c83Var.c = "local-debug";
            } else {
                c83Var.c = W.T();
            }
            c83Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                c83Var.e = str;
            }
            if (zq2Var != null) {
                c83Var.a("path", zq2Var.a);
                c83Var.a("routeType", zq2Var.e);
                c83Var.a("routeid", zq2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                c83Var.a("errcode", str2);
            }
            if (qn1Var != null && qn1Var.c > 0) {
                c83Var.a("valuetype", qn1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                c83Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            c83Var.b(s73.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + c83Var.f());
            }
            s73.onEvent(c83Var);
        }
    }

    public static zq2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            i02 V = mm2.U().V();
            zq2 zq2Var = null;
            if (V == null) {
                return null;
            }
            f02 j = V.j((V.k() - i) - 1);
            if (j instanceof h02) {
                zq2Var = ((h02) j).m3();
                zq2Var.e = "1";
                zq2Var.f = str;
            }
            g(zq2Var);
            return zq2Var;
        }
        return (zq2) invokeLI.objValue;
    }

    public static void g(zq2 zq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, zq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(zq2Var, null, null);
        }
    }

    public static void h(zq2 zq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, zq2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(zq2Var, null, null);
        }
    }

    public static void i(zq2 zq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, zq2Var) == null) {
            j(zq2Var, null);
        }
    }

    public static void j(zq2 zq2Var, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, zq2Var, sc3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + zq2Var + " errCode=" + sc3Var);
            }
            if (c) {
                if (sc3Var == null) {
                    sc3Var = new sc3();
                    sc3Var.k(5L);
                    sc3Var.i(58L);
                    sc3Var.d("route check fail");
                }
                e(zq2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(sc3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (n73.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (n73.class) {
                b = z;
            }
        }
    }
}
