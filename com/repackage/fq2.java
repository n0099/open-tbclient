package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class fq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return i != 3 ? 100 : 118;
                    }
                    return 112;
                }
                return 100;
            }
            return 82;
        }
        return invokeI.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Bundle b = ww2.b(gq2.class, null);
            if (b == null) {
                return 1;
            }
            return b.getInt("font_size_level", 1);
        }
        return invokeV.intValue;
    }

    public static NgWebView c(pz1 pz1Var) {
        InterceptResult invokeL;
        HashMap<String, rm1> V;
        rm1 rm1Var;
        qm1 u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pz1Var)) == null) {
            if (pz1Var instanceof rz1) {
                pm1 n3 = ((rz1) pz1Var).n3();
                if (n3 == null || n3.m() == null) {
                    if (n3 != null) {
                        return (NgWebView) n3.u();
                    }
                    return null;
                }
                return (NgWebView) n3.m().u();
            } else if (!(pz1Var instanceof wz1) || (V = d72.U().V()) == null || V.size() <= 0 || (rm1Var = V.get(bg3.c().h())) == null || !(rm1Var instanceof SwanWebModeWidget) || (u = rm1Var.u()) == null || !(u instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) u;
            }
        }
        return (NgWebView) invokeL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b() + 1 : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? yd3.f("3.200.101") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            SwanAppConfigData s = wl2.U().s();
            if (s == null) {
                return false;
            }
            return TextUtils.equals("none", s.e.q);
        }
        return invokeV.booleanValue;
    }

    public static void g(int i, int i2) {
        SwanAppActivity x;
        sz1 swanAppFragmentManager;
        pz1 m;
        NgWebView c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65542, null, i, i2) == null) || (x = i03.J().x()) == null || (swanAppFragmentManager = x.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || (c = c(m)) == null) {
            return;
        }
        if (!f()) {
            c.getSettings().setTextZoom(a(i));
            eq2.a(Integer.valueOf(i + 1), String.valueOf(i2));
        }
        h(i);
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
            zw2.e().h(new bx2(22, bundle));
        }
    }
}
