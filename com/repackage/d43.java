package com.repackage;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d43 extends g43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d43(e13 e13Var) {
        super(e13Var, "/swanAPI/removeWebView");
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
            if (e23.b) {
                Log.d("RemoveWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            f43 h = f43.h(unitedSchemeEntity);
            if (!h.isValid()) {
                hx1.c("removeWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return true;
            }
            nm1 nm1Var = (nm1) ul2.U().A(h.c);
            if (nm1Var == null) {
                hx1.c("removeWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return true;
            } else if (!nm1Var.a0(h)) {
                hx1.c("removeWebView", "remove webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return true;
            } else {
                hx1.i("removeWebView", "remove webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
