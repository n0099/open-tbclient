package com.repackage;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ob3 extends kb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob3(e13 e13Var) {
        super(e13Var, "/swanAPI/openTabBar");
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
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                hx1.c("openTabBar", "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (kb3.k()) {
                hx1.c("OpenTabBarAction", "fail not TabBar page");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
                return false;
            } else {
                tb3 j = kb3.j();
                if (j == null) {
                    hx1.c("OpenTabBarAction", "tabBarViewController is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!j.r(optParamsAsJo.optBoolean("animation"))) {
                    hx1.c("openTabBar", "open bottom bar fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
