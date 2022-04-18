package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yc4 extends pb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yc4() {
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

    @Override // com.repackage.pb4, com.repackage.sb4
    public void b(JSONObject jSONObject, c84 c84Var, @Nullable c84 c84Var2, @Nullable c84 c84Var3) {
        JSONObject optJSONObject;
        vc4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, c84Var, c84Var2, c84Var3) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("base_info")) == null || (a = vc4.a(optJSONObject)) == null) {
            return;
        }
        wc4.e().i(a);
        wc4.e().j(a.k);
    }
}
