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
public class yr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ur5 b;
    public int c;

    public yr5(TbPageContext tbPageContext) {
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
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.a(viewGroup);
    }

    public void b(ir5 ir5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ir5Var, z) == null) {
            if (ir5Var == null) {
                this.c = -1;
                this.b = new vr5(this.a);
            } else if (z) {
                int i = ir5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new xr5(this.a);
                } else if (i == 2) {
                    this.b = new zr5(this.a);
                } else if (i != 3) {
                    this.b = new vr5(this.a);
                } else {
                    this.b = new wr5(this.a);
                }
            }
            if (this.b.f(ir5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(ir5Var);
                return;
            }
            this.c = -1;
            vr5 vr5Var = new vr5(this.a);
            this.b = vr5Var;
            if (z) {
                vr5Var.d();
            }
            this.b.b(ir5Var);
        }
    }

    public boolean c(ir5 ir5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ir5Var)) == null) ? ir5Var == null || this.c != ir5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.g(z);
    }

    public void e() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.h();
    }

    public void f(int i) {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.i(i);
    }

    public void g() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.j();
    }

    public void h() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.k();
    }

    public void i() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.l();
    }

    public void j() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.m();
    }

    public void k() {
        ur5 ur5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ur5Var = this.b) == null) {
            return;
        }
        ur5Var.n();
    }
}
