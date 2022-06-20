package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b4;
/* loaded from: classes7.dex */
public class y6 extends u6 implements v6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c4 h;

    public y6() {
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

    public void o(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c4Var) == null) {
            this.h = c4Var;
            if (c4Var != null) {
                j(c4Var.c());
                h(c4Var.b());
            }
        }
    }

    public v6 p(k3 k3Var) {
        InterceptResult invokeL;
        a4 a4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k3Var)) == null) {
            c4 c4Var = this.h;
            if (c4Var instanceof b4.a) {
                a4Var = new b4.b((b4.a) c4Var);
            } else {
                a4Var = new a4(c4Var);
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
        return (v6) invokeL.objValue;
    }

    public y6(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(c4Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6(y6 y6Var) {
        super(y6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y6Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((v6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        o(y6Var.h);
    }
}
