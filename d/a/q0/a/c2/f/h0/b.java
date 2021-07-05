package d.a.q0.a.c2.f.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.d;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.n0.l.b;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46987g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46988h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f46989i;

        public a(b bVar, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46989i = bVar;
            this.f46985e = callbackHandler;
            this.f46986f = str;
            this.f46987g = unitedSchemeEntity;
            this.f46988h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f46989i.m(this.f46987g, this.f46985e, this.f46988h, this.f46986f);
                } else {
                    d.p(iVar, this.f46985e, this.f46986f);
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.c2.f.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0701b implements h.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0882b f46991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46993h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46994i;

        public C0701b(b bVar, String str, b.C0882b c0882b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0882b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46990e = str;
            this.f46991f = c0882b;
            this.f46992g = callbackHandler;
            this.f46993h = unitedSchemeEntity;
            this.f46994i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e i2;
            d.a.q0.a.v1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f46990e) && (i2 = e.i()) != null && (z = i2.z()) != null) {
                        z.O(8, new SwanAppDeleteInfo(this.f46990e).setPurgerScenes(d.a.q0.a.n0.l.c.m(this.f46991f).c()));
                    }
                    d.a.q0.a.e0.d.g("history", "remove success");
                    if (a0.f46883b) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.f46990e);
                    }
                    UnitedSchemeUtility.safeCallback(this.f46992g, this.f46993h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f46994i);
                    return;
                }
                d.a.q0.a.e0.d.l("history", "execute fail --- no match app id");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(this.f46992g, this.f46993h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f46994i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0882b f46995e;

        public c(b bVar, b.C0882b c0882b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0882b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46995e = c0882b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(d.a.q0.a.j0.c.b.f(AppRuntime.getAppContext().getContentResolver(), str, false, this.f46995e)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/deleteHistory");
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.a.q0.a.e0.d.b("history", "none swanApp");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.q0.a.e0.d.b("history", "empty joParams");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("history", "empty cb");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            if (TextUtils.isEmpty(optString2)) {
                d.a.q0.a.e0.d.b("history", "empty appId");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty appId");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
                return false;
            }
            eVar.T().g(context, "mapp_i_delete_history", new a(this, callbackHandler, optString, unitedSchemeEntity, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, str, str2) == null) {
            d.a.q0.a.e0.d.g("history", "start remove history");
            d.a.q0.a.n0.l.c l = d.a.q0.a.n0.l.c.l();
            l.n(4);
            b.C0882b k = l.k();
            h.d.i(str).D(Schedulers.io()).k(new c(this, k)).o(h.l.b.a.b()).B(new C0701b(this, str, k, callbackHandler, unitedSchemeEntity, str2));
        }
    }
}
