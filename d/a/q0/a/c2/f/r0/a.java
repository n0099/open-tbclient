package d.a.q0.a.c2.f.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.h0.g.g;
/* loaded from: classes8.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.c2.f.r0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0710a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f47189f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47190g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47191h;

        public C0710a(a aVar, CallbackHandler callbackHandler, d dVar, d.a.q0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47191h = aVar;
            this.f47188e = callbackHandler;
            this.f47189f = dVar;
            this.f47190g = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.q0.a.e2.c.d.h(iVar)) {
                    d.a.q0.a.e2.c.d.p(iVar, this.f47188e, this.f47189f.f46782i);
                    this.f47189f.o = null;
                } else {
                    d dVar = this.f47189f;
                    dVar.q = false;
                    this.f47191h.m(this.f47188e, (SwanAppSlaveManager) this.f47190g, dVar);
                }
                if (this.f47190g.y(this.f47189f)) {
                    this.f47191h.o();
                    return;
                }
                d.a.q0.a.e0.d.b("insertWebView", "insert webview widget fail");
                this.f47188e.handleSchemeDispatchCallback(this.f47189f.f46782i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/insertWebView");
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
                super((d.a.q0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            d j = d.j(unitedSchemeEntity);
            if (!j.isValid()) {
                d.a.q0.a.e0.d.b("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(j.n) && l(j.n, j.r)) {
                d.a.q0.a.e0.d.b("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                d.a.q0.a.p.e.b bVar = (d.a.q0.a.p.e.b) d.a.q0.a.g1.f.V().B(j.f46780g);
                if (bVar == null) {
                    d.a.q0.a.e0.d.b("insertWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(j.p, "quickPass")) {
                    eVar.T().g(context, "scope_webview_extra_operation", new C0710a(this, callbackHandler, j, bVar));
                } else if (!bVar.y(j)) {
                    d.a.q0.a.e0.d.b("insertWebView", "insert webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    o();
                }
                d.a.q0.a.e0.d.g("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o() {
        g W;
        d.a.q0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (W = d.a.q0.a.g1.f.V().W()) == null || (o = W.o()) == null) {
            return;
        }
        d.a.q0.a.e0.d.g("insertWebView", "disable navigationStyle custom");
        o.X2();
    }
}
