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
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    public static final String KEY_MAX_THREADS = "rx2.computation-threads";
    public static final int MAX_THREADS;
    public static final FixedSchedulerPool NONE;
    public static final PoolWorker SHUTDOWN_WORKER;
    public static final RxThreadFactory THREAD_FACTORY;
    public static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<FixedSchedulerPool> pool;
    public final ThreadFactory threadFactory;

    /* loaded from: classes3.dex */
    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int cores;
        public final PoolWorker[] eventLoops;
        public long n;

        public FixedSchedulerPool(int i2, ThreadFactory threadFactory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cores = i2;
            this.eventLoops = new PoolWorker[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                this.eventLoops[i5] = new PoolWorker(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void createWorkers(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, workerCallback) == null) {
                int i3 = this.cores;
                if (i3 == 0) {
                    for (int i4 = 0; i4 < i2; i4++) {
                        workerCallback.onWorker(i4, ComputationScheduler.SHUTDOWN_WORKER);
                    }
                    return;
                }
                int i5 = ((int) this.n) % i3;
                for (int i6 = 0; i6 < i2; i6++) {
                    workerCallback.onWorker(i6, new EventLoopWorker(this.eventLoops[i5]));
                    i5++;
                    if (i5 == i3) {
                        i5 = 0;
                    }
                }
                this.n = i5;
            }
        }

        public PoolWorker getEventLoop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.cores;
                if (i2 == 0) {
                    return ComputationScheduler.SHUTDOWN_WORKER;
                }
                PoolWorker[] poolWorkerArr = this.eventLoops;
                long j = this.n;
                this.n = 1 + j;
                return poolWorkerArr[(int) (j % i2)];
            }
            return (PoolWorker) invokeV.objValue;
        }

        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                for (PoolWorker poolWorker : this.eventLoops) {
                    poolWorker.dispose();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class PoolWorker extends NewThreadWorker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ThreadFactory) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750279861, "Lio/reactivex/internal/schedulers/ComputationScheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750279861, "Lio/reactivex/internal/schedulers/ComputationScheduler;");
                return;
            }
        }
        MAX_THREADS = cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger(KEY_MAX_THREADS, 0).intValue());
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        THREAD_FACTORY = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        NONE = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComputationScheduler() {
        this(THREAD_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ThreadFactory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int cap(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? (i3 <= 0 || i3 > i2) ? i2 : i3 : invokeII.intValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new EventLoopWorker(this.pool.get().getEventLoop()) : (Scheduler.Worker) invokeV.objValue;
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, workerCallback) == null) {
            ObjectHelper.verifyPositive(i2, "number > 0 required");
            this.pool.get().createWorkers(i2, workerCallback);
        }
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) ? this.pool.get().getEventLoop().scheduleDirect(runnable, j, timeUnit) : (Disposable) invokeCommon.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) ? this.pool.get().getEventLoop().schedulePeriodicallyDirect(runnable, j, j2, timeUnit) : (Disposable) invokeCommon.objValue;
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            do {
                fixedSchedulerPool = this.pool.get();
                fixedSchedulerPool2 = NONE;
                if (fixedSchedulerPool == fixedSchedulerPool2) {
                    return;
                }
            } while (!this.pool.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
            fixedSchedulerPool.shutdown();
        }
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(MAX_THREADS, this.threadFactory);
            if (this.pool.compareAndSet(NONE, fixedSchedulerPool)) {
                return;
            }
            fixedSchedulerPool.shutdown();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference<>(NONE);
        start();
    }

    /* loaded from: classes3.dex */
    public static final class EventLoopWorker extends Scheduler.Worker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ListCompositeDisposable both;
        public volatile boolean disposed;
        public final PoolWorker poolWorker;
        public final ListCompositeDisposable serial;
        public final CompositeDisposable timed;

        public EventLoopWorker(PoolWorker poolWorker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {poolWorker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.poolWorker = poolWorker;
            this.serial = new ListCompositeDisposable();
            this.timed = new CompositeDisposable();
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.both = listCompositeDisposable;
            listCompositeDisposable.add(this.serial);
            this.both.add(this.timed);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.disposed) {
                return;
            }
            this.disposed = true;
            this.both.dispose();
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
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable)) == null) {
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                return this.poolWorker.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.serial);
            }
            return (Disposable) invokeL.objValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                return this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
            }
            return (Disposable) invokeCommon.objValue;
        }
    }
}
