package d.a.o0.a.c2.f.f0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h;
import d.a.o0.a.k;
import d.a.o0.a.p.d.f0;
import d.a.o0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.c2.f.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0656a implements d.a.o0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44124e;

        public C0656a(a aVar, d.a.o0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44124e = aVar;
            this.f44120a = eVar;
            this.f44121b = callbackHandler;
            this.f44122c = unitedSchemeEntity;
            this.f44123d = str;
        }

        @Override // d.a.o0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f44124e.f44126d) {
                    d.a.o0.a.z1.b.f.e f2 = d.a.o0.a.z1.b.f.e.f(this.f44120a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                    f2.l(2);
                    f2.F();
                }
                this.f44124e.n(this.f44122c, this.f44121b, this.f44123d);
            }
        }

        @Override // d.a.o0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f44124e.f44126d) {
                    d.a.o0.a.z1.b.f.e f2 = d.a.o0.a.z1.b.f.e.f(this.f44120a.getApplicationContext(), h.aiapps_fav_fail);
                    f2.l(2);
                    f2.F();
                }
                this.f44124e.n(this.f44122c, this.f44121b, this.f44123d);
            }
        }

        @Override // d.a.o0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e2) {
                    if (k.f46335a) {
                        e2.printStackTrace();
                    }
                }
                if (this.f44124e.f44126d) {
                    b.m("1", "btn", "success");
                    d.a.o0.a.j0.b.a.t();
                    if (d.a.o0.a.j1.a.k(this.f44120a.x())) {
                        d.a.o0.a.j1.a.p("addmyswan", q0.n().h());
                    } else {
                        Context applicationContext = this.f44120a.getApplicationContext();
                        d.a.o0.a.z1.b.f.e g2 = d.a.o0.a.z1.b.f.e.g(applicationContext, d.a.o0.a.c1.a.e0().f(applicationContext));
                        g2.l(2);
                        g2.p(2);
                        g2.F();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.f44121b, this.f44122c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44123d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/addFavor");
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
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.c2.f.f0.b
    public boolean j(d.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String D = this.f44126d ? eVar.D() : new JSONObject(param).optString("appid");
                this.f44125c = D;
                return !TextUtils.isEmpty(D);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.o0.a.c2.f.f0.b
    public void k(d.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo s = d.a.o0.n.g.a.h().s(this.f44125c);
            if (s != null && !TextUtils.isEmpty(s.appId)) {
                if (this.f44126d) {
                    b.m("1", "btn", "invoke");
                } else {
                    b.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.f44125c, new C0656a(this, eVar, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // d.a.o0.a.c2.f.f0.b
    public void l(d.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) && this.f44126d && (e0 = d.a.o0.a.c1.a.e0()) != null) {
            e0.g(eVar);
        }
    }
}
