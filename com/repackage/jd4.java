package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jd4 extends ac4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jd4() {
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

    @Override // com.repackage.ac4, com.repackage.dc4
    public void b(JSONObject jSONObject, n84 n84Var, @Nullable n84 n84Var2, @Nullable n84 n84Var3) {
        JSONObject optJSONObject;
        gd4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, n84Var, n84Var2, n84Var3) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("base_info")) == null || (a = gd4.a(optJSONObject)) == null) {
            return;
        }
        hd4.e().i(a);
        hd4.e().j(a.k);
    }
}
