package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    public final int bufferSize;
    public final long size;
    public final long skip;

    /* loaded from: classes7.dex */
    public static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final long serialVersionUID = -2365647875069161133L;
        public final Subscriber<? super Flowable<T>> actual;
        public final int bufferSize;
        public long index;
        public final AtomicBoolean once;
        public Subscription s;
        public final long size;
        public UnicastProcessor<T> window;

        public WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, int i2) {
            super(1);
            this.actual = subscriber;
            this.size = j;
            this.once = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 == this.size) {
                this.index = 0L;
                this.window = null;
                unicastProcessor.onComplete();
                return;
            }
            this.index = j2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.s.request(BackpressureHelper.multiplyCap(this.size, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final long serialVersionUID = 2428527070996323976L;
        public final Subscriber<? super Flowable<T>> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public Throwable error;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public long produced;
        public final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
        public final AtomicLong requested;
        public Subscription s;
        public final long size;
        public final long skip;
        public final ArrayDeque<UnicastProcessor<T>> windows;
        public final AtomicInteger wip;

        public WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i2) {
            super(1);
            this.actual = subscriber;
            this.size = j;
            this.skip = j2;
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r10 != 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
            if (checkTerminated(r14.done, r1.isEmpty(), r0, r1) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
            if (r8 == 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
            if (r4 == Long.MAX_VALUE) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
            r14.requested.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
            r3 = r14.wip.addAndGet(-r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.actual;
            SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.queue;
            int i2 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    }
                    boolean z = this.done;
                    UnicastProcessor<T> poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
            } while (i2 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index;
            if (j == 0 && !this.cancelled) {
                getAndIncrement();
                UnicastProcessor<T> create = UnicastProcessor.create(this.bufferSize, this);
                this.windows.offer(create);
                this.queue.offer(create);
                drain();
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j3 = this.produced + 1;
            if (j3 == this.size) {
                this.produced = j3 - this.skip;
                UnicastProcessor<T> poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j3;
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, j - 1)));
                } else {
                    this.s.request(BackpressureHelper.multiplyCap(this.skip, j));
                }
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final long serialVersionUID = -8792836352386833856L;
        public final Subscriber<? super Flowable<T>> actual;
        public final int bufferSize;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public Subscription s;
        public final long size;
        public final long skip;
        public UnicastProcessor<T> window;

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i2) {
            super(1);
            this.actual = subscriber;
            this.size = j;
            this.skip = j2;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j2 == this.size) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.size, j), BackpressureHelper.multiplyCap(this.skip - this.size, j - 1)));
                    return;
                }
                this.s.request(BackpressureHelper.multiplyCap(this.skip, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j, long j2, int i2) {
        super(flowable);
        this.size = j;
        this.skip = j2;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j = this.skip;
        long j2 = this.size;
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber) new WindowExactSubscriber(subscriber, this.size, this.bufferSize));
        } else if (j > j2) {
            this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        } else {
            this.source.subscribe((FlowableSubscriber) new WindowOverlapSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        }
    }
}
