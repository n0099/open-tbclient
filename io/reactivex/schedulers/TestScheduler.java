package io.reactivex.schedulers;

import com.baidu.android.imsdk.internal.Constants;
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
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class TestScheduler extends Scheduler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long counter;
    public final Queue<TimedRunnable> queue;
    public volatile long time;

    /* loaded from: classes3.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long count;
        public final Runnable run;
        public final TestWorker scheduler;
        public final long time;

        public TimedRunnable(TestWorker testWorker, long j2, Runnable runnable, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {testWorker, Long.valueOf(j2), runnable, Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.time = j2;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j3;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.time), this.run.toString()) : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timedRunnable)) == null) {
                long j2 = this.time;
                long j3 = timedRunnable.time;
                if (j2 == j3) {
                    return ObjectHelper.compare(this.count, timedRunnable.count);
                }
                return ObjectHelper.compare(j2, j3);
            }
            return invokeL.intValue;
        }
    }

    public TestScheduler() {
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
        this.queue = new PriorityBlockingQueue(11);
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, timeUnit) == null) {
            advanceTimeTo(this.time + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
        }
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit) == null) {
            triggerActions(timeUnit.toNanos(j2));
        }
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new TestWorker(this) : (Scheduler.Worker) invokeV.objValue;
    }

    @Override // io.reactivex.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, timeUnit)) == null) ? timeUnit.convert(this.time, TimeUnit.NANOSECONDS) : invokeL.longValue;
    }

    public void triggerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            triggerActions(this.time);
        }
    }

    private void triggerActions(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            while (true) {
                TimedRunnable peek = this.queue.peek();
                if (peek == null) {
                    break;
                }
                long j3 = peek.time;
                if (j3 > j2) {
                    break;
                }
                if (j3 == 0) {
                    j3 = this.time;
                }
                this.time = j3;
                this.queue.remove(peek);
                if (!peek.scheduler.disposed) {
                    peek.run.run();
                }
            }
            this.time = j2;
        }
    }

    public TestScheduler(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), timeUnit};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.queue = new PriorityBlockingQueue(11);
        this.time = timeUnit.toNanos(j2);
    }

    /* loaded from: classes3.dex */
    public final class TestWorker extends Scheduler.Worker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean disposed;
        public final /* synthetic */ TestScheduler this$0;

        /* loaded from: classes3.dex */
        public final class QueueRemove implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TestWorker this$1;
            public final TimedRunnable timedAction;

            public QueueRemove(TestWorker testWorker, TimedRunnable timedRunnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {testWorker, timedRunnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = testWorker;
                this.timedAction = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$1.this$0.queue.remove(this.timedAction);
                }
            }
        }

        public TestWorker(TestScheduler testScheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {testScheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = testScheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.disposed : invokeV.booleanValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@NonNull TimeUnit timeUnit) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, timeUnit)) == null) ? this.this$0.now(timeUnit) : invokeL.longValue;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j2), timeUnit})) == null) {
                if (this.disposed) {
                    return EmptyDisposable.INSTANCE;
                }
                long nanos = this.this$0.time + timeUnit.toNanos(j2);
                TestScheduler testScheduler = this.this$0;
                long j3 = testScheduler.counter;
                testScheduler.counter = 1 + j3;
                TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j3);
                this.this$0.queue.add(timedRunnable);
                return Disposables.fromRunnable(new QueueRemove(this, timedRunnable));
            }
            return (Disposable) invokeCommon.objValue;
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
                TestScheduler testScheduler = this.this$0;
                long j2 = testScheduler.counter;
                testScheduler.counter = 1 + j2;
                TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j2);
                this.this$0.queue.add(timedRunnable);
                return Disposables.fromRunnable(new QueueRemove(this, timedRunnable));
            }
            return (Disposable) invokeL.objValue;
        }
    }
}
