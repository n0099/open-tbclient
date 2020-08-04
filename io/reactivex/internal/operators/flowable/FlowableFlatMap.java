package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMap<T, U> extends a<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final h<? super T, ? extends org.a.b<? extends U>> mapper;
    final int maxConcurrency;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super U> cVar) {
        if (!g.a(this.nSG, cVar, this.mapper)) {
            this.nSG.a((j) a(cVar, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
        }
    }

    public static <T, U> j<T> a(org.a.c<? super U> cVar, h<? super T, ? extends org.a.b<? extends U>> hVar, boolean z, int i, int i2) {
        return new MergeSubscriber(cVar, hVar, z, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -2117620485640801370L;
        final org.a.c<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        long lastId;
        int lastIndex;
        final h<? super T, ? extends org.a.b<? extends U>> mapper;
        final int maxConcurrency;
        volatile io.reactivex.internal.a.f<U> queue;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        org.a.d upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];
        final AtomicThrowable errs = new AtomicThrowable();
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        MergeSubscriber(org.a.c<? super U> cVar, h<? super T, ? extends org.a.b<? extends U>> hVar, boolean z, int i, int i2) {
            this.actual = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        dVar.request(Long.MAX_VALUE);
                    } else {
                        dVar.request(this.maxConcurrency);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber<T, U> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                try {
                    org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null Publisher");
                    if (bVar instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar).call();
                            if (call != null) {
                                tryEmitScalar(call);
                                return;
                            } else if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                                return;
                            } else {
                                int i = this.scalarEmitted + 1;
                                this.scalarEmitted = i;
                                if (i == this.scalarLimit) {
                                    this.scalarEmitted = 0;
                                    this.upstream.request(this.scalarLimit);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.K(th);
                            this.errs.addThrowable(th);
                            drain();
                            return;
                        }
                    }
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    if (addInner(innerSubscriber)) {
                        bVar.subscribe(innerSubscriber);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.K(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber<?, ?>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        boolean addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr != CANCELLED && innerSubscriberArr != EMPTY) {
                    int length = innerSubscriberArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriberArr[i2] == innerSubscriber) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            innerSubscriberArr2 = new InnerSubscriber[length - 1];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        io.reactivex.internal.a.g<U> getMainQueue() {
            io.reactivex.internal.a.f<U> fVar = this.queue;
            if (fVar == null) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    fVar = new io.reactivex.internal.queue.a<>(this.bufferSize);
                } else {
                    fVar = new SpscArrayQueue<>(this.maxConcurrency);
                }
                this.queue = fVar;
            }
            return fVar;
        }

        void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.internal.a.g<U> gVar = this.queue;
                if (j != 0 && (gVar == null || gVar.isEmpty())) {
                    this.actual.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        if (i == this.scalarLimit) {
                            this.scalarEmitted = 0;
                            this.upstream.request(this.scalarLimit);
                        }
                    }
                } else {
                    if (gVar == null) {
                        gVar = getMainQueue();
                    }
                    if (!gVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        io.reactivex.internal.a.g<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            io.reactivex.internal.a.g<U> gVar = innerSubscriber.queue;
            if (gVar == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                innerSubscriber.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return gVar;
        }

        void tryEmit(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.internal.a.g<U> gVar = innerSubscriber.queue;
                if (j != 0 && (gVar == null || gVar.isEmpty())) {
                    this.actual.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                } else {
                    if (gVar == null) {
                        gVar = getInnerQueue(innerSubscriber);
                    }
                    if (!gVar.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.a.g gVar2 = innerSubscriber.queue;
                if (gVar2 == null) {
                    gVar2 = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = gVar2;
                }
                if (!gVar2.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
            } else if (this.errs.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            io.reactivex.internal.a.f<U> fVar;
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeAll();
                if (getAndIncrement() == 0 && (fVar = this.queue) != null) {
                    fVar.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x0133, code lost:
            r25.lastIndex = r11;
            r25.lastId = r4[r11].id;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean z;
            long j;
            long j2;
            long j3;
            long j4;
            boolean z2;
            int i;
            int i2;
            U u;
            org.a.c<? super U> cVar = this.actual;
            int i3 = 1;
            while (!checkTerminate()) {
                io.reactivex.internal.a.f<U> fVar = this.queue;
                long j5 = this.requested.get();
                boolean z3 = j5 == Long.MAX_VALUE;
                long j6 = 0;
                if (fVar != null) {
                    do {
                        long j7 = 0;
                        u = (U) null;
                        while (j5 != 0) {
                            u = fVar.poll();
                            if (!checkTerminate()) {
                                if (u == null) {
                                    break;
                                }
                                cVar.onNext(u);
                                j5--;
                                j7 = 1 + j7;
                                j6 = 1 + j6;
                            } else {
                                return;
                            }
                        }
                        if (j7 != 0) {
                            if (z3) {
                                j5 = Long.MAX_VALUE;
                            } else {
                                j5 = this.requested.addAndGet(-j7);
                            }
                        }
                        if (j5 == 0) {
                            break;
                        }
                    } while (u != null);
                }
                boolean z4 = this.done;
                io.reactivex.internal.a.f<U> fVar2 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (z4 && ((fVar2 == null || fVar2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errs.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        if (terminate == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                if (length == 0) {
                    z = false;
                    j = j6;
                } else {
                    long j8 = this.lastId;
                    int i4 = this.lastIndex;
                    if (length <= i4 || innerSubscriberArr[i4].id != j8) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        for (int i5 = 0; i5 < length && innerSubscriberArr[i4].id != j8; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr[i4].id;
                    }
                    boolean z5 = false;
                    int i6 = i4;
                    int i7 = 0;
                    j = j6;
                    while (true) {
                        if (i7 >= length) {
                            z = z5;
                            break;
                        } else if (!checkTerminate()) {
                            InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr[i6];
                            Object obj = null;
                            while (!checkTerminate()) {
                                io.reactivex.internal.a.g<U> gVar = innerSubscriber.queue;
                                if (gVar == null) {
                                    j2 = j5;
                                } else {
                                    long j9 = 0;
                                    long j10 = j5;
                                    U u2 = (U) obj;
                                    while (j10 != 0) {
                                        try {
                                            u2 = gVar.poll();
                                            if (u2 == null) {
                                                break;
                                            }
                                            cVar.onNext(u2);
                                            if (!checkTerminate()) {
                                                j10--;
                                                j9 = 1 + j9;
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.K(th);
                                            innerSubscriber.dispose();
                                            this.errs.addThrowable(th);
                                            if (!this.delayErrors) {
                                                this.upstream.cancel();
                                            }
                                            if (!checkTerminate()) {
                                                removeInner(innerSubscriber);
                                                i2 = i7 + 1;
                                                z2 = true;
                                                i = i6;
                                                j4 = j;
                                                j3 = j10;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    if (j9 != 0) {
                                        if (!z3) {
                                            j2 = this.requested.addAndGet(-j9);
                                        } else {
                                            j2 = Long.MAX_VALUE;
                                        }
                                        innerSubscriber.requestMore(j9);
                                    } else {
                                        j2 = j10;
                                    }
                                    if (j2 != 0 && u2 != null) {
                                        Object obj2 = u2;
                                        j5 = j2;
                                        obj = obj2;
                                    }
                                }
                                boolean z6 = innerSubscriber.done;
                                io.reactivex.internal.a.g<U> gVar2 = innerSubscriber.queue;
                                if (z6 && (gVar2 == null || gVar2.isEmpty())) {
                                    removeInner(innerSubscriber);
                                    if (!checkTerminate()) {
                                        j++;
                                        z = true;
                                    } else {
                                        return;
                                    }
                                } else {
                                    z = z5;
                                }
                                if (j2 == 0) {
                                    break;
                                }
                                int i8 = i6 + 1;
                                if (i8 == length) {
                                    int i9 = i7;
                                    j4 = j;
                                    j3 = j2;
                                    i2 = i9;
                                    i = 0;
                                    z2 = z;
                                } else {
                                    int i10 = i7;
                                    j4 = j;
                                    j3 = j2;
                                    i2 = i10;
                                    i = i8;
                                    z2 = z;
                                }
                                z5 = z2;
                                j5 = j3;
                                j = j4;
                                i7 = i2 + 1;
                                i6 = i;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (j != 0 && !this.cancelled) {
                    this.upstream.request(j);
                }
                if (!z) {
                    int addAndGet = addAndGet(-i3);
                    if (addAndGet == 0) {
                        return;
                    }
                    i3 = addAndGet;
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            } else if (!this.delayErrors && this.errs.get() != null) {
                clearScalarQueue();
                Throwable terminate = this.errs.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.actual.onError(terminate);
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }

        void clearScalarQueue() {
            io.reactivex.internal.a.f<U> fVar = this.queue;
            if (fVar != null) {
                fVar.clear();
            }
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            if (this.subscribers.get() != CANCELLED && (andSet = this.subscribers.getAndSet(CANCELLED)) != CANCELLED) {
                for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                    innerSubscriber.dispose();
                }
                Throwable terminate = this.errs.terminate();
                if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                    io.reactivex.e.a.onError(terminate);
                }
            }
        }

        void innerError(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.errs.addThrowable(th)) {
                innerSubscriber.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                        innerSubscriber2.dispose();
                    }
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile io.reactivex.internal.a.g<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            this.bufferSize = mergeSubscriber.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = dVar2;
                    }
                }
                dVar.request(this.bufferSize);
            }
        }

        @Override // org.a.c
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
