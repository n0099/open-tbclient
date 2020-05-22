package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class ParallelJoin<T> extends g<T> {
    final boolean delayErrors;
    final a<? extends T> npb;
    final int prefetch;

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        JoinSubscriptionBase joinSubscription;
        if (this.delayErrors) {
            joinSubscription = new JoinSubscriptionDelayError(cVar, this.npb.dKI(), this.prefetch);
        } else {
            joinSubscription = new JoinSubscription(cVar, this.npb.dKI(), this.prefetch);
        }
        cVar.onSubscribe(joinSubscription);
        this.npb.a(joinSubscription.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 3100232009247827843L;
        final c<? super T> actual;
        volatile boolean cancelled;
        final JoinInnerSubscriber<T>[] subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(c<? super T> cVar, int i, int i2) {
            this.actual = cVar;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        void cancelAll() {
            for (int i = 0; i < this.subscribers.length; i++) {
                this.subscribers[i].cancel();
            }
        }

        void cleanup() {
            for (int i = 0; i < this.subscribers.length; i++) {
                this.subscribers[i].queue = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(c<? super T> cVar, int i, int i2) {
            super(cVar, i, i2);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.actual.onError(missingBackpressureException);
                        return;
                    } else {
                        io.reactivex.e.a.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
            if (r0 == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
            if (r3 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
            r8.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
            if (r3 == false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            Object obj;
            int i = 1;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            c<? super T> cVar = this.actual;
            while (true) {
                int i2 = i;
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th = this.errors.get();
                    if (th != null) {
                        cleanup();
                        cVar.onError(th);
                        return;
                    }
                    boolean z = this.done.get() == 0;
                    boolean z2 = true;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= joinInnerSubscriberArr.length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i3];
                        f<T> fVar = joinInnerSubscriber.queue;
                        if (fVar != null && (obj = (T) fVar.poll()) != null) {
                            z2 = false;
                            cVar.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j2++;
                            if (j2 == j) {
                                break;
                            }
                        }
                        i3++;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        cVar.onError(th2);
                        return;
                    }
                    boolean z3 = this.done.get() == 0;
                    boolean z4 = true;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            f<T> fVar2 = joinInnerSubscriberArr[i4].queue;
                            if (fVar2 == null || fVar2.isEmpty()) {
                                i4++;
                            } else {
                                z4 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z3 && z4) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                i = get();
                if (i == i2 && (i = addAndGet(-i2)) == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(c<? super T> cVar, int i, int i2) {
            super(cVar, i, i2);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
            if (r1 == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
            if (r2 == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
            if (r15.errors.get() == null) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
            r8.onError(r15.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
            r8.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
            if (r2 == false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            Object obj;
            int i = 1;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            c<? super T> cVar = this.actual;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z = this.done.get() == 0;
                    boolean z2 = true;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i2];
                        f<T> fVar = joinInnerSubscriber.queue;
                        if (fVar != null && (obj = (T) fVar.poll()) != null) {
                            z2 = false;
                            cVar.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j2++;
                            if (j2 == j) {
                                break;
                            }
                        }
                        i2++;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z3 = this.done.get() == 0;
                    boolean z4 = true;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            f<T> fVar2 = joinInnerSubscriberArr[i3].queue;
                            if (fVar2 == null || fVar2.isEmpty()) {
                                i3++;
                            } else {
                                z4 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z3 && z4) {
                        if (this.errors.get() != null) {
                            cVar.onError(this.errors.terminate());
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 == i) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<d> implements j<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile f<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long j = 1 + this.produced;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
                return;
            }
            this.produced = j2;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        f<T> getQueue() {
            f<T> fVar = this.queue;
            if (fVar == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
                this.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return fVar;
        }
    }
}
