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
public class gr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public cr5 b;
    public int c;

    public gr5(TbPageContext tbPageContext) {
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
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.a(viewGroup);
    }

    public void b(qq5 qq5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qq5Var, z) == null) {
            if (qq5Var == null) {
                this.c = -1;
                this.b = new dr5(this.a);
            } else if (z) {
                int i = qq5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new fr5(this.a);
                } else if (i == 2) {
                    this.b = new hr5(this.a);
                } else if (i != 3) {
                    this.b = new dr5(this.a);
                } else {
                    this.b = new er5(this.a);
                }
            }
            if (this.b.f(qq5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(qq5Var);
                return;
            }
            this.c = -1;
            dr5 dr5Var = new dr5(this.a);
            this.b = dr5Var;
            if (z) {
                dr5Var.d();
            }
            this.b.b(qq5Var);
        }
    }

    public boolean c(qq5 qq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qq5Var)) == null) ? qq5Var == null || this.c != qq5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.g(z);
    }

    public void e() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.h();
    }

    public void f(int i) {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.i(i);
    }

    public void g() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.j();
    }

    public void h() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.k();
    }

    public void i() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.l();
    }

    public void j() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.m();
    }

    public void k() {
        cr5 cr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cr5Var = this.b) == null) {
            return;
        }
        cr5Var.n();
    }
}
