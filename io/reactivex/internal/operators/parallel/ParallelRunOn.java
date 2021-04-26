package io.reactivex.internal.operators.parallel;

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
/* loaded from: classes7.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    public final int prefetch;
    public final Scheduler scheduler;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: classes7.dex */
    public static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final long serialVersionUID = 9222303586456402150L;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final SpscArrayQueue<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public Subscription s;
        public final Scheduler.Worker worker;

        public BaseRunOnSubscriber(int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.prefetch = i2;
            this.queue = spscArrayQueue;
            this.limit = i2 - (i2 >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
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
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }

        public final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        public final Subscriber<T>[] parents;
        public final Subscriber<? super T>[] subscribers;

        public MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.subscribers = subscriberArr;
            this.parents = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i2, Scheduler.Worker worker) {
            ParallelRunOn.this.createSubscriber(i2, this.subscribers, this.parents, worker);
        }
    }

    /* loaded from: classes7.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        public static final long serialVersionUID = 1075119423897941642L;
        public final ConditionalSubscriber<? super T> actual;

        public RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i2, spscArrayQueue, worker);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
            if (r13 != 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
            if (r18.cancelled == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
            if (r18.done == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
            if (r13 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
            if (r2.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
            if (r11 == 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
            if (r7 == Long.MAX_VALUE) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
            if (r7 != r6) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
            if (r6 != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i5 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i5 == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (z && (th = this.error) != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                        T poll = spscArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            if (conditionalSubscriber.tryOnNext(poll)) {
                                j2++;
                            }
                            i2++;
                            if (i2 == i3) {
                                this.s.request(i2);
                                i2 = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        public static final long serialVersionUID = 1075119423897941642L;
        public final Subscriber<? super T> actual;

        public RunOnSubscriber(Subscriber<? super T> subscriber, int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i2, spscArrayQueue, worker);
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
            if (r13 != 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r18.cancelled == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
            if (r18.done == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
            if (r13 == null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
            if (r2.isEmpty() == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
            if (r11 == 0) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
            if (r7 == Long.MAX_VALUE) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
            if (r7 != r6) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
            if (r6 != 0) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i5 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i5 == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (z && (th = this.error) != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                        T poll = spscArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j2++;
                            i2++;
                            if (i2 == i3) {
                                this.s.request(i2);
                                i2 = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i2) {
        this.source = parallelFlowable;
        this.scheduler = scheduler;
        this.prefetch = i2;
    }

    public void createSubscriber(int i2, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i2];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i2] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.prefetch, spscArrayQueue, worker);
        } else {
            subscriberArr2[i2] = new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.scheduler;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i2 = 0; i2 < length; i2++) {
                    createSubscriber(i2, subscriberArr, subscriberArr2, this.scheduler.createWorker());
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
