package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ExecutionSequencer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<ListenableFuture<Object>> ref;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RunningState {
        public static final /* synthetic */ RunningState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RunningState CANCELLED;
        public static final RunningState NOT_RUN;
        public static final RunningState STARTED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-754136111, "Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-754136111, "Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;");
                    return;
                }
            }
            NOT_RUN = new RunningState("NOT_RUN", 0);
            CANCELLED = new RunningState("CANCELLED", 1);
            RunningState runningState = new RunningState("STARTED", 2);
            STARTED = runningState;
            $VALUES = new RunningState[]{NOT_RUN, CANCELLED, runningState};
        }

        public RunningState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RunningState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RunningState) Enum.valueOf(RunningState.class, str) : (RunningState) invokeL.objValue;
        }

        public static RunningState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RunningState[]) $VALUES.clone() : (RunningState[]) invokeV.objValue;
        }
    }

    public ExecutionSequencer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ref = new AtomicReference<>(Futures.immediateFuture(null));
    }

    public static ExecutionSequencer create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new ExecutionSequencer() : (ExecutionSequencer) invokeV.objValue;
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, callable, executor)) == null) {
            n.p(callable);
            return submitAsync(new AsyncCallable<T>(this, callable) { // from class: com.google.common.util.concurrent.ExecutionSequencer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExecutionSequencer this$0;
                public final /* synthetic */ Callable val$callable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callable};
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
                    this.val$callable = callable;
                }

                @Override // com.google.common.util.concurrent.AsyncCallable
                public ListenableFuture<T> call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Futures.immediateFuture(this.val$callable.call()) : (ListenableFuture) invokeV.objValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$callable.toString() : (String) invokeV.objValue;
                }
            }, executor);
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> asyncCallable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, asyncCallable, executor)) == null) {
            n.p(asyncCallable);
            AtomicReference atomicReference = new AtomicReference(RunningState.NOT_RUN);
            AsyncCallable<T> asyncCallable2 = new AsyncCallable<T>(this, atomicReference, asyncCallable) { // from class: com.google.common.util.concurrent.ExecutionSequencer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExecutionSequencer this$0;
                public final /* synthetic */ AsyncCallable val$callable;
                public final /* synthetic */ AtomicReference val$runningState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, atomicReference, asyncCallable};
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
                    this.val$runningState = atomicReference;
                    this.val$callable = asyncCallable;
                }

                @Override // com.google.common.util.concurrent.AsyncCallable
                public ListenableFuture<T> call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (!this.val$runningState.compareAndSet(RunningState.NOT_RUN, RunningState.STARTED)) {
                            return Futures.immediateCancelledFuture();
                        }
                        return this.val$callable.call();
                    }
                    return (ListenableFuture) invokeV.objValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$callable.toString() : (String) invokeV.objValue;
                }
            };
            SettableFuture create = SettableFuture.create();
            ListenableFuture<Object> andSet = this.ref.getAndSet(create);
            ListenableFuture submitAsync = Futures.submitAsync(asyncCallable2, new Executor(this, andSet, executor) { // from class: com.google.common.util.concurrent.ExecutionSequencer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExecutionSequencer this$0;
                public final /* synthetic */ Executor val$executor;
                public final /* synthetic */ ListenableFuture val$oldFuture;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, andSet, executor};
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
                    this.val$oldFuture = andSet;
                    this.val$executor = executor;
                }

                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                        this.val$oldFuture.addListener(runnable, this.val$executor);
                    }
                }
            });
            ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(submitAsync);
            Runnable runnable = new Runnable(this, submitAsync, nonCancellationPropagating, atomicReference, create, andSet) { // from class: com.google.common.util.concurrent.ExecutionSequencer.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExecutionSequencer this$0;
                public final /* synthetic */ SettableFuture val$newFuture;
                public final /* synthetic */ ListenableFuture val$oldFuture;
                public final /* synthetic */ ListenableFuture val$outputFuture;
                public final /* synthetic */ AtomicReference val$runningState;
                public final /* synthetic */ ListenableFuture val$taskFuture;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, submitAsync, nonCancellationPropagating, atomicReference, create, andSet};
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
                    this.val$taskFuture = submitAsync;
                    this.val$outputFuture = nonCancellationPropagating;
                    this.val$runningState = atomicReference;
                    this.val$newFuture = create;
                    this.val$oldFuture = andSet;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$taskFuture.isDone() || (this.val$outputFuture.isCancelled() && this.val$runningState.compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED))) {
                            this.val$newFuture.setFuture(this.val$oldFuture);
                        }
                    }
                }
            };
            nonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
            submitAsync.addListener(runnable, MoreExecutors.directExecutor());
            return nonCancellationPropagating;
        }
        return (ListenableFuture) invokeLL.objValue;
    }
}
