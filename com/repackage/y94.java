package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y94 extends w94<ja4> implements fa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ja4 b;

    public y94() {
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

    @Override // com.repackage.fa4
    public <T> void a(ja4<T> ja4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ja4Var) == null) {
            this.b = ja4Var;
        }
    }

    @Override // com.repackage.fa4
    public <T> void b(ja4<T> ja4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ja4Var) == null) {
            if (this.b == ja4Var) {
                this.b = null;
            }
            k(ja4Var);
        }
    }

    public synchronized ja4 g() {
        InterceptResult invokeV;
        ja4 ja4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ja4Var = (ja4) super.c();
            }
            return ja4Var;
        }
        return (ja4) invokeV.objValue;
    }

    public synchronized void h(ja4 ja4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ja4Var) == null) {
            synchronized (this) {
                if (ja4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ja4Var)) {
                    ja4Var.e().f(ja4Var.f());
                    return;
                }
                ja4 e = e(ja4Var);
                if (e != null) {
                    ja4Var.e().f(ja4Var.f());
                    if (ja4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ja4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ja4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ja4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ja4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ja4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ja4 i() {
        InterceptResult invokeV;
        ja4 ja4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ja4Var = (ja4) super.d();
            }
            return ja4Var;
        }
        return (ja4) invokeV.objValue;
    }

    public final void j(ja4 ja4Var) {
        ja4 ja4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ja4Var) == null) || ja4Var.g() != 300 || (ja4Var2 = this.b) == null || ja4Var2.g() == 300) {
            return;
        }
        ja4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ja4 ja4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ja4Var) == null) && ja4Var.k()) {
            ja4Var.r(true);
            this.a.add(0, ja4Var);
        }
    }
}
