package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a53 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a53(g13 g13Var) {
        super(g13Var, "/swanAPI/login");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
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

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (j03Var != null && j03Var.m0()) {
                if (g23.b) {
                    Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (j03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                rj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    rj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                    ro1.J(j03Var, 1, 201, "params is null");
                    return false;
                }
                String optString = optParamsAsJo.optString("invokeFrom");
                String str = optString.equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
                c73.T(str, "create");
                String optString2 = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    rj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    ro1.J(j03Var, 1, 201, "empty cb");
                    return false;
                } else if (!optParamsAsJo.optBoolean(TTDownloadField.TT_FORCE, true) && !j03Var.M().e(context)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    rj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    ro1.J(j03Var, 43, 10004, "user not logged in");
                    return true;
                } else {
                    if (!j03Var.M().e(context)) {
                        c73.S("show", 1, optString);
                    }
                    if (!i03.J().r().M().e(context)) {
                        c73.T(str, "passLogin");
                    }
                    ro1.D(j03Var, (Activity) context, optParamsAsJo, callbackHandler, optString2, true, str);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
