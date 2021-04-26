package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    public final int bufferSize;
    public final long maxSize;
    public final boolean restartTimerOnMaxSize;
    public final Scheduler scheduler;
    public final long timeskip;
    public final long timespan;
    public final TimeUnit unit;

    /* loaded from: classes7.dex */
    public static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final int bufferSize;
        public long count;
        public final long maxSize;
        public long producerIndex;
        public final boolean restartTimerOnMaxSize;
        public Subscription s;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final SequentialDisposable timer;
        public final long timespan;
        public final TimeUnit unit;
        public UnicastProcessor<T> window;
        public final Scheduler.Worker worker;

        /* loaded from: classes7.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            public final long index;
            public final WindowExactBoundedSubscriber<?> parent;

            public ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.index = j;
                this.parent = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
                if (!windowExactBoundedSubscriber.cancelled) {
                    windowExactBoundedSubscriber.queue.offer(this);
                } else {
                    windowExactBoundedSubscriber.terminated = true;
                    windowExactBoundedSubscriber.dispose();
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.drainLoop();
                }
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i2, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i2;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i2 = 1;
            while (!this.terminated) {
                boolean z = this.done;
                Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.window = null;
                    simpleQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    dispose();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    int i3 = i2;
                    if (z3) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (this.restartTimerOnMaxSize || this.producerIndex == consumerIndexHolder.index) {
                            unicastProcessor.onComplete();
                            this.count = 0L;
                            unicastProcessor = UnicastProcessor.create(this.bufferSize);
                            this.window = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1L);
                                }
                            } else {
                                this.window = null;
                                this.queue.clear();
                                this.s.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                dispose();
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j = this.count + 1;
                        if (j >= this.maxSize) {
                            this.producerIndex++;
                            this.count = 0L;
                            unicastProcessor.onComplete();
                            long requested2 = requested();
                            if (requested2 != 0) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                                this.window = create;
                                this.actual.onNext(create);
                                if (requested2 != Long.MAX_VALUE) {
                                    produced(1L);
                                }
                                if (this.restartTimerOnMaxSize) {
                                    this.timer.get().dispose();
                                    Scheduler.Worker worker = this.worker;
                                    ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.producerIndex, this);
                                    long j2 = this.timespan;
                                    this.timer.replace(worker.schedulePeriodically(consumerIndexHolder2, j2, j2, this.unit));
                                }
                                unicastProcessor = create;
                            } else {
                                this.window = null;
                                this.s.cancel();
                                this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                        } else {
                            this.count = j;
                        }
                    }
                    i2 = i3;
                }
            }
            this.s.cancel();
            simpleQueue.clear();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastProcessor<T> unicastProcessor = this.window;
                unicastProcessor.onNext(t);
                long j = this.count + 1;
                if (j >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastProcessor.onComplete();
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                        this.window = create;
                        this.actual.onNext(create);
                        if (requested != Long.MAX_VALUE) {
                            produced(1L);
                        }
                        if (this.restartTimerOnMaxSize) {
                            this.timer.get().dispose();
                            Scheduler.Worker worker = this.worker;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                            long j2 = this.timespan;
                            this.timer.replace(worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit));
                        }
                    } else {
                        this.window = null;
                        this.s.cancel();
                        this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                } else {
                    this.count = j;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable schedulePeriodicallyDirect;
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                this.window = create;
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                    if (this.restartTimerOnMaxSize) {
                        Scheduler.Worker worker = this.worker;
                        long j = this.timespan;
                        schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.unit);
                    } else {
                        Scheduler scheduler = this.scheduler;
                        long j2 = this.timespan;
                        schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.unit);
                    }
                    if (this.timer.replace(schedulePeriodicallyDirect)) {
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.cancelled = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    /* loaded from: classes7.dex */
    public static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object NEXT = new Object();
        public final int bufferSize;
        public Subscription s;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final SequentialDisposable timer;
        public final long timespan;
        public final TimeUnit unit;
        public UnicastProcessor<T> window;

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: io.reactivex.processors.UnicastProcessor */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
            r10.window = null;
            r0.clear();
            dispose();
            r0 = r10.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r0 == null) goto L13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            UnicastProcessor<T> unicastProcessor = this.window;
            int i2 = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                Object poll = simpleQueue.poll();
                if (!z2 || (poll != null && poll != NEXT)) {
                    if (poll == null) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        unicastProcessor.onComplete();
                        if (!z) {
                            unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.create(this.bufferSize);
                            this.window = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1L);
                                }
                            } else {
                                this.window = null;
                                this.queue.clear();
                                this.s.cancel();
                                dispose();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                        } else {
                            this.s.cancel();
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                this.window.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.window = UnicastProcessor.create(this.bufferSize);
                Subscriber<? super V> subscriber = this.actual;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.window);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (this.cancelled) {
                        return;
                    }
                    SequentialDisposable sequentialDisposable = this.timer;
                    Scheduler scheduler = this.scheduler;
                    long j = this.timespan;
                    if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.unit))) {
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.cancelled = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                dispose();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        public final int bufferSize;
        public Subscription s;
        public volatile boolean terminated;
        public final long timeskip;
        public final long timespan;
        public final TimeUnit unit;
        public final List<UnicastProcessor<T>> windows;
        public final Scheduler.Worker worker;

        /* loaded from: classes7.dex */
        public final class Completion implements Runnable {
            public final UnicastProcessor<T> processor;

            public Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipSubscriber.this.complete(this.processor);
            }
        }

        /* loaded from: classes7.dex */
        public static final class SubjectWork<T> {
            public final boolean open;
            public final UnicastProcessor<T> w;

            public SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.w = unicastProcessor;
                this.open = z;
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i2;
            this.windows = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void complete(UnicastProcessor<T> unicastProcessor) {
            this.queue.offer(new SubjectWork(unicastProcessor, false));
            if (enter()) {
                drainLoop();
            }
        }

        public void dispose() {
            this.worker.dispose();
        }

        public void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.actual;
            List<UnicastProcessor<T>> list = this.windows;
            int i2 = 1;
            while (!this.terminated) {
                boolean z = this.done;
                T t = (T) simpleQueue.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simpleQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastProcessor<T> unicastProcessor : list) {
                            unicastProcessor.onError(th);
                        }
                    } else {
                        for (UnicastProcessor<T> unicastProcessor2 : list) {
                            unicastProcessor2.onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) t;
                    if (subjectWork.open) {
                        if (!this.cancelled) {
                            long requested = requested();
                            if (requested != 0) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                                list.add(create);
                                subscriber.onNext(create);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1L);
                                }
                                this.worker.schedule(new Completion(create), this.timespan, this.unit);
                            } else {
                                subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                            }
                        }
                    } else {
                        list.remove(subjectWork.w);
                        subjectWork.w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    }
                } else {
                    for (UnicastProcessor<T> unicastProcessor3 : list) {
                        unicastProcessor3.onNext(t);
                    }
                }
            }
            this.s.cancel();
            dispose();
            simpleQueue.clear();
            list.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastProcessor<T> unicastProcessor : this.windows) {
                    unicastProcessor.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                long requested = requested();
                if (requested != 0) {
                    UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize);
                    this.windows.add(create);
                    this.actual.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    this.worker.schedule(new Completion(create), this.timespan, this.unit);
                    Scheduler.Worker worker = this.worker;
                    long j = this.timeskip;
                    worker.schedulePeriodically(this, j, j, this.unit);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.cancel();
                this.actual.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i2, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j3;
        this.bufferSize = i2;
        this.restartTimerOnMaxSize = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j = this.timespan;
        long j2 = this.timeskip;
        if (j == j2) {
            long j3 = this.maxSize;
            if (j3 == Long.MAX_VALUE) {
                this.source.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
                return;
            } else {
                this.source.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(serializedSubscriber, j, this.unit, this.scheduler, this.bufferSize, j3, this.restartTimerOnMaxSize));
                return;
            }
        }
        this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(serializedSubscriber, j, j2, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }
}
