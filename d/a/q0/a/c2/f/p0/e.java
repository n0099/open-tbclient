package d.a.q0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.c2.f.p0.g;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.h0.t.a;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f47096d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f47097c;

    /* loaded from: classes8.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47099b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.g1.f f47100c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.g f47101d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47104g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l1.b f47105h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f47106i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ e l;

        public a(e eVar, String str, d.a.q0.a.a2.e eVar2, d.a.q0.a.g1.f fVar, d.a.q0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.q0.a.l1.b bVar, String str3, a.d dVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {eVar, str, eVar2, fVar, gVar, unitedSchemeEntity, callbackHandler, str2, bVar, str3, dVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f47098a = str;
            this.f47099b = eVar2;
            this.f47100c = fVar;
            this.f47101d = gVar;
            this.f47102e = unitedSchemeEntity;
            this.f47103f = callbackHandler;
            this.f47104g = str2;
            this.f47105h = bVar;
            this.f47106i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.q0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.q0.a.r1.i.d(this.f47098a);
                d.a.q0.a.e0.d.g("navigateTo", "check pages success");
                d.a.q0.a.j2.k.B(true, this.f47099b.N().T());
                this.f47100c.o();
                d.a.q0.a.c2.f.p0.a.l(this.f47102e, this.f47103f, this.f47099b, this.f47104g, this.f47105h.f49291e, d.a.q0.a.c2.f.p0.a.g(this.f47101d), this.f47106i);
                this.l.p(this.j, this.f47105h, this.f47101d, this.f47098a);
            }
        }

        @Override // d.a.q0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.q0.a.e0.d.b("navigateTo", "check pages failed");
                d.a.q0.a.j2.k.B(false, this.f47099b.N().T());
                this.f47100c.o();
                if (a0.f46883b) {
                    Context context = this.k;
                    d.a.q0.a.z1.b.f.e.g(context, this.k.getString(d.a.q0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.q0.a.c2.f.p0.a.j(this.f47102e, this.f47103f, this.f47106i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f47107a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47108b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l1.b f47109c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.g f47110d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f47111e;

        public b(e eVar, a.d dVar, String str, d.a.q0.a.l1.b bVar, d.a.q0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47111e = eVar;
            this.f47107a = dVar;
            this.f47108b = str;
            this.f47109c = bVar;
            this.f47110d = gVar;
        }

        @Override // d.a.q0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f46883b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                d.a.q0.a.r1.i.e(this.f47107a, this.f47108b);
                this.f47111e.o(this.f47107a.f48514a, this.f47109c, this.f47110d, this.f47108b);
                if (a0.f46883b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(597521557, "Ld/a/q0/a/c2/f/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(597521557, "Ld/a/q0/a/c2/f/p0/e;");
                return;
            }
        }
        f47096d = d.a.q0.a.c1.a.Z().s();
        if (a0.f46883b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f47096d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.q0.a.g1.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.f47097c = context;
            String uuid = UUID.randomUUID().toString();
            d.a.q0.a.r1.i.b(uuid);
            String o = d.a.q0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.q0.a.e0.d.b("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
            d.a.q0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.q0.a.e0.d.b("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.q0.a.l1.b g2 = d.a.q0.a.l1.b.g(o, V.A());
            d.a.q0.a.j2.h.f(g2.f49291e, "0");
            if (!q0.b(V.s(), g2, false)) {
                d.a.q0.a.e0.d.b("navigateTo", "page params error : path=" + g2.f49291e + " ; routePath=" + g2.f49294h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.q0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f49294h) && d.a.q0.a.a2.e.i() != null) {
                d.a.q0.a.a2.e.i().x0(n, g2.f49294h);
            }
            String n2 = d.a.q0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n2)) {
                fVar = V;
            } else {
                HybridUbcFlow q = d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                fVar = V;
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            if (a0.f46883b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            a.d f2 = d.a.q0.a.h0.t.a.f(fVar.getActivity());
            String b2 = f2.f48514a.b();
            if (a0.f46883b) {
                Log.d("NavigateToAction", "slave webView id: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.q0.a.c2.f.g0.d.b().a(g2)) {
                d.a.q0.a.c2.f.g0.d.b().i("navigateTo", g2);
                d.a.q0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                fVar.u();
                g.g(eVar, g2, b2, new a(this, uuid, eVar, fVar, W, unitedSchemeEntity, callbackHandler, b2, g2, optString, f2, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(d.a.q0.a.p.e.b bVar, d.a.q0.a.l1.b bVar2, d.a.q0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = d.a.q0.a.g1.f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d.a.q0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.q0.a.r1.i.c(0, str);
        if (gVar.k() < f47096d) {
            d.a.q0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.q0.a.h0.g.g.f48010g, d.a.q0.a.h0.g.g.f48012i);
            i2.k("normal", bVar2).b();
            d.a.q0.a.v2.g.c(gVar, this.f47097c);
            d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.q0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.q0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.q0.a.l1.b bVar, d.a.q0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f48515b;
            HybridUbcFlow q = d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f46883b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.q0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f46883b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
