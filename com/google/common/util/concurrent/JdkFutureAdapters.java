package com.google.common.util.concurrent;

import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public final class JdkFutureAdapters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        public static /* synthetic */ Interceptable $ic;
        public static final Executor defaultAdapterExecutor;
        public static final ThreadFactory threadFactory;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor adapterExecutor;
        public final Future<V> delegate;
        public final ExecutionList executionList;
        public final AtomicBoolean hasListeners;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1652805839, "Lcom/google/common/util/concurrent/JdkFutureAdapters$ListenableFutureAdapter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1652805839, "Lcom/google/common/util/concurrent/JdkFutureAdapters$ListenableFutureAdapter;");
                    return;
                }
            }
            ThreadFactory build = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            threadFactory = build;
            defaultAdapterExecutor = Executors.newCachedThreadPool(build);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ListenableFutureAdapter(Future<V> future) {
            this(future, defaultAdapterExecutor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {future};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Future) objArr2[0], (Executor) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
                this.executionList.add(runnable, executor);
                if (this.hasListeners.compareAndSet(false, true)) {
                    if (this.delegate.isDone()) {
                        this.executionList.execute();
                    } else {
                        this.adapterExecutor.execute(new Runnable(this) { // from class: com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ListenableFutureAdapter this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        Uninterruptibles.getUninterruptibly(this.this$0.delegate);
                                    } catch (Throwable unused) {
                                    }
                                    this.this$0.executionList.execute();
                                }
                            }
                        });
                    }
                }
            }
        }

        public ListenableFutureAdapter(Future<V> future, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {future, executor};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.executionList = new ExecutionList();
            this.hasListeners = new AtomicBoolean(false);
            n.p(future);
            this.delegate = future;
            n.p(executor);
            this.adapterExecutor = executor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.ForwardingFuture, b.h.d.c.h0
        public Future<V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delegate : (Future) invokeV.objValue;
        }
    }

    public JdkFutureAdapters() {
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

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, future)) == null) {
            if (future instanceof ListenableFuture) {
                return (ListenableFuture) future;
            }
            return new ListenableFutureAdapter(future);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, future, executor)) == null) {
            n.p(executor);
            if (future instanceof ListenableFuture) {
                return (ListenableFuture) future;
            }
            return new ListenableFutureAdapter(future, executor);
        }
        return (ListenableFuture) invokeLL.objValue;
    }
}
