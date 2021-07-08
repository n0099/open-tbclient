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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import d.a.n0.a.j2.k;
import d.a.n0.a.r1.i;
import d.a.n0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f47705d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47706e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47707f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47708g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47709h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f47710i;
        public final /* synthetic */ b j;

        /* renamed from: d.a.n0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0924a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f47711a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f47712b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f47713c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f47714d;

            public C0924a(a aVar, e eVar, String str, a.d dVar) {
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
                this.f47714d = aVar;
                this.f47711a = eVar;
                this.f47712b = str;
                this.f47713c = dVar;
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i.d(this.f47714d.f47709h);
                    d.a.n0.a.e0.d.g("Api-NavigateTo", "check pages success");
                    k.B(true, this.f47711a.N().T());
                    this.f47714d.f47706e.o();
                    List<String> g2 = d.a.n0.a.c2.f.p0.a.g(this.f47714d.f47710i);
                    a aVar = this.f47714d;
                    d.a.n0.a.c2.f.p0.a.m(aVar.j, this.f47711a, this.f47712b, aVar.f47708g.f45989e, g2, aVar.f47707f);
                    a aVar2 = this.f47714d;
                    aVar2.j.w(this.f47713c, aVar2.f47708g, aVar2.f47710i, aVar2.f47709h);
                }
            }

            @Override // d.a.n0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    d.a.n0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                    k.B(false, this.f47711a.N().T());
                    this.f47714d.f47706e.o();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Context i3 = this.f47714d.j.i();
                        d.a.n0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                    }
                    a aVar = this.f47714d;
                    d.a.n0.a.c2.f.p0.a.k(aVar.j, aVar.f47707f);
                }
            }
        }

        public a(b bVar, f fVar, String str, d.a.n0.a.l1.b bVar2, String str2, d.a.n0.a.h0.g.g gVar) {
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
            this.f47706e = fVar;
            this.f47707f = str;
            this.f47708g = bVar2;
            this.f47709h = str2;
            this.f47710i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity activity = this.f47706e.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a.d f2 = d.a.n0.a.h0.t.a.f(activity);
                    String b2 = f2.f45212a.b();
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Log.d("Api-NavigateTo", "slave webView id: " + b2);
                    }
                    e i2 = e.i();
                    if (i2 == null) {
                        if (!d.a.n0.a.u.c.d.f47438c) {
                            this.j.d(this.f47707f, new d.a.n0.a.u.h.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    this.f47706e.u();
                    d.a.n0.a.c2.f.p0.g.g(i2, this.f47708g, b2, new C0924a(this, i2, b2, f2), this.f47709h);
                } else if (!d.a.n0.a.u.c.d.f47438c) {
                    this.j.d(this.f47707f, new d.a.n0.a.u.h.b(1001, "swan activity is null"));
                } else {
                    throw new RuntimeException("swan activity is null");
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0925b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f47715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47716b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f47717c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f47718d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f47719e;

        public C0925b(b bVar, a.d dVar, String str, d.a.n0.a.l1.b bVar2, d.a.n0.a.h0.g.g gVar) {
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
            this.f47719e = bVar;
            this.f47715a = dVar;
            this.f47716b = str;
            this.f47717c = bVar2;
            this.f47718d = gVar;
        }

        @Override // d.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                i.e(this.f47715a, this.f47716b);
                this.f47719e.u(this.f47715a.f45212a, this.f47717c, this.f47718d, this.f47716b);
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231469705, "Ld/a/n0/a/u/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231469705, "Ld/a/n0/a/u/e/k/b;");
                return;
            }
        }
        f47705d = d.a.n0.a.c1.a.Z().s();
        if (d.a.n0.a.u.c.d.f47438c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f47705d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void u(d.a.n0.a.p.e.b bVar, d.a.n0.a.l1.b bVar2, d.a.n0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, bVar2, gVar, str) == null) || (activity = f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d.a.n0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f47705d) {
            d.a.n0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.n0.a.h0.g.g.f44708g, d.a.n0.a.h0.g.g.f44710i);
            i2.k("normal", bVar2).b();
            d.a.n0.a.v2.g.c(gVar, i());
            d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public d.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigateTo", "handle: " + str);
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-NavigateTo", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-NavigateTo", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String p = d.a.n0.a.c2.f.p0.a.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d.a.n0.a.e0.d.b("Api-NavigateTo", "url is null");
                return new d.a.n0.a.u.h.b(202, "url is null");
            }
            f V = f.V();
            d.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-NavigateTo", "manager is null");
                return new d.a.n0.a.u.h.b(1001, "manager is null");
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(p, V.A());
            d.a.n0.a.j2.h.f(g2.f45989e, "0");
            if (!q0.b(V.s(), g2, false)) {
                String str2 = "page params error : path=" + g2.f45989e + " ; routePath=" + g2.f45992h;
                d.a.n0.a.e0.d.b("Api-NavigateTo", str2);
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
                d.a.n0.a.e0.d.b("Api-NavigateTo", "cb is null");
                return new d.a.n0.a.u.h.b(202, "cb is null");
            } else if (d.a.n0.a.c2.f.g0.d.b().a(g2)) {
                d.a.n0.a.c2.f.g0.d.b().i("navigateTo", g2);
                d.a.n0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
                return new d.a.n0.a.u.h.b(1003, "access to this page is prohibited");
            } else {
                q0.X(new a(this, V, optString3, g2, uuid, W));
                return new d.a.n0.a.u.h.b(0);
            }
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void w(a.d dVar, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45213b;
            HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.n0.a.h0.t.a.n(dVar, new C0925b(this, dVar, str, bVar, gVar));
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
