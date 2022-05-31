package com.repackage;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class kt1 extends ns1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vs1 a;

    public kt1() {
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

    @Override // com.repackage.ns1
    public void a(os1 os1Var, Canvas canvas) {
        vs1 vs1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, os1Var, canvas) == null) && (vs1Var = this.a) != null && vs1Var.d()) {
            if (this.a.c()) {
                os1Var.b.setShader(this.a.b());
                return;
            }
            os1Var.e.setColor(this.a.a());
            os1Var.b.setColor(this.a.a());
            os1Var.b.setShader(null);
        }
    }

    @Override // com.repackage.ns1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 0) {
            return;
        }
        this.a = new vs1(jSONArray);
    }
}
