package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class or3 implements rr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lr3 a;

    public or3(lr3 lr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lr3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lr3Var;
    }

    private void setResult(sr3 sr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, sr3Var) == null) {
            this.a.d.clear();
            if (sr3Var != null) {
                this.a.d.putString("functionType", sr3Var.a());
                this.a.d.putString("resultData", sr3Var.b());
                this.a.d.putInt("resultStatus", sr3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.rr3
    public void a(sr3 sr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sr3Var) == null) {
            setResult(sr3Var);
        }
    }
}
