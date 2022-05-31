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
public final class u62 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u62 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<y62> b;

    public u62() {
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

    public static u62 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (u62.class) {
                    if (c == null) {
                        c = new u62();
                    }
                }
            }
            return c;
        }
        return (u62) invokeV.objValue;
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

    public void b(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).d(p62Var);
        }
    }

    public void c(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).b(p62Var);
        }
    }

    public void d(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).f(p62Var);
        }
    }

    public void e(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).c(p62Var);
        }
    }

    public void f(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).g(p62Var);
        }
    }

    public void g(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).a(p62Var);
        }
    }

    public void h(p62 p62Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, p62Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((y62) obj).e(p62Var);
        }
    }
}
