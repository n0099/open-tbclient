package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xb4 extends nb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xb4() {
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

    @Override // com.repackage.nb4, com.repackage.qb4
    public void b(JSONObject jSONObject, a84 a84Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        ub4 d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, a84Var, a84Var2, a84Var3) == null) || jSONObject == null || (d = vb4.c().d(jSONObject)) == null) {
            return;
        }
        q74.b().D(d);
    }
}
