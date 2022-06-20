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
/* loaded from: classes5.dex */
public class br5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public xq5 b;
    public int c;

    public br5(TbPageContext tbPageContext) {
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
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.a(viewGroup);
    }

    public void b(lq5 lq5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lq5Var, z) == null) {
            if (lq5Var == null) {
                this.c = -1;
                this.b = new yq5(this.a);
            } else if (z) {
                int i = lq5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new ar5(this.a);
                } else if (i == 2) {
                    this.b = new cr5(this.a);
                } else if (i != 3) {
                    this.b = new yq5(this.a);
                } else {
                    this.b = new zq5(this.a);
                }
            }
            if (this.b.f(lq5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(lq5Var);
                return;
            }
            this.c = -1;
            yq5 yq5Var = new yq5(this.a);
            this.b = yq5Var;
            if (z) {
                yq5Var.d();
            }
            this.b.b(lq5Var);
        }
    }

    public boolean c(lq5 lq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq5Var)) == null) ? lq5Var == null || this.c != lq5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.g(z);
    }

    public void e() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.h();
    }

    public void f(int i) {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.i(i);
    }

    public void g() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.j();
    }

    public void h() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.k();
    }

    public void i() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.l();
    }

    public void j() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.m();
    }

    public void k() {
        xq5 xq5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (xq5Var = this.b) == null) {
            return;
        }
        xq5Var.n();
    }
}
