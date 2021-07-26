package d.a.o0.a.e2.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.u.e.l.b;
import d.a.o0.a.v2.w;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44743f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44744g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44745h;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, d.a.o0.a.a2.e eVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, str, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44742e = callbackHandler;
            this.f44743f = unitedSchemeEntity;
            this.f44744g = str;
            this.f44745h = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar.c() && (jSONObject = iVar.f44872a) != null) {
                    UnitedSchemeUtility.safeCallback(this.f44742e, this.f44743f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44744g);
                    d.a.o0.a.a2.e eVar = this.f44745h;
                    if (eVar != null) {
                        this.f44745h.T().B(b.h.a(eVar), iVar.f44872a.toString());
                    }
                    d.a.o0.a.e0.d.g("getSwanId", "getSwanId success");
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f44742e, this.f44743f, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), this.f44744g);
                d.a.o0.a.e0.d.b("getSwanId", "getSwanId failed: internal_error");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getSwanId");
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.a.o0.a.e0.d.b("getSwanId", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.o0.a.e0.d.b("getSwanId", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("getSwanId", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            if (d.a.o0.a.r1.l.b.j()) {
                String q = eVar.T().q(b.h.a(eVar), null);
                if (TextUtils.isEmpty(q)) {
                    j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                } else {
                    JSONObject d2 = w.d(q);
                    JSONObject optJSONObject = d2.optJSONObject("data");
                    if (optJSONObject != null) {
                        String optString2 = optJSONObject.optString("swanid");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(StringUtil.NULL_STRING, optString2)) {
                            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d2, 0).toString(), optString);
                            d.a.o0.a.e0.d.g("getSwanId", "getSwanId success");
                        } else {
                            j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                        }
                    } else {
                        j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                    }
                }
            } else {
                j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, str) == null) {
            d.a.o0.a.e0.d.g("getSwanId", "getSwanId start");
            if (!SwanAppNetworkUtils.i(context)) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
                d.a.o0.a.e0.d.b("getSwanId", "network_error");
                return;
            }
            d.a.o0.a.e2.c.j.e e2 = d.a.o0.a.a2.d.g().y().a().b().e(context);
            e2.p(new a(this, callbackHandler, unitedSchemeEntity, str, eVar));
            e2.a();
        }
    }
}
