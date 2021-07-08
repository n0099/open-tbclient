package d.a.n0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.c2.f.p0.g;
import d.a.n0.a.g1.f;
import d.a.n0.a.h;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.h0.t.a;
import d.a.n0.a.r1.i;
import d.a.n0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47733e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47734f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47735g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47736h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f47737i;
        public final /* synthetic */ d j;

        /* renamed from: d.a.n0.a.u.e.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0927a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f47738a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f47739b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f47740c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f47741d;

            public C0927a(a aVar, e eVar, String str, a.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, str, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47741d = aVar;
                this.f47738a = eVar;
                this.f47739b = str;
                this.f47740c = dVar;
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f47741d.f47736h);
                    d.a.n0.a.e0.d.g("Api-ReLaunch", "check pages success");
                    this.f47741d.f47733e.o();
                    a aVar = this.f47741d;
                    d.a.n0.a.c2.f.p0.a.m(aVar.j, this.f47738a, this.f47739b, aVar.f47735g.f45989e, null, aVar.f47734f);
                    d.a.n0.a.j2.e.t(this.f47739b);
                    a aVar2 = this.f47741d;
                    aVar2.j.u(this.f47740c, aVar2.f47735g, aVar2.f47737i, aVar2.f47736h);
                }
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.n0.a.e0.d.b("Api-ReLaunch", "check pages failed");
                    this.f47741d.f47733e.o();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Context i3 = this.f47741d.j.i();
                        d.a.n0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f47741d;
                    d.a.n0.a.c2.f.p0.a.k(aVar.j, aVar.f47734f);
                }
            }
        }

        public a(d dVar, f fVar, String str, d.a.n0.a.l1.b bVar, String str2, d.a.n0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = dVar;
            this.f47733e = fVar;
            this.f47734f = str;
            this.f47735g = bVar;
            this.f47736h = str2;
            this.f47737i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.f47733e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d g2 = d.a.n0.a.h0.t.a.g(activity, true);
                    String b2 = g2.f45212a.b();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Log.d("Api-ReLaunch", "webview idx: " + b2);
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!d.a.n0.a.u.c.d.f47438c) {
                            this.j.d(this.f47734f, new d.a.n0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f47733e.u();
                    d.a.n0.a.c2.f.p0.g.g(i2, this.f47735g, b2, new C0927a(this, i2, b2, g2), this.f47736h);
                } else if (!d.a.n0.a.u.c.d.f47438c) {
                    this.j.d(this.f47734f, new d.a.n0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f47742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47743b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47744c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f47745d;

        public b(d dVar, a.d dVar2, String str, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47742a = dVar2;
            this.f47743b = str;
            this.f47744c = bVar;
            this.f47745d = gVar;
        }

        @Override // d.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                i.e(this.f47742a, this.f47743b);
                d.a.n0.a.c2.f.p0.a.e(this.f47742a.f45212a, this.f47744c, this.f47743b);
                d.t(this.f47745d, this.f47744c, this.f47743b);
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.n0.a.h0.g.g.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // d.a.n0.a.h0.g.g.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof d.a.n0.a.h0.g.f)) {
                ((d.a.n0.a.h0.g.f) fragment).P0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void t(d.a.n0.a.h0.g.g gVar, d.a.n0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, gVar, bVar, str) == null) {
            if (bVar != null) {
                d.a.n0.a.e0.d.g("Api-ReLaunch", "doReLaunch page=" + bVar.f45989e + " routePage=" + bVar.f45992h);
            }
            SwanAppActivity x = d.a.n0.a.a2.d.g().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            i.c(3, str);
            d.a.n0.a.h0.g.f.E3(q0.n());
            gVar.g(cVar);
            g.b i2 = gVar.i("reLaunch");
            i2.n(0, 0);
            i2.f();
            i2.k("normal", bVar).b();
            gVar.p(cVar);
            d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar);
        }
    }

    public final void u(a.d dVar, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45213b;
            HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.n0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
            }
        }
    }

    public d.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-ReLaunch", "handle: " + str);
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-ReLaunch", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-ReLaunch", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = d.a.n0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d.a.n0.a.e0.d.b("Api-ReLaunch", "url is null");
                return new d.a.n0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            d.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-ReLaunch", "manager is null");
                return new d.a.n0.a.u.h.b(1001, "manager is null");
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(p, V.A());
            d.a.n0.a.j2.h.f(g2.f45989e, "3");
            if (!q0.b(V.s(), g2, true)) {
                String str2 = "page params error : path=" + g2.f45989e + " ; routePath=" + g2.f45992h;
                d.a.n0.a.e0.d.b("Api-ReLaunch", str2);
                return new d.a.n0.a.u.h.b(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f45992h) && e.i() != null) {
                e.i().x0(optString, g2.f45992h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                d.a.n0.a.e0.d.b("Api-ReLaunch", "cb is null");
                return new d.a.n0.a.u.h.b(202, "cb is null");
            } else if (d.a.n0.a.c2.f.g0.d.b().a(g2)) {
                d.a.n0.a.c2.f.g0.d.b().i("reLaunch", g2);
                d.a.n0.a.e0.d.b("Api-ReLaunch", "access to this page is prohibited");
                return new d.a.n0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new d.a.n0.a.u.h.b(0);
            }
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
