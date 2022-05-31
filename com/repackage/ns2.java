package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
import com.repackage.m52;
/* loaded from: classes6.dex */
public class ns2 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755459004, "Lcom/repackage/ns2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755459004, "Lcom/repackage/ns2;");
        }
    }

    public static void a(String str, @Nullable hp2 hp2Var) {
        hz2 L;
        ek2.a X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, hp2Var) == null) || (L = hz2.L()) == null || (X = L.X()) == null) {
            return;
        }
        HybridUbcFlow q = ms2.q("route", str);
        q.D("appid", X.H());
        q.D("swan", m83.i(X.j0(), X.G()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", X.v1());
        q.D("thirdversion", X.w1());
        q.D("mobile", xb3.c());
        q.D("scheme", X.W());
        q.D("launchid", X.V());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (hp2Var != null) {
            q.E("na_multi_jump_dst_path", hp2Var.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            up2.j(true);
            ms2.s("route", str);
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            mh2.c(i);
            HybridUbcFlow q = ms2.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            py1 H = uk2.U().H();
            q.E("na_multi_jump_src_path", H != null ? H.l3().a() : "");
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(ms2.q("route", str).h("sub_state"), "1")) {
            ms2.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void e(m52.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            ms2.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            nl1 nl1Var = eVar.a;
            if (nl1Var != null) {
                nl1Var.y(str);
            }
            HybridUbcFlow q = ms2.q("route", str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
            ubcFlowEvent.h(eVar.d);
            q.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
            ubcFlowEvent2.h(eVar.e);
            q.F(ubcFlowEvent2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.T();
        }
    }
}
