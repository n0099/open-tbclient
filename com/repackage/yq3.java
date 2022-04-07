package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yq3 implements br3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vq3 a;

    public yq3(vq3 vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vq3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vq3Var;
    }

    private void setResult(cr3 cr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cr3Var) == null) {
            this.a.d.clear();
            if (cr3Var != null) {
                this.a.d.putString("functionType", cr3Var.a());
                this.a.d.putString("resultData", cr3Var.b());
                this.a.d.putInt("resultStatus", cr3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.repackage.br3
    public void a(cr3 cr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cr3Var) == null) {
            setResult(cr3Var);
        }
    }
}
