package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wp3 implements zp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tp3 a;

    public wp3(tp3 tp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tp3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tp3Var;
    }

    private void setResult(aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aq3Var) == null) {
            this.a.d.clear();
            if (aq3Var != null) {
                this.a.d.putString("functionType", aq3Var.a());
                this.a.d.putString("resultData", aq3Var.b());
                this.a.d.putInt("resultStatus", aq3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.zp3
    public void a(aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aq3Var) == null) {
            setResult(aq3Var);
        }
    }
}
