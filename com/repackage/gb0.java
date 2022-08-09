package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ib0 a;
    public mb0 b;
    public tb0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755683940, "Lcom/repackage/gb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755683940, "Lcom/repackage/gb0;");
        }
    }

    public gb0(tb0 tb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tb0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = tb0Var;
        this.a = new ib0(tb0Var.f(), 1);
        d();
    }

    public final void a(mb0 mb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mb0Var) == null) {
            if (mb0Var == null) {
                this.b = new lb0();
            } else {
                this.b = mb0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void b(long j) {
        tb0 tb0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == null || (tb0Var = this.c) == null) {
            return;
        }
        if (tb0Var.l()) {
            d();
        }
        if (j != 0) {
            this.c.h().h(j);
        }
        this.b.a(this.c.e(), this.c.h());
    }

    public ib0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (ib0) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            vb0.b(b);
            rb0 c = this.c.c();
            vb0.e(b, c.g(), c.h());
            vb0.a(b, c.d());
            vb0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                vb0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            pb0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            vb0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mb0 mb0Var = this.b;
            if (mb0Var != null) {
                mb0Var.release();
                this.b = null;
            }
            ib0 ib0Var = this.a;
            if (ib0Var != null) {
                ib0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            mb0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public void g(mb0 mb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mb0Var) == null) {
            tb0 tb0Var = this.c;
            if (tb0Var != null) {
                tb0Var.o(mb0Var);
            }
            this.b.release();
            a(mb0Var);
        }
    }
}
