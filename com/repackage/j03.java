package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m43;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j03 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(j03 j03Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j03Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (!f43.h(k43Var)) {
                    f43.q(k43Var, this.a, this.b);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                nc2.b().e(this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j03(e03 e03Var) {
        super(e03Var, "/swanAPI/confirmSwanClose");
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
            if (hz2Var == null) {
                hw1.c("SwanConfirmClose", "framework runtime exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "framework runtime exception");
                return false;
            } else if (!(context instanceof Activity)) {
                hw1.c("SwanConfirmClose", "handle action, but context is not Activity");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    hw1.c("SwanConfirmClose", "empty params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hw1.c("SwanConfirmClose", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                hz2Var.d0().g(context, "mapp_confirm_close", new a(this, callbackHandler, optString, optParamsAsJo.optString("content")));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
