package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xa4 extends na4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xa4() {
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

    @Override // com.repackage.na4, com.repackage.qa4
    public void b(JSONObject jSONObject, a74 a74Var, @Nullable a74 a74Var2, @Nullable a74 a74Var3) {
        ua4 d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, a74Var, a74Var2, a74Var3) == null) || jSONObject == null || (d = va4.c().d(jSONObject)) == null) {
            return;
        }
        q64.b().D(d);
    }
}
