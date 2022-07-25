package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x94 extends v94<ia4> implements ea4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ia4 b;

    public x94() {
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

    @Override // com.repackage.ea4
    public <T> void a(ia4<T> ia4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ia4Var) == null) {
            this.b = ia4Var;
        }
    }

    @Override // com.repackage.ea4
    public <T> void b(ia4<T> ia4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ia4Var) == null) {
            if (this.b == ia4Var) {
                this.b = null;
            }
            k(ia4Var);
        }
    }

    public synchronized ia4 g() {
        InterceptResult invokeV;
        ia4 ia4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ia4Var = (ia4) super.c();
            }
            return ia4Var;
        }
        return (ia4) invokeV.objValue;
    }

    public synchronized void h(ia4 ia4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ia4Var) == null) {
            synchronized (this) {
                if (ia4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ia4Var)) {
                    ia4Var.e().f(ia4Var.f());
                    return;
                }
                ia4 e = e(ia4Var);
                if (e != null) {
                    ia4Var.e().f(ia4Var.f());
                    if (ia4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ia4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ia4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ia4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ia4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ia4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ia4 i() {
        InterceptResult invokeV;
        ia4 ia4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ia4Var = (ia4) super.d();
            }
            return ia4Var;
        }
        return (ia4) invokeV.objValue;
    }

    public final void j(ia4 ia4Var) {
        ia4 ia4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ia4Var) == null) || ia4Var.g() != 300 || (ia4Var2 = this.b) == null || ia4Var2.g() == 300) {
            return;
        }
        ia4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ia4 ia4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ia4Var) == null) && ia4Var.k()) {
            ia4Var.r(true);
            this.a.add(0, ia4Var);
        }
    }
}
