package io.reactivex.internal.operators.parallel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes9.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int prefetch;
    public final Scheduler scheduler;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: classes9.dex */
    public static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 9222303586456402150L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final SpscArrayQueue<T> queue;
        public final AtomicLong requested;
        public Subscription s;
        public final Scheduler.Worker worker;

        public BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), spscArrayQueue, worker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requested = new AtomicLong();
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        public final void schedule() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.error = th;
                this.done = true;
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, t) != null) || this.done) {
                return;
            }
            if (!this.queue.offer(t)) {
                this.s.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<T>[] parents;
        public final Subscriber<? super T>[] subscribers;
        public final /* synthetic */ ParallelRunOn this$0;

        public MultiWorkerCallback(ParallelRunOn parallelRunOn, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parallelRunOn, subscriberArr, subscriberArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = parallelRunOn;
            this.subscribers = subscriberArr;
            this.parents = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker worker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, worker) == null) {
                this.this$0.createSubscriber(i, this.subscribers, this.parents, worker);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1075119423897941642L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber<? super T> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, Integer.valueOf(i), spscArrayQueue, worker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (SpscArrayQueue) objArr2[1], (Scheduler.Worker) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
            if (r13 != 0) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
            if (r18.cancelled == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
            if (r18.done == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
            if (r13 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
            if (r2.isEmpty() == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009a, code lost:
            if (r11 == 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a3, code lost:
            if (r7 == Long.MAX_VALUE) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
            if (r7 != r6) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
            if (r6 != 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ba, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i = this.consumed;
                SpscArrayQueue<T> spscArrayQueue = this.queue;
                ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                int i2 = this.limit;
                int i3 = 1;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        int i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i4 == 0) {
                            break;
                        } else if (this.cancelled) {
                            spscArrayQueue.clear();
                            return;
                        } else {
                            boolean z2 = this.done;
                            if (z2 && (th = this.error) != null) {
                                spscArrayQueue.clear();
                                conditionalSubscriber.onError(th);
                                this.worker.dispose();
                                return;
                            }
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z2 && z) {
                                conditionalSubscriber.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (z) {
                                break;
                            } else {
                                if (conditionalSubscriber.tryOnNext(poll)) {
                                    j2++;
                                }
                                i++;
                                if (i == i2) {
                                    this.s.request(i);
                                    i = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1075119423897941642L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), spscArrayQueue, worker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (SpscArrayQueue) objArr2[1], (Scheduler.Worker) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r13 != 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
            if (r18.cancelled == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
            if (r18.done == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
            if (r13 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
            if (r2.isEmpty() == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0094, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0097, code lost:
            if (r11 == 0) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
            if (r7 == Long.MAX_VALUE) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a8, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00ac, code lost:
            if (r7 != r6) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ae, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b5, code lost:
            if (r6 != 0) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b7, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i = this.consumed;
                SpscArrayQueue<T> spscArrayQueue = this.queue;
                Subscriber<? super T> subscriber = this.actual;
                int i2 = this.limit;
                int i3 = 1;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        int i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i4 == 0) {
                            break;
                        } else if (this.cancelled) {
                            spscArrayQueue.clear();
                            return;
                        } else {
                            boolean z2 = this.done;
                            if (z2 && (th = this.error) != null) {
                                spscArrayQueue.clear();
                                subscriber.onError(th);
                                this.worker.dispose();
                                return;
                            }
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z2 && z) {
                                subscriber.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (z) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i++;
                                if (i == i2) {
                                    this.s.request(i);
                                    i = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parallelFlowable, scheduler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = parallelFlowable;
        this.scheduler = scheduler;
        this.prefetch = i;
    }

    public void createSubscriber(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), subscriberArr, subscriberArr2, worker}) == null) {
            Subscriber<? super T> subscriber = subscriberArr[i];
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            if (subscriber instanceof ConditionalSubscriber) {
                subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.prefetch, spscArrayQueue, worker);
            } else {
                subscriberArr2[i] = new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
            }
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.source.parallelism();
        }
        return invokeV.intValue;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subscriberArr) != null) || !validate(subscriberArr)) {
            return;
        }
        int length = subscriberArr.length;
        Subscriber<T>[] subscriberArr2 = new Subscriber[length];
        Scheduler scheduler = this.scheduler;
        if (scheduler instanceof SchedulerMultiWorkerSupport) {
            ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new MultiWorkerCallback(this, subscriberArr, subscriberArr2));
        } else {
            for (int i = 0; i < length; i++) {
                createSubscriber(i, subscriberArr, subscriberArr2, this.scheduler.createWorker());
            }
        }
        this.source.subscribe(subscriberArr2);
    }
}
