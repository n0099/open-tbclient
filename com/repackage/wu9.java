package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bq9 a;

    public wu9(bq9 bq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bq9Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            bq9 bq9Var = this.a;
            cq9 cq9Var = bq9Var.e;
            if (cq9Var != null && !bq9Var.f && !bq9Var.k && !bq9.x) {
                if (cq9Var != null) {
                    cq9Var.e();
                    return;
                }
                return;
            }
            bq9 bq9Var2 = this.a;
            if (bq9Var2.e == null || bq9Var2.f || !bq9Var2.k || bq9.x) {
                return;
            }
            so9 so9Var = bq9Var2.b.a;
            if (((so9Var == null || !so9Var.f()) ? -1 : so9Var.c.getOpent()) == 1) {
                bq9 bq9Var3 = this.a;
                if (bq9Var3.e == null || !bq9Var3.r.isShown()) {
                    return;
                }
                this.a.e.e();
            }
        }
    }
}
