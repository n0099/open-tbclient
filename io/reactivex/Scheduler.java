package io.reactivex;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public abstract class Scheduler {
    public static /* synthetic */ Interceptable $ic;
    public static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract Worker createWorker();

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class Worker implements Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        /* loaded from: classes8.dex */
        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long count;
            @NonNull
            public final Runnable decoratedRun;
            public long lastNowNanoseconds;
            public final long periodInNanoseconds;
            @NonNull
            public final SequentialDisposable sd;
            public long startInNanoseconds;
            public final /* synthetic */ Worker this$0;

            public PeriodicTask(Worker worker, @NonNull long j, Runnable runnable, @NonNull long j2, SequentialDisposable sequentialDisposable, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {worker, Long.valueOf(j), runnable, Long.valueOf(j2), sequentialDisposable, Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = worker;
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j3;
                this.lastNowNanoseconds = j2;
                this.startInNanoseconds = j;
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.decoratedRun;
                }
                return (Runnable) invokeV.objValue;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.decoratedRun.run();
                    if (!this.sd.isDisposed()) {
                        long now = this.this$0.now(TimeUnit.NANOSECONDS);
                        long j2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                        long j3 = this.lastNowNanoseconds;
                        if (now + j2 >= j3) {
                            long j4 = this.periodInNanoseconds;
                            if (now < j3 + j4 + j2) {
                                long j5 = this.startInNanoseconds;
                                long j6 = this.count + 1;
                                this.count = j6;
                                j = j5 + (j6 * j4);
                                this.lastNowNanoseconds = now;
                                this.sd.replace(this.this$0.schedule(this, j - now, TimeUnit.NANOSECONDS));
                            }
                        }
                        long j7 = this.periodInNanoseconds;
                        long j8 = now + j7;
                        long j9 = this.count + 1;
                        this.count = j9;
                        this.startInNanoseconds = j8 - (j7 * j9);
                        j = j8;
                        this.lastNowNanoseconds = now;
                        this.sd.replace(this.this$0.schedule(this, j - now, TimeUnit.NANOSECONDS));
                    }
                }
            }
        }

        public Worker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timeUnit)) == null) {
                return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            }
            return invokeL.longValue;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
                return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
            }
            return (Disposable) invokeL.objValue;
        }

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
                Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
                long nanos = timeUnit.toNanos(j2);
                long now = now(TimeUnit.NANOSECONDS);
                Disposable schedule = schedule(new PeriodicTask(this, now + timeUnit.toNanos(j), onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
                if (schedule == EmptyDisposable.INSTANCE) {
                    return schedule;
                }
                sequentialDisposable.replace(schedule);
                return sequentialDisposable2;
            }
            return (Disposable) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Runnable decoratedRun;
        public Thread runner;
        public final Worker w;

        public DisposeTask(Runnable runnable, Worker worker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, worker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.decoratedRun = runnable;
            this.w = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.runner == Thread.currentThread()) {
                    Worker worker = this.w;
                    if (worker instanceof NewThreadWorker) {
                        ((NewThreadWorker) worker).shutdown();
                        return;
                    }
                }
                this.w.dispose();
            }
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.decoratedRun;
            }
            return (Runnable) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.w.isDisposed();
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.runner = Thread.currentThread();
                try {
                    this.decoratedRun.run();
                } finally {
                    dispose();
                    this.runner = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public volatile boolean disposed;
        public final Runnable run;
        @NonNull
        public final Worker worker;

        public PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, worker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.run = runnable;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.run;
            }
            return (Runnable) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.disposed;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.worker.dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1615133165, "Lio/reactivex/Scheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1615133165, "Lio/reactivex/Scheduler;");
                return;
            }
        }
        CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public Scheduler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long clockDriftTolerance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
        }
        return invokeV.longValue;
    }

    public long now(@NonNull TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timeUnit)) == null) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return invokeL.longValue;
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable)) == null) {
            return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
        }
        return (Disposable) invokeL.objValue;
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, function)) == null) {
            return new SchedulerWhen(function, this);
        }
        return (S) ((Scheduler) invokeL.objValue);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
            Worker createWorker = createWorker();
            DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
            createWorker.schedule(disposeTask, j, timeUnit);
            return disposeTask;
        }
        return (Disposable) invokeCommon.objValue;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            Worker createWorker = createWorker();
            PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
            Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
            if (schedulePeriodically == EmptyDisposable.INSTANCE) {
                return schedulePeriodically;
            }
            return periodicDirectTask;
        }
        return (Disposable) invokeCommon.objValue;
    }
}
