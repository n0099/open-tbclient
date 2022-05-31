package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hs1 extends es1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hs1(e03 e03Var) {
        super(e03Var, "/swanAPI/canvas/insert");
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
                super((e03) objArr2[0], (String) objArr2[1]);
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
            eu1 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                hw1.c("SwanAppCanvas", "insert action parse model is null");
                return false;
            } else if (context == null) {
                hw1.c("SwanAppCanvas", "context is null");
                unitedSchemeEntity.result = l(1001);
                return false;
            } else {
                String str = k.b;
                np2 np2Var = k.h;
                if (!TextUtils.isEmpty(str) && np2Var != null && np2Var.h()) {
                    yu1 insert = new hv1(context, k).insert();
                    boolean a = insert.a();
                    if (!a) {
                        hw1.c("SwanAppCanvas", "insert canvas fail: " + insert.b);
                    }
                    j(unitedSchemeEntity, callbackHandler, a);
                    return a;
                }
                hw1.c("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = l(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
