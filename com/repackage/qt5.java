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
/* loaded from: classes7.dex */
public class qt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public mt5 b;
    public int c;

    public qt5(TbPageContext tbPageContext) {
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
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.a(viewGroup);
    }

    public void b(at5 at5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, at5Var, z) == null) {
            if (at5Var == null) {
                this.c = -1;
                this.b = new nt5(this.a);
            } else if (z) {
                int i = at5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new pt5(this.a);
                } else if (i == 2) {
                    this.b = new rt5(this.a);
                } else if (i != 3) {
                    this.b = new nt5(this.a);
                } else {
                    this.b = new ot5(this.a);
                }
            }
            if (this.b.f(at5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(at5Var);
                return;
            }
            this.c = -1;
            nt5 nt5Var = new nt5(this.a);
            this.b = nt5Var;
            if (z) {
                nt5Var.d();
            }
            this.b.b(at5Var);
        }
    }

    public boolean c(at5 at5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, at5Var)) == null) ? at5Var == null || this.c != at5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.g(z);
    }

    public void e() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.h();
    }

    public void f(int i) {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.i(i);
    }

    public void g() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.j();
    }

    public void h() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.k();
    }

    public void i() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.l();
    }

    public void j() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.m();
    }

    public void k() {
        mt5 mt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mt5Var = this.b) == null) {
            return;
        }
        mt5Var.n();
    }
}
