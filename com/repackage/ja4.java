package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ja4 extends ha4<ua4> implements qa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ua4 b;

    public ja4() {
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

    @Override // com.repackage.qa4
    public <T> void a(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ua4Var) == null) {
            this.b = ua4Var;
        }
    }

    @Override // com.repackage.qa4
    public <T> void b(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua4Var) == null) {
            if (this.b == ua4Var) {
                this.b = null;
            }
            k(ua4Var);
        }
    }

    public synchronized ua4 g() {
        InterceptResult invokeV;
        ua4 ua4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ua4Var = (ua4) super.c();
            }
            return ua4Var;
        }
        return (ua4) invokeV.objValue;
    }

    public synchronized void h(ua4 ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ua4Var) == null) {
            synchronized (this) {
                if (ua4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ua4Var)) {
                    ua4Var.e().f(ua4Var.f());
                    return;
                }
                ua4 e = e(ua4Var);
                if (e != null) {
                    ua4Var.e().f(ua4Var.f());
                    if (ua4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ua4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ua4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ua4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ua4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ua4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ua4 i() {
        InterceptResult invokeV;
        ua4 ua4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ua4Var = (ua4) super.d();
            }
            return ua4Var;
        }
        return (ua4) invokeV.objValue;
    }

    public final void j(ua4 ua4Var) {
        ua4 ua4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ua4Var) == null) || ua4Var.g() != 300 || (ua4Var2 = this.b) == null || ua4Var2.g() == 300) {
            return;
        }
        ua4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ua4 ua4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ua4Var) == null) && ua4Var.k()) {
            ua4Var.r(true);
            this.a.add(0, ua4Var);
        }
    }
}
