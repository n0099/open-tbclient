package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sm5 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ sm5 d;

        public a(sm5 sm5Var, String str, CallbackHandler callbackHandler, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm5Var, str, callbackHandler, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sm5Var;
            this.a = str;
            this.b = callbackHandler;
            this.c = u03Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.d.n(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm5(r13 r13Var) {
        super(r13Var, "/swanAPI/navigateToProgram");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (u03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                String f0 = u03.f0();
                if (!TextUtils.isEmpty(f0) && !TextUtils.isEmpty(f0.trim())) {
                    String optString = optParamsAsJo.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    String optString2 = optParamsAsJo.optString("path");
                    if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                        zm5.j(context, unitedSchemeEntity.getParam("params"));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    Request l = l(f0, optParamsAsJo);
                    if (l == null) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    m(l.body(), unitedSchemeEntity, optString, callbackHandler, u03Var);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final Uri k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
            }
            buildUpon.scheme(schemeHead);
            if (r23.b) {
                Log.i("NavigateToSmartProgram", buildUpon.build().toString());
            }
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final Request l(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                String b = uq2.b(oe3.n());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                    jSONObject2.put("srcAppPage", b);
                    jSONObject2.put("params", jSONObject);
                    Request build = new Request.Builder().url(bk2.o().I()).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                    if (r23.b) {
                        Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                    }
                    return build;
                } catch (Exception e) {
                    if (r23.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Request) invokeLL.objValue;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, requestBody, unitedSchemeEntity, str, callbackHandler, u03Var) == null) {
            v74 v74Var = new v74(bk2.o().I(), requestBody, new a(this, str, callbackHandler, u03Var));
            v74Var.f = true;
            v74Var.g = false;
            v74Var.h = true;
            w74.g().e(v74Var);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, callbackHandler, u03Var) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                Uri k = k(optJSONObject.optString("scheme"));
                if (k == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(u03Var.getApplicationContext(), k, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                }
            } catch (Exception e) {
                if (r23.b) {
                    Log.d("NavigateToSmartProgram", e.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
            }
        }
    }
}
