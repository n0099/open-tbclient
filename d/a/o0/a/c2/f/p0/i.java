package d.a.o0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
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
public class i extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44357a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.g1.f f44358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44359c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44360d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44363g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44364h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f44365i;
        public final /* synthetic */ d.a.o0.a.h0.g.g j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ i l;

        public a(i iVar, String str, d.a.o0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, String str2, d.a.o0.a.l1.b bVar, String str3, a.d dVar, d.a.o0.a.h0.g.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {iVar, str, fVar, unitedSchemeEntity, callbackHandler, eVar, str2, bVar, str3, dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = iVar;
            this.f44357a = str;
            this.f44358b = fVar;
            this.f44359c = unitedSchemeEntity;
            this.f44360d = callbackHandler;
            this.f44361e = eVar;
            this.f44362f = str2;
            this.f44363g = bVar;
            this.f44364h = str3;
            this.f44365i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.o0.a.r1.i.d(this.f44357a);
                d.a.o0.a.e0.d.g("redirect", "check pages success");
                this.f44358b.o();
                d.a.o0.a.c2.f.p0.a.l(this.f44359c, this.f44360d, this.f44361e, this.f44362f, this.f44363g.f46493e, null, this.f44364h);
                this.l.n(this.f44365i, this.f44363g, this.j, this.f44357a);
            }
        }

        @Override // d.a.o0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e0.d.b("redirect", "check pages failed");
                this.f44358b.o();
                if (a0.f44085b) {
                    Context context = this.k;
                    d.a.o0.a.z1.b.f.e.g(context, this.k.getString(d.a.o0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                d.a.o0.a.c2.f.p0.a.j(this.f44359c, this.f44360d, this.f44364h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f44366a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44367b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.l1.b f44368c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.g.g f44369d;

        public b(i iVar, a.d dVar, String str, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44366a = dVar;
            this.f44367b = str;
            this.f44368c = bVar;
            this.f44369d = gVar;
        }

        @Override // d.a.o0.a.h0.t.a.e
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a0.f44085b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                d.a.o0.a.r1.i.e(this.f44366a, this.f44367b);
                d.a.o0.a.c2.f.p0.a.e(this.f44366a.f45716a, this.f44368c, this.f44367b);
                d.a.o0.a.u.e.k.c.u(this.f44369d, this.f44368c, this.f44367b, false);
                if (a0.f44085b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/redirectTo");
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        d.a.o0.a.h0.g.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            d.a.o0.a.r1.i.b(uuid);
            String o = d.a.o0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.o0.a.e0.d.b("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.o0.a.g1.f V = d.a.o0.a.g1.f.V();
            d.a.o0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.o0.a.e0.d.b("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(o, V.A());
            d.a.o0.a.j2.h.f(g2.f46493e, "2");
            if (!q0.b(V.s(), g2, false)) {
                d.a.o0.a.e0.d.b("redirect", "page params error : path=" + g2.f46493e + " ; routePath=" + g2.f46496h);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && g2 != null && !TextUtils.isEmpty(g2.f46496h) && d.a.o0.a.a2.e.i() != null) {
                d.a.o0.a.a2.e.i().x0(str, g2.f46496h);
            }
            String n = d.a.o0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (TextUtils.isEmpty(n)) {
                gVar = W;
            } else {
                HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                gVar = W;
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            if (a0.f44085b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            a.d f2 = d.a.o0.a.h0.t.a.f(V.getActivity());
            String b2 = f2.f45716a.b();
            if (a0.f44085b) {
                Log.d("redirectTo", "webview id: " + b2);
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (d.a.o0.a.c2.f.g0.d.b().a(g2)) {
                d.a.o0.a.c2.f.g0.d.b().i("redirectTo", g2);
                d.a.o0.a.e0.d.b("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.u();
                g.g(eVar, g2, b2, new a(this, uuid, V, unitedSchemeEntity, callbackHandler, eVar, b2, g2, optString, f2, gVar, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(a.d dVar, d.a.o0.a.l1.b bVar, d.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar, gVar, str) == null) {
            boolean z = dVar != null && dVar.f45717b;
            HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", z ? "1" : "0");
            if (a0.f44085b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d.a.o0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
            if (a0.f44085b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
