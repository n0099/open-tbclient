package com.repackage;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj2;
import com.repackage.rl2;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class tw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static b93 b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755276414, "Lcom/repackage/tw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755276414, "Lcom/repackage/tw2;");
                return;
            }
        }
        a = eh1.a;
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        c.add("aiapps_server_domains_debug_key");
        c.add("aiapps_use_extension_debug_key");
        c.add("aiapps_emit_live_debug_key");
        c.add("aiapps_emit_https_debug_key");
        c.add("aiapps_emit_wss_debug_key");
        c.add("aiapps_load_cts_debug_key");
        c.add("aiapps_env_data");
        c.add("aiapps_js_native_switch_key");
        c.add("aiapps_emit_game_core_debug_key");
        c.add("aiapps_emit_game_launch_mode_key");
    }

    public tw2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d("aiapps_websafe_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean B(rl2 rl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rl2Var)) == null) ? (a && rl2Var.n0()) || F(rl2Var.g0()) || xx1.e() || xx1.f() || rl2Var.p0() || (x() && rl2Var.R()) : invokeL.booleanValue;
    }

    public static boolean C(sl2 sl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sl2Var)) == null) ? (a && sl2Var.n0()) || F(sl2Var.g0()) || xx1.e() || xx1.f() || sl2Var.p0() || (x() && sl2Var.R()) : invokeL.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 != null) {
                return a0.V().p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? s() || r() || o() || y() || !A() || k() || h() || q() || x() || ib2.b(t()) : invokeV.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) || ly1.d() : invokeL.booleanValue;
    }

    public static Boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false)) : (Boolean) invokeV.objValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? xx1.e() || xx1.f() : invokeV.booleanValue;
    }

    public static Bundle I(sl2 sl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, sl2Var)) == null) {
            if (C(sl2Var)) {
                rl2.a b2 = b();
                b2.v0(sl2Var.H());
                b2.I0(sl2Var.T());
                b2.R0(sl2Var.e0());
                b2.A0(sl2Var.n0());
                b2.L0(sl2Var.p0());
                b2.y0(sl2Var.L());
                b2.D0(sl2Var.s0());
                b2.K0(sl2Var.W());
                b2.P0(sl2Var.c0());
                b2.Z0(sl2Var.j0());
                b2.C0(sl2Var.O());
                b2.a1(sl2Var.k0());
                b2.T0(sl2Var.g0());
                b2.H1("0");
                b2.u0(sl2Var.G());
                b2.Q0(sl2Var.d0());
                if (F(sl2Var.g0()) || H() || sl2Var.p0()) {
                    b2.A1(sl2Var.H());
                }
                return b2.D();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static void J(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            u().putBoolean(str, z);
        }
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            u().putString("aiapps_env_data", str);
        }
    }

    public static void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            J("aiapps_emit_game_core_debug_key", z);
        }
    }

    public static void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            z93.q(z);
        }
    }

    public static void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            J("aiapps_emit_https_debug_key", z);
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            J("aiapps_js_native_switch_key", z);
        }
    }

    public static void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            J("aiapps_emit_wss_debug_key", z);
        }
    }

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            J("aiapps_emit_live_debug_key", z);
        }
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            J("aiapps_load_cts_debug_key", z);
        }
    }

    public static void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, null, i) == null) {
            u().putInt("aiapps_pms_host_env", i);
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            J("aiapps_server_domains_debug_key", z);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            J("aiapps_emit_game_launch_mode_key", z);
        }
    }

    public static void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            J("aiapps_use_extension_debug_key", z);
        }
    }

    public static void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            J("aiapps_websafe_debug_key", z);
        }
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? u().getBoolean("swan_debug_forbid_sample", true) : invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? u().getBoolean("swan_debug_force_ab", false) : invokeV.booleanValue;
    }

    public static void Z() {
        d02 V;
        a02 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, null) == null) || (V = hm2.U().V()) == null || (m = V.m()) == null) {
            return;
        }
        m.R2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, extensionCore)) == null) {
            if (extensionCore == null) {
                return null;
            }
            extensionCore.extensionCoreVersionCode = 4294967297L;
            extensionCore.extensionCoreVersionName = "1.0.1";
            return extensionCore;
        }
        return (ExtensionCore) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static rl2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? ((rl2.a) ((rl2.a) ((rl2.a) new rl2.a().S0(new PMSAppInfo())).B1("小程序测试").v0("10985873").O0(Color.parseColor("#FF308EF0"))).I0("1230000000000000")).y1("小程序简介").E1("测试服务类目").F1("测试主体信息").A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").H1("1.0").C1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png") : (rl2.a) invokeV.objValue;
    }

    public static qj2.g c(rl2 rl2Var, af3 af3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, rl2Var, af3Var)) == null) {
            if (a && rl2Var.n0()) {
                return qj2.b.a(rl2Var, af3Var);
            }
            if (F(rl2Var.g0())) {
                return qj2.f.a(rl2Var);
            }
            if (xx1.e()) {
                return yx1.a(rl2Var);
            }
            if (xx1.f()) {
                return ny1.a(rl2Var);
            }
            if (rl2Var.p0()) {
                return by1.a(rl2Var);
            }
            return null;
        }
        return (qj2.g) invokeLL.objValue;
    }

    public static boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65567, null, str, z)) == null) ? u().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? d("aiapps_close_view_disable_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? d("aiapps_dashboard_enable_debug_key", false) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? u().getString("aiapps_env_data", "") : (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? d("aiapps_emit_game_core_debug_key", false) : invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? u().getString("swan_debug_so_url_key", "") : (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? u().getInt("swan_debug_open_so_key", -1) : invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? z93.j() : invokeV.booleanValue;
    }

    public static String l(rl2 rl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, rl2Var)) == null) {
            if (a && rl2Var.n0()) {
                return qj2.b.g().getPath();
            }
            if (F(rl2Var.g0())) {
                return qj2.f.e().getPath();
            }
            if (xx1.e()) {
                return yx1.b().getPath();
            }
            if (xx1.f()) {
                return ny1.e().getPath();
            }
            return rl2Var.p0() ? by1.d().getPath() : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? d("aiapps_force_authorized_key", false) : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? d("swan_game_fps_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? d("aiapps_emit_https_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? d("aiapps_js_native_switch_key", true) : invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? d("aiapps_emit_wss_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? d("aiapps_emit_live_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? d("aiapps_load_cts_debug_key", false) : invokeV.booleanValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? u().getInt("aiapps_pms_host_env", 0) : invokeV.intValue;
    }

    public static b93 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (b == null) {
                synchronized (tw2.class) {
                    if (b == null) {
                        b93 b93Var = new b93("swan_app_debug");
                        b = b93Var;
                        b93Var.f.addAll(c);
                    }
                }
            }
            return b;
        }
        return (b93) invokeV.objValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? d("aiapps_sconsole_scan_mode_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? d("aiapps_server_domains_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? d("aiapps_emit_game_launch_mode_key", false) : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? d("aiapps_use_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? d("aiapps_use_game_extension_debug_key", false) : invokeV.booleanValue;
    }
}
