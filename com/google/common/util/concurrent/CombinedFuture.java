package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AsyncCallable<V> callable;
        public final /* synthetic */ CombinedFuture this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, AsyncCallable<V> asyncCallable, Executor executor) {
            super(combinedFuture, executor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinedFuture, asyncCallable, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((CombinedFuture) objArr2[0], (Executor) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = combinedFuture;
            n.p(asyncCallable);
            this.callable = asyncCallable;
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object obj) {
            setValue((ListenableFuture) ((ListenableFuture) obj));
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.callable.toString() : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.thrownByExecute = false;
                ListenableFuture<V> call = this.callable.call();
                n.r(call, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
                return call;
            }
            return (ListenableFuture) invokeV.objValue;
        }

        public void setValue(ListenableFuture<V> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listenableFuture) == null) {
                this.this$0.setFuture(listenableFuture);
                this.this$0.releaseResources();
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callable<V> callable;
        public final /* synthetic */ CombinedFuture this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallableInterruptibleTask(CombinedFuture combinedFuture, Callable<V> callable, Executor executor) {
            super(combinedFuture, executor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinedFuture, callable, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((CombinedFuture) objArr2[0], (Executor) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = combinedFuture;
            n.p(callable);
            this.callable = callable;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.thrownByExecute = false;
                return this.callable.call();
            }
            return (V) invokeV.objValue;
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                this.this$0.set(v);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.callable.toString() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor listenerExecutor;
        public final /* synthetic */ CombinedFuture this$0;
        public boolean thrownByExecute;

        public CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinedFuture, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = combinedFuture;
            this.thrownByExecute = true;
            n.p(executor);
            this.listenerExecutor = executor;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, th) == null) {
                if (th != null) {
                    if (th instanceof ExecutionException) {
                        this.this$0.setException(th.getCause());
                        return;
                    } else if (th instanceof CancellationException) {
                        this.this$0.cancel(false);
                        return;
                    } else {
                        this.this$0.setException(th);
                        return;
                    }
                }
                setValue(t);
            }
        }

        public final void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.listenerExecutor.execute(this);
                } catch (RejectedExecutionException e2) {
                    if (this.thrownByExecute) {
                        this.this$0.setException(e2);
                    }
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.isDone() : invokeV.booleanValue;
        }

        public abstract void setValue(T t);
    }

    /* loaded from: classes2.dex */
    public final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CombinedFutureInterruptibleTask task;
        public final /* synthetic */ CombinedFuture this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CombinedFutureRunningState(CombinedFuture combinedFuture, ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(combinedFuture, immutableCollection, z, false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinedFuture, immutableCollection, Boolean.valueOf(z), combinedFutureInterruptibleTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AggregateFuture) objArr2[0], (ImmutableCollection) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = combinedFuture;
            this.task = combinedFutureInterruptibleTask;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void collectOneValue(boolean z, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), obj}) == null) {
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void handleAllCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
                if (combinedFutureInterruptibleTask != null) {
                    combinedFutureInterruptibleTask.execute();
                } else {
                    n.w(this.this$0.isDone());
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void interruptTask() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (combinedFutureInterruptibleTask = this.task) == null) {
                return;
            }
            combinedFutureInterruptibleTask.interruptTask();
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.releaseResourcesAfterFailure();
                this.task = null;
            }
        }
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, AsyncCallable<V> asyncCallable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableCollection, Boolean.valueOf(z), executor, asyncCallable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(new CombinedFutureRunningState(this, immutableCollection, z, new AsyncCallableInterruptibleTask(this, asyncCallable, executor)));
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, Callable<V> callable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableCollection, Boolean.valueOf(z), executor, callable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(new CombinedFutureRunningState(this, immutableCollection, z, new CallableInterruptibleTask(this, callable, executor)));
    }
}
