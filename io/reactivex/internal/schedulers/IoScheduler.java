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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class IoScheduler extends Scheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final RxThreadFactory EVICTOR_THREAD_FACTORY;
    public static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    public static final long KEEP_ALIVE_TIME = 60;
    public static final TimeUnit KEEP_ALIVE_UNIT;
    public static final String KEY_IO_PRIORITY = "rx2.io-priority";
    public static final CachedWorkerPool NONE;
    public static final ThreadWorker SHUTDOWN_THREAD_WORKER;
    public static final RxThreadFactory WORKER_THREAD_FACTORY;
    public static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference pool;
    public final ThreadFactory threadFactory;

    /* loaded from: classes8.dex */
    public final class CachedWorkerPool implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompositeDisposable allWorkers;
        public final ScheduledExecutorService evictorService;
        public final Future evictorTask;
        public final ConcurrentLinkedQueue expiringWorkerQueue;
        public final long keepAliveTime;
        public final ThreadFactory threadFactory;

        public CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j2;
            ScheduledFuture<?> scheduledFuture;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit, threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            this.keepAliveTime = j2;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
                long j3 = this.keepAliveTime;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        public void evictExpiredWorkers() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.expiringWorkerQueue.isEmpty()) {
                long now = now();
                Iterator it = this.expiringWorkerQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker threadWorker = (ThreadWorker) it.next();
                    if (threadWorker.getExpirationTime() <= now) {
                        if (this.expiringWorkerQueue.remove(threadWorker)) {
                            this.allWorkers.remove(threadWorker);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public ThreadWorker get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.allWorkers.isDisposed()) {
                    return IoScheduler.SHUTDOWN_THREAD_WORKER;
                }
                while (!this.expiringWorkerQueue.isEmpty()) {
                    ThreadWorker threadWorker = (ThreadWorker) this.expiringWorkerQueue.poll();
                    if (threadWorker != null) {
                        return threadWorker;
                    }
                }
                ThreadWorker threadWorker2 = new ThreadWorker(this.threadFactory);
                this.allWorkers.add(threadWorker2);
                return threadWorker2;
            }
            return (ThreadWorker) invokeV.objValue;
        }

        public long now() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return System.nanoTime();
            }
            return invokeV.longValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                evictExpiredWorkers();
            }
        }

        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.allWorkers.dispose();
                Future future = this.evictorTask;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.evictorService;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            }
        }

        public void release(ThreadWorker threadWorker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, threadWorker) == null) {
                threadWorker.setExpirationTime(now() + this.keepAliveTime);
                this.expiringWorkerQueue.offer(threadWorker);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class EventLoopWorker extends Scheduler.Worker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean once;
        public final CachedWorkerPool pool;
        public final CompositeDisposable tasks;
        public final ThreadWorker threadWorker;

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cachedWorkerPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.once = new AtomicBoolean();
            this.pool = cachedWorkerPool;
            this.tasks = new CompositeDisposable();
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                this.pool.release(this.threadWorker);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.once.get();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
                if (this.tasks.isDisposed()) {
                    return EmptyDisposable.INSTANCE;
                }
                return this.threadWorker.scheduleActual(runnable, j, timeUnit, this.tasks);
            }
            return (Disposable) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ThreadWorker extends NewThreadWorker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long expirationTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ThreadFactory) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.expirationTime;
            }
            return invokeV.longValue;
        }

        public void setExpirationTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.expirationTime = j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475725880, "Lio/reactivex/internal/schedulers/IoScheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(475725880, "Lio/reactivex/internal/schedulers/IoScheduler;");
                return;
            }
        }
        KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        SHUTDOWN_THREAD_WORKER = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        WORKER_THREAD_FACTORY = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, max);
        EVICTOR_THREAD_FACTORY = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, WORKER_THREAD_FACTORY);
        NONE = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IoScheduler() {
        this(WORKER_THREAD_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((ThreadFactory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new EventLoopWorker((CachedWorkerPool) this.pool.get());
        }
        return (Scheduler.Worker) invokeV.objValue;
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                cachedWorkerPool = (CachedWorkerPool) this.pool.get();
                cachedWorkerPool2 = NONE;
                if (cachedWorkerPool == cachedWorkerPool2) {
                    return;
                }
            } while (!this.pool.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
            cachedWorkerPool.shutdown();
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((CachedWorkerPool) this.pool.get()).allWorkers.size();
        }
        return invokeV.intValue;
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(60L, KEEP_ALIVE_UNIT, this.threadFactory);
            if (!this.pool.compareAndSet(NONE, cachedWorkerPool)) {
                cachedWorkerPool.shutdown();
            }
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference(NONE);
        start();
    }
}
