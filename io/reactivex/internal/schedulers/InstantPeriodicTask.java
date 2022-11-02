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
/* loaded from: classes8.dex */
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

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.first.get() == CANCELLED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable, executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Future<?> andSet = this.first.getAndSet(CANCELLED);
            boolean z2 = true;
            if (andSet != null && andSet != CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                andSet.cancel(z);
            }
            Future<?> andSet2 = this.rest.getAndSet(CANCELLED);
            if (andSet2 != null && andSet2 != CANCELLED) {
                if (this.runner == Thread.currentThread()) {
                    z2 = false;
                }
                andSet2.cancel(z2);
            }
        }
    }

    public void setFirst(Future<?> future) {
        Future<?> future2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, future) == null) {
            do {
                future2 = this.first.get();
                if (future2 == CANCELLED) {
                    if (this.runner != Thread.currentThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    future.cancel(z);
                    return;
                }
            } while (!this.first.compareAndSet(future2, future));
        }
    }

    public void setRest(Future<?> future) {
        Future<?> future2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, future) == null) {
            do {
                future2 = this.rest.get();
                if (future2 == CANCELLED) {
                    if (this.runner != Thread.currentThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    future.cancel(z);
                    return;
                }
            } while (!this.rest.compareAndSet(future2, future));
        }
    }
}
