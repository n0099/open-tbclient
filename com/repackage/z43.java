package com.repackage;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z43 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public in1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z43(w13 w13Var) {
        super(w13Var, "/swanAPI/webviewPostMessage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w13Var};
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

    @Override // com.repackage.w23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, z03Var)) == null) {
            if (w23.b) {
                Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            zx1.i("webviewPostMsg", "start post webview msg");
            in1 in1Var = this.c;
            if (in1Var == null) {
                zx1.c("webviewPostMsg", "none webview widget");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
                return false;
            }
            x43 params = in1Var.getParams();
            if (params == null) {
                zx1.c("webviewPostMsg", "none WWWParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
                return false;
            }
            JSONObject a = w23.a(unitedSchemeEntity, "params");
            if (a == null) {
                zx1.c("webviewPostMsg", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            } else if (!a.has("data")) {
                zx1.c("webviewPostMsg", "none param data");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
                return false;
            } else {
                String optString = a.optString("data");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", optString);
                    jSONObject.put("eventType", "message");
                    jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, params.c);
                    jSONObject.put("webviewId", params.b);
                } catch (JSONException e) {
                    if (w23.b) {
                        e.printStackTrace();
                    }
                    zx1.c("webviewPostMsg", "meet json exception");
                }
                gg3.c(params.c, params.b, AlbumActivityConfig.FROM_WEB_VIEW, "message", jSONObject);
                zx1.i("webviewPostMsg", "post webview msg success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void j(in1 in1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, in1Var) == null) {
            this.c = in1Var;
        }
    }
}
