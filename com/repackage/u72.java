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
/* loaded from: classes7.dex */
public final class u72 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u72 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<y72> b;

    public u72() {
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

    public static u72 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (u72.class) {
                    if (c == null) {
                        c = new u72();
                    }
                }
            }
            return c;
        }
        return (u72) invokeV.objValue;
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

    public void b(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).d(p72Var);
        }
    }

    public void c(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).b(p72Var);
        }
    }

    public void d(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).f(p72Var);
        }
    }

    public void e(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).c(p72Var);
        }
    }

    public void f(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).g(p72Var);
        }
    }

    public void g(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).a(p72Var);
        }
    }

    public void h(p72 p72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, p72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y72) obj).e(p72Var);
        }
    }
}
