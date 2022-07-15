package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w94 extends u94<ha4> implements da4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ha4 b;

    public w94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.da4
    public <T> void a(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ha4Var) == null) {
            this.b = ha4Var;
        }
    }

    @Override // com.repackage.da4
    public <T> void b(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha4Var) == null) {
            if (this.b == ha4Var) {
                this.b = null;
            }
            k(ha4Var);
        }
    }

    public synchronized ha4 g() {
        InterceptResult invokeV;
        ha4 ha4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ha4Var = (ha4) super.c();
            }
            return ha4Var;
        }
        return (ha4) invokeV.objValue;
    }

    public synchronized void h(ha4 ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ha4Var) == null) {
            synchronized (this) {
                if (ha4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ha4Var)) {
                    ha4Var.e().f(ha4Var.f());
                    return;
                }
                ha4 e = e(ha4Var);
                if (e != null) {
                    ha4Var.e().f(ha4Var.f());
                    if (ha4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ha4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ha4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ha4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ha4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ha4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ha4 i() {
        InterceptResult invokeV;
        ha4 ha4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ha4Var = (ha4) super.d();
            }
            return ha4Var;
        }
        return (ha4) invokeV.objValue;
    }

    public final void j(ha4 ha4Var) {
        ha4 ha4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ha4Var) == null) || ha4Var.g() != 300 || (ha4Var2 = this.b) == null || ha4Var2.g() == 300) {
            return;
        }
        ha4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ha4 ha4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ha4Var) == null) && ha4Var.k()) {
            ha4Var.r(true);
            this.a.add(0, ha4Var);
        }
    }
}
