package d.a.q0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
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
import d.a.q0.a.a1.e;
import d.a.q0.a.c2.f.p0.g;
import d.a.q0.a.c2.f.p0.j;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.k;
import d.a.q0.a.v2.o0;
import d.a.q0.a.v2.p0;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.x0;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c extends d.a.q0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47835e;

        public a(c cVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47835e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0.g(this.f47835e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f47837b;

        /* loaded from: classes8.dex */
        public class a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f47838a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.g f47839b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f47840c;

            public a(b bVar, int i2, e.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47840c = bVar;
                this.f47838a = i2;
                this.f47839b = gVar;
            }

            @Override // d.a.q0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    d.a.q0.a.e0.d.g("SwanApp", "download subpackage success");
                    b bVar = this.f47840c;
                    bVar.f47837b.Y(this.f47838a, bVar.f47836a, this.f47839b);
                }
            }

            @Override // d.a.q0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.q0.a.e0.d.l("SwanApp", "download subpackage fail: " + i2);
                    this.f47840c.f47836a.Q0(null);
                    b bVar = this.f47840c;
                    bVar.f47837b.Y(this.f47838a, bVar.f47836a, this.f47839b);
                    d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(38L);
                    aVar.e("download subpackage fail, errcode=" + i2);
                    d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
                    dVar.q(k.m(this.f47840c.f47836a.G()));
                    dVar.p(aVar);
                    dVar.r(this.f47840c.f47836a);
                    k.L(dVar);
                }
            }
        }

        public b(c cVar, d.a.q0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47837b = cVar;
            this.f47836a = bVar;
        }

        @Override // d.a.q0.a.a1.b
        public void a(int i2, d.a.q0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                e.g gVar = (e.g) aVar;
                if (d.a.q0.a.c2.f.p0.g.o(this.f47836a, gVar)) {
                    if (d.a.q0.a.a2.e.i() != null && !TextUtils.isEmpty(gVar.f46625a)) {
                        String f2 = o0.f(this.f47836a.e0());
                        if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                            f2 = f2.substring(1);
                        }
                        String str = gVar.f46626b.f11458c.f11493c.get(j.b(f2));
                        d.a.q0.a.c2.f.p0.g.l(this.f47836a.H(), this.f47836a.u1(), "3", str, gVar.f46626b.f11459d.f11497a.get(str), this.f47837b.D(), new a(this, i2, gVar));
                        return;
                    }
                    d.a.q0.a.e0.d.l("SwanApp", "subpackage is invalid");
                }
                this.f47837b.Y(i2, this.f47836a, gVar);
            }
        }
    }

    /* renamed from: d.a.q0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0759c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47841e;

        public RunnableC0759c(c cVar, d.a.q0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47841e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.C0680e.c(this.f47841e.H(), this.f47841e.u1());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f47843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f47844g;

        public d(c cVar, d.a.q0.a.f1.e.b bVar, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47844g = cVar;
            this.f47842e = bVar;
            this.f47843f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47844g.Z(this.f47842e, this.f47843f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47845e;

        public e(c cVar, d.a.q0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47845e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.f47845e.n("fromHost");
                String n2 = this.f47845e.n("spuId");
                String n3 = this.f47845e.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !d.a.q0.a.c1.a.j0().a(n, n2, n3)) {
                    return;
                }
                this.f47845e.y("fromHost", null);
                this.f47845e.y("spuId", null);
                this.f47845e.y("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116041188, "Ld/a/q0/a/g1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116041188, "Ld/a/q0/a/g1/c;");
                return;
            }
        }
        l = d.a.q0.a.k.f49133a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    @Nullable
    public d.a.q0.a.a2.e F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.q0.a.a2.e.i() : (d.a.q0.a.a2.e) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void G(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.G(bVar, bVar2);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
            }
            d.a.q0.a.a1.e.c(bVar, new b(this, bVar));
            d.a.q0.a.h0.u.g.N().O0(bVar);
            d.a.q0.a.h0.u.g.N().N0(bVar);
            d.a.q0.a.h0.u.g.N().v0(null);
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.q0.a.h0.u.g.N().V() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.P();
            d.a.q0.a.h0.t.a.d();
            d.a.q0.a.h0.u.g.A0(false);
            if (this.f47823a != null) {
                this.f47823a = null;
            }
            d.a.q0.a.v2.j.h();
            d.a.q0.a.i1.b.b();
            d.a.q0.a.i1.f.e.a.y();
            d.a.q0.a.n2.d.a.a.b();
            d.a.q0.a.n2.f.a.n();
            d.a.q0.a.n2.a.a.d();
            d.a.q0.a.n2.i.a.k();
            d.a.q0.a.v0.a.d();
            d.a.q0.a.m1.g.f().q();
            d.a.q0.a.c2.f.i0.a.h();
            d.a.q0.a.n2.b.d.i();
            d.a.q0.a.m1.f.k();
            if (d.a.q0.a.c1.a.E() != null) {
                d.a.q0.a.c1.a.E().d();
            }
            d.a.q0.a.u.e.o.k.e().m();
            d.a.q0.a.z.a.b().f();
            d.a.q0.a.c2.f.g0.d.b().k();
            d.a.q0.a.y0.g.e.d();
            d.a.q0.a.u.f.a.d().h();
            d.a.q0.a.l1.d.d.f().e();
            d.a.q0.a.l0.o.a.m();
            d.a.q0.a.h0.u.b.b();
            if (d.a.q0.a.r1.l.e.g()) {
                d.a.q0.a.f1.c.b.c().a();
                d.a.q0.a.r1.r.a.f().b();
            }
            SwanPrefetchImageRes.b().e();
        }
    }

    public final void Y(int i2, d.a.q0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bVar, gVar) == null) || i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        d.a.q0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
        q0.a0(this.k);
        d dVar = new d(this, bVar, gVar);
        this.k = dVar;
        q0.d0(dVar);
    }

    public final void Z(d.a.q0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, gVar) == null) {
            d.a.q0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_end"));
            d.a.q0.a.i2.a.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.f47831i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f46625a + ", baseUrl:" + f.V().A())));
                    return;
                }
                return;
            }
            this.f47825c = gVar.f46625a;
            b0(gVar.f46626b);
            if (bVar.l0()) {
                n(this.f47826d).setVisibility(0);
                d.a.q0.a.e0.a.b(true);
                d.a.q0.a.e0.d.g("AppsControllerImpl", "init sConsole for devHook");
            }
            d.a.q0.a.h0.u.g.N().M0(bVar, gVar);
        }
    }

    public final void a0(d.a.q0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.Y(new e(this, bVar), 2000L);
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
            if (g2.C()) {
                g2.r().t0(swanAppConfigData);
            }
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void c(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bVar2) == null) {
            super.c(bVar, bVar2);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.i0());
            }
            d.a.q0.a.h0.u.g.N().O0(bVar);
            d.a.q0.a.h0.u.g.N().v0(null);
            SwanAppConfigData F = d.a.q0.a.a2.d.g().r().F();
            if (F != null) {
                e.g gVar = new e.g();
                d.a.q0.a.r1.k.i.c.f().e(new RunnableC0759c(this, bVar), "deleteLowerVersionFolder");
                gVar.f46626b = F;
                gVar.f46625a = e.C0680e.i(bVar.H(), bVar.u1()).getPath() + File.separator;
                d.a.q0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
                d.a.q0.a.i2.a.d().i("na_post_to_main_start");
                Z(bVar, gVar);
            }
        }
    }

    @Override // d.a.q0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long T = f.V().T();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T);
            }
            return this.f47830h && T <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.w();
            d.a.q0.a.e0.d.g("SwanApp", "onAppForeground");
            String V = d.a.q0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
            SwanAppActivity swanAppActivity = this.f47826d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                hashMap.put("clkid", this.f47826d.getLaunchInfo().L());
                hashMap.put("scene", this.f47826d.getLaunchInfo().T());
                b.a launchInfo = this.f47826d.getLaunchInfo();
                d.a.q0.a.j2.e.v(launchInfo);
                a0(launchInfo);
            }
            v(new d.a.q0.a.o0.d.c(hashMap));
            d.a.q0.a.e0.d.g("SwanApp", "onAppShow");
            d.a.q0.a.z.a.b().g(false);
            d.a.q0.a.i1.b.h(true);
            d.a.q0.a.i1.f.e.a.r(false);
            d.a.q0.a.m1.g.f().j(false);
            d.a.q0.a.u.e.o.k.e().i();
            d.a.q0.a.m1.f.i();
            if (d.a.q0.a.c1.a.E() != null) {
                d.a.q0.a.c1.a.E().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (d.a.q0.a.r1.l.e.l()) {
                d.a.q0.a.r1.k.i.b.e().f(aVar, "saveSwanAppForeGroundTime");
            } else {
                q.j(aVar, "saveSwanAppForeGroundTime");
            }
            d.a.q0.a.l0.o.a.l();
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.x();
            d.a.q0.a.e0.d.g("SwanApp", "onAppBackground");
            String V = d.a.q0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
            contentValues.put("hiddenType", Integer.valueOf(x0.b().a()));
            v(new d.a.q0.a.o0.d.c(contentValues));
            d.a.q0.a.e0.d.g("SwanApp", "onAppHide");
            x0.b().d();
            d.a.q0.a.z.a.b().g(true);
            d.a.q0.a.i1.b.h(false);
            d.a.q0.a.i1.f.e.a.r(true);
            d.a.q0.a.m1.g.f().j(true);
            d.a.q0.a.m1.f.j(false);
            if (d.a.q0.a.c1.a.E() != null) {
                d.a.q0.a.c1.a.E().c();
            }
            p0.h();
            d.a.q0.a.k1.a.i();
            d.a.q0.a.l0.o.a.k();
        }
    }
}
