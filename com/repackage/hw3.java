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
import com.repackage.cx2;
import com.repackage.qz1;
import com.repackage.ww3;
/* loaded from: classes6.dex */
public class hw3 extends gd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    /* loaded from: classes6.dex */
    public class a implements bj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw3 a;

        public a(hw3 hw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw3Var;
        }

        @Override // com.repackage.bj2
        public void a(int i, aj2 aj2Var) {
            ww3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, aj2Var) == null) || (cVar = (ww3.c) aj2Var) == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            gw3.m().I(this.a.Z());
            gw3.m().x(cVar);
            ju3.h();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cx2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw3 a;

        public b(hw3 hw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw3Var;
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
                    gw3.m().H();
                    g03.K().s();
                    return true;
                } else if (i == 102) {
                    boolean a = oj2.M().a();
                    oj2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.x(a, false);
                    }
                    return true;
                } else if (i == 103) {
                    h03 M = h03.M();
                    if (M != null) {
                        M.e0().i();
                        ds2.g().v();
                    }
                    this.a.Q0();
                    gw3.m().H();
                    ut3.b();
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
                        case 126:
                            ax2.d(message);
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
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw3 a;

        public c(hw3 hw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (hw3.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                d14.f(this.a.Z());
                this.a.b.O();
                mt2.h("preload", "startup");
                int j = gw3.m().j();
                HybridUbcFlow p = mt2.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                gw3.m().i(new gy3(f));
                if (hw3.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                t24.A().D();
                xw3.f().init();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw3 a;

        public d(hw3 hw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw3Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755633875, "Lcom/repackage/hw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755633875, "Lcom/repackage/hw3;");
                return;
            }
        }
        r = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw3(SwanAppActivity swanAppActivity, String str) {
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
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            a73.E();
            if (z2) {
                d14.f(Z());
                ut3.b();
            }
        }
    }

    @Override // com.repackage.gd2
    @NonNull
    public cx2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (cx2.c) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (g03.K().E()) {
                ul2.U().E(Z(), new a(this));
                if (gw3.m().v() && gw3.m().q()) {
                    gw3.m().F(this.b);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.longValue;
    }

    @Override // com.repackage.gd2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? g03.K().q().Y().d0() == 1 : invokeV.booleanValue;
    }

    public p72 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? gw3.m().n() : (p72) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t24.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            t24.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q > 0 : invokeV.booleanValue;
    }

    @Override // com.repackage.p03, com.repackage.k03
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gd2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            hx1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            k73 k73Var = new k73();
            k73Var.e = "back";
            Q(k73Var);
            nz1 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    h03 M = h03.M();
                    if (M != null) {
                        M.P().E();
                    }
                    d14.e("back", Z());
                    ut3.g("0");
                    return;
                }
                qz1.b i = this.c.i("navigateBack");
                i.n(qz1.i, qz1.h);
                i.g();
                i.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            be3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            v24.q();
            u24.b();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.repackage.gd2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            x04.c().b();
            uy3.b().e();
            q().J(true);
            e1();
            V8Engine.setCrashKeyValue("game_title", Z() == null ? "" : Z().K());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && q().I()) {
            if (wd3.f(Z().a0())) {
                if (r) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
                }
                gw3.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && wd3.f(j0.swanCoreVersionName) && dl2.a(Z().S())) {
                if (r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                gw3.C();
            }
        }
    }

    @Override // com.repackage.gd2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            tt3.v();
            mc2.i();
            d14.e(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, Z());
            ul2.U().unregisterReceiver(this.b);
            ul2.b0();
            m24.a().b();
            SwanInspectorEndpoint.v().q();
            x04.c().b();
            uy3.b().e();
        }
    }

    @Override // com.repackage.gd2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            gw3.m().h(this.b);
        }
    }

    @Override // com.repackage.gd2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.repackage.gd2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ul2.U().registerReceiver(this.b);
        }
    }

    @Override // com.repackage.gd2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.repackage.gd2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
