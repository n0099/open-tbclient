package com.facebook.common.executors;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;

    public HandlerExecutorServiceImpl(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeJL.booleanValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            this.mHandler.post(runnable);
        }
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public boolean isHandlerThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Thread.currentThread() == this.mHandler.getLooper().getThread() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Runnable runnable, @Nullable Object obj) {
        return newTaskFor(runnable, (Runnable) obj);
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public void quit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mHandler.getLooper().quit();
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
            ScheduledFutureImpl newTaskFor = newTaskFor(runnable, (Runnable) null);
            this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
            return newTaskFor;
        }
        return (ScheduledFuture) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ScheduledFuture) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ScheduledFuture) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (List) invokeV.objValue;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ScheduledFutureImpl<T> newTaskFor(Runnable runnable, @Nullable T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, runnable, t)) == null) ? new ScheduledFutureImpl<>(this.mHandler, runnable, t) : (ScheduledFutureImpl) invokeLL.objValue;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{callable, Long.valueOf(j), timeUnit})) == null) {
            ScheduledFutureImpl newTaskFor = newTaskFor((Callable) callable);
            this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
            return newTaskFor;
        }
        return (ScheduledFuture) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callable)) == null) ? new ScheduledFutureImpl<>(this.mHandler, callable) : (ScheduledFutureImpl) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ScheduledFuture<?> submit(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, runnable)) == null) ? submit(runnable, (Runnable) null) : (ScheduledFuture) invokeL.objValue;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ScheduledFuture<T> submit(Runnable runnable, @Nullable T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, runnable, t)) == null) {
            if (runnable != null) {
                ScheduledFutureImpl<T> newTaskFor = newTaskFor(runnable, (Runnable) t);
                execute(newTaskFor);
                return newTaskFor;
            }
            throw null;
        }
        return (ScheduledFuture) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, callable)) == null) {
            if (callable != null) {
                ScheduledFutureImpl<T> newTaskFor = newTaskFor((Callable) callable);
                execute(newTaskFor);
                return newTaskFor;
            }
            throw null;
        }
        return (ScheduledFuture) invokeL.objValue;
    }
}
