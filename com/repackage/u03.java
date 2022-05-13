package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.h02;
import com.repackage.rb4;
import com.repackage.rl2;
import com.repackage.y03;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class u03 extends c13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public d13 e;
    public d83 f;
    public x83 g;
    public d53 h;
    public hh1 i;
    public fs2 j;
    public HttpManager k;
    public k13 l;
    public wn2 m;
    public gs2 n;
    public w03 o;
    public Map<String, String> p;
    public final a13 q;
    public final rl2.a r;
    public boolean s;
    public String t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755314823, "Lcom/repackage/u03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755314823, "Lcom/repackage/u03;");
                return;
            }
        }
        v = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u03(x03 x03Var, String str) {
        super(x03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x03Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new a13(this);
        this.r = new rl2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            k13 k13Var = new k13();
            this.l = k13Var;
            k13Var.f(this.b);
        }
        ux1.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Deprecated
    public static u03 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a0() : (u03) invokeV.objValue;
    }

    public static u03 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            t03 J = t03.J();
            if (J.D()) {
                return J.r();
            }
            return null;
        }
        return (u03) invokeV.objValue;
    }

    @Deprecated
    public static String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? t03.J().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public void A(y03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((y03.a) aVar.update(R()));
        }
    }

    public void A0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            d0().w(activity);
        }
    }

    public String B0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            if (v) {
                Log.d("SwanApp", "——> release client Id " + this.b);
            }
            SwanAppActivity x = x();
            if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
                x.reset(strArr);
            }
            hm2.b0();
            w03 w03Var = this.o;
            if (w03Var != null) {
                w03Var.g();
            }
            xg4.k(c83.x(this.b));
            wn2 wn2Var = this.m;
            if (wn2Var != null) {
                wn2Var.E();
            }
            k13 k13Var = this.l;
            if (k13Var != null) {
                k13Var.g();
            }
            gs2 gs2Var = this.n;
            if (gs2Var != null) {
                gs2Var.d();
            }
            this.f = null;
            this.h = null;
            this.k = null;
            this.s = false;
            return this.b;
        }
        return (String) invokeL.objValue;
    }

    public boolean C0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, bundle, str, z)) == null) {
            boolean contains = x03.e0.contains(str);
            rl2.a V = V();
            HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.q.l0() && o0()) {
                if (V.c("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (V.c("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            V.update(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            if (z) {
                q("event_on_app_occupied");
            }
            if (this.c && !this.q.l0() && !this.q.k0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.q.p0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.q.l0() && contains) {
                a13.n0(V, V.f0(), false, false);
            }
            return this.q.k0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q.v0() : invokeV.intValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q.A0() : invokeV.booleanValue;
    }

    public void F0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            this.d = swanAppConfigData;
        }
    }

    public void G0(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d13Var) == null) {
            this.e = d13Var;
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c && this.q.l0() && l() > -1 : invokeV.booleanValue;
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.t = str;
            ux1.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public u03 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.s = z;
            q("event_first_action_launched");
            return this;
        }
        return (u03) invokeZ.objValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.u = z;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public rl2 J0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            rl2.a V = V();
            V.update(bundle);
            return V;
        }
        return (rl2) invokeL.objValue;
    }

    public final String K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i == 0) {
                rl2.a aVar = this.r;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = j0();
                }
                String f = oe3.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f) ? " version is empty " : f;
                ux1.b("SwanApp", objArr);
                return f;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public void K0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.p == null) {
            this.p = new HashMap();
        }
        if (v) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.p.put(str2, str);
    }

    public void L0(Set<rb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.q.I0(set);
        }
    }

    public hh1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.i == null) {
                this.i = new hh1(this);
            }
            return this.i;
        }
        return (hh1) invokeV.objValue;
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        this.q.L0(pMSAppInfo);
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? V().I() : (String) invokeV.objValue;
    }

    public void N0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || lVar.b == null) {
            return;
        }
        if (v) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.d.c.b.put(str, Boolean.valueOf(z));
    }

    public wn2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.m == null) {
                this.m = new wn2(this);
            }
            return this.m;
        }
        return (wn2) invokeV.objValue;
    }

    public SwanAppConfigData P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.d : (SwanAppConfigData) invokeV.objValue;
    }

    public String Q(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData == null || (mVar = swanAppConfigData.d) == null || (map = mVar.a) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final Bundle R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public d13 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e : (d13) invokeV.objValue;
    }

    @NonNull
    public w03 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.o == null) {
                this.o = new w03(this);
            }
            return this.o;
        }
        return (w03) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            rl2.a V = V();
            return V != null ? K(V.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public rl2.a V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (rl2.a) invokeV.objValue;
    }

    @Nullable
    public String W(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public rl2.a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? V() : (rl2.a) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? V().K() : (String) invokeV.objValue;
    }

    public synchronized fs2 Z() {
        InterceptResult invokeV;
        fs2 fs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new fs2(this);
                }
                fs2Var = this.j;
            }
            return fs2Var;
        }
        return (fs2) invokeV.objValue;
    }

    public String b0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData == null || (lVar = swanAppConfigData.c) == null || lVar.c == null) {
                return null;
            }
            return this.d.c.c.get(m43.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            return swanAppConfigData != null ? swanAppConfigData.h(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public d53 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.h == null) {
                this.h = new d53(this);
            }
            return this.h;
        }
        return (d53) invokeV.objValue;
    }

    public d83 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.f == null) {
                this.f = new d83(this);
            }
            return this.f;
        }
        return (d83) invokeV.objValue;
    }

    public x83 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.g == null) {
                if (v0()) {
                    this.g = new cd2();
                } else {
                    this.g = new z83();
                }
            }
            return this.g;
        }
        return (x83) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public synchronized HttpManager h0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = ck2.l().a();
                }
                httpManager = this.k;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? V().v1() : (String) invokeV.objValue;
    }

    public k13 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                this.l = new k13();
            }
            return this.l;
        }
        return (k13) invokeV.objValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.c) {
                return V().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public gs2 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.n == null) {
                this.n = new gs2();
            }
            return this.n;
        }
        return (gs2) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        td2 frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (u42.h()) {
                SwanAppActivity x = x();
                if (x == null || x.isFinishing() || x.isDestroyed() || (frame = x.getFrame()) == null) {
                    return true;
                }
                return !frame.a0().hasStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(V().j0());
            swanAppCores.setExtensionCore(V().O());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? p0(hm2.U().T()) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        td2 frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SwanAppActivity x = x();
            if (x == null || (frame = x.getFrame()) == null) {
                return false;
            }
            return frame.a0().hasCreated();
        }
        return invokeV.booleanValue;
    }

    public boolean p0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null) {
                return false;
            }
            return swanAppConfigData.o(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            w(str, R());
        }
    }

    public boolean q0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (eVar = swanAppConfigData.b) == null) {
                return false;
            }
            return eVar.c(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public u03 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this : (u03) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.q.k0() : invokeV.booleanValue;
    }

    public boolean s0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || (map = lVar.b) == null || !map.containsKey(str)) {
                return false;
            }
            if (v) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.d.c.b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            d0().l();
            e0().d(true);
        }
    }

    public boolean t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? new File(hm2.U().z(), str).exists() : invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return p84.i().n(this.b, j0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? V().G() == 1 : invokeV.booleanValue;
    }

    @Override // com.repackage.c13, com.repackage.x03
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = R();
            } else {
                bundle.putAll(R());
            }
            super.w(str, bundle);
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.t) : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (h02.b.a()) {
                return true;
            }
            rl2.a V = V();
            if (V == null) {
                ux1.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = V.f0();
            if (f0 == null) {
                ux1.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                ux1.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                ux1.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                return f0.webPermit == 1;
            }
        }
        return invokeV.booleanValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.q.t0();
        }
    }
}
