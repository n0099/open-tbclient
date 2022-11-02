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
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FutureTask<Void> DISPOSED;
    public static final FutureTask<Void> FINISHED;
    public static final long serialVersionUID = 1811839108042568751L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable runnable;
    public Thread runner;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1799297127, "Lio/reactivex/internal/schedulers/AbstractDirectTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1799297127, "Lio/reactivex/internal/schedulers/AbstractDirectTask;");
                return;
            }
        }
        FINISHED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
        DISPOSED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Future<?> future;
        FutureTask<Void> futureTask;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (future = get()) != FINISHED && future != (futureTask = DISPOSED) && compareAndSet(future, futureTask) && future != null) {
            if (this.runner != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            future.cancel(z);
        }
    }

    public AbstractDirectTask(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.runnable = runnable;
    }

    @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
    public Runnable getWrappedRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.runnable;
        }
        return (Runnable) invokeV.objValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Future<?> future = get();
            if (future != FINISHED && future != DISPOSED) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, future) == null) {
            do {
                future2 = get();
                if (future2 != FINISHED) {
                    if (future2 == DISPOSED) {
                        if (this.runner != Thread.currentThread()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        future.cancel(z);
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(future2, future));
        }
    }
}
