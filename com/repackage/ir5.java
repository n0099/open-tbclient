package com.repackage;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ir5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public er5 b;
    public int c;

    public ir5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.a(viewGroup);
    }

    public void b(sq5 sq5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sq5Var, z) == null) {
            if (sq5Var == null) {
                this.c = -1;
                this.b = new fr5(this.a);
            } else if (z) {
                int i = sq5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new hr5(this.a);
                } else if (i == 2) {
                    this.b = new jr5(this.a);
                } else if (i != 3) {
                    this.b = new fr5(this.a);
                } else {
                    this.b = new gr5(this.a);
                }
            }
            if (this.b.f(sq5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(sq5Var);
                return;
            }
            this.c = -1;
            fr5 fr5Var = new fr5(this.a);
            this.b = fr5Var;
            if (z) {
                fr5Var.d();
            }
            this.b.b(sq5Var);
        }
    }

    public boolean c(sq5 sq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sq5Var)) == null) ? sq5Var == null || this.c != sq5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.g(z);
    }

    public void e() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.h();
    }

    public void f(int i) {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.i(i);
    }

    public void g() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.j();
    }

    public void h() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.k();
    }

    public void i() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.l();
    }

    public void j() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.m();
    }

    public void k() {
        er5 er5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (er5Var = this.b) == null) {
            return;
        }
        er5Var.n();
    }
}
