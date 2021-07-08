package d.a.n0.a.u1.a;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.a2.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.f1.e.c;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.g.d;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47873a;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.n0.a.k2.g.a f47874b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f47875c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1000734587, "Ld/a/n0/a/u1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1000734587, "Ld/a/n0/a/u1/a/a;");
                return;
            }
        }
        f47873a = k.f45831a;
        HashSet hashSet = new HashSet();
        f47875c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        f47875c.add("aiapps_server_domains_debug_key");
        f47875c.add("aiapps_use_extension_debug_key");
        f47875c.add("aiapps_emit_live_debug_key");
        f47875c.add("aiapps_emit_https_debug_key");
        f47875c.add("aiapps_emit_wss_debug_key");
        f47875c.add("aiapps_load_cts_debug_key");
        f47875c.add("aiapps_env_data");
        f47875c.add("aiapps_js_native_switch_key");
        f47875c.add("aiapps_emit_game_core_debug_key");
        f47875c.add("aiapps_emit_game_launch_mode_key");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean A(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? (f47873a && bVar.m0()) || E(bVar.g0()) || d.a.n0.a.e0.f.b.e() || d.a.n0.a.e0.f.b.f() || bVar.o0() || (w() && bVar.R()) : invokeL.booleanValue;
    }

    public static boolean B(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) ? (f47873a && cVar.m0()) || E(cVar.g0()) || d.a.n0.a.e0.f.b.e() || d.a.n0.a.e0.f.b.f() || cVar.o0() || (w() && cVar.R()) : invokeL.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            e Q = e.Q();
            if (Q != null) {
                return Q.L().o0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? s() || r() || o() || x() || !z() || k() || h() || q() || w() : invokeV.booleanValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? !TextUtils.isEmpty(str) || d.a.n0.a.e0.f.e.e.d() : invokeL.booleanValue;
    }

    public static Boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false)) : (Boolean) invokeV.objValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.a.n0.a.e0.f.b.e() || d.a.n0.a.e0.f.b.f() : invokeV.booleanValue;
    }

    public static Bundle H(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            if (B(cVar)) {
                b.a b2 = b();
                b2.u0(cVar.H());
                b2.H0(cVar.T());
                b2.Q0(cVar.e0());
                b2.z0(cVar.m0());
                b2.K0(cVar.o0());
                b2.x0(cVar.L());
                b2.C0(cVar.r0());
                b2.J0(cVar.W());
                b2.O0(cVar.c0());
                b2.X0(cVar.i0());
                b2.B0(cVar.O());
                b2.Y0(cVar.j0());
                b2.S0(cVar.g0());
                b2.G1("0");
                b2.t0(cVar.G());
                b2.P0(cVar.d0());
                if (E(cVar.g0()) || G() || cVar.o0()) {
                    b2.z1(cVar.H());
                }
                return b2.C();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static void I(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            t().putBoolean(str, z);
        }
    }

    public static void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            t().putString("aiapps_env_data", str);
        }
    }

    public static void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            I("aiapps_emit_game_core_debug_key", z);
        }
    }

    public static void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            d.a.n0.a.m2.b.q(z);
        }
    }

    public static void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            I("aiapps_emit_https_debug_key", z);
        }
    }

    public static void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            I("aiapps_js_native_switch_key", z);
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            I("aiapps_emit_wss_debug_key", z);
        }
    }

    public static void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            I("aiapps_emit_live_debug_key", z);
        }
    }

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            I("aiapps_load_cts_debug_key", z);
        }
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            I("aiapps_server_domains_debug_key", z);
        }
    }

    public static void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
            I("aiapps_emit_game_launch_mode_key", z);
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            I("aiapps_use_extension_debug_key", z);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            I("aiapps_websafe_debug_key", z);
        }
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? t().getBoolean("swan_debug_forbid_sample", true) : invokeV.booleanValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? t().getBoolean("swan_debug_force_ab", false) : invokeV.booleanValue;
    }

    public static void X() {
        g W;
        d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, null) == null) || (W = f.V().W()) == null || (m = W.m()) == null) {
            return;
        }
        m.G2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, extensionCore)) == null) {
            if (extensionCore == null) {
                return null;
            }
            extensionCore.extensionCoreVersionCode = 4294967297L;
            extensionCore.extensionCoreVersionName = com.baidu.fsg.face.base.b.b.f5571e;
            return extensionCore;
        }
        return (ExtensionCore) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? ((b.a) ((b.a) ((b.a) new b.a().R0(new PMSAppInfo())).A1("小程序测试").u0("10985873").N0(Color.parseColor("#FF308EF0"))).H0("1230000000000000")).x1("小程序简介").D1("测试服务类目").E1("测试主体信息").z1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").G1("1.0").B1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png") : (b.a) invokeV.objValue;
    }

    public static e.g c(b bVar, d.a.n0.a.v2.a1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bVar, bVar2)) == null) {
            if (f47873a && bVar.m0()) {
                return e.b.a(bVar, bVar2);
            }
            if (E(bVar.g0())) {
                return e.f.a(bVar);
            }
            if (d.a.n0.a.e0.f.b.e()) {
                return d.a.n0.a.e0.f.c.a.a(bVar);
            }
            if (d.a.n0.a.e0.f.b.f()) {
                return d.a.n0.a.e0.f.f.b.a(bVar);
            }
            if (bVar.o0()) {
                return d.a.n0.a.e0.f.d.b.a(bVar);
            }
            return null;
        }
        return (e.g) invokeLL.objValue;
    }

    public static boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65565, null, str, z)) == null) ? t().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? d("aiapps_close_view_disable_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? d("aiapps_dashboard_enable_debug_key", false) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? t().getString("aiapps_env_data", "") : (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? d("aiapps_emit_game_core_debug_key", false) : invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? t().getString("swan_debug_so_url_key", "") : (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? t().getInt("swan_debug_open_so_key", -1) : invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? d.a.n0.a.m2.b.j() : invokeV.booleanValue;
    }

    public static String l(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, bVar)) == null) {
            if (f47873a && bVar.m0()) {
                return e.b.g().getPath();
            }
            if (E(bVar.g0())) {
                return e.f.e().getPath();
            }
            if (d.a.n0.a.e0.f.b.e()) {
                return d.a.n0.a.e0.f.c.a.b().getPath();
            }
            if (d.a.n0.a.e0.f.b.f()) {
                return d.a.n0.a.e0.f.f.b.e().getPath();
            }
            return bVar.o0() ? d.a.n0.a.e0.f.d.b.d().getPath() : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? d("aiapps_force_authorized_key", false) : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? d("swan_game_fps_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? d("aiapps_emit_https_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? d("aiapps_js_native_switch_key", true) : invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? d("aiapps_emit_wss_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? d("aiapps_emit_live_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? d("aiapps_load_cts_debug_key", false) : invokeV.booleanValue;
    }

    public static d.a.n0.a.k2.g.a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            if (f47874b == null) {
                synchronized (a.class) {
                    if (f47874b == null) {
                        d.a.n0.a.k2.g.a aVar = new d.a.n0.a.k2.g.a("swan_app_debug");
                        f47874b = aVar;
                        aVar.f45874f.addAll(f47875c);
                    }
                }
            }
            return f47874b;
        }
        return (d.a.n0.a.k2.g.a) invokeV.objValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? d("aiapps_sconsole_scan_mode_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? d("aiapps_server_domains_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? d("aiapps_emit_game_launch_mode_key", false) : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? d("aiapps_use_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? d("aiapps_use_game_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? d("aiapps_websafe_debug_key", true) : invokeV.booleanValue;
    }
}
