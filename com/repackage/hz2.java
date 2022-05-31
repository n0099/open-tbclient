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
import com.repackage.ea4;
import com.repackage.ek2;
import com.repackage.lz2;
import com.repackage.uy1;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class hz2 extends pz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public qz2 e;
    public q63 f;
    public k73 g;
    public q33 h;
    public uf1 i;
    public sq2 j;
    public HttpManager k;
    public xz2 l;
    public jm2 m;
    public tq2 n;
    public jz2 o;
    public Map<String, String> p;
    public final nz2 q;
    public final ek2.a r;
    public boolean s;
    public String t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755631023, "Lcom/repackage/hz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755631023, "Lcom/repackage/hz2;");
                return;
            }
        }
        v = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz2(kz2 kz2Var, String str) {
        super(kz2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kz2Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new nz2(this);
        this.r = new ek2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            xz2 xz2Var = new xz2();
            this.l = xz2Var;
            xz2Var.f(this.b);
        }
        hw1.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Deprecated
    public static hz2 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a0() : (hz2) invokeV.objValue;
    }

    public static hz2 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            gz2 J = gz2.J();
            if (J.D()) {
                return J.r();
            }
            return null;
        }
        return (hz2) invokeV.objValue;
    }

    @Deprecated
    public static String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? gz2.J().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.repackage.pz2, com.repackage.kz2
    public void A(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((lz2.a) aVar.update(R()));
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
            uk2.b0();
            jz2 jz2Var = this.o;
            if (jz2Var != null) {
                jz2Var.g();
            }
            kf4.k(p63.x(this.b));
            jm2 jm2Var = this.m;
            if (jm2Var != null) {
                jm2Var.E();
            }
            xz2 xz2Var = this.l;
            if (xz2Var != null) {
                xz2Var.g();
            }
            tq2 tq2Var = this.n;
            if (tq2Var != null) {
                tq2Var.d();
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
            boolean contains = kz2.e0.contains(str);
            ek2.a V = V();
            HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
                nz2.n0(V, V.f0(), false, false);
            }
            return this.q.k0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.repackage.pz2, com.repackage.kz2
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

    public void G0(qz2 qz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qz2Var) == null) {
            this.e = qz2Var;
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
            hw1.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public hz2 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.s = z;
            q("event_first_action_launched");
            return this;
        }
        return (hz2) invokeZ.objValue;
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

    public ek2 J0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            ek2.a V = V();
            V.update(bundle);
            return V;
        }
        return (ek2) invokeL.objValue;
    }

    public final String K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i == 0) {
                ek2.a aVar = this.r;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = j0();
                }
                String f = bd3.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f) ? " version is empty " : f;
                hw1.b("SwanApp", objArr);
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

    public void L0(Set<ea4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.q.I0(set);
        }
    }

    public uf1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.i == null) {
                this.i = new uf1(this);
            }
            return this.i;
        }
        return (uf1) invokeV.objValue;
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

    public jm2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.m == null) {
                this.m = new jm2(this);
            }
            return this.m;
        }
        return (jm2) invokeV.objValue;
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

    public qz2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e : (qz2) invokeV.objValue;
    }

    @NonNull
    public jz2 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.o == null) {
                this.o = new jz2(this);
            }
            return this.o;
        }
        return (jz2) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ek2.a V = V();
            return V != null ? K(V.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public ek2.a V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (ek2.a) invokeV.objValue;
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
    public ek2.a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? V() : (ek2.a) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? V().K() : (String) invokeV.objValue;
    }

    public synchronized sq2 Z() {
        InterceptResult invokeV;
        sq2 sq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new sq2(this);
                }
                sq2Var = this.j;
            }
            return sq2Var;
        }
        return (sq2) invokeV.objValue;
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
            return this.d.c.c.get(z23.b(str));
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
    public q33 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.h == null) {
                this.h = new q33(this);
            }
            return this.h;
        }
        return (q33) invokeV.objValue;
    }

    public q63 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.f == null) {
                this.f = new q63(this);
            }
            return this.f;
        }
        return (q63) invokeV.objValue;
    }

    public k73 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.g == null) {
                if (v0()) {
                    this.g = new pb2();
                } else {
                    this.g = new m73();
                }
            }
            return this.g;
        }
        return (k73) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.pz2, com.repackage.kz2
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
                    this.k = pi2.l().a();
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

    public xz2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                this.l = new xz2();
            }
            return this.l;
        }
        return (xz2) invokeV.objValue;
    }

    @Override // com.repackage.pz2, com.repackage.kz2
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

    public tq2 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.n == null) {
                this.n = new tq2();
            }
            return this.n;
        }
        return (tq2) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        gc2 frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (h32.h()) {
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

    @Override // com.repackage.pz2, com.repackage.kz2
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? p0(uk2.U().T()) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        gc2 frame;
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

    @Override // com.repackage.pz2, com.repackage.kz2
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

    @Override // com.repackage.pz2, com.repackage.kz2
    public hz2 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this : (hz2) invokeV.objValue;
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

    @Override // com.repackage.pz2, com.repackage.kz2
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? new File(uk2.U().z(), str).exists() : invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return c74.i().n(this.b, j0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? V().G() == 1 : invokeV.booleanValue;
    }

    @Override // com.repackage.pz2, com.repackage.kz2
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
            if (uy1.b.a()) {
                return true;
            }
            ek2.a V = V();
            if (V == null) {
                hw1.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = V.f0();
            if (f0 == null) {
                hw1.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                hw1.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                hw1.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
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
