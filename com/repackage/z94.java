package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z94 extends x94<ka4> implements ga4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ka4 b;

    public z94() {
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

    @Override // com.repackage.ga4
    public <T> void a(ka4<T> ka4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ka4Var) == null) {
            this.b = ka4Var;
        }
    }

    @Override // com.repackage.ga4
    public <T> void b(ka4<T> ka4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ka4Var) == null) {
            if (this.b == ka4Var) {
                this.b = null;
            }
            k(ka4Var);
        }
    }

    public synchronized ka4 g() {
        InterceptResult invokeV;
        ka4 ka4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ka4Var = (ka4) super.c();
            }
            return ka4Var;
        }
        return (ka4) invokeV.objValue;
    }

    public synchronized void h(ka4 ka4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ka4Var) == null) {
            synchronized (this) {
                if (ka4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ka4Var)) {
                    ka4Var.e().f(ka4Var.f());
                    return;
                }
                ka4 e = e(ka4Var);
                if (e != null) {
                    ka4Var.e().f(ka4Var.f());
                    if (ka4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ka4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ka4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ka4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ka4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ka4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ka4 i() {
        InterceptResult invokeV;
        ka4 ka4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ka4Var = (ka4) super.d();
            }
            return ka4Var;
        }
        return (ka4) invokeV.objValue;
    }

    public final void j(ka4 ka4Var) {
        ka4 ka4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ka4Var) == null) || ka4Var.g() != 300 || (ka4Var2 = this.b) == null || ka4Var2.g() == 300) {
            return;
        }
        ka4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ka4 ka4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ka4Var) == null) && ka4Var.k()) {
            ka4Var.r(true);
            this.a.add(0, ka4Var);
        }
    }
}
