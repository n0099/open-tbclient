package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wq3 implements zq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tq3 a;

    public wq3(tq3 tq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tq3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tq3Var;
    }

    private void setResult(ar3 ar3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, ar3Var) == null) {
            this.a.d.clear();
            if (ar3Var != null) {
                this.a.d.putString("functionType", ar3Var.a());
                this.a.d.putString("resultData", ar3Var.b());
                this.a.d.putInt("resultStatus", ar3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.zq3
    public void a(ar3 ar3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ar3Var) == null) {
            setResult(ar3Var);
        }
    }
}
