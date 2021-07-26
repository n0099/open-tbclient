package d.a.o0.a.c2.f.h0;

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
import d.a.o0.a.a2.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.d;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.n0.l.b;
import h.n.f;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44190h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f44191i;

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
            this.f44191i = bVar;
            this.f44187e = callbackHandler;
            this.f44188f = str;
            this.f44189g = unitedSchemeEntity;
            this.f44190h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f44191i.m(this.f44189g, this.f44187e, this.f44190h, this.f44188f);
                } else {
                    d.p(iVar, this.f44187e, this.f44188f);
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.c2.f.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0659b implements h.n.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0840b f44193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44194g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44195h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44196i;

        public C0659b(b bVar, String str, b.C0840b c0840b, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, c0840b, callbackHandler, unitedSchemeEntity, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44192e = str;
            this.f44193f = c0840b;
            this.f44194g = callbackHandler;
            this.f44195h = unitedSchemeEntity;
            this.f44196i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Boolean bool) {
            e i2;
            d.a.o0.a.v1.c.e.a z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    if (!TextUtils.isEmpty(this.f44192e) && (i2 = e.i()) != null && (z = i2.z()) != null) {
                        z.O(8, new SwanAppDeleteInfo(this.f44192e).setPurgerScenes(d.a.o0.a.n0.l.c.m(this.f44193f).c()));
                    }
                    d.a.o0.a.e0.d.g("history", "remove success");
                    if (a0.f44085b) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + this.f44192e);
                    }
                    UnitedSchemeUtility.safeCallback(this.f44194g, this.f44195h, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f44196i);
                    return;
                }
                d.a.o0.a.e0.d.l("history", "execute fail --- no match app id");
                if (a0.f44085b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(this.f44194g, this.f44195h, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), this.f44196i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.C0840b f44197e;

        public c(b bVar, b.C0840b c0840b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0840b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44197e = c0840b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Boolean.valueOf(d.a.o0.a.j0.c.b.f(AppRuntime.getAppContext().getContentResolver(), str, false, this.f44197e)) : (Boolean) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.a.c2.e eVar) {
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.a.o0.a.e0.d.b("history", "none swanApp");
                if (a0.f44085b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.o0.a.e0.d.b("history", "empty joParams");
                if (a0.f44085b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("history", "empty cb");
                if (a0.f44085b) {
                    Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("appid");
            if (TextUtils.isEmpty(optString2)) {
                d.a.o0.a.e0.d.b("history", "empty appId");
                if (a0.f44085b) {
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
            d.a.o0.a.e0.d.g("history", "start remove history");
            d.a.o0.a.n0.l.c l = d.a.o0.a.n0.l.c.l();
            l.n(4);
            b.C0840b k = l.k();
            h.d.i(str).D(Schedulers.io()).k(new c(this, k)).o(h.l.b.a.b()).B(new C0659b(this, str, k, callbackHandler, unitedSchemeEntity, str2));
        }
    }
}
