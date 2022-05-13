package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class t13 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t13(r13 r13Var, String str) {
        super(r13Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var, str};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.r23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var) {
        InterceptResult invokeLLLLL;
        boolean n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, u03Var)) == null) {
            String l = l("insert");
            String l2 = l("update");
            String l3 = l("remove");
            if (TextUtils.equals(l, str)) {
                n = m(context, unitedSchemeEntity, callbackHandler, str, u03Var);
            } else if (TextUtils.equals(l2, str)) {
                n = p(context, unitedSchemeEntity, callbackHandler, str, u03Var);
            } else if (TextUtils.equals(l3, str)) {
                n = o(context, unitedSchemeEntity, callbackHandler, str, u03Var);
            } else {
                n = n(context, unitedSchemeEntity, callbackHandler, str, u03Var);
            }
            ux1.b("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + n);
            return n;
        }
        return invokeLLLLL.booleanValue;
    }

    @NonNull
    public abstract String j();

    public JSONObject k(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                ux1.c("AbsSwanAppWidget", "getParamsJSONObject entity is null");
                return null;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                ux1.c("AbsSwanAppWidget", "getParamsJSONObject paramsJson is empty");
                return null;
            }
            try {
                return new JSONObject(param);
            } catch (JSONException e) {
                ux1.c("AbsSwanAppWidget", "getParamsJSONObject exception = " + e.getMessage());
                if (r23.b) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return j() + "/" + str;
        }
        return (String) invokeL.objValue;
    }

    public abstract boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var);

    public boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, str, u03Var)) == null) ? super.i(context, unitedSchemeEntity, callbackHandler, str, u03Var) : invokeLLLLL.booleanValue;
    }

    public abstract boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var);

    public abstract boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u03 u03Var);
}
