package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jr3 implements mr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gr3 a;

    public jr3(gr3 gr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gr3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gr3Var;
    }

    private void setResult(nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, nr3Var) == null) {
            this.a.d.clear();
            if (nr3Var != null) {
                this.a.d.putString("functionType", nr3Var.a());
                this.a.d.putString("resultData", nr3Var.b());
                this.a.d.putInt("resultStatus", nr3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.mr3
    public void a(nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nr3Var) == null) {
            setResult(nr3Var);
        }
    }
}
