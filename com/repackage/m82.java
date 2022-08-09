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
public final class m82 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m82 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<q82> b;

    public m82() {
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

    public static m82 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (m82.class) {
                    if (c == null) {
                        c = new m82();
                    }
                }
            }
            return c;
        }
        return (m82) invokeV.objValue;
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

    public void b(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).d(h82Var);
        }
    }

    public void c(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).b(h82Var);
        }
    }

    public void d(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).f(h82Var);
        }
    }

    public void e(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).c(h82Var);
        }
    }

    public void f(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).g(h82Var);
        }
    }

    public void g(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).a(h82Var);
        }
    }

    public void h(h82 h82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, h82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((q82) obj).e(h82Var);
        }
    }
}
