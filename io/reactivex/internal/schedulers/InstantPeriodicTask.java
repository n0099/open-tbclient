package io.reactivex.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public static final FutureTask<Void> CANCELLED;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService executor;
    public final AtomicReference<Future<?>> first;
    public final AtomicReference<Future<?>> rest;
    public Thread runner;
    public final Runnable task;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1744338260, "Lio/reactivex/internal/schedulers/InstantPeriodicTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1744338260, "Lio/reactivex/internal/schedulers/InstantPeriodicTask;");
                return;
            }
        }
        CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    }

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable, executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.task = runnable;
        this.first = new AtomicReference<>();
        this.rest = new AtomicReference<>();
        this.executor = executorService;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Future<?> andSet = this.first.getAndSet(CANCELLED);
            if (andSet != null && andSet != CANCELLED) {
                andSet.cancel(this.runner != Thread.currentThread());
            }
            Future<?> andSet2 = this.rest.getAndSet(CANCELLED);
            if (andSet2 == null || andSet2 == CANCELLED) {
                return;
            }
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.first.get() == CANCELLED : invokeV.booleanValue;
    }

    public void setFirst(Future<?> future) {
        Future<?> future2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, future) == null) {
            do {
                future2 = this.first.get();
                if (future2 == CANCELLED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } while (!this.first.compareAndSet(future2, future));
        }
    }

    public void setRest(Future<?> future) {
        Future<?> future2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, future) == null) {
            do {
                future2 = this.rest.get();
                if (future2 == CANCELLED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } while (!this.rest.compareAndSet(future2, future));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.runner = Thread.currentThread();
            try {
                this.task.run();
                setRest(this.executor.submit(this));
                this.runner = null;
            } catch (Throwable th) {
                this.runner = null;
                RxJavaPlugins.onError(th);
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
