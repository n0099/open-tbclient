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
public final class h82 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h82 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<l82> b;

    public h82() {
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

    public static h82 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (h82.class) {
                    if (c == null) {
                        c = new h82();
                    }
                }
            }
            return c;
        }
        return (h82) invokeV.objValue;
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

    public void b(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).d(c82Var);
        }
    }

    public void c(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).b(c82Var);
        }
    }

    public void d(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).f(c82Var);
        }
    }

    public void e(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).c(c82Var);
        }
    }

    public void f(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).g(c82Var);
        }
    }

    public void g(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).a(c82Var);
        }
    }

    public void h(c82 c82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, c82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((l82) obj).e(c82Var);
        }
    }
}
