package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ em9 a;

    public zq9(em9 em9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {em9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = em9Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            em9 em9Var = this.a;
            fm9 fm9Var = em9Var.e;
            if (fm9Var != null && !em9Var.f && !em9Var.k && !em9.x) {
                if (fm9Var != null) {
                    fm9Var.e();
                    return;
                }
                return;
            }
            em9 em9Var2 = this.a;
            if (em9Var2.e == null || em9Var2.f || !em9Var2.k || em9.x) {
                return;
            }
            vk9 vk9Var = em9Var2.b.a;
            if (((vk9Var == null || !vk9Var.f()) ? -1 : vk9Var.c.getOpent()) == 1) {
                em9 em9Var3 = this.a;
                if (em9Var3.e == null || !em9Var3.r.isShown()) {
                    return;
                }
                this.a.e.e();
            }
        }
    }
}
