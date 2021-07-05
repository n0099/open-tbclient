package d.a.q0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.c2.f.p0.g;
import d.a.q0.a.h0.t.a;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.g1.f f47143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47144c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47145d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l1.b f47148g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47149h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f47150i;
        public final /* synthetic */ d.a.q0.a.h0.g.g j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ h l;

        public a(h hVar, String str, d.a.q0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, String str2, d.a.q0.a.l1.b bVar, String str3, a.d dVar, d.a.q0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {hVar, str, fVar, unitedSchemeEntity, callbackHandler, eVar, str2, bVar, str3, dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f47142a = str;
            this.f47143b = fVar;
            this.f47144c = unitedSchemeEntity;
            this.f47145d = callbackHandler;
            this.f47146e = eVar;
            this.f47147f = str2;
            this.f47148g = bVar;
            this.f47149h = str3;
            this.f47150i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.q0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.q0.a.r1.i.d(this.f47142a);
                d.a.q0.a.e0.d.g("relaunch", "check pages success");
                this.f47143b.o();
                d.a.q0.a.c2.f.p0.a.l(this.f47144c, this.f47145d, this.f47146e, this.f47147f, this.f47148g.f49291e, null, this.f47149h);
                this.l.p(this.f47150i, this.f47148g, this.j, this.f47142a);
            }
        }

        @Override // d.a.q0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.q0.a.e0.d.b("relaunch", "check pages failed");
                this.f47143b.o();
                if (a0.f46883b) {
                    Context context = this.k;
                    d.a.q0.a.z1.b.f.e.g(context, this.k.getString(d.a.q0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.q0.a.c2.f.p0.a.j(this.f47144c, this.f47145d, this.f47149h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f47151a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.l1.b f47153c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.g f47154d;

        public b(h hVar, a.d dVar, String str, d.a.q0.a.l1.b bVar, d.a.q0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47151a = dVar;
            this.f47152b = str;
            this.f47153c = bVar;
            this.f47154d = gVar;
        }

        @Override // d.a.q0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f46883b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                d.a.q0.a.r1.i.e(this.f47151a, this.f47152b);
                d.a.q0.a.c2.f.p0.a.e(this.f47151a.f48514a, this.f47153c, this.f47152b);
                h.o(this.f47154d, this.f47153c, this.f47152b);
                if (a0.f46883b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void o(d.a.q0.a.h0.g.g gVar, d.a.q0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, bVar, str) == null) {
            d.a.q0.a.u.e.k.d.t(gVar, bVar, str);
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.q0.a.h0.g.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            d.a.q0.a.r1.i.b(uuid);
            String o = d.a.q0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.q0.a.e0.d.b("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
            d.a.q0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.q0.a.e0.d.b("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.q0.a.l1.b g2 = d.a.q0.a.l1.b.g(o, V.A());
            d.a.q0.a.j2.h.f(g2.f49291e, "3");
            if (!q0.b(V.s(), g2, true)) {
                d.a.q0.a.e0.d.b("relaunch", "page params error : path=" + g2.f49291e + " ; routePath=" + g2.f49294h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.q0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f49294h) && d.a.q0.a.a2.e.i() != null) {
                d.a.q0.a.a2.e.i().x0(n, g2.f49294h);
            }
            String n2 = d.a.q0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n2)) {
                gVar = W;
            } else {
                HybridUbcFlow q = d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                gVar = W;
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            a.d g3 = d.a.q0.a.h0.t.a.g(V.getActivity(), true);
            String b2 = g3.f48514a.b();
            if (a0.f46883b) {
                Log.d("ReLaunchAction", "webview idx: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.q0.a.c2.f.g0.d.b().a(g2)) {
                d.a.q0.a.c2.f.g0.d.b().i("reLaunch", g2);
                d.a.q0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.u();
                g.g(eVar, g2, b2, new a(this, uuid, V, unitedSchemeEntity, callbackHandler, eVar, b2, g2, optString, g3, gVar, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(a.d dVar, d.a.q0.a.l1.b bVar, d.a.q0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f48515b;
            HybridUbcFlow q = d.a.q0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f46883b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.q0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f46883b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
