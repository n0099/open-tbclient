package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ev1 extends g03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev1(e03 e03Var) {
        super(e03Var, "/swanAPI/button");
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

    @Override // com.repackage.g03
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/button" : (String) invokeV.objValue;
    }

    @Override // com.repackage.g03
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-Button", "insert");
            }
            fv1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-Button", "model is null");
                return false;
            }
            yu1 insert = new dv1(context, q).insert();
            boolean a = insert.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g03
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-Button", "remove");
            }
            fv1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-Button", "model is null");
                return false;
            }
            dv1 dv1Var = (dv1) uv1.a(q);
            if (dv1Var == null) {
                String str2 = "can't find button component:#" + q.b;
                hw1.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yu1 B = dv1Var.B();
            boolean a = B.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g03
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-Button", "update");
            }
            fv1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-Button", "model is null");
                return false;
            }
            dv1 dv1Var = (dv1) uv1.a(q);
            if (dv1Var == null) {
                String str2 = "can't find button component:#" + q.b;
                hw1.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yu1 update = dv1Var.update((dv1) q);
            boolean a = update.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final fv1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-Button", "params is null");
                return null;
            }
            fv1 fv1Var = new fv1();
            try {
                fv1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                hw1.d("Component-Action-Button", "model parse exception:", e);
            }
            return fv1Var;
        }
        return (fv1) invokeL.objValue;
    }
}
