package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ xl9 a;

    public sq9(xl9 xl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xl9Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            xl9 xl9Var = this.a;
            yl9 yl9Var = xl9Var.e;
            if (yl9Var != null && !xl9Var.f && !xl9Var.k && !xl9.x) {
                if (yl9Var != null) {
                    yl9Var.e();
                    return;
                }
                return;
            }
            xl9 xl9Var2 = this.a;
            if (xl9Var2.e == null || xl9Var2.f || !xl9Var2.k || xl9.x) {
                return;
            }
            ok9 ok9Var = xl9Var2.b.a;
            if (((ok9Var == null || !ok9Var.f()) ? -1 : ok9Var.c.getOpent()) == 1) {
                xl9 xl9Var3 = this.a;
                if (xl9Var3.e == null || !xl9Var3.r.isShown()) {
                    return;
                }
                this.a.e.e();
            }
        }
    }
}
