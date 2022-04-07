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
import com.repackage.fj2;
import com.repackage.gl2;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class iw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static q83 b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755604115, "Lcom/repackage/iw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755604115, "Lcom/repackage/iw2;");
                return;
            }
        }
        a = tg1.a;
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

    public iw2() {
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

    public static boolean B(gl2 gl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gl2Var)) == null) ? (a && gl2Var.n0()) || F(gl2Var.g0()) || mx1.e() || mx1.f() || gl2Var.p0() || (x() && gl2Var.R()) : invokeL.booleanValue;
    }

    public static boolean C(hl2 hl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hl2Var)) == null) ? (a && hl2Var.n0()) || F(hl2Var.g0()) || mx1.e() || mx1.f() || hl2Var.p0() || (x() && hl2Var.R()) : invokeL.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            j03 a0 = j03.a0();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? s() || r() || o() || y() || !A() || k() || h() || q() || x() || xa2.b(t()) : invokeV.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) || ay1.d() : invokeL.booleanValue;
    }

    public static Boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false)) : (Boolean) invokeV.objValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? mx1.e() || mx1.f() : invokeV.booleanValue;
    }

    public static Bundle I(hl2 hl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hl2Var)) == null) {
            if (C(hl2Var)) {
                gl2.a b2 = b();
                b2.v0(hl2Var.H());
                b2.I0(hl2Var.T());
                b2.R0(hl2Var.e0());
                b2.A0(hl2Var.n0());
                b2.L0(hl2Var.p0());
                b2.y0(hl2Var.L());
                b2.D0(hl2Var.s0());
                b2.K0(hl2Var.W());
                b2.P0(hl2Var.c0());
                b2.Z0(hl2Var.j0());
                b2.C0(hl2Var.O());
                b2.a1(hl2Var.k0());
                b2.T0(hl2Var.g0());
                b2.H1("0");
                b2.u0(hl2Var.G());
                b2.Q0(hl2Var.d0());
                if (F(hl2Var.g0()) || H() || hl2Var.p0()) {
                    b2.A1(hl2Var.H());
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
            o93.q(z);
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
        sz1 V;
        pz1 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, null) == null) || (V = wl2.U().V()) == null || (m = V.m()) == null) {
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
    public static gl2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? ((gl2.a) ((gl2.a) ((gl2.a) new gl2.a().S0(new PMSAppInfo())).B1("小程序测试").v0("10985873").O0(Color.parseColor("#FF308EF0"))).I0("1230000000000000")).y1("小程序简介").E1("测试服务类目").F1("测试主体信息").A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").H1("1.0").C1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png") : (gl2.a) invokeV.objValue;
    }

    public static fj2.g c(gl2 gl2Var, pe3 pe3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, gl2Var, pe3Var)) == null) {
            if (a && gl2Var.n0()) {
                return fj2.b.a(gl2Var, pe3Var);
            }
            if (F(gl2Var.g0())) {
                return fj2.f.a(gl2Var);
            }
            if (mx1.e()) {
                return nx1.a(gl2Var);
            }
            if (mx1.f()) {
                return cy1.a(gl2Var);
            }
            if (gl2Var.p0()) {
                return qx1.a(gl2Var);
            }
            return null;
        }
        return (fj2.g) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? o93.j() : invokeV.booleanValue;
    }

    public static String l(gl2 gl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, gl2Var)) == null) {
            if (a && gl2Var.n0()) {
                return fj2.b.g().getPath();
            }
            if (F(gl2Var.g0())) {
                return fj2.f.e().getPath();
            }
            if (mx1.e()) {
                return nx1.b().getPath();
            }
            if (mx1.f()) {
                return cy1.e().getPath();
            }
            return gl2Var.p0() ? qx1.d().getPath() : "";
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

    public static q83 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (b == null) {
                synchronized (iw2.class) {
                    if (b == null) {
                        q83 q83Var = new q83("swan_app_debug");
                        b = q83Var;
                        q83Var.f.addAll(c);
                    }
                }
            }
            return b;
        }
        return (q83) invokeV.objValue;
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
