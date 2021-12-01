package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.a.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public final class Callables {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Callables() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, callable, listeningExecutorService)) == null) {
            n.p(callable);
            n.p(listeningExecutorService);
            return new AsyncCallable<T>(listeningExecutorService, callable) { // from class: com.google.common.util.concurrent.Callables.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ ListeningExecutorService val$listeningExecutorService;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {listeningExecutorService, callable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listeningExecutorService = listeningExecutorService;
                    this.val$callable = callable;
                }

                @Override // com.google.common.util.concurrent.AsyncCallable
                public ListenableFuture<T> call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$listeningExecutorService.submit(this.val$callable) : (ListenableFuture) invokeV.objValue;
                }
            };
        }
        return (AsyncCallable) invokeLL.objValue;
    }

    public static <T> Callable<T> returning(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? new Callable<T>(t) { // from class: com.google.common.util.concurrent.Callables.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object val$value;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$value = t;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
            @Override // java.util.concurrent.Callable
            public T call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$value : invokeV.objValue;
            }
        } : (Callable) invokeL.objValue;
    }

    public static <T> Callable<T> threadRenaming(Callable<T> callable, r<String> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, callable, rVar)) == null) {
            n.p(rVar);
            n.p(callable);
            return new Callable<T>(rVar, callable) { // from class: com.google.common.util.concurrent.Callables.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ r val$nameSupplier;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rVar, callable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$nameSupplier = rVar;
                    this.val$callable = callable;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Thread currentThread = Thread.currentThread();
                        String name = currentThread.getName();
                        boolean trySetName = Callables.trySetName((String) this.val$nameSupplier.get(), currentThread);
                        try {
                            return this.val$callable.call();
                        } finally {
                            if (trySetName) {
                                Callables.trySetName(name, currentThread);
                            }
                        }
                    }
                    return invokeV.objValue;
                }
            };
        }
        return (Callable) invokeLL.objValue;
    }

    public static boolean trySetName(String str, Thread thread) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, thread)) == null) {
            try {
                thread.setName(str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Runnable threadRenaming(Runnable runnable, r<String> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable, rVar)) == null) {
            n.p(rVar);
            n.p(runnable);
            return new Runnable(rVar, runnable) { // from class: com.google.common.util.concurrent.Callables.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r val$nameSupplier;
                public final /* synthetic */ Runnable val$task;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rVar, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$nameSupplier = rVar;
                    this.val$task = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Thread currentThread = Thread.currentThread();
                        String name = currentThread.getName();
                        boolean trySetName = Callables.trySetName((String) this.val$nameSupplier.get(), currentThread);
                        try {
                            this.val$task.run();
                        } finally {
                            if (trySetName) {
                                Callables.trySetName(name, currentThread);
                            }
                        }
                    }
                }
            };
        }
        return (Runnable) invokeLL.objValue;
    }
}
