package io.reactivex.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ExecutorScheduler extends Scheduler {
    public static /* synthetic */ Interceptable $ic;
    public static final Scheduler HELPER;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Executor executor;

    /* loaded from: classes3.dex */
    public final class DelayedDispose implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DelayedRunnable dr;
        public final /* synthetic */ ExecutorScheduler this$0;

        public DelayedDispose(ExecutorScheduler executorScheduler, DelayedRunnable delayedRunnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executorScheduler, delayedRunnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = executorScheduler;
            this.dr = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DelayedRunnable delayedRunnable = this.dr;
                delayedRunnable.direct.replace(this.this$0.scheduleDirect(delayedRunnable));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4101336210206799084L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SequentialDisposable direct;
        public final SequentialDisposable timed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getAndSet(null) == null) {
                return;
            }
            this.timed.dispose();
            this.direct.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Runnable runnable = get();
                return runnable != null ? runnable : Functions.EMPTY_RUNNABLE;
            }
            return (Runnable) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() == null : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (runnable = get()) == null) {
                return;
            }
            try {
                runnable.run();
            } finally {
                lazySet(null);
                this.timed.lazySet(DisposableHelper.DISPOSED);
                this.direct.lazySet(DisposableHelper.DISPOSED);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1294171611, "Lio/reactivex/internal/schedulers/ExecutorScheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1294171611, "Lio/reactivex/internal/schedulers/ExecutorScheduler;");
                return;
            }
        }
        HELPER = Schedulers.single();
    }

    public ExecutorScheduler(@NonNull Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.executor = executor;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ExecutorWorker(this.executor) : (Scheduler.Worker) invokeV.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            try {
                if (this.executor instanceof ExecutorService) {
                    ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                    scheduledDirectTask.setFuture(((ExecutorService) this.executor).submit(scheduledDirectTask));
                    return scheduledDirectTask;
                }
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(onSchedule);
                this.executor.execute(booleanRunnable);
                return booleanRunnable;
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.onError(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        return (Disposable) invokeL.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            if (this.executor instanceof ScheduledExecutorService) {
                try {
                    ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable));
                    scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                    return scheduledDirectPeriodicTask;
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        return (Disposable) invokeCommon.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.executor instanceof ScheduledExecutorService) {
                try {
                    ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                    scheduledDirectTask.setFuture(((ScheduledExecutorService) this.executor).schedule(scheduledDirectTask, j, timeUnit));
                    return scheduledDirectTask;
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            DelayedRunnable delayedRunnable = new DelayedRunnable(onSchedule);
            delayedRunnable.timed.replace(HELPER.scheduleDirect(new DelayedDispose(this, delayedRunnable), j, timeUnit));
            return delayedRunnable;
        }
        return (Disposable) invokeCommon.objValue;
    }

    /* loaded from: classes3.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean disposed;
        public final Executor executor;
        public final MpscLinkedQueue<Runnable> queue;
        public final CompositeDisposable tasks;
        public final AtomicInteger wip;

        /* loaded from: classes3.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -2421395018820541164L;
            public transient /* synthetic */ FieldHolder $fh;
            public final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    lazySet(true);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() : invokeV.booleanValue;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* loaded from: classes3.dex */
        public final class SequentialDispose implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Runnable decoratedRun;
            public final SequentialDisposable mar;
            public final /* synthetic */ ExecutorWorker this$0;

            public SequentialDispose(ExecutorWorker executorWorker, SequentialDisposable sequentialDisposable, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {executorWorker, sequentialDisposable, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = executorWorker;
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.mar.replace(this.this$0.schedule(this.decoratedRun));
                }
            }
        }

        public ExecutorWorker(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wip = new AtomicInteger();
            this.tasks = new CompositeDisposable();
            this.executor = executor;
            this.queue = new MpscLinkedQueue<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.disposed) {
                return;
            }
            this.disposed = true;
            this.tasks.dispose();
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.disposed : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
            if (r4.disposed == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
            r1 = r4.wip.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
            if (r1 != 0) goto L4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
                int i2 = 1;
                while (!this.disposed) {
                    while (true) {
                        Runnable poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            break;
                        }
                        poll.run();
                        if (this.disposed) {
                            mpscLinkedQueue.clear();
                            return;
                        }
                    }
                }
                mpscLinkedQueue.clear();
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                BooleanRunnable booleanRunnable = new BooleanRunnable(RxJavaPlugins.onSchedule(runnable));
                this.queue.offer(booleanRunnable);
                if (this.wip.getAndIncrement() == 0) {
                    try {
                        this.executor.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.disposed = true;
                        this.queue.clear();
                        RxJavaPlugins.onError(e2);
                        return EmptyDisposable.INSTANCE;
                    }
                }
                return booleanRunnable;
            }
            return (Disposable) invokeL.objValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return schedule(runnable);
                }
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(this, sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.tasks);
                this.tasks.add(scheduledRunnable);
                Executor executor = this.executor;
                if (executor instanceof ScheduledExecutorService) {
                    try {
                        scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                    } catch (RejectedExecutionException e2) {
                        this.disposed = true;
                        RxJavaPlugins.onError(e2);
                        return EmptyDisposable.INSTANCE;
                    }
                } else {
                    scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect(scheduledRunnable, j, timeUnit)));
                }
                sequentialDisposable.replace(scheduledRunnable);
                return sequentialDisposable2;
            }
            return (Disposable) invokeCommon.objValue;
        }
    }
}
