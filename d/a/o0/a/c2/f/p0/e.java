package d.a.o0.a.c2.f.p0;

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
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.c2.f.p0.g;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.h0.t.a;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f44298d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f44299c;

    /* loaded from: classes7.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44300a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44301b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.g1.f f44302c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f44303d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44306g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44307h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44308i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ e l;

        public a(e eVar, String str, d.a.o0.a.a2.e eVar2, d.a.o0.a.g1.f fVar, d.a.o0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.o0.a.l1.b bVar, String str3, a.d dVar, Context context) {
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
            this.f44300a = str;
            this.f44301b = eVar2;
            this.f44302c = fVar;
            this.f44303d = gVar;
            this.f44304e = unitedSchemeEntity;
            this.f44305f = callbackHandler;
            this.f44306g = str2;
            this.f44307h = bVar;
            this.f44308i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.r1.i.d(this.f44300a);
                d.a.o0.a.e0.d.g("navigateTo", "check pages success");
                d.a.o0.a.j2.k.B(true, this.f44301b.N().T());
                this.f44302c.o();
                d.a.o0.a.c2.f.p0.a.l(this.f44304e, this.f44305f, this.f44301b, this.f44306g, this.f44307h.f46493e, d.a.o0.a.c2.f.p0.a.g(this.f44303d), this.f44308i);
                this.l.p(this.j, this.f44307h, this.f44303d, this.f44300a);
            }
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e0.d.b("navigateTo", "check pages failed");
                d.a.o0.a.j2.k.B(false, this.f44301b.N().T());
                this.f44302c.o();
                if (a0.f44085b) {
                    Context context = this.k;
                    d.a.o0.a.z1.b.f.e.g(context, this.k.getString(d.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.o0.a.c2.f.p0.a.j(this.f44304e, this.f44305f, this.f44308i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f44309a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f44312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f44313e;

        public b(e eVar, a.d dVar, String str, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar) {
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
            this.f44313e = eVar;
            this.f44309a = dVar;
            this.f44310b = str;
            this.f44311c = bVar;
            this.f44312d = gVar;
        }

        @Override // d.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f44085b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                d.a.o0.a.r1.i.e(this.f44309a, this.f44310b);
                this.f44313e.o(this.f44309a.f45716a, this.f44311c, this.f44312d, this.f44310b);
                if (a0.f44085b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1877385235, "Ld/a/o0/a/c2/f/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1877385235, "Ld/a/o0/a/c2/f/p0/e;");
                return;
            }
        }
        f44298d = d.a.o0.a.c1.a.Z().s();
        if (a0.f44085b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f44298d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.o0.a.c2.e eVar) {
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.o0.a.g1.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.f44299c = context;
            String uuid = UUID.randomUUID().toString();
            d.a.o0.a.r1.i.b(uuid);
            String o = d.a.o0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.o0.a.e0.d.b("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.o0.a.g1.f V = d.a.o0.a.g1.f.V();
            d.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.o0.a.e0.d.b("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(o, V.A());
            d.a.o0.a.j2.h.f(g2.f46493e, "0");
            if (!q0.b(V.s(), g2, false)) {
                d.a.o0.a.e0.d.b("navigateTo", "page params error : path=" + g2.f46493e + " ; routePath=" + g2.f46496h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f46496h) && d.a.o0.a.a2.e.i() != null) {
                d.a.o0.a.a2.e.i().x0(n, g2.f46496h);
            }
            String n2 = d.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n2)) {
                fVar = V;
            } else {
                HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                fVar = V;
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            if (a0.f44085b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            a.d f2 = d.a.o0.a.h0.t.a.f(fVar.getActivity());
            String b2 = f2.f45716a.b();
            if (a0.f44085b) {
                Log.d("NavigateToAction", "slave webView id: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.o0.a.c2.f.g0.d.b().a(g2)) {
                d.a.o0.a.c2.f.g0.d.b().i("navigateTo", g2);
                d.a.o0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
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

    public final void o(d.a.o0.a.p.e.b bVar, d.a.o0.a.l1.b bVar2, d.a.o0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2, gVar, str) == null) || (activity = d.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d.a.o0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.o0.a.r1.i.c(0, str);
        if (gVar.k() < f44298d) {
            d.a.o0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.o0.a.h0.g.g.f45212g, d.a.o0.a.h0.g.g.f45214i);
            i2.k("normal", bVar2).b();
            d.a.o0.a.v2.g.c(gVar, this.f44299c);
            d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.o0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.o0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45717b;
            HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f44085b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f44085b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
