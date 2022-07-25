package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xc4 extends ob4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xc4() {
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

    @Override // com.repackage.ob4, com.repackage.rb4
    public void b(JSONObject jSONObject, b84 b84Var, @Nullable b84 b84Var2, @Nullable b84 b84Var3) {
        JSONObject optJSONObject;
        uc4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, b84Var, b84Var2, b84Var3) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("base_info")) == null || (a = uc4.a(optJSONObject)) == null) {
            return;
        }
        vc4.e().i(a);
        vc4.e().j(a.k);
    }
}
