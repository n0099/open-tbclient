package d.a.q0.h.o;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.g1.f;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.h0.m.h;
import d.a.q0.a.k;
import d.a.q0.a.r0.i;
import d.a.q0.a.v1.c.e.a;
import d.a.q0.a.v2.l0;
import d.a.q0.a.v2.q0;
import d.a.q0.h.s.a;
/* loaded from: classes8.dex */
public class d extends d.a.q0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public long v;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f53449a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53449a = dVar;
        }

        @Override // d.a.q0.a.a1.b
        public void a(int i2, d.a.q0.a.a1.a aVar) {
            a.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || (cVar = (a.c) aVar) == null || TextUtils.isEmpty(cVar.f53602a)) {
                return;
            }
            d.a.q0.h.o.c.m().I(this.f53449a.O());
            d.a.q0.h.o.c.m().x(cVar);
            d.a.q0.h.c.j.b.h();
            this.f53449a.Z0();
            this.f53449a.Y0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f53450a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53450a = dVar;
        }

        @Override // d.a.q0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(4));
                    this.f53450a.G0();
                    d.a.q0.h.o.c.m().H();
                    d.a.q0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 102) {
                    boolean a2 = d.a.q0.a.c1.a.H().a();
                    d.a.q0.a.c1.a.H().d(a2);
                    if (this.f53450a.f50645f != null) {
                        this.f53450a.f50645f.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    d.a.q0.a.a2.e i3 = d.a.q0.a.a2.e.i();
                    if (i3 != null) {
                        i3.T().i();
                        d.a.q0.a.n1.q.a.g().v();
                    }
                    this.f53450a.G0();
                    d.a.q0.h.o.c.m().H();
                    return true;
                } else if (i2 == 106) {
                    d.a.q0.a.a2.d.g().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            d.a.q0.a.v2.c.r(message);
                            return true;
                        case 124:
                            d.a.q0.a.v2.c.q(message);
                            return true;
                        case 125:
                            d.a.q0.a.v1.c.d.a.b(message);
                            return true;
                        case 126:
                            d.a.q0.a.v1.c.d.a.d(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    h.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f53451e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53451e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.f53451e.v = System.currentTimeMillis();
                d.a.q0.h.f0.h.f(this.f53451e.O());
                this.f53451e.f50645f.finishLoadingAnimator();
                d.a.q0.a.r1.h.h("preload", "startup");
                int j = d.a.q0.h.o.c.m().j();
                HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.A("codecache", String.valueOf(j));
                p.C(new UbcFlowEvent("na_first_paint"));
                p.x();
                long e2 = p.e("na_first_paint", "naStart");
                d.a.q0.h.o.c.m().i(new d.a.q0.h.w.b(e2));
                if (d.w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2);
                }
                d.a.q0.h.m0.d.A().D();
                d.a.q0.h.t.a.f().init();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035669321, "Ld/a/q0/h/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035669321, "Ld/a/q0/h/o/d;");
                return;
            }
        }
        w = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.t0.c
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (a.c) invokeV.objValue;
    }

    @Override // d.a.q0.a.t0.c
    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.q0.a.a2.d.g().r().N().d0() == 1 : invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c1();
            if (d.a.q0.a.a2.d.g().C()) {
                f.V().G(O(), new a(this));
                if (d.a.q0.h.o.c.m().v() && d.a.q0.h.o.c.m().q()) {
                    d.a.q0.h.o.c.m().F(this.f50645f);
                }
            }
        }
    }

    public long W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.longValue;
    }

    public d.a.q0.a.l0.a X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.a.q0.h.o.c.m().n() : (d.a.q0.a.l0.a) invokeV.objValue;
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.q0.h.m0.d.A().m();
        }
    }

    @Override // d.a.q0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f50646g.k());
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49123e = j.j;
            F(fVar);
            d.a.q0.a.h0.g.d m = this.f50646g.m();
            if (m == null || !m.K()) {
                if (T()) {
                    d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
                    if (i2 != null) {
                        i2.E().E();
                    }
                    d.a.q0.h.f0.h.e(j.j, O());
                    return;
                }
                g.b i3 = this.f50646g.i("navigateBack");
                i3.n(g.f48012i, g.f48011h);
                i3.g();
                i3.a();
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.h.m0.d.A().F();
        }
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d1();
            d.a.q0.h.f0.b.c().b();
            d.a.q0.h.y.e.b.b().e();
            r().f(true);
            V0();
            V8Engine.setCrashKeyValue("game_title", O() == null ? "" : O().K());
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            q0.b0(new c(this));
            d.a.q0.h.m0.f.j();
            d.a.q0.h.m0.e.b();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.v = 0L;
        }
    }

    @Override // d.a.q0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.q0.h.b.d.w();
            i.i();
            d.a.q0.h.f0.h.e("exit", O());
            f.V().k(this.f50645f);
            f.c0();
            d.a.q0.h.l0.a.a().b();
            SwanInspectorEndpoint.v().q();
            d.a.q0.h.f0.b.c().b();
            d.a.q0.h.y.e.b.b().e();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && r().e()) {
            if (l0.f(O().a0())) {
                if (w) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + O().a0());
                }
                d.a.q0.h.o.c.C();
                return;
            }
            SwanCoreVersion i0 = O().i0();
            if (i0 != null && l0.f(i0.swanCoreVersionName) && d.a.q0.a.f1.e.a.a(O().S())) {
                if (w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                d.a.q0.h.o.c.C();
            }
        }
    }

    @Override // d.a.q0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.h0();
            d.a.q0.h.o.c.m().h(this.f50645f);
        }
    }

    @Override // d.a.q0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // d.a.q0.a.a2.m, d.a.q0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            f.V().E(this.f50645f);
        }
    }

    @Override // d.a.q0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // d.a.q0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // d.a.q0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // d.a.q0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // d.a.q0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            d.a.q0.a.j2.k.A();
            if (z2) {
                d.a.q0.h.f0.h.f(O());
            }
        }
    }
}
