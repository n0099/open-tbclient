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
import com.repackage.cx2;
import com.repackage.dj2;
import com.repackage.el2;
import com.repackage.pd2;
import com.repackage.qz1;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes6.dex */
public class jd2 extends gd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd2 a;

        public a(jd2 jd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && qc3.d(this.a.b)) {
                o43.g();
                ul2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(jd2 jd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd2Var};
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
                ds2.g().y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements t12<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd2 a;

        public c(jd2 jd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements pd2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd2 a;

        public d(jd2 jd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd2Var;
        }

        @Override // com.repackage.pd2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.moveTaskToBack(true);
            je3.b().e(1);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements cx2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd2 a;

        public e(jd2 jd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd2Var;
        }

        @Override // com.repackage.cx2.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    xw2.e().h(new zw2(4));
                    this.a.Q0();
                    this.a.l1();
                    g03.K().s();
                    return true;
                } else if (i == 127) {
                    int d = dq2.d();
                    int a = dq2.a(d);
                    if (!dq2.f()) {
                        cq2.a(Integer.valueOf(d), String.valueOf(a));
                    }
                    return true;
                } else if (i == 129) {
                    int p = nc3.m().p();
                    hx1.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.b != null && this.a.b.e0() && p != -1 && this.a.b.getTaskId() != p) {
                        hx1.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        g03.K().s();
                    }
                    return true;
                } else if (i == 102) {
                    boolean a2 = oj2.M().a();
                    oj2.M().d(a2);
                    if (this.a.b != null) {
                        this.a.b.x(a2, false);
                    }
                    return true;
                } else if (i == 103) {
                    h03 M = h03.M();
                    if (M != null) {
                        M.e0().i();
                        ds2.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
                    return true;
                } else if (i == 106) {
                    g03.K().s();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            nc3.r(message);
                            return true;
                        case 124:
                            nc3.q(message);
                            return true;
                        case 125:
                            ax2.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    j32.a(message);
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
                d93.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755592583, "Lcom/repackage/jd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755592583, "Lcom/repackage/jd2;");
                return;
            }
        }
        q = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.repackage.gd2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.gd2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.gd2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.repackage.gd2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            hx1.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = hd3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                r63.w();
                vq2.e().l(z2);
                HybridUbcFlow p = mt2.p("startup");
                el2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    r52.k().x(Z.H(), true);
                    z63.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            q33.f("backtohome", "message", v1);
                        } else {
                            boolean i = q33.i(v1);
                            r63.u(v1, Z);
                            j02.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = u23.b().a(hq2.d(v1, ul2.U().z()));
                            q33.f("backtohome", a2 ? "message" : "relaunch", v1);
                            if (i && !a2) {
                                q33.q("reLaunch");
                                tr1.d().i();
                                mi2.d("2");
                            } else {
                                mi2.d("3");
                            }
                        }
                    } else if (r73.a()) {
                        q33.f("backtohome", "relaunch", ul2.U().g());
                    } else {
                        vq2.e().m();
                        vq2.e().l(false);
                        j02.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        mi2.d("3");
                        r63.s(Z);
                        r63.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        h63.d().i("na_page_show");
                    }
                    h63.d().i("frame_new_intent");
                    h03 q2 = g03.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        r52.k().w();
                    }
                    a73.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    cg3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.repackage.gd2
    @NonNull
    public cx2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (cx2.c) invokeV.objValue;
    }

    @Override // com.repackage.p03, com.repackage.k03
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gd2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.a();
    }

    @Override // com.repackage.gd2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            hx1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            nz1 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    h03 M = h03.M();
                    if (M != null) {
                        M.P().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h03.g0());
                    ul2.U().u(new ja2(hashMap));
                    hx1.i("SwanAppFrame", "onBack");
                    vl2.a().d(false);
                    return;
                }
                v63.f(UUID.randomUUID().toString(), 1);
                rc3.a(c0(), this.b);
                qz1.b i2 = this.c.i("navigateBack");
                i2.n(qz1.i, qz1.h);
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

    @Override // com.repackage.gd2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            qc3.a(this.b);
            if (uy1.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            h63.d().a();
            h63.d().i("frame_create");
            vq2.e().l(true);
            vq2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(el2 el2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, el2Var)) == null) {
            if (el2Var != null && !gw2.B(el2Var)) {
                if (el2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = g03.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!dj2.e.i(el2Var.H(), el2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !w33.q(el2Var, Q);
                }
            }
            if (q) {
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
            j73 j73Var = new j73();
            j73Var.e = "back";
            qz1 qz1Var = this.c;
            boolean z = true;
            j73Var.g = (qz1Var == null || qz1Var.k() <= 1) ? false : false ? "1" : "0";
            j73Var.b = str;
            q63.a(j73Var, Z());
            q63.c(j73Var);
        }
    }

    @Override // com.repackage.gd2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o43.j();
            o43.h();
            vq2.e().o();
            oj2.a0().a();
            ul2.U().unregisterReceiver(this.b);
        }
    }

    public final pd2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (pd2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? el2.m1(Z(), ul2.U().s()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.gd2
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

    @Override // com.repackage.gd2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (nd2.b().c()) {
                    nd2.b().f(this.b, new c(this));
                    return true;
                }
                qz1 qz1Var = this.c;
                if (qz1Var != null && qz1Var.k() == 1) {
                    od2 od2Var = new od2();
                    od2Var.h();
                    if (od2Var.j()) {
                        pd2.a().c(this.b, od2Var.f(), od2Var.e(), od2Var, o1());
                        return true;
                    }
                    vq2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (g03.K().q().y0()) {
                hx1.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            r63.z();
            if (E()) {
                t1();
                el2.a Z = Z();
                if (m1(Z)) {
                    if (q) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    ul2.U().d(Z, null);
                    return;
                }
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                ul2.U().E(Z, null);
            }
        }
    }

    @Override // com.repackage.gd2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (b72.U().W() != null) {
                b72.U().W().e(this.b);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            g03 K = g03.K();
            if (K.E()) {
                el2.a Y = K.q().Y();
                String T = Y.T();
                String U = Y.U();
                if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                j03 U2 = q().U();
                if (U2.b(Y.T())) {
                    return !U2.c(T, Boolean.FALSE).booleanValue();
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
            el2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (wd3.f(Z.a0())) {
                b72.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = b72.U().T();
                ExtensionCore O = Z.O();
                boolean z = false;
                boolean z2 = j0 != null && wd3.f(j0.swanCoreVersionName) && dl2.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && dl2.b(Z.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    b72.N0(true);
                }
            }
        }
    }

    @Override // com.repackage.gd2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            au2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            el2.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? ul2.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.gd2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            el2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(m93.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    @Override // com.repackage.gd2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.repackage.gd2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            mt2.o().F(new UbcFlowEvent("frame_start_end"));
            h63.d().i("frame_start_end");
        }
    }
}
