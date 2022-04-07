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
public class lc0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nc0 a;
    public rc0 b;
    public yc0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755534024, "Lcom/repackage/lc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755534024, "Lcom/repackage/lc0;");
        }
    }

    public lc0(yc0 yc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yc0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = yc0Var;
        this.a = new nc0(yc0Var.f(), 1);
        d();
    }

    public final void a(rc0 rc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rc0Var) == null) {
            if (rc0Var == null) {
                this.b = new qc0();
            } else {
                this.b = rc0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void b(long j) {
        yc0 yc0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == null || (yc0Var = this.c) == null) {
            return;
        }
        if (yc0Var.l()) {
            d();
        }
        if (j != 0) {
            this.c.h().h(j);
        }
        this.b.a(this.c.e(), this.c.h());
    }

    public nc0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (nc0) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            ad0.b(b);
            wc0 c = this.c.c();
            ad0.e(b, c.g(), c.h());
            ad0.a(b, c.d());
            ad0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                ad0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            uc0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            ad0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rc0 rc0Var = this.b;
            if (rc0Var != null) {
                rc0Var.release();
                this.b = null;
            }
            nc0 nc0Var = this.a;
            if (nc0Var != null) {
                nc0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            rc0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public void g(rc0 rc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rc0Var) == null) {
            yc0 yc0Var = this.c;
            if (yc0Var != null) {
                yc0Var.o(rc0Var);
            }
            this.b.release();
            a(rc0Var);
        }
    }
}
