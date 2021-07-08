package d.a.n0.a.c2.f.p0;

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
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.c2.f.p0.g;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.h0.t.a;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f43794d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f43795c;

    /* loaded from: classes7.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43796a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f43797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.g1.f f43798c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f43799d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43801f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43802g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f43803h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43804i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ e l;

        public a(e eVar, String str, d.a.n0.a.a2.e eVar2, d.a.n0.a.g1.f fVar, d.a.n0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.n0.a.l1.b bVar, String str3, a.d dVar, Context context) {
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
            this.f43796a = str;
            this.f43797b = eVar2;
            this.f43798c = fVar;
            this.f43799d = gVar;
            this.f43800e = unitedSchemeEntity;
            this.f43801f = callbackHandler;
            this.f43802g = str2;
            this.f43803h = bVar;
            this.f43804i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.r1.i.d(this.f43796a);
                d.a.n0.a.e0.d.g("navigateTo", "check pages success");
                d.a.n0.a.j2.k.B(true, this.f43797b.N().T());
                this.f43798c.o();
                d.a.n0.a.c2.f.p0.a.l(this.f43800e, this.f43801f, this.f43797b, this.f43802g, this.f43803h.f45989e, d.a.n0.a.c2.f.p0.a.g(this.f43799d), this.f43804i);
                this.l.p(this.j, this.f43803h, this.f43799d, this.f43796a);
            }
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.n0.a.e0.d.b("navigateTo", "check pages failed");
                d.a.n0.a.j2.k.B(false, this.f43797b.N().T());
                this.f43798c.o();
                if (a0.f43581b) {
                    Context context = this.k;
                    d.a.n0.a.z1.b.f.e.g(context, this.k.getString(d.a.n0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.n0.a.c2.f.p0.a.j(this.f43800e, this.f43801f, this.f43804i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f43805a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43806b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f43807c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f43808d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f43809e;

        public b(e eVar, a.d dVar, String str, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar) {
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
            this.f43809e = eVar;
            this.f43805a = dVar;
            this.f43806b = str;
            this.f43807c = bVar;
            this.f43808d = gVar;
        }

        @Override // d.a.n0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f43581b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                d.a.n0.a.r1.i.e(this.f43805a, this.f43806b);
                this.f43809e.o(this.f43805a.f45212a, this.f43807c, this.f43808d, this.f43806b);
                if (a0.f43581b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369833426, "Ld/a/n0/a/c2/f/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(369833426, "Ld/a/n0/a/c2/f/p0/e;");
                return;
            }
        }
        f43794d = d.a.n0.a.c1.a.Z().s();
        if (a0.f43581b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f43794d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.n0.a.c2.e eVar) {
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

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.n0.a.g1.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f43581b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.f43795c = context;
            String uuid = UUID.randomUUID().toString();
            d.a.n0.a.r1.i.b(uuid);
            String o = d.a.n0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.n0.a.e0.d.b("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.n0.a.g1.f V = d.a.n0.a.g1.f.V();
            d.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(o, V.A());
            d.a.n0.a.j2.h.f(g2.f45989e, "0");
            if (!q0.b(V.s(), g2, false)) {
                d.a.n0.a.e0.d.b("navigateTo", "page params error : path=" + g2.f45989e + " ; routePath=" + g2.f45992h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.n0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f45992h) && d.a.n0.a.a2.e.i() != null) {
                d.a.n0.a.a2.e.i().x0(n, g2.f45992h);
            }
            String n2 = d.a.n0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n2)) {
                fVar = V;
            } else {
                HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                fVar = V;
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            if (a0.f43581b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            a.d f2 = d.a.n0.a.h0.t.a.f(fVar.getActivity());
            String b2 = f2.f45212a.b();
            if (a0.f43581b) {
                Log.d("NavigateToAction", "slave webView id: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.n0.a.e0.d.b("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.n0.a.c2.f.g0.d.b().a(g2)) {
                d.a.n0.a.c2.f.g0.d.b().i("navigateTo", g2);
                d.a.n0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
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

    public final void o(d.a.n0.a.p.e.b bVar, d.a.n0.a.l1.b bVar2, d.a.n0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d.a.n0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.n0.a.r1.i.c(0, str);
        if (gVar.k() < f43794d) {
            d.a.n0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.n0.a.h0.g.g.f44708g, d.a.n0.a.h0.g.g.f44710i);
            i2.k("normal", bVar2).b();
            d.a.n0.a.v2.g.c(gVar, this.f43795c);
            d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.n0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.n0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.n0.a.l1.b bVar, d.a.n0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45213b;
            HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f43581b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.n0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f43581b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
