package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public final class f72 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f72 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<j72> b;

    public f72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ReentrantLock();
        this.b = new ArrayList<>();
    }

    public static f72 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (f72.class) {
                    if (c == null) {
                        c = new f72();
                    }
                }
            }
            return c;
        }
        return (f72) invokeV.objValue;
    }

    public final Object[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.a.lock();
                return this.b.size() > 0 ? this.b.toArray() : null;
            } finally {
                this.a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).d(a72Var);
        }
    }

    public void c(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).b(a72Var);
        }
    }

    public void d(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).f(a72Var);
        }
    }

    public void e(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).c(a72Var);
        }
    }

    public void f(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).g(a72Var);
        }
    }

    public void g(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).a(a72Var);
        }
    }

    public void h(a72 a72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, a72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j72) obj).e(a72Var);
        }
    }
}
