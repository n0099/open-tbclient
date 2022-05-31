package com.repackage;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.cw2;
import com.repackage.qy1;
import com.repackage.wv3;
/* loaded from: classes6.dex */
public class hv3 extends gc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public long r;

    /* loaded from: classes6.dex */
    public class a implements bi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv3 a;

        public a(hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv3Var;
        }

        @Override // com.repackage.bi2
        public void a(int i, ai2 ai2Var) {
            wv3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, ai2Var) == null) || (cVar = (wv3.c) ai2Var) == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            gv3.m().I(this.a.Z());
            gv3.m().x(cVar);
            jt3.h();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cw2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv3 a;

        public b(hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv3Var;
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
                    gv3.m().H();
                    gz2.J().t();
                    return true;
                } else if (i == 102) {
                    boolean a = oi2.M().a();
                    oi2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.onNightModeCoverChanged(a, false);
                    }
                    return true;
                } else if (i == 103) {
                    hz2 L = hz2.L();
                    if (L != null) {
                        L.d0().i();
                        dr2.g().v();
                    }
                    this.a.Q0();
                    gv3.m().H();
                    us3.b();
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
                        case 126:
                            aw2.d(message);
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
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv3 a;

        public c(hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (hv3.s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.r = System.currentTimeMillis();
                d04.f(this.a.Z());
                this.a.b.finishLoadingAnimator();
                ms2.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                int j = gv3.m().j();
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                gv3.m().i(new gx3(f));
                if (hv3.s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                t14.A().D();
                xv3.f().init();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv3 a;

        public d(hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i1();
                this.a.h1();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755634836, "Lcom/repackage/hv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755634836, "Lcom/repackage/hv3;");
                return;
            }
        }
        s = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv3(SwanAppActivity swanAppActivity, String str) {
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
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            a63.E();
            if (z2) {
                d04.f(Z());
                us3.b();
            }
        }
    }

    @Override // com.repackage.gc2
    @NonNull
    public cw2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (cw2.c) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (gz2.J().D()) {
                uk2.U().E(Z(), new a(this));
                if (gv3.m().v() && gv3.m().q()) {
                    gv3.m().F(this.b);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : invokeV.longValue;
    }

    @Override // com.repackage.gc2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? gz2.J().r().X().d0() == 1 : invokeV.booleanValue;
    }

    public p62 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? gv3.m().n() : (p62) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t14.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            t14.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r > 0 : invokeV.booleanValue;
    }

    @Override // com.repackage.gc2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hw1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            k63 k63Var = new k63();
            k63Var.e = "back";
            Q(k63Var);
            ny1 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    hz2 L = hz2.L();
                    if (L != null) {
                        L.O().E();
                    }
                    d04.e("back", Z());
                    us3.g("0");
                    return;
                }
                qy1.b i = this.c.i("navigateBack");
                i.n(qy1.i, qy1.h);
                i.g();
                i.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            bd3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            v14.q();
            u14.b();
        }
    }

    @Override // com.repackage.pz2, com.repackage.kz2
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.r = 0L;
        }
    }

    @Override // com.repackage.gc2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            xz3.c().b();
            ux3.b().e();
            r().I(true);
            e1();
            V8Engine.setCrashKeyValue("game_title", Z() == null ? "" : Z().K());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && r().H()) {
            if (wc3.f(Z().a0())) {
                if (s) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
                }
                gv3.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && wc3.f(j0.swanCoreVersionName) && dk2.a(Z().S())) {
                if (s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                gv3.C();
            }
        }
    }

    @Override // com.repackage.gc2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ts3.v();
            mb2.i();
            d04.e(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, Z());
            uk2.U().unregisterReceiver(this.b);
            uk2.b0();
            m14.a().b();
            SwanInspectorEndpoint.v().q();
            xz3.c().b();
            ux3.b().e();
        }
    }

    @Override // com.repackage.gc2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            gv3.m().h(this.b);
        }
    }

    @Override // com.repackage.gc2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.repackage.gc2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            uk2.U().registerReceiver(this.b);
        }
    }

    @Override // com.repackage.gc2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.repackage.gc2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
