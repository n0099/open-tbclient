package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ut2 implements st2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public tt2 a;
    public long b;
    public long c;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ut2 a;

        public a(ut2 ut2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ut2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ut2Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.l()) {
                    this.a.m();
                    return true;
                }
                this.a.n();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755249506, "Lcom/repackage/ut2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755249506, "Lcom/repackage/ut2;");
                return;
            }
        }
        d = rf1.a;
    }

    public ut2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (l()) {
            this.a = new tt2();
        }
    }

    @Override // com.repackage.st2
    public void a(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && l() && (tt2Var = this.a) != null) {
            tt2Var.f(j - this.b);
        }
    }

    @Override // com.repackage.ts2
    public void b(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && l() && (tt2Var = this.a) != null) {
            this.b = j;
            tt2Var.e();
        }
    }

    @Override // com.repackage.ts2
    public void c(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && l() && (tt2Var = this.a) != null) {
            this.c = j;
            tt2Var.l(this.b, j);
            this.a.a();
        }
    }

    @Override // com.repackage.st2
    public void e(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048579, this, j) == null) && l() && (tt2Var = this.a) != null) {
            tt2Var.h(j - this.b);
        }
    }

    @Override // com.repackage.st2
    public void f(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && l() && (tt2Var = this.a) != null) {
            tt2Var.i(j - this.b);
        }
    }

    @Override // com.repackage.st2
    public void g(long j) {
        tt2 tt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && l() && (tt2Var = this.a) != null) {
            tt2Var.g(j - this.b);
        }
    }

    @Override // com.repackage.st2
    public void h(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && d && view2 != null) {
            view2.setOnLongClickListener(new a(this));
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (d) {
                return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
            tt2 tt2Var = this.a;
            if (tt2Var != null) {
                tt2Var.c();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
            if (this.a == null) {
                this.a = new tt2();
            }
            this.a.k();
        }
    }
}
