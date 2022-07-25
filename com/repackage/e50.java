package com.repackage;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i50;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class e50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    @Nullable
    public Runnable c;
    @Nullable
    public Executor d;
    public final Deque<i50.a> e;
    public final Deque<i50.a> f;
    public final Deque<i50> g;

    public e50(Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 64;
        this.b = 5;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        this.d = executor;
    }

    public synchronized void a(i50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (this.f.size() < this.a && i(aVar) < this.b) {
                    this.f.add(aVar);
                    c().execute(aVar);
                } else {
                    this.e.add(aVar);
                }
            }
        }
    }

    public synchronized void b(i50 i50Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i50Var) == null) {
            synchronized (this) {
                this.g.add(i50Var);
            }
        }
    }

    public synchronized Executor c() {
        InterceptResult invokeV;
        Executor executor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BaiduNetwork Dispatcher", false));
                }
                executor = this.d;
            }
            return executor;
        }
        return (Executor) invokeV.objValue;
    }

    public void d(i50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            f(this.f, aVar, true);
        }
    }

    public void e(i50 i50Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i50Var) == null) {
            f(this.g, i50Var, false);
        }
    }

    public final <T> void f(Deque<T> deque, T t, boolean z) {
        int h;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, deque, t, z) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    if (z) {
                        g();
                    }
                    h = h();
                    runnable = this.c;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            if (h != 0 || runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f.size() >= this.a || this.e.isEmpty()) {
            return;
        }
        Iterator<i50.a> it = this.e.iterator();
        while (it.hasNext()) {
            i50.a next = it.next();
            if (i(next) < this.b) {
                it.remove();
                this.f.add(next);
                c().execute(next);
            }
            if (this.f.size() >= this.a) {
                return;
            }
        }
    }

    public synchronized int h() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.f.size() + this.g.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public final int i(i50.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) {
            int i = 0;
            for (i50.a aVar2 : this.f) {
                if (!aVar2.b().c && aVar2.c().equals(aVar.c())) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public e50() {
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
        this.a = 64;
        this.b = 5;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
    }
}
