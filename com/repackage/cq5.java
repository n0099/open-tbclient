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
public class cq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public yp5 b;
    public int c;

    public cq5(TbPageContext tbPageContext) {
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
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.a(viewGroup);
    }

    public void b(mp5 mp5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp5Var, z) == null) {
            if (mp5Var == null) {
                this.c = -1;
                this.b = new zp5(this.a);
            } else if (z) {
                int i = mp5Var.d;
                this.c = i;
                if (i == 1) {
                    this.b = new bq5(this.a);
                } else if (i == 2) {
                    this.b = new dq5(this.a);
                } else if (i != 3) {
                    this.b = new zp5(this.a);
                } else {
                    this.b = new aq5(this.a);
                }
            }
            if (this.b.f(mp5Var)) {
                if (z) {
                    this.b.d();
                }
                this.b.b(mp5Var);
                return;
            }
            this.c = -1;
            zp5 zp5Var = new zp5(this.a);
            this.b = zp5Var;
            if (z) {
                zp5Var.d();
            }
            this.b.b(mp5Var);
        }
    }

    public boolean c(mp5 mp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp5Var)) == null) ? mp5Var == null || this.c != mp5Var.d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.g(z);
    }

    public void e() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.h();
    }

    public void f(int i) {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.i(i);
    }

    public void g() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.j();
    }

    public void h() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.k();
    }

    public void i() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.l();
    }

    public void j() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.m();
    }

    public void k() {
        yp5 yp5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (yp5Var = this.b) == null) {
            return;
        }
        yp5Var.n();
    }
}
