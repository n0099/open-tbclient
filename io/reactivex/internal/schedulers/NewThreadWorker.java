package io.reactivex.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean disposed;
    public final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.executor = SchedulerPoolFactory.create(threadFactory);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.disposed) {
            return;
        }
        this.disposed = true;
        this.executor.shutdownNow();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.disposed : invokeV.booleanValue;
    }

    @Override // io.reactivex.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable)) == null) ? schedule(runnable, 0L, null) : (Disposable) invokeL.objValue;
    }

    @NonNull
    public ScheduledRunnable scheduleActual(Runnable runnable, long j2, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j2), timeUnit, disposableContainer})) == null) {
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
            if (disposableContainer == null || disposableContainer.add(scheduledRunnable)) {
                try {
                    if (j2 <= 0) {
                        schedule = this.executor.submit((Callable) scheduledRunnable);
                    } else {
                        schedule = this.executor.schedule((Callable) scheduledRunnable, j2, timeUnit);
                    }
                    scheduledRunnable.setFuture(schedule);
                } catch (RejectedExecutionException e2) {
                    if (disposableContainer != null) {
                        disposableContainer.remove(scheduledRunnable);
                    }
                    RxJavaPlugins.onError(e2);
                }
                return scheduledRunnable;
            }
            return scheduledRunnable;
        }
        return (ScheduledRunnable) invokeCommon.objValue;
    }

    public Disposable scheduleDirect(Runnable runnable, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{runnable, Long.valueOf(j2), timeUnit})) == null) {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
            try {
                if (j2 <= 0) {
                    schedule = this.executor.submit(scheduledDirectTask);
                } else {
                    schedule = this.executor.schedule(scheduledDirectTask, j2, timeUnit);
                }
                scheduledDirectTask.setFuture(schedule);
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.onError(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        return (Disposable) invokeCommon.objValue;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{runnable, Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) {
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (j3 <= 0) {
                InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(onSchedule, this.executor);
                try {
                    if (j2 <= 0) {
                        schedule = this.executor.submit(instantPeriodicTask);
                    } else {
                        schedule = this.executor.schedule(instantPeriodicTask, j2, timeUnit);
                    }
                    instantPeriodicTask.setFirst(schedule);
                    return instantPeriodicTask;
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
            try {
                scheduledDirectPeriodicTask.setFuture(this.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e3) {
                RxJavaPlugins.onError(e3);
                return EmptyDisposable.INSTANCE;
            }
        }
        return (Disposable) invokeCommon.objValue;
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.disposed) {
            return;
        }
        this.disposed = true;
        this.executor.shutdown();
    }

    @Override // io.reactivex.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j2), timeUnit})) == null) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return scheduleActual(runnable, j2, timeUnit, null);
        }
        return (Disposable) invokeCommon.objValue;
    }
}
