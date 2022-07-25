package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xq3 implements ar3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uq3 a;

    public xq3(uq3 uq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uq3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uq3Var;
    }

    private void setResult(br3 br3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, br3Var) == null) {
            this.a.d.clear();
            if (br3Var != null) {
                this.a.d.putString("functionType", br3Var.a());
                this.a.d.putString("resultData", br3Var.b());
                this.a.d.putInt("resultStatus", br3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.ar3
    public void a(br3 br3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, br3Var) == null) {
            setResult(br3Var);
        }
    }
}
