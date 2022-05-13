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
public class jr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public fr5 b;
    public int c;

    public jr5(TbPageContext tbPageContext) {
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
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.a(viewGroup);
    }

    public void b(tq5 tq5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tq5Var, z) == null) {
            if (tq5Var == null) {
                this.c = -1;
                this.b = new gr5(this.a);
            } else if (z) {
                int i = tq5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new ir5(this.a);
                } else if (i == 2) {
                    this.b = new kr5(this.a);
                } else if (i != 3) {
                    this.b = new gr5(this.a);
                } else {
                    this.b = new hr5(this.a);
                }
            }
            if (this.b.f(tq5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(tq5Var);
                return;
            }
            this.c = -1;
            gr5 gr5Var = new gr5(this.a);
            this.b = gr5Var;
            if (z) {
                gr5Var.d();
            }
            this.b.b(tq5Var);
        }
    }

    public boolean c(tq5 tq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tq5Var)) == null) ? tq5Var == null || this.c != tq5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.g(z);
    }

    public void e() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.h();
    }

    public void f(int i) {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.i(i);
    }

    public void g() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.j();
    }

    public void h() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.k();
    }

    public void i() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.l();
    }

    public void j() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.m();
    }

    public void k() {
        fr5 fr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (fr5Var = this.b) == null) {
            return;
        }
        fr5Var.n();
    }
}
