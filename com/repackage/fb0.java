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
public class fb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hb0 a;
    public lb0 b;
    public sb0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755713731, "Lcom/repackage/fb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755713731, "Lcom/repackage/fb0;");
        }
    }

    public fb0(sb0 sb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sb0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = sb0Var;
        this.a = new hb0(sb0Var.f(), 1);
        d();
    }

    public final void a(lb0 lb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lb0Var) == null) {
            if (lb0Var == null) {
                this.b = new kb0();
            } else {
                this.b = lb0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void b(long j) {
        sb0 sb0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == null || (sb0Var = this.c) == null) {
            return;
        }
        if (sb0Var.l()) {
            d();
        }
        if (j != 0) {
            this.c.h().h(j);
        }
        this.b.a(this.c.e(), this.c.h());
    }

    public hb0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (hb0) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            ub0.b(b);
            qb0 c = this.c.c();
            ub0.e(b, c.g(), c.h());
            ub0.a(b, c.d());
            ub0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                ub0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            ob0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            ub0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            lb0 lb0Var = this.b;
            if (lb0Var != null) {
                lb0Var.release();
                this.b = null;
            }
            hb0 hb0Var = this.a;
            if (hb0Var != null) {
                hb0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            lb0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public void g(lb0 lb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lb0Var) == null) {
            sb0 sb0Var = this.c;
            if (sb0Var != null) {
                sb0Var.o(lb0Var);
            }
            this.b.release();
            a(lb0Var);
        }
    }
}
