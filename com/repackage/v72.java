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
public final class v72 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v72 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<z72> b;

    public v72() {
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

    public static v72 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (v72.class) {
                    if (c == null) {
                        c = new v72();
                    }
                }
            }
            return c;
        }
        return (v72) invokeV.objValue;
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

    public void b(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).d(q72Var);
        }
    }

    public void c(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).b(q72Var);
        }
    }

    public void d(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).f(q72Var);
        }
    }

    public void e(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).c(q72Var);
        }
    }

    public void f(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).g(q72Var);
        }
    }

    public void g(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).a(q72Var);
        }
    }

    public void h(q72 q72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, q72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((z72) obj).e(q72Var);
        }
    }
}
