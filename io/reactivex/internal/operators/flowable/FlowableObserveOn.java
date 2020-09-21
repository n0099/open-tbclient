package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes25.dex */
public final class FlowableObserveOn<T> extends a<T, T> {
    final boolean delayError;
    final int prefetch;
    final v scheduler;

    public FlowableObserveOn(io.reactivex.g<T> gVar, v vVar, boolean z, int i) {
        super(gVar);
        this.scheduler = vVar;
        this.delayError = z;
        this.prefetch = i;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        v.c eja = this.scheduler.eja();
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.owE.a((j) new ObserveOnConditionalSubscriber((io.reactivex.internal.a.a) cVar, eja, this.delayError, this.prefetch));
        } else {
            this.owE.a((j) new ObserveOnSubscriber(cVar, eja, this.delayError, this.prefetch));
        }
    }

    /* loaded from: classes25.dex */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        io.reactivex.internal.a.g<T> queue;
        final AtomicLong requested = new AtomicLong();
        org.a.d s;
        int sourceMode;
        final v.c worker;

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        BaseObserveOnSubscriber(v.c cVar, boolean z, int i) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.a.c
        public final void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 2) {
                    trySchedule();
                    return;
                }
                if (!this.queue.offer(t)) {
                    this.s.cancel();
                    this.error = new MissingBackpressureException("Queue is full?!");
                    this.done = true;
                }
                trySchedule();
            }
        }

        @Override // org.a.c
        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // org.a.c
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                trySchedule();
            }
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                trySchedule();
            }
        }

        @Override // org.a.d
        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        final void trySchedule() {
            if (getAndIncrement() == 0) {
                this.worker.G(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (z) {
                if (this.delayError) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            cVar.onError(th);
                        } else {
                            cVar.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return true;
                    } else if (z2) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.g
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* loaded from: classes25.dex */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements j<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final org.a.c<? super T> actual;

        ObserveOnSubscriber(org.a.c<? super T> cVar, v.c cVar2, boolean z, int i) {
            super(cVar2, z, i);
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = dVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = dVar2;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            int i = 1;
            org.a.c<? super T> cVar = this.actual;
            io.reactivex.internal.a.g<T> gVar = this.queue;
            long j = this.produced;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object obj = (T) gVar.poll();
                        if (!this.cancelled) {
                            if (obj == null) {
                                cVar.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            cVar.onNext(obj);
                            j++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.J(th);
                        this.s.cancel();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (gVar.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            long j;
            org.a.c<? super T> cVar = this.actual;
            io.reactivex.internal.a.g<T> gVar = this.queue;
            long j2 = this.produced;
            int i = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    boolean z = this.done;
                    try {
                        Object obj = (T) gVar.poll();
                        boolean z2 = obj == null;
                        if (!checkTerminated(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.onNext(obj);
                            long j4 = 1 + j2;
                            if (j4 == this.limit) {
                                j = j3 != Long.MAX_VALUE ? this.requested.addAndGet(-j4) : j3;
                                this.s.request(j4);
                                j4 = 0;
                            } else {
                                j = j3;
                            }
                            j3 = j;
                            j2 = j4;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.J(th);
                        this.s.cancel();
                        gVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 != j3 || !checkTerminated(this.done, gVar.isEmpty(), cVar)) {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j2;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j == this.limit) {
                    this.produced = 0L;
                    this.s.request(j);
                } else {
                    this.produced = j;
                }
            }
            return poll;
        }
    }

    /* loaded from: classes25.dex */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final io.reactivex.internal.a.a<? super T> actual;
        long consumed;

        ObserveOnConditionalSubscriber(io.reactivex.internal.a.a<? super T> aVar, v.c cVar, boolean z, int i) {
            super(cVar, z, i);
            this.actual = aVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = dVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = dVar2;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            int i = 1;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            io.reactivex.internal.a.g<T> gVar = this.queue;
            long j = this.produced;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object obj = (T) gVar.poll();
                        if (!this.cancelled) {
                            if (obj == null) {
                                aVar.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (aVar.tryOnNext(obj)) {
                                j++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.J(th);
                        this.s.cancel();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (gVar.isEmpty()) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            int i = 1;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            io.reactivex.internal.a.g<T> gVar = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            while (true) {
                long j3 = this.requested.get();
                while (j != j3) {
                    boolean z = this.done;
                    try {
                        Object obj = (T) gVar.poll();
                        boolean z2 = obj == null;
                        if (!checkTerminated(z, z2, aVar)) {
                            if (z2) {
                                break;
                            }
                            if (aVar.tryOnNext(obj)) {
                                j++;
                            }
                            j2++;
                            if (j2 == this.limit) {
                                this.s.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.J(th);
                        this.s.cancel();
                        gVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j != j3 || !checkTerminated(this.done, gVar.isEmpty(), aVar)) {
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        this.consumed = j2;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j = this.consumed + 1;
                if (j == this.limit) {
                    this.consumed = 0L;
                    this.s.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return poll;
        }
    }
}
