package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa3;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba3 extends ca3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba3(e13 e13Var) {
        super(e13Var, "/swanAPI/getBatteryInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (j(context, h03Var, unitedSchemeEntity)) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (e23.b) {
                        Log.d("SwanAppAction", "getBatteryInfo --- params is empty");
                    }
                    hx1.c("battery", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (e23.b) {
                        Log.d("SwanAppAction", "getBatteryInfo --- cb is empty");
                    }
                    hx1.c("battery", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                aa3.a a = aa3.a(context);
                if (a == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                    return false;
                }
                if (e23.b) {
                    Log.d("battery", "/swanAPI/getBatteryInfo = level: " + a.a + " ; plugged: " + a.b);
                }
                JSONObject k = k(a);
                if (k == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                    if (e23.b) {
                        Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                    }
                    return false;
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(k, 0).toString(), optString);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
