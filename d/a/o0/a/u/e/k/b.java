package d.a.o0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import d.a.o0.a.j2.k;
import d.a.o0.a.r1.i;
import d.a.o0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f48209d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48211f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f48212g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48213h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f48214i;
        public final /* synthetic */ b j;

        /* renamed from: d.a.o0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0933a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f48215a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48216b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f48217c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f48218d;

            public C0933a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f48218d = aVar;
                this.f48215a = eVar;
                this.f48216b = str;
                this.f48217c = dVar;
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f48218d.f48213h);
                    d.a.o0.a.e0.d.g("Api-NavigateTo", "check pages success");
                    k.B(true, this.f48215a.N().T());
                    this.f48218d.f48210e.o();
                    List<String> g2 = d.a.o0.a.c2.f.p0.a.g(this.f48218d.f48214i);
                    a aVar = this.f48218d;
                    d.a.o0.a.c2.f.p0.a.m(aVar.j, this.f48215a, this.f48216b, aVar.f48212g.f46493e, g2, aVar.f48211f);
                    a aVar2 = this.f48218d;
                    aVar2.j.w(this.f48217c, aVar2.f48212g, aVar2.f48214i, aVar2.f48213h);
                }
            }

            @Override // d.a.o0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.o0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                    k.B(false, this.f48215a.N().T());
                    this.f48218d.f48210e.o();
                    if (d.a.o0.a.u.c.d.f47942c) {
                        Context i3 = this.f48218d.j.i();
                        d.a.o0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f48218d;
                    d.a.o0.a.c2.f.p0.a.k(aVar.j, aVar.f48211f);
                }
            }
        }

        public a(b bVar, f fVar, String str, d.a.o0.a.l1.b bVar2, String str2, d.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar, str, bVar2, str2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f48210e = fVar;
            this.f48211f = str;
            this.f48212g = bVar2;
            this.f48213h = str2;
            this.f48214i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity activity = this.f48210e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = d.a.o0.a.h0.t.a.f(activity);
                    String b2 = f2.f45716a.b();
                    if (d.a.o0.a.u.c.d.f47942c) {
                        Log.d("Api-NavigateTo", "slave webView id: " + b2);
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!d.a.o0.a.u.c.d.f47942c) {
                            this.j.d(this.f48211f, new d.a.o0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f48210e.u();
                    d.a.o0.a.c2.f.p0.g.g(i2, this.f48212g, b2, new C0933a(this, i2, b2, f2), this.f48213h);
                } else if (!d.a.o0.a.u.c.d.f47942c) {
                    this.j.d(this.f48211f, new d.a.o0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0934b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f48219a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48220b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f48221c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f48222d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48223e;

        public C0934b(b bVar, a.d dVar, String str, d.a.o0.a.l1.b bVar2, d.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar, str, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48223e = bVar;
            this.f48219a = dVar;
            this.f48220b = str;
            this.f48221c = bVar2;
            this.f48222d = gVar;
        }

        @Override // d.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                i.e(this.f48219a, this.f48220b);
                this.f48223e.u(this.f48219a.f45716a, this.f48221c, this.f48222d, this.f48220b);
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524872712, "Ld/a/o0/a/u/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1524872712, "Ld/a/o0/a/u/e/k/b;");
                return;
            }
        }
        f48209d = d.a.o0.a.c1.a.Z().s();
        if (d.a.o0.a.u.c.d.f47942c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f48209d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void u(d.a.o0.a.p.e.b bVar, d.a.o0.a.l1.b bVar2, d.a.o0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, bVar2, gVar, str) == null) || (activity = f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d.a.o0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f48209d) {
            d.a.o0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.o0.a.h0.g.g.f45212g, d.a.o0.a.h0.g.g.f45214i);
            i2.k("normal", bVar2).b();
            d.a.o0.a.v2.g.c(gVar, i());
            d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public d.a.o0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateTo", "handle: " + str);
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-NavigateTo", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-NavigateTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = d.a.o0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d.a.o0.a.e0.d.b("Api-NavigateTo", "url is null");
                return new d.a.o0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            d.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.o0.a.e0.d.b("Api-NavigateTo", "manager is null");
                return new d.a.o0.a.u.h.b(1001, "manager is null");
            }
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(p, V.A());
            d.a.o0.a.j2.h.f(g2.f46493e, "0");
            if (!q0.b(V.s(), g2, false)) {
                String str2 = "page params error : path=" + g2.f46493e + " ; routePath=" + g2.f46496h;
                d.a.o0.a.e0.d.b("Api-NavigateTo", str2);
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
                d.a.o0.a.e0.d.b("Api-NavigateTo", "cb is null");
                return new d.a.o0.a.u.h.b(202, "cb is null");
            } else if (d.a.o0.a.c2.f.g0.d.b().a(g2)) {
                d.a.o0.a.c2.f.g0.d.b().i("navigateTo", g2);
                d.a.o0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
                return new d.a.o0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new d.a.o0.a.u.h.b(0);
            }
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void w(a.d dVar, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45717b;
            HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.o0.a.h0.t.a.n(dVar, new C0934b(this, dVar, str, bVar, gVar));
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
