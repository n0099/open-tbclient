package d.a.n0.a.u.e.k;

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
public class c extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47722g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47723h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f47724i;
        public final /* synthetic */ c j;

        /* renamed from: d.a.n0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0926a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f47725a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f47726b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f47727c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f47728d;

            public C0926a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f47728d = aVar;
                this.f47725a = eVar;
                this.f47726b = str;
                this.f47727c = dVar;
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f47728d.f47723h);
                    d.a.n0.a.e0.d.g("Api-RedirectTo", "check pages success");
                    this.f47728d.f47720e.o();
                    a aVar = this.f47728d;
                    d.a.n0.a.c2.f.p0.a.m(aVar.j, this.f47725a, this.f47726b, aVar.f47722g.f45989e, null, aVar.f47721f);
                    a aVar2 = this.f47728d;
                    aVar2.j.v(this.f47727c, aVar2.f47722g, aVar2.f47724i, aVar2.f47723h);
                }
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.n0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                    this.f47728d.f47720e.o();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Context i3 = this.f47728d.j.i();
                        d.a.n0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f47728d;
                    d.a.n0.a.c2.f.p0.a.k(aVar.j, aVar.f47721f);
                }
            }
        }

        public a(c cVar, f fVar, String str, d.a.n0.a.l1.b bVar, String str2, d.a.n0.a.h0.g.g gVar) {
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
            this.f47720e = fVar;
            this.f47721f = str;
            this.f47722g = bVar;
            this.f47723h = str2;
            this.f47724i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity activity = this.f47720e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = d.a.n0.a.h0.t.a.f(activity);
                    String b2 = f2.f45212a.b();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Log.d("Api-RedirectTo", "webview id: " + b2);
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!d.a.n0.a.u.c.d.f47438c) {
                            this.j.d(this.f47721f, new d.a.n0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f47720e.u();
                    d.a.n0.a.c2.f.p0.g.g(i2, this.f47722g, b2, new C0926a(this, i2, b2, f2), this.f47723h);
                } else if (!d.a.n0.a.u.c.d.f47438c) {
                    this.j.d(this.f47721f, new d.a.n0.a.u.h.b(1001, "swan activity is null"));
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
        public final /* synthetic */ a.d f47729a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47730b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47731c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f47732d;

        public b(c cVar, a.d dVar, String str, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar) {
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
            this.f47729a = dVar;
            this.f47730b = str;
            this.f47731c = bVar;
            this.f47732d = gVar;
        }

        @Override // d.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                i.e(this.f47729a, this.f47730b);
                d.a.n0.a.c2.f.p0.a.e(this.f47729a.f45212a, this.f47731c, this.f47730b);
                c.u(this.f47732d, this.f47731c, this.f47730b, false);
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.n0.a.u.c.b bVar) {
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

    public static void u(d.a.n0.a.h0.g.g gVar, d.a.n0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gVar, bVar, str, Boolean.valueOf(z)}) == null) || t() || (x = d.a.n0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        d.a.n0.a.h0.g.f.E3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45213b;
            HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.n0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
            }
        }
    }

    public d.a.n0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-RedirectTo", "handle: " + str);
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-RedirectTo", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-RedirectTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = d.a.n0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d.a.n0.a.e0.d.b("Api-RedirectTo", "url is null");
                return new d.a.n0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            d.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-RedirectTo", "manager is null");
                return new d.a.n0.a.u.h.b(1001, "manager is null");
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(p, V.A());
            d.a.n0.a.j2.h.f(g2.f45989e, "2");
            if (!q0.b(V.s(), g2, false)) {
                String str2 = "page params error : path=" + g2.f45989e + " ; routePath=" + g2.f45992h;
                d.a.n0.a.e0.d.b("Api-RedirectTo", str2);
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
                d.a.n0.a.e0.d.b("Api-RedirectTo", "cb is null");
                return new d.a.n0.a.u.h.b(202, "cb is null");
            } else if (d.a.n0.a.c2.f.g0.d.b().a(g2)) {
                d.a.n0.a.c2.f.g0.d.b().i("redirectTo", g2);
                d.a.n0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
                return new d.a.n0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new d.a.n0.a.u.h.b(0);
            }
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
