package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oa4 extends ma4<za4> implements va4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile za4 b;

    public oa4() {
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

    @Override // com.repackage.va4
    public <T> void a(za4<T> za4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, za4Var) == null) {
            this.b = za4Var;
        }
    }

    @Override // com.repackage.va4
    public <T> void b(za4<T> za4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, za4Var) == null) {
            if (this.b == za4Var) {
                this.b = null;
            }
            k(za4Var);
        }
    }

    public synchronized za4 g() {
        InterceptResult invokeV;
        za4 za4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                za4Var = (za4) super.c();
            }
            return za4Var;
        }
        return (za4) invokeV.objValue;
    }

    public synchronized void h(za4 za4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, za4Var) == null) {
            synchronized (this) {
                if (za4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(za4Var)) {
                    za4Var.e().f(za4Var.f());
                    return;
                }
                za4 e = e(za4Var);
                if (e != null) {
                    za4Var.e().f(za4Var.f());
                    if (za4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = za4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(za4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, za4Var);
                        }
                    } else if (e == null) {
                        this.a.add(za4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, za4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized za4 i() {
        InterceptResult invokeV;
        za4 za4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                za4Var = (za4) super.d();
            }
            return za4Var;
        }
        return (za4) invokeV.objValue;
    }

    public final void j(za4 za4Var) {
        za4 za4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, za4Var) == null) || za4Var.g() != 300 || (za4Var2 = this.b) == null || za4Var2.g() == 300) {
            return;
        }
        za4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(za4 za4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, za4Var) == null) && za4Var.k()) {
            za4Var.r(true);
            this.a.add(0, za4Var);
        }
    }
}
