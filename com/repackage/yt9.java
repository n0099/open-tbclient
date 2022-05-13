package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ dp9 a;

    public yt9(dp9 dp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dp9Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            dp9 dp9Var = this.a;
            ep9 ep9Var = dp9Var.e;
            if (ep9Var != null && !dp9Var.f && !dp9Var.k && !dp9.x) {
                if (ep9Var != null) {
                    ep9Var.e();
                    return;
                }
                return;
            }
            dp9 dp9Var2 = this.a;
            if (dp9Var2.e == null || dp9Var2.f || !dp9Var2.k || dp9.x) {
                return;
            }
            un9 un9Var = dp9Var2.b.a;
            if (((un9Var == null || !un9Var.f()) ? -1 : un9Var.c.getOpent()) == 1) {
                dp9 dp9Var3 = this.a;
                if (dp9Var3.e == null || !dp9Var3.r.isShown()) {
                    return;
                }
                this.a.e.e();
            }
        }
    }
}
