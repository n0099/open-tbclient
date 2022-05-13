package com.repackage;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.ce2;
import com.repackage.d02;
import com.repackage.px2;
import com.repackage.qj2;
import com.repackage.rl2;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes7.dex */
public class wd2 extends td2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public a(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && dd3.d(this.a.b)) {
                b53.g();
                hm2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qs2.g().y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g22<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public c(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ce2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public d(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        @Override // com.repackage.ce2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.moveTaskToBack(true);
            we3.b().e(1);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements px2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public e(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        @Override // com.repackage.px2.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    kx2.e().h(new mx2(4));
                    this.a.Q0();
                    this.a.l1();
                    t03.J().t();
                    return true;
                } else if (i == 127) {
                    int d = qq2.d();
                    int a = qq2.a(d);
                    if (!qq2.f()) {
                        pq2.a(Integer.valueOf(d), String.valueOf(a));
                    }
                    return true;
                } else if (i == 129) {
                    int p = ad3.m().p();
                    ux1.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.b != null && this.a.b.isBackground() && p != -1 && this.a.b.getTaskId() != p) {
                        ux1.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        t03.J().t();
                    }
                    return true;
                } else if (i == 102) {
                    boolean a2 = bk2.M().a();
                    bk2.M().d(a2);
                    if (this.a.b != null) {
                        this.a.b.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i == 103) {
                    u03 L = u03.L();
                    if (L != null) {
                        L.d0().i();
                        qs2.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
                    return true;
                } else if (i == 106) {
                    t03.J().t();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            ad3.r(message);
                            return true;
                        case 124:
                            ad3.q(message);
                            return true;
                        case 125:
                            nx2.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    w32.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                q93.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755205300, "Lcom/repackage/wd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755205300, "Lcom/repackage/wd2;");
                return;
            }
        }
        r = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd2(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.td2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.td2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.td2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.repackage.td2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ux1.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = ud3.d(Z().n("_naExtParams"));
            if (r) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                e73.w();
                ir2.e().l(z2);
                HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
                rl2.a Z = Z();
                if (z2) {
                    if (r) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    e62.k().x(Z.H(), true);
                    m73.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            d43.f("backtohome", "message", v1);
                        } else {
                            boolean i = d43.i(v1);
                            e73.u(v1, Z);
                            w02.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = h33.b().a(uq2.d(v1, hm2.U().z()));
                            d43.f("backtohome", a2 ? "message" : "relaunch", v1);
                            if (i && !a2) {
                                d43.q("reLaunch");
                                gs1.d().i();
                                zi2.d("2");
                            } else {
                                zi2.d("3");
                            }
                        }
                    } else if (e83.a()) {
                        d43.f("backtohome", "relaunch", hm2.U().g());
                    } else {
                        ir2.e().m();
                        ir2.e().l(false);
                        w02.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        zi2.d("3");
                        e73.s(Z);
                        e73.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        u63.d().i("na_page_show");
                    }
                    u63.d().i("frame_new_intent");
                    u03 r2 = t03.J().r();
                    r2.d0().j();
                    r2.M().a();
                    if (r) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    r2.P();
                    if (r) {
                        e62.k().w();
                    }
                    n73.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    pg3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.repackage.td2
    @NonNull
    public px2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (px2.c) invokeV.objValue;
    }

    @Override // com.repackage.td2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.a();
    }

    @Override // com.repackage.c13, com.repackage.x03
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.td2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ux1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            a02 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    u03 L = u03.L();
                    if (L != null) {
                        L.O().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, u03.f0());
                    hm2.U().u(new wa2(hashMap));
                    ux1.i("SwanAppFrame", "onBack");
                    im2.a().d(false);
                    return;
                }
                i73.f(UUID.randomUUID().toString(), 1);
                ed3.a(c0(), this.b);
                d02.b i2 = this.c.i("navigateBack");
                i2.n(d02.i, d02.h);
                i2.g();
                i2.a();
            }
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.b();
    }

    @Override // com.repackage.td2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            dd3.a(this.b);
            if (hz1.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            u63.d().a();
            u63.d().i("frame_create");
            ir2.e().l(true);
            ir2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(rl2 rl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, rl2Var)) == null) {
            if (rl2Var != null && !tw2.B(rl2Var)) {
                if (rl2Var.G() != 0) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData P = t03.J().r().P();
                if (P == null) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!qj2.e.i(rl2Var.H(), rl2Var.v1()).exists()) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !j43.q(rl2Var, P);
                }
            }
            if (r) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = i != 2 ? i != 3 ? "virtual" : "gesture" : "click";
            w73 w73Var = new w73();
            w73Var.e = "back";
            d02 d02Var = this.c;
            boolean z = true;
            w73Var.g = (d02Var == null || d02Var.k() <= 1) ? false : false ? "1" : "0";
            w73Var.b = str;
            d73.a(w73Var, Z());
            d73.c(w73Var);
        }
    }

    @Override // com.repackage.td2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b53.j();
            b53.h();
            ir2.e().o();
            bk2.a0().a();
            hm2.U().unregisterReceiver(this.b);
        }
    }

    public final ce2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (ce2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? rl2.m1(Z(), hm2.U().s()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.td2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // com.repackage.td2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (ae2.b().c()) {
                    ae2.b().f(this.b, new c(this));
                    return true;
                }
                d02 d02Var = this.c;
                if (d02Var != null && d02Var.k() == 1) {
                    be2 be2Var = new be2();
                    be2Var.h();
                    if (be2Var.j()) {
                        ce2.c().j(this.b, be2Var.f(), be2Var.e(), be2Var, o1());
                        return true;
                    }
                    ir2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (t03.J().r().x0()) {
                ux1.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            e73.z();
            if (D()) {
                t1();
                rl2.a Z = Z();
                if (m1(Z)) {
                    if (r) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    hm2.U().d(Z, null);
                    return;
                }
                if (r) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                hm2.U().E(Z, null);
            }
        }
    }

    @Override // com.repackage.td2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (o72.U().W() != null) {
                o72.U().W().f(this.b);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            t03 J = t03.J();
            if (J.D()) {
                rl2.a X = J.r().X();
                String T = X.T();
                String U = X.U();
                if (TextUtils.isEmpty(X.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                w03 T2 = r().T();
                if (T2.b(X.T())) {
                    return !T2.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            rl2.a Z = Z();
            if (r) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (r) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (je3.f(Z.a0())) {
                o72.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = o72.U().T();
                ExtensionCore O = Z.O();
                boolean z = false;
                boolean z2 = j0 != null && je3.f(j0.swanCoreVersionName) && ql2.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && ql2.b(Z.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (r) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    o72.N0(true);
                }
            }
        }
    }

    @Override // com.repackage.td2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            nu2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            rl2.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? hm2.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.td2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            rl2.a Z = Z();
            if (r) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (r) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(z93.g(0));
                if (r) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    @Override // com.repackage.td2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.repackage.td2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            zt2.o().F(new UbcFlowEvent("frame_start_end"));
            u63.d().i("frame_start_end");
        }
    }
}
