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
/* loaded from: classes7.dex */
public class zt1 extends rt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zt1(r13 r13Var) {
        super(r13Var, "/swanAPI/canvas/update");
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
                super((r13) objArr2[0], (String) objArr2[1]);
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
            rv1 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                ux1.c("SwanAppCanvas", "update action parse model is null");
                return false;
            }
            String str = k.b;
            ar2 ar2Var = k.h;
            if (!TextUtils.isEmpty(str) && ar2Var != null && ar2Var.h()) {
                uw1 uw1Var = (uw1) hx1.a(k);
                if (uw1Var == null) {
                    ux1.c("SwanAppCanvas", "update canvas fail: fina a null component");
                    unitedSchemeEntity.result = l(1001);
                    return false;
                }
                lw1 update = uw1Var.update((uw1) k);
                boolean a = update.a();
                if (!a) {
                    ux1.c("SwanAppCanvas", "update canvas fail: " + update.b);
                }
                j(unitedSchemeEntity, callbackHandler, a);
                return a;
            }
            ux1.c("SwanAppCanvas", "some params invalid");
            unitedSchemeEntity.result = l(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
