package com.repackage;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class za3 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za3(e03 e03Var) {
        super(e03Var, "/swanAPI/updateTextarea");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (e13.b) {
                Log.d("UpdateTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hw1.i("UpdateTextAreaAction", "UpdateTextAreaAction updateParams: " + optParamsAsJo);
            String optString = optParamsAsJo.optString("slaveId");
            String optString2 = optParamsAsJo.optString("componentId");
            sv1 sv1Var = (sv1) uv1.b(optString, optString2);
            if (sv1Var == null) {
                String str = "can't find textarea component:#" + optString2;
                hw1.c("UpdateTextAreaAction", str);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
                return false;
            }
            tv1 tv1Var = (tv1) sv1Var.l();
            tv1Var.g(optParamsAsJo);
            yu1 update = sv1Var.update((sv1) tv1Var);
            if (!update.a()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            sv1Var.U0(optString2);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
