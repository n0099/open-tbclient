package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hq3 implements kq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eq3 a;

    public hq3(eq3 eq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eq3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eq3Var;
    }

    private void setResult(lq3 lq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, lq3Var) == null) {
            this.a.d.clear();
            if (lq3Var != null) {
                this.a.d.putString("functionType", lq3Var.a());
                this.a.d.putString("resultData", lq3Var.b());
                this.a.d.putInt("resultStatus", lq3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.kq3
    public void a(lq3 lq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lq3Var) == null) {
            setResult(lq3Var);
        }
    }
}
