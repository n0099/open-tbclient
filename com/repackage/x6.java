package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b4;
/* loaded from: classes7.dex */
public class x6 extends u6 implements v6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a4 h;

    public x6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void o(a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a4Var) == null) {
            this.h = a4Var;
            j(a4Var.n());
            h(a4Var.k());
        }
    }

    public x6 p(k3 k3Var) {
        InterceptResult invokeL;
        a4 a4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k3Var)) == null) {
            a4 a4Var2 = this.h;
            if (a4Var2 instanceof b4.b) {
                a4Var = new b4.b((b4.b) a4Var2);
            } else {
                a4Var = new a4(a4Var2);
            }
            a4Var.u(k3Var);
            a4Var.z(a(), k());
            x6 x6Var = new x6(a4Var);
            x6Var.b(l());
            x6Var.c(g());
            x6Var.f(i());
            x6Var.d(e());
            return x6Var;
        }
        return (x6) invokeL.objValue;
    }

    public x6(a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(a4Var);
    }
}
