package com.repackage;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gh5 {
    public static /* synthetic */ Interceptable $ic;
    public static gh5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public th5 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755678019, "Lcom/repackage/gh5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755678019, "Lcom/repackage/gh5;");
        }
    }

    public gh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static gh5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new gh5();
            }
            return b;
        }
        return (gh5) invokeV.objValue;
    }

    public void a() {
        th5 th5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (th5Var = this.a) == null || th5Var.b() == null) {
            return;
        }
        this.a.b().dismiss();
    }

    public boolean c(lh5 lh5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh5Var)) == null) {
            th5 th5Var = this.a;
            if (th5Var == null || th5Var.b() == null) {
                return false;
            }
            return this.a.b().c(lh5Var);
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        th5 th5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (th5Var = this.a) == null || th5Var.b() == null) {
            return;
        }
        this.a.b().b(i);
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, jh5Var) == null) {
            th5 th5Var = this.a;
            if (th5Var == null || !th5Var.a) {
                this.a = new uh5(tbPageContext, viewGroup, jh5Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            th5 th5Var = this.a;
            if (th5Var == null || th5Var.b() == null) {
                return false;
            }
            return this.a.b().a(str);
        }
        return invokeL.booleanValue;
    }
}
