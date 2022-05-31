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
import com.repackage.cw2;
import com.repackage.di2;
import com.repackage.ek2;
import com.repackage.pc2;
import com.repackage.qy1;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes6.dex */
public class jc2 extends gc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public a(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && qb3.d(this.a.b)) {
                o33.g();
                uk2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
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
                dr2.g().y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements t02<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public c(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t02
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements pc2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public d(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.repackage.pc2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.moveTaskToBack(true);
            jd3.b().e(1);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements cw2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc2 a;

        public e(jc2 jc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc2Var;
        }

        @Override // com.repackage.cw2.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    xv2.e().h(new zv2(4));
                    this.a.Q0();
                    this.a.l1();
                    gz2.J().t();
                    return true;
                } else if (i == 127) {
                    int d = dp2.d();
                    int a = dp2.a(d);
                    if (!dp2.f()) {
                        cp2.a(Integer.valueOf(d), String.valueOf(a));
                    }
                    return true;
                } else if (i == 129) {
                    int p = nb3.m().p();
                    hw1.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.b != null && this.a.b.isBackground() && p != -1 && this.a.b.getTaskId() != p) {
                        hw1.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        gz2.J().t();
                    }
                    return true;
                } else if (i == 102) {
                    boolean a2 = oi2.M().a();
                    oi2.M().d(a2);
                    if (this.a.b != null) {
                        this.a.b.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i == 103) {
                    hz2 L = hz2.L();
                    if (L != null) {
                        L.d0().i();
                        dr2.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
                    return true;
                } else if (i == 106) {
                    gz2.J().t();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            nb3.r(message);
                            return true;
                        case 124:
                            nb3.q(message);
                            return true;
                        case 125:
                            aw2.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    j22.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                d83.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755593544, "Lcom/repackage/jc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755593544, "Lcom/repackage/jc2;");
                return;
            }
        }
        r = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.repackage.gc2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.gc2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.gc2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.repackage.gc2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            hw1.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = hc3.d(Z().n("_naExtParams"));
            if (r) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                r53.w();
                vp2.e().l(z2);
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                ek2.a Z = Z();
                if (z2) {
                    if (r) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    r42.k().x(Z.H(), true);
                    z53.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            q23.f("backtohome", "message", v1);
                        } else {
                            boolean i = q23.i(v1);
                            r53.u(v1, Z);
                            jz1.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = u13.b().a(hp2.d(v1, uk2.U().z()));
                            q23.f("backtohome", a2 ? "message" : "relaunch", v1);
                            if (i && !a2) {
                                q23.q("reLaunch");
                                tq1.d().i();
                                mh2.d("2");
                            } else {
                                mh2.d("3");
                            }
                        }
                    } else if (r63.a()) {
                        q23.f("backtohome", "relaunch", uk2.U().g());
                    } else {
                        vp2.e().m();
                        vp2.e().l(false);
                        jz1.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        mh2.d("3");
                        r53.s(Z);
                        r53.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        h53.d().i("na_page_show");
                    }
                    h53.d().i("frame_new_intent");
                    hz2 r2 = gz2.J().r();
                    r2.d0().j();
                    r2.M().a();
                    if (r) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    r2.P();
                    if (r) {
                        r42.k().w();
                    }
                    a63.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    cf3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.repackage.gc2
    @NonNull
    public cw2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (cw2.c) invokeV.objValue;
    }

    @Override // com.repackage.gc2
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

    @Override // com.repackage.pz2, com.repackage.kz2
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gc2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            hw1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            ny1 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    hz2 L = hz2.L();
                    if (L != null) {
                        L.O().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, hz2.f0());
                    uk2.U().u(new j92(hashMap));
                    hw1.i("SwanAppFrame", "onBack");
                    vk2.a().d(false);
                    return;
                }
                v53.f(UUID.randomUUID().toString(), 1);
                rb3.a(c0(), this.b);
                qy1.b i2 = this.c.i("navigateBack");
                i2.n(qy1.i, qy1.h);
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

    @Override // com.repackage.gc2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            qb3.a(this.b);
            if (ux1.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            h53.d().a();
            h53.d().i("frame_create");
            vp2.e().l(true);
            vp2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(ek2 ek2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ek2Var)) == null) {
            if (ek2Var != null && !gv2.B(ek2Var)) {
                if (ek2Var.G() != 0) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData P = gz2.J().r().P();
                if (P == null) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!di2.e.i(ek2Var.H(), ek2Var.v1()).exists()) {
                    if (r) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !w23.q(ek2Var, P);
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
            j63 j63Var = new j63();
            j63Var.e = "back";
            qy1 qy1Var = this.c;
            boolean z = true;
            j63Var.g = (qy1Var == null || qy1Var.k() <= 1) ? false : false ? "1" : "0";
            j63Var.b = str;
            q53.a(j63Var, Z());
            q53.c(j63Var);
        }
    }

    @Override // com.repackage.gc2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o33.j();
            o33.h();
            vp2.e().o();
            oi2.a0().a();
            uk2.U().unregisterReceiver(this.b);
        }
    }

    public final pc2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (pc2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? ek2.m1(Z(), uk2.U().s()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.gc2
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

    @Override // com.repackage.gc2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (nc2.b().c()) {
                    nc2.b().f(this.b, new c(this));
                    return true;
                }
                qy1 qy1Var = this.c;
                if (qy1Var != null && qy1Var.k() == 1) {
                    oc2 oc2Var = new oc2();
                    oc2Var.h();
                    if (oc2Var.j()) {
                        pc2.c().j(this.b, oc2Var.f(), oc2Var.e(), oc2Var, o1());
                        return true;
                    }
                    vp2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (gz2.J().r().x0()) {
                hw1.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            r53.z();
            if (D()) {
                t1();
                ek2.a Z = Z();
                if (m1(Z)) {
                    if (r) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    uk2.U().d(Z, null);
                    return;
                }
                if (r) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                uk2.U().E(Z, null);
            }
        }
    }

    @Override // com.repackage.gc2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (b62.U().W() != null) {
                b62.U().W().f(this.b);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            gz2 J = gz2.J();
            if (J.D()) {
                ek2.a X = J.r().X();
                String T = X.T();
                String U = X.U();
                if (TextUtils.isEmpty(X.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                jz2 T2 = r().T();
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
            ek2.a Z = Z();
            if (r) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (r) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (wc3.f(Z.a0())) {
                b62.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = b62.U().T();
                ExtensionCore O = Z.O();
                boolean z = false;
                boolean z2 = j0 != null && wc3.f(j0.swanCoreVersionName) && dk2.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && dk2.b(Z.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (r) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    b62.N0(true);
                }
            }
        }
    }

    @Override // com.repackage.gc2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            at2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ek2.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? uk2.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.gc2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ek2.a Z = Z();
            if (r) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (r) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(m83.g(0));
                if (r) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    @Override // com.repackage.gc2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.repackage.gc2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ms2.o().F(new UbcFlowEvent("frame_start_end"));
            h53.d().i("frame_start_end");
        }
    }
}
