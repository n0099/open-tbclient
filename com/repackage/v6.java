package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z3;
/* loaded from: classes7.dex */
public class v6 extends s6 implements t6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y3 h;

    public v6() {
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

    public void o(y3 y3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, y3Var) == null) {
            this.h = y3Var;
            j(y3Var.n());
            h(y3Var.k());
        }
    }

    public v6 p(i3 i3Var) {
        InterceptResult invokeL;
        y3 y3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3Var)) == null) {
            y3 y3Var2 = this.h;
            if (y3Var2 instanceof z3.b) {
                y3Var = new z3.b((z3.b) y3Var2);
            } else {
                y3Var = new y3(y3Var2);
            }
            y3Var.u(i3Var);
            y3Var.z(a(), k());
            v6 v6Var = new v6(y3Var);
            v6Var.b(l());
            v6Var.c(g());
            v6Var.f(i());
            v6Var.d(e());
            return v6Var;
        }
        return (v6) invokeL.objValue;
    }

    public v6(y3 y3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(y3Var);
    }
}
