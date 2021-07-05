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
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class TrampolineScheduler extends Scheduler {
    public static /* synthetic */ Interceptable $ic;
    public static final TrampolineScheduler INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class SleepingRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long execTime;
        public final Runnable run;
        public final TrampolineWorker worker;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, trampolineWorker, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.worker.disposed) {
                return;
            }
            long now = this.worker.now(TimeUnit.MILLISECONDS);
            long j = this.execTime;
            if (j > now) {
                try {
                    Thread.sleep(j - now);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    RxJavaPlugins.onError(e2);
                    return;
                }
            }
            if (this.worker.disposed) {
                return;
            }
            this.run.run();
        }
    }

    /* loaded from: classes10.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int count;
        public volatile boolean disposed;
        public final long execTime;
        public final Runnable run;

        public TimedRunnable(Runnable runnable, Long l, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, l, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.run = runnable;
            this.execTime = l.longValue();
            this.count = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timedRunnable)) == null) {
                int compare = ObjectHelper.compare(this.execTime, timedRunnable.execTime);
                return compare == 0 ? ObjectHelper.compare(this.count, timedRunnable.count) : compare;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger counter;
        public volatile boolean disposed;
        public final PriorityBlockingQueue<TimedRunnable> queue;
        public final AtomicInteger wip;

        /* loaded from: classes10.dex */
        public final class AppendToQueueTask implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TrampolineWorker this$0;
            public final TimedRunnable timedRunnable;

            public AppendToQueueTask(TrampolineWorker trampolineWorker, TimedRunnable timedRunnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {trampolineWorker, timedRunnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = trampolineWorker;
                this.timedRunnable = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.timedRunnable.disposed = true;
                    this.this$0.queue.remove(this.timedRunnable);
                }
            }
        }

        public TrampolineWorker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queue = new PriorityBlockingQueue<>();
            this.wip = new AtomicInteger();
            this.counter = new AtomicInteger();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
            }
        }

        public Disposable enqueue(Runnable runnable, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j)) == null) {
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.counter.incrementAndGet());
                this.queue.add(timedRunnable);
                if (this.wip.getAndIncrement() == 0) {
                    int i2 = 1;
                    while (!this.disposed) {
                        TimedRunnable poll = this.queue.poll();
                        if (poll == null) {
                            i2 = this.wip.addAndGet(-i2);
                            if (i2 == 0) {
                                return EmptyDisposable.INSTANCE;
                            }
                        } else if (!poll.disposed) {
                            poll.run.run();
                        }
                    }
                    this.queue.clear();
                    return EmptyDisposable.INSTANCE;
                }
                return Disposables.fromRunnable(new AppendToQueueTask(this, timedRunnable));
            }
            return (Disposable) invokeLJ.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.disposed : invokeV.booleanValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) ? enqueue(runnable, now(TimeUnit.MILLISECONDS)) : (Disposable) invokeL.objValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
                long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
                return enqueue(new SleepingRunnable(runnable, this, now), now);
            }
            return (Disposable) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479611503, "Lio/reactivex/internal/schedulers/TrampolineScheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479611503, "Lio/reactivex/internal/schedulers/TrampolineScheduler;");
                return;
            }
        }
        INSTANCE = new TrampolineScheduler();
    }

    public TrampolineScheduler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static TrampolineScheduler instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? INSTANCE : (TrampolineScheduler) invokeV.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TrampolineWorker() : (Scheduler.Worker) invokeV.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
            RxJavaPlugins.onSchedule(runnable).run();
            return EmptyDisposable.INSTANCE;
        }
        return (Disposable) invokeL.objValue;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
            try {
                timeUnit.sleep(j);
                RxJavaPlugins.onSchedule(runnable).run();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                RxJavaPlugins.onError(e2);
            }
            return EmptyDisposable.INSTANCE;
        }
        return (Disposable) invokeCommon.objValue;
    }
}
