package d.a.n0.a.c2.f.p0;

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
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.c2.f.p0.g;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.h0.t.a;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.g1.f f43867b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.g f43868c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.l1.b f43869d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43870e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43871f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43872g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43873h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ k f43874i;

        /* renamed from: d.a.n0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0656a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f43875a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f43876b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f43877c;

            public C0656a(a aVar, a.d dVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43877c = aVar;
                this.f43875a = dVar;
                this.f43876b = jSONObject;
            }

            @Override // d.a.n0.a.h0.t.a.e
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.n0.a.r1.i.e(this.f43875a, this.f43877c.f43866a);
                    d.a.n0.a.p.e.b bVar = this.f43875a.f45212a;
                    a aVar = this.f43877c;
                    d.a.n0.a.c2.f.p0.a.e(bVar, aVar.f43869d, aVar.f43866a);
                    d.a.n0.a.r1.i.c(5, this.f43877c.f43866a);
                    a aVar2 = this.f43877c;
                    aVar2.f43874i.l(aVar2.f43868c, aVar2.f43869d, aVar2.f43866a);
                    a aVar3 = this.f43877c;
                    UnitedSchemeUtility.callCallback(aVar3.f43870e, aVar3.f43871f, UnitedSchemeUtility.wrapCallbackParams(this.f43876b, 0));
                }
            }
        }

        public a(k kVar, String str, d.a.n0.a.g1.f fVar, d.a.n0.a.h0.g.g gVar, d.a.n0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, fVar, gVar, bVar, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43874i = kVar;
            this.f43866a = str;
            this.f43867b = fVar;
            this.f43868c = gVar;
            this.f43869d = bVar;
            this.f43870e = callbackHandler;
            this.f43871f = unitedSchemeEntity;
            this.f43872g = context;
            this.f43873h = str2;
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.r1.i.d(this.f43866a);
                this.f43867b.o();
                d.a.n0.a.h0.g.f l = this.f43868c.l();
                if (l != null && !TextUtils.isEmpty(l.j3(this.f43869d.f45992h))) {
                    JSONObject c2 = d.a.n0.a.c2.f.p0.a.c(l.j3(this.f43869d.f45992h));
                    d.a.n0.a.r1.i.c(4, this.f43866a);
                    this.f43874i.l(this.f43868c, this.f43869d, this.f43866a);
                    UnitedSchemeUtility.callCallback(this.f43870e, this.f43871f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                    return;
                }
                a.d f2 = d.a.n0.a.h0.t.a.f(this.f43867b.getActivity());
                JSONObject c3 = d.a.n0.a.c2.f.p0.a.c(f2.f45212a.b());
                HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f43866a);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f45213b ? "1" : "0");
                d.a.n0.a.h0.t.a.n(f2, new C0656a(this, f2, c3));
            }
        }

        @Override // d.a.n0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f43867b.o();
                if (a0.f43581b) {
                    Context context = this.f43872g;
                    d.a.n0.a.z1.b.f.e.g(context, this.f43872g.getString(d.a.n0.a.h.aiapps_open_pages_failed) + i2).F();
                }
                if (TextUtils.isEmpty(this.f43873h)) {
                    return;
                }
                d.a.n0.a.c2.f.p0.a.j(this.f43871f, this.f43870e, this.f43873h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/switchTab");
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

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f43581b) {
                Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            d.a.n0.a.r1.i.b(uuid);
            String o = d.a.n0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d.a.n0.a.e0.d.b("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            d.a.n0.a.g1.f V = d.a.n0.a.g1.f.V();
            d.a.n0.a.h0.g.g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(o, V.A());
            d.a.n0.a.j2.h.f(g2.f45989e, "4");
            if (!q0.c(V.s(), g2)) {
                d.a.n0.a.e0.d.b("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String n = d.a.n0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.C(ubcFlowEvent);
            }
            V.u();
            g.g(eVar, g2, "", new a(this, uuid, V, W, g2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            d.a.n0.a.e0.d.g("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(d.a.n0.a.h0.g.g gVar, d.a.n0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bVar, str) == null) {
            d.a.n0.a.h0.g.f.E3(q0.n());
            g.b i2 = gVar.i("switchTab");
            i2.n(0, 0);
            i2.i();
            i2.p(bVar).b();
            d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.n0.a.r1.i.a(str, bVar);
        }
    }
}
