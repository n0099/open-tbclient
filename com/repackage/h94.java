package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h94 extends f94<s94> implements o94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile s94 b;

    public h94() {
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

    @Override // com.repackage.o94
    public <T> void a(s94<T> s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s94Var) == null) {
            this.b = s94Var;
        }
    }

    @Override // com.repackage.o94
    public <T> void b(s94<T> s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s94Var) == null) {
            if (this.b == s94Var) {
                this.b = null;
            }
            k(s94Var);
        }
    }

    public synchronized s94 g() {
        InterceptResult invokeV;
        s94 s94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                s94Var = (s94) super.c();
            }
            return s94Var;
        }
        return (s94) invokeV.objValue;
    }

    public synchronized void h(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s94Var) == null) {
            synchronized (this) {
                if (s94Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(s94Var)) {
                    s94Var.e().f(s94Var.f());
                    return;
                }
                s94 e = e(s94Var);
                if (e != null) {
                    s94Var.e().f(s94Var.f());
                    if (s94Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = s94Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(s94Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, s94Var);
                        }
                    } else if (e == null) {
                        this.a.add(s94Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, s94Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized s94 i() {
        InterceptResult invokeV;
        s94 s94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                s94Var = (s94) super.d();
            }
            return s94Var;
        }
        return (s94) invokeV.objValue;
    }

    public final void j(s94 s94Var) {
        s94 s94Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, s94Var) == null) || s94Var.g() != 300 || (s94Var2 = this.b) == null || s94Var2.g() == 300) {
            return;
        }
        s94Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(s94 s94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, s94Var) == null) && s94Var.k()) {
            s94Var.r(true);
            this.a.add(0, s94Var);
        }
    }
}
