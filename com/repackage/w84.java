package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w84 extends u84<h94> implements d94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile h94 b;

    public w84() {
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

    @Override // com.repackage.d94
    public <T> void a(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) {
            this.b = h94Var;
        }
    }

    @Override // com.repackage.d94
    public <T> void b(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var) == null) {
            if (this.b == h94Var) {
                this.b = null;
            }
            k(h94Var);
        }
    }

    public synchronized h94 g() {
        InterceptResult invokeV;
        h94 h94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                h94Var = (h94) super.c();
            }
            return h94Var;
        }
        return (h94) invokeV.objValue;
    }

    public synchronized void h(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h94Var) == null) {
            synchronized (this) {
                if (h94Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(h94Var)) {
                    h94Var.e().f(h94Var.f());
                    return;
                }
                h94 e = e(h94Var);
                if (e != null) {
                    h94Var.e().f(h94Var.f());
                    if (h94Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = h94Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(h94Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, h94Var);
                        }
                    } else if (e == null) {
                        this.a.add(h94Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, h94Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized h94 i() {
        InterceptResult invokeV;
        h94 h94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                h94Var = (h94) super.d();
            }
            return h94Var;
        }
        return (h94) invokeV.objValue;
    }

    public final void j(h94 h94Var) {
        h94 h94Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, h94Var) == null) || h94Var.g() != 300 || (h94Var2 = this.b) == null || h94Var2.g() == 300) {
            return;
        }
        h94Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(h94 h94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, h94Var) == null) && h94Var.k()) {
            h94Var.r(true);
            this.a.add(0, h94Var);
        }
    }
}
