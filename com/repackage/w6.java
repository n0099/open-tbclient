package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z3;
/* loaded from: classes7.dex */
public class w6 extends s6 implements t6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a4 h;

    public w6() {
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
            if (a4Var != null) {
                j(a4Var.c());
                h(a4Var.b());
            }
        }
    }

    public t6 p(i3 i3Var) {
        InterceptResult invokeL;
        y3 y3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3Var)) == null) {
            a4 a4Var = this.h;
            if (a4Var instanceof z3.a) {
                y3Var = new z3.b((z3.a) a4Var);
            } else {
                y3Var = new y3(a4Var);
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
        return (t6) invokeL.objValue;
    }

    public w6(a4 a4Var) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w6(w6 w6Var) {
        super(w6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w6Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        o(w6Var.h);
    }
}
