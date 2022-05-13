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
import com.repackage.d02;
import com.repackage.jx3;
import com.repackage.px2;
/* loaded from: classes7.dex */
public class uw3 extends td2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public long r;

    /* loaded from: classes7.dex */
    public class a implements oj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw3 a;

        public a(uw3 uw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw3Var;
        }

        @Override // com.repackage.oj2
        public void a(int i, nj2 nj2Var) {
            jx3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, nj2Var) == null) || (cVar = (jx3.c) nj2Var) == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            tw3.m().I(this.a.Z());
            tw3.m().x(cVar);
            wu3.h();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements px2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw3 a;

        public b(uw3 uw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw3Var;
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
                    tw3.m().H();
                    t03.J().t();
                    return true;
                } else if (i == 102) {
                    boolean a = bk2.M().a();
                    bk2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.onNightModeCoverChanged(a, false);
                    }
                    return true;
                } else if (i == 103) {
                    u03 L = u03.L();
                    if (L != null) {
                        L.d0().i();
                        qs2.g().v();
                    }
                    this.a.Q0();
                    tw3.m().H();
                    hu3.b();
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
                        case 126:
                            nx2.d(message);
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
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw3 a;

        public c(uw3 uw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (uw3.s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.r = System.currentTimeMillis();
                q14.f(this.a.Z());
                this.a.b.finishLoadingAnimator();
                zt2.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                int j = tw3.m().j();
                HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                tw3.m().i(new ty3(f));
                if (uw3.s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                g34.A().D();
                kx3.f().init();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw3 a;

        public d(uw3 uw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw3Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755246592, "Lcom/repackage/uw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755246592, "Lcom/repackage/uw3;");
                return;
            }
        }
        s = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw3(SwanAppActivity swanAppActivity, String str) {
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
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            n73.E();
            if (z2) {
                q14.f(Z());
                hu3.b();
            }
        }
    }

    @Override // com.repackage.td2
    @NonNull
    public px2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (px2.c) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (t03.J().D()) {
                hm2.U().E(Z(), new a(this));
                if (tw3.m().v() && tw3.m().q()) {
                    tw3.m().F(this.b);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : invokeV.longValue;
    }

    @Override // com.repackage.td2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? t03.J().r().X().d0() == 1 : invokeV.booleanValue;
    }

    public c82 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? tw3.m().n() : (c82) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g34.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g34.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r > 0 : invokeV.booleanValue;
    }

    @Override // com.repackage.td2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ux1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            x73 x73Var = new x73();
            x73Var.e = "back";
            Q(x73Var);
            a02 m = this.c.m();
            if (m == null || !m.L()) {
                if (e0()) {
                    u03 L = u03.L();
                    if (L != null) {
                        L.O().E();
                    }
                    q14.e("back", Z());
                    hu3.g("0");
                    return;
                }
                d02.b i = this.c.i("navigateBack");
                i.n(d02.i, d02.h);
                i.g();
                i.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            oe3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            i34.q();
            h34.b();
        }
    }

    @Override // com.repackage.c13, com.repackage.x03
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

    @Override // com.repackage.td2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            k14.c().b();
            hz3.b().e();
            r().I(true);
            e1();
            V8Engine.setCrashKeyValue("game_title", Z() == null ? "" : Z().K());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && r().H()) {
            if (je3.f(Z().a0())) {
                if (s) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
                }
                tw3.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && je3.f(j0.swanCoreVersionName) && ql2.a(Z().S())) {
                if (s) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                tw3.C();
            }
        }
    }

    @Override // com.repackage.td2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            gu3.v();
            zc2.i();
            q14.e(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, Z());
            hm2.U().unregisterReceiver(this.b);
            hm2.b0();
            z24.a().b();
            SwanInspectorEndpoint.v().q();
            k14.c().b();
            hz3.b().e();
        }
    }

    @Override // com.repackage.td2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            tw3.m().h(this.b);
        }
    }

    @Override // com.repackage.td2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.repackage.td2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            hm2.U().registerReceiver(this.b);
        }
    }

    @Override // com.repackage.td2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.repackage.td2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
