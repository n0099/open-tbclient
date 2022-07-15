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
public class kb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mb0 a;
    public qb0 b;
    public xb0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755564776, "Lcom/repackage/kb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755564776, "Lcom/repackage/kb0;");
        }
    }

    public kb0(xb0 xb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xb0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = xb0Var;
        this.a = new mb0(xb0Var.f(), 1);
        d();
    }

    public final void a(qb0 qb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qb0Var) == null) {
            if (qb0Var == null) {
                this.b = new pb0();
            } else {
                this.b = qb0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void b(long j) {
        xb0 xb0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == null || (xb0Var = this.c) == null) {
            return;
        }
        if (xb0Var.l()) {
            d();
        }
        if (j != 0) {
            this.c.h().h(j);
        }
        this.b.a(this.c.e(), this.c.h());
    }

    public mb0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (mb0) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            zb0.b(b);
            vb0 c = this.c.c();
            zb0.e(b, c.g(), c.h());
            zb0.a(b, c.d());
            zb0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                zb0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            tb0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            zb0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qb0 qb0Var = this.b;
            if (qb0Var != null) {
                qb0Var.release();
                this.b = null;
            }
            mb0 mb0Var = this.a;
            if (mb0Var != null) {
                mb0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            qb0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public void g(qb0 qb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qb0Var) == null) {
            xb0 xb0Var = this.c;
            if (xb0Var != null) {
                xb0Var.o(qb0Var);
            }
            this.b.release();
            a(qb0Var);
        }
    }
}
