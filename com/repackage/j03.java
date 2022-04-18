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
import com.repackage.gb4;
import com.repackage.gl2;
import com.repackage.n03;
import com.repackage.wz1;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class j03 extends r03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public s03 e;
    public s73 f;
    public m83 g;
    public s43 h;
    public wg1 i;
    public ur2 j;
    public HttpManager k;
    public z03 l;
    public ln2 m;
    public vr2 n;
    public l03 o;
    public Map<String, String> p;
    public final p03 q;
    public final gl2.a r;
    public boolean s;
    public String t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755642524, "Lcom/repackage/j03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755642524, "Lcom/repackage/j03;");
                return;
            }
        }
        v = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j03(m03 m03Var, String str) {
        super(m03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m03Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((m03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new p03(this);
        this.r = new gl2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            z03 z03Var = new z03();
            this.l = z03Var;
            z03Var.f(this.b);
        }
        jx1.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Deprecated
    public static j03 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a0() : (j03) invokeV.objValue;
    }

    public static j03 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            i03 J = i03.J();
            if (J.D()) {
                return J.r();
            }
            return null;
        }
        return (j03) invokeV.objValue;
    }

    @Deprecated
    public static String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? i03.J().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
    public void A(n03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((n03.a) aVar.update(R()));
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
            wl2.b0();
            l03 l03Var = this.o;
            if (l03Var != null) {
                l03Var.g();
            }
            mg4.k(r73.x(this.b));
            ln2 ln2Var = this.m;
            if (ln2Var != null) {
                ln2Var.E();
            }
            z03 z03Var = this.l;
            if (z03Var != null) {
                z03Var.g();
            }
            vr2 vr2Var = this.n;
            if (vr2Var != null) {
                vr2Var.d();
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
            boolean contains = m03.e0.contains(str);
            gl2.a V = V();
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
                p03.n0(V, V.f0(), false, false);
            }
            return this.q.k0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
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

    public void G0(s03 s03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s03Var) == null) {
            this.e = s03Var;
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
            jx1.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public j03 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.s = z;
            q("event_first_action_launched");
            return this;
        }
        return (j03) invokeZ.objValue;
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

    public gl2 J0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            gl2.a V = V();
            V.update(bundle);
            return V;
        }
        return (gl2) invokeL.objValue;
    }

    public final String K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i == 0) {
                gl2.a aVar = this.r;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = j0();
                }
                String f = de3.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f) ? " version is empty " : f;
                jx1.b("SwanApp", objArr);
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

    public void L0(Set<gb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.q.I0(set);
        }
    }

    public wg1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.i == null) {
                this.i = new wg1(this);
            }
            return this.i;
        }
        return (wg1) invokeV.objValue;
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

    public ln2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.m == null) {
                this.m = new ln2(this);
            }
            return this.m;
        }
        return (ln2) invokeV.objValue;
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

    public s03 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e : (s03) invokeV.objValue;
    }

    @NonNull
    public l03 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.o == null) {
                this.o = new l03(this);
            }
            return this.o;
        }
        return (l03) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            gl2.a V = V();
            return V != null ? K(V.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public gl2.a V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (gl2.a) invokeV.objValue;
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
    public gl2.a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? V() : (gl2.a) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? V().K() : (String) invokeV.objValue;
    }

    public synchronized ur2 Z() {
        InterceptResult invokeV;
        ur2 ur2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new ur2(this);
                }
                ur2Var = this.j;
            }
            return ur2Var;
        }
        return (ur2) invokeV.objValue;
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
            return this.d.c.c.get(b43.b(str));
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
    public s43 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.h == null) {
                this.h = new s43(this);
            }
            return this.h;
        }
        return (s43) invokeV.objValue;
    }

    public s73 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.f == null) {
                this.f = new s73(this);
            }
            return this.f;
        }
        return (s73) invokeV.objValue;
    }

    public m83 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.g == null) {
                if (v0()) {
                    this.g = new rc2();
                } else {
                    this.g = new o83();
                }
            }
            return this.g;
        }
        return (m83) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
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
                    this.k = rj2.l().a();
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

    public z03 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                this.l = new z03();
            }
            return this.l;
        }
        return (z03) invokeV.objValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
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

    public vr2 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.n == null) {
                this.n = new vr2();
            }
            return this.n;
        }
        return (vr2) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        id2 frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (j42.h()) {
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

    @Override // com.repackage.r03, com.repackage.m03
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? p0(wl2.U().T()) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        id2 frame;
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

    @Override // com.repackage.r03, com.repackage.m03
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

    @Override // com.repackage.r03, com.repackage.m03
    public j03 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this : (j03) invokeV.objValue;
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

    @Override // com.repackage.r03, com.repackage.m03
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? new File(wl2.U().z(), str).exists() : invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e84.i().n(this.b, j0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? V().G() == 1 : invokeV.booleanValue;
    }

    @Override // com.repackage.r03, com.repackage.m03
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
            if (wz1.b.a()) {
                return true;
            }
            gl2.a V = V();
            if (V == null) {
                jx1.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = V.f0();
            if (f0 == null) {
                jx1.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                jx1.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                jx1.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
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
