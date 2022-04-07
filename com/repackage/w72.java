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
public final class w72 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w72 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<a82> b;

    public w72() {
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

    public static w72 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (w72.class) {
                    if (c == null) {
                        c = new w72();
                    }
                }
            }
            return c;
        }
        return (w72) invokeV.objValue;
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

    public void b(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).d(r72Var);
        }
    }

    public void c(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).b(r72Var);
        }
    }

    public void d(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).f(r72Var);
        }
    }

    public void e(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).c(r72Var);
        }
    }

    public void f(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).g(r72Var);
        }
    }

    public void g(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).a(r72Var);
        }
    }

    public void h(r72 r72Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, r72Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((a82) obj).e(r72Var);
        }
    }
}
