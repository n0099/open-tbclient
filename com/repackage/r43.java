package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r43 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ r43 d;

        public a(r43 r43Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r43Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r43Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                this.d.k(this.a, this.b, this.c, k53Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400352, "Lcom/repackage/r43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400352, "Lcom/repackage/r43;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r43(e13 e13Var) {
        super(e13Var, "/swanAPI/authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (h03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
                return false;
            }
            String c = h53.c(optParamsAsJo.optString("scope"));
            if (TextUtils.isEmpty(c)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
                return false;
            }
            h03Var.e0().c(context, c, false, new a(this, callbackHandler, c, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, k53<m53.e> k53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str, str2, k53Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scope", h53.d(str));
                if (k53Var != null && k53Var.a != null) {
                    if (!k53Var.c()) {
                        OAuthException a2 = k53Var.a();
                        jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, a2 == null ? "" : a2.getMessage());
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(k53Var.b()).toString());
                        pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k53Var.b()).toString());
                        return;
                    }
                    jSONObject.put("code", k53Var.a.a);
                    jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, k53Var.a.b ? "authorize:ok" : "user deny");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k53Var.a.b ? 0 : 10003).toString());
                    if (k53Var.a.b) {
                        return;
                    }
                    pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k53Var.b()).toString());
                    return;
                }
                int b = k53Var.b();
                f53.k("empty auth result", Boolean.TRUE);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, f53.f(b));
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
                f53.t("AuthorizeAction", "null == result || null == result.mData");
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
            } catch (JSONException unused) {
                f53.k("json exception", Boolean.TRUE);
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
                pj2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
            }
        }
    }
}
