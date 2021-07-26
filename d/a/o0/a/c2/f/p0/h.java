package d.a.o0.a.c2.f.p0;

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
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.c2.f.p0.g;
import d.a.o0.a.h0.t.a;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44344a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.g1.f f44345b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44346c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44347d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44348e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44349f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44350g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44351h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f44352i;
        public final /* synthetic */ d.a.o0.a.h0.g.g j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ h l;

        public a(h hVar, String str, d.a.o0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, String str2, d.a.o0.a.l1.b bVar, String str3, a.d dVar, d.a.o0.a.h0.g.g gVar, Context context) {
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
            this.f44344a = str;
            this.f44345b = fVar;
            this.f44346c = unitedSchemeEntity;
            this.f44347d = callbackHandler;
            this.f44348e = eVar;
            this.f44349f = str2;
            this.f44350g = bVar;
            this.f44351h = str3;
            this.f44352i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.r1.i.d(this.f44344a);
                d.a.o0.a.e0.d.g("relaunch", "check pages success");
                this.f44345b.o();
                d.a.o0.a.c2.f.p0.a.l(this.f44346c, this.f44347d, this.f44348e, this.f44349f, this.f44350g.f46493e, null, this.f44351h);
                this.l.p(this.f44352i, this.f44350g, this.j, this.f44344a);
            }
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e0.d.b("relaunch", "check pages failed");
                this.f44345b.o();
                if (a0.f44085b) {
                    Context context = this.k;
                    d.a.o0.a.z1.b.f.e.g(context, this.k.getString(d.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.o0.a.c2.f.p0.a.j(this.f44346c, this.f44347d, this.f44351h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f44353a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44354b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44355c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f44356d;

        public b(h hVar, a.d dVar, String str, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar) {
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
            this.f44353a = dVar;
            this.f44354b = str;
            this.f44355c = bVar;
            this.f44356d = gVar;
        }

        @Override // d.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f44085b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                d.a.o0.a.r1.i.e(this.f44353a, this.f44354b);
                d.a.o0.a.c2.f.p0.a.e(this.f44353a.f45716a, this.f44355c, this.f44354b);
                h.o(this.f44356d, this.f44355c, this.f44354b);
                if (a0.f44085b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.o0.a.c2.e eVar) {
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

    public static void o(d.a.o0.a.h0.g.g gVar, d.a.o0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, bVar, str) == null) {
            d.a.o0.a.u.e.k.d.t(gVar, bVar, str);
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.o0.a.h0.g.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            d.a.o0.a.r1.i.b(uuid);
            String o = d.a.o0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.o0.a.e0.d.b("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.o0.a.g1.f V = d.a.o0.a.g1.f.V();
            d.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.o0.a.e0.d.b("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(o, V.A());
            d.a.o0.a.j2.h.f(g2.f46493e, "3");
            if (!q0.b(V.s(), g2, true)) {
                d.a.o0.a.e0.d.b("relaunch", "page params error : path=" + g2.f46493e + " ; routePath=" + g2.f46496h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && g2 != null && !TextUtils.isEmpty(g2.f46496h) && d.a.o0.a.a2.e.i() != null) {
                d.a.o0.a.a2.e.i().x0(n, g2.f46496h);
            }
            String n2 = d.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n2)) {
                gVar = W;
            } else {
                HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                gVar = W;
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.C(ubcFlowEvent);
            }
            a.d g3 = d.a.o0.a.h0.t.a.g(V.getActivity(), true);
            String b2 = g3.f45716a.b();
            if (a0.f44085b) {
                Log.d("ReLaunchAction", "webview idx: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.o0.a.c2.f.g0.d.b().a(g2)) {
                d.a.o0.a.c2.f.g0.d.b().i("reLaunch", g2);
                d.a.o0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
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

    public final void p(a.d dVar, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45717b;
            HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f44085b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f44085b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
