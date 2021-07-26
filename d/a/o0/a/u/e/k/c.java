package d.a.o0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.c2.f.p0.g;
import d.a.o0.a.g1.f;
import d.a.o0.a.h;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.h0.t.a;
import d.a.o0.a.r1.i;
import d.a.o0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48225f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f48226g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48227h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f48228i;
        public final /* synthetic */ c j;

        /* renamed from: d.a.o0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0935a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f48229a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48230b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f48231c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f48232d;

            public C0935a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f48232d = aVar;
                this.f48229a = eVar;
                this.f48230b = str;
                this.f48231c = dVar;
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f48232d.f48227h);
                    d.a.o0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f48232d.f48224e.o();
                    a aVar = this.f48232d;
                    d.a.o0.a.c2.f.p0.a.m(aVar.j, this.f48229a, this.f48230b, aVar.f48226g.f46493e, null, aVar.f48225f);
                    a aVar2 = this.f48232d;
                    aVar2.j.v(this.f48231c, aVar2.f48226g, aVar2.f48228i, aVar2.f48227h);
                }
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.o0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f48232d.f48224e.o();
                    if (d.a.o0.a.u.c.d.f47942c) {
                        Context i3 = this.f48232d.j.i();
                        d.a.o0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f48232d;
                    d.a.o0.a.c2.f.p0.a.k(aVar.j, aVar.f48225f);
                }
            }
        }

        public a(c cVar, f fVar, String str, d.a.o0.a.l1.b bVar, String str2, d.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, str, bVar, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f48224e = fVar;
            this.f48225f = str;
            this.f48226g = bVar;
            this.f48227h = str2;
            this.f48228i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity activity = this.f48224e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = d.a.o0.a.h0.t.a.f(activity);
                    String b2 = f2.f45716a.b();
                    if (d.a.o0.a.u.c.d.f47942c) {
                        Log.d("Api-RedirectTo", "webview id: " + b2);
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!d.a.o0.a.u.c.d.f47942c) {
                            this.j.d(this.f48225f, new d.a.o0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f48224e.u();
                    d.a.o0.a.c2.f.p0.g.g(i2, this.f48226g, b2, new C0935a(this, i2, b2, f2), this.f48227h);
                } else if (!d.a.o0.a.u.c.d.f47942c) {
                    this.j.d(this.f48225f, new d.a.o0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f48233a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48234b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f48235c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f48236d;

        public b(c cVar, a.d dVar, String str, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48233a = dVar;
            this.f48234b = str;
            this.f48235c = bVar;
            this.f48236d = gVar;
        }

        @Override // d.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                i.e(this.f48233a, this.f48234b);
                d.a.o0.a.c2.f.p0.a.e(this.f48233a.f45716a, this.f48235c, this.f48234b);
                c.u(this.f48236d, this.f48235c, this.f48234b, false);
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.o0.a.u.c.b bVar) {
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
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e Q = e.Q();
            return Q == null || (x = Q.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public static void u(d.a.o0.a.h0.g.g gVar, d.a.o0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || t() || (x = d.a.o0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        d.a.o0.a.h0.g.f.E3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45717b;
            HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
            }
        }
    }

    public d.a.o0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-RedirectTo", "handle: " + str);
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-RedirectTo", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = d.a.o0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d.a.o0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new d.a.o0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            d.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.o0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new d.a.o0.a.u.h.b(1001, "manager is null");
            }
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(p, V.A());
            d.a.o0.a.j2.h.f(g2.f46493e, "2");
            if (!q0.b(V.s(), g2, false)) {
                String str2 = "page params error : path=" + g2.f46493e + " ; routePath=" + g2.f46496h;
                d.a.o0.a.e0.d.b("Api-RedirectTo", str2);
                return new d.a.o0.a.u.h.b(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && g2 != null && !TextUtils.isEmpty(g2.f46496h) && e.i() != null) {
                e.i().x0(optString, g2.f46496h);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.C(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                d.a.o0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new d.a.o0.a.u.h.b(202, "cb is null");
            } else if (d.a.o0.a.c2.f.g0.d.b().a(g2)) {
                d.a.o0.a.c2.f.g0.d.b().i("redirectTo", g2);
                d.a.o0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new d.a.o0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new d.a.o0.a.u.h.b(0);
            }
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
