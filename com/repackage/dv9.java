package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ iq9 a;

    public dv9(iq9 iq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iq9Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            iq9 iq9Var = this.a;
            jq9 jq9Var = iq9Var.e;
            if (jq9Var != null && !iq9Var.f && !iq9Var.k && !iq9.x) {
                if (jq9Var != null) {
                    jq9Var.e();
                    return;
                }
                return;
            }
            iq9 iq9Var2 = this.a;
            if (iq9Var2.e == null || iq9Var2.f || !iq9Var2.k || iq9.x) {
                return;
            }
            zo9 zo9Var = iq9Var2.b.a;
            if (((zo9Var == null || !zo9Var.f()) ? -1 : zo9Var.c.getOpent()) == 1) {
                iq9 iq9Var3 = this.a;
                if (iq9Var3.e == null || !iq9Var3.r.isShown()) {
                    return;
                }
                this.a.e.e();
            }
        }
    }
}
