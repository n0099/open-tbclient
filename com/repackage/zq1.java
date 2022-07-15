package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final boolean c;

    public zq1(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, unitedSchemeEntity, callbackHandler) == null) && this.c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.b);
        }
    }

    public void b(ko1 ko1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ko1Var) == null) && this.c) {
            ko1Var.d(this.b, new hs1(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, jSONObject) == null) {
            if (this.c) {
                ul2.U().u(new ma2(this.a, new hs1(0, jSONObject)));
                return;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.b);
        }
    }

    public void d(ko1 ko1Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, ko1Var, jSONObject) == null) {
            hs1 hs1Var = new hs1(0, jSONObject);
            if (this.c) {
                ul2.U().u(new ma2(this.a, hs1Var));
            } else {
                ko1Var.d(this.b, hs1Var);
            }
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.c) {
                ul2.U().u(new ma2(this.a, new hs1(1001, str)));
                return;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.b);
        }
    }

    public void f(ko1 ko1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ko1Var, str) == null) {
            hs1 hs1Var = new hs1(1001, str);
            if (this.c) {
                ul2.U().u(new ma2(this.a, hs1Var));
            } else {
                ko1Var.d(this.b, hs1Var);
            }
        }
    }
}
