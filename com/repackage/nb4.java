package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class nb4 implements qb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.qb4
    public void a(JSONArray jSONArray, a84 a84Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, a84Var, a84Var2, a84Var3) == null) {
        }
    }

    @Override // com.repackage.qb4
    public void b(JSONObject jSONObject, a84 a84Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, a84Var, a84Var2, a84Var3) == null) {
        }
    }
}
