package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.h;
import f.b.x.c.e;
import f.b.x.c.f;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -2117620485640801370L;
    public final c<? super U> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public long lastId;
    public int lastIndex;
    public final h<? super T, ? extends b<? extends U>> mapper;
    public final int maxConcurrency;
    public volatile e<U> queue;
    public int scalarEmitted;
    public final int scalarLimit;
    public long uniqueId;
    public d upstream;
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap$InnerSubscriber[0];
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    public final AtomicThrowable errs = new AtomicThrowable();
    public final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableFlatMap$MergeSubscriber(c<? super U> cVar, h<? super T, ? extends b<? extends U>> hVar, boolean z, int i, int i2) {
        this.actual = cVar;
        this.mapper = hVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
        this.scalarLimit = Math.max(1, i >> 1);
        this.subscribers.lazySet(EMPTY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber<?, ?>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean addInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED) {
                flowableFlatMap$InnerSubscriber.dispose();
                return false;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            flowableFlatMap$InnerSubscriberArr2 = new FlowableFlatMap$InnerSubscriber[length + 1];
            System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr2, 0, length);
            flowableFlatMap$InnerSubscriberArr2[length] = flowableFlatMap$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
        return true;
    }

    @Override // g.d.d
    public void cancel() {
        e<U> eVar;
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        disposeAll();
        if (getAndIncrement() != 0 || (eVar = this.queue) == null) {
            return;
        }
        eVar.clear();
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            clearScalarQueue();
            return true;
        } else if (this.delayErrors || this.errs.get() == null) {
            return false;
        } else {
            clearScalarQueue();
            Throwable terminate = this.errs.terminate();
            if (terminate != ExceptionHelper.f69103a) {
                this.actual.onError(terminate);
            }
            return true;
        }
    }

    public void clearScalarQueue() {
        e<U> eVar = this.queue;
        if (eVar != null) {
            eVar.clear();
        }
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber<?, ?>[] andSet;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = CANCELLED;
        if (flowableFlatMap$InnerSubscriberArr == flowableFlatMap$InnerSubscriberArr2 || (andSet = this.subscribers.getAndSet(flowableFlatMap$InnerSubscriberArr2)) == CANCELLED) {
            return;
        }
        for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber : andSet) {
            flowableFlatMap$InnerSubscriber.dispose();
        }
        Throwable terminate = this.errs.terminate();
        if (terminate == null || terminate == ExceptionHelper.f69103a) {
            return;
        }
        a.f(terminate);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x018f, code lost:
        r24.lastIndex = r3;
        r24.lastId = r13[r3].id;
        r3 = r16;
        r5 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        long j;
        long j2;
        boolean z;
        FlowableFlatMap$InnerSubscriber<T, U>[] flowableFlatMap$InnerSubscriberArr;
        int i;
        long j3;
        c<? super U> cVar = this.actual;
        int i2 = 1;
        while (!checkTerminate()) {
            e<U> eVar = this.queue;
            long j4 = this.requested.get();
            boolean z2 = j4 == Long.MAX_VALUE;
            long j5 = 0;
            long j6 = 0;
            if (eVar != null) {
                while (true) {
                    long j7 = 0;
                    Object obj = null;
                    while (true) {
                        if (j4 == 0) {
                            break;
                        }
                        U poll = eVar.poll();
                        if (checkTerminate()) {
                            return;
                        }
                        if (poll == null) {
                            obj = poll;
                            break;
                        }
                        cVar.onNext(poll);
                        j6++;
                        j7++;
                        j4--;
                        obj = poll;
                    }
                    if (j7 != 0) {
                        j4 = z2 ? Long.MAX_VALUE : this.requested.addAndGet(-j7);
                    }
                    if (j4 == 0 || obj == null) {
                        break;
                    }
                }
            }
            boolean z3 = this.done;
            e<U> eVar2 = this.queue;
            FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr2.length;
            if (z3 && ((eVar2 == null || eVar2.isEmpty()) && length == 0)) {
                Throwable terminate = this.errs.terminate();
                if (terminate != ExceptionHelper.f69103a) {
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
            int i3 = i2;
            if (length != 0) {
                long j8 = this.lastId;
                int i4 = this.lastIndex;
                if (length <= i4 || flowableFlatMap$InnerSubscriberArr2[i4].id != j8) {
                    if (length <= i4) {
                        i4 = 0;
                    }
                    for (int i5 = 0; i5 < length && flowableFlatMap$InnerSubscriberArr2[i4].id != j8; i5++) {
                        i4++;
                        if (i4 == length) {
                            i4 = 0;
                        }
                    }
                    this.lastIndex = i4;
                    this.lastId = flowableFlatMap$InnerSubscriberArr2[i4].id;
                }
                int i6 = i4;
                boolean z4 = false;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                        z = z4;
                        break;
                    } else if (checkTerminate()) {
                        return;
                    } else {
                        FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber = flowableFlatMap$InnerSubscriberArr2[i6];
                        U u = null;
                        while (!checkTerminate()) {
                            f<U> fVar = flowableFlatMap$InnerSubscriber.queue;
                            if (fVar == null) {
                                flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                                i = length;
                            } else {
                                flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                                i = length;
                                long j9 = j5;
                                while (j4 != j5) {
                                    try {
                                        u = fVar.poll();
                                        if (u == null) {
                                            break;
                                        }
                                        cVar.onNext(u);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j4--;
                                        j9++;
                                    } catch (Throwable th) {
                                        f.b.u.a.a(th);
                                        flowableFlatMap$InnerSubscriber.dispose();
                                        this.errs.addThrowable(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(flowableFlatMap$InnerSubscriber);
                                        i7++;
                                        length = i;
                                        z4 = true;
                                    }
                                }
                                if (j9 != j5) {
                                    j4 = !z2 ? this.requested.addAndGet(-j9) : Long.MAX_VALUE;
                                    flowableFlatMap$InnerSubscriber.requestMore(j9);
                                    j3 = 0;
                                } else {
                                    j3 = j5;
                                }
                                if (j4 != j3 && u != null) {
                                    flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                                    length = i;
                                    j5 = 0;
                                }
                            }
                            boolean z5 = flowableFlatMap$InnerSubscriber.done;
                            f<U> fVar2 = flowableFlatMap$InnerSubscriber.queue;
                            if (z5 && (fVar2 == null || fVar2.isEmpty())) {
                                removeInner(flowableFlatMap$InnerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j6++;
                                z4 = true;
                            }
                            if (j4 == 0) {
                                z = z4;
                                break;
                            }
                            i6++;
                            length = i;
                            if (i6 == length) {
                                i6 = 0;
                            }
                            i7++;
                            flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                            j5 = 0;
                        }
                        return;
                    }
                }
            }
            j = 0;
            j2 = j6;
            z = false;
            if (j2 != j && !this.cancelled) {
                this.upstream.request(j2);
            }
            if (z) {
                i2 = i3;
            } else {
                i2 = addAndGet(-i3);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    public f<U> getInnerQueue(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        f<U> fVar = flowableFlatMap$InnerSubscriber.queue;
        if (fVar == null) {
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            flowableFlatMap$InnerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }
        return fVar;
    }

    public f<U> getMainQueue() {
        e<U> eVar = this.queue;
        if (eVar == null) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                eVar = new f.b.x.f.a<>(this.bufferSize);
            } else {
                eVar = new SpscArrayQueue<>(this.maxConcurrency);
            }
            this.queue = eVar;
        }
        return eVar;
    }

    public void innerError(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber, Throwable th) {
        if (this.errs.addThrowable(th)) {
            flowableFlatMap$InnerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (FlowableFlatMap$InnerSubscriber<?, ?> flowableFlatMap$InnerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                    flowableFlatMap$InnerSubscriber2.dispose();
                }
            }
            drain();
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
        } else if (this.errs.addThrowable(th)) {
            this.done = true;
            drain();
        } else {
            a.f(th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber<T, U> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            b<? extends U> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The mapper returned a null Publisher");
            b<? extends U> bVar = apply;
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
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    this.errs.addThrowable(th);
                    drain();
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = new FlowableFlatMap$InnerSubscriber(this, j);
            if (addInner(flowableFlatMap$InnerSubscriber)) {
                bVar.subscribe(flowableFlatMap$InnerSubscriber);
            }
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.actual.onSubscribe(this);
            if (this.cancelled) {
                return;
            }
            int i = this.maxConcurrency;
            if (i == Integer.MAX_VALUE) {
                dVar.request(Long.MAX_VALUE);
            } else {
                dVar.request(i);
            }
        }
    }

    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED || flowableFlatMap$InnerSubscriberArr == EMPTY) {
                return;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (flowableFlatMap$InnerSubscriberArr[i2] == flowableFlatMap$InnerSubscriber) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                flowableFlatMap$InnerSubscriberArr2 = EMPTY;
            } else {
                FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = new FlowableFlatMap$InnerSubscriber[length - 1];
                System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr3, 0, i);
                System.arraycopy(flowableFlatMap$InnerSubscriberArr, i + 1, flowableFlatMap$InnerSubscriberArr3, i, (length - i) - 1);
                flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr3;
            }
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
            drain();
        }
    }

    public void tryEmit(U u, FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        if (get() == 0 && compareAndSet(0, 1)) {
            long j = this.requested.get();
            f<U> fVar = flowableFlatMap$InnerSubscriber.queue;
            if (j != 0 && (fVar == null || fVar.isEmpty())) {
                this.actual.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                flowableFlatMap$InnerSubscriber.requestMore(1L);
            } else {
                if (fVar == null) {
                    fVar = getInnerQueue(flowableFlatMap$InnerSubscriber);
                }
                if (!fVar.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            f fVar2 = flowableFlatMap$InnerSubscriber.queue;
            if (fVar2 == null) {
                fVar2 = new SpscArrayQueue(this.bufferSize);
                flowableFlatMap$InnerSubscriber.queue = fVar2;
            }
            if (!fVar2.offer(u)) {
                onError(new MissingBackpressureException("Inner queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void tryEmitScalar(U u) {
        if (get() == 0 && compareAndSet(0, 1)) {
            long j = this.requested.get();
            f<U> fVar = this.queue;
            if (j != 0 && (fVar == null || fVar.isEmpty())) {
                this.actual.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    int i2 = this.scalarLimit;
                    if (i == i2) {
                        this.scalarEmitted = 0;
                        this.upstream.request(i2);
                    }
                }
            } else {
                if (fVar == null) {
                    fVar = getMainQueue();
                }
                if (!fVar.offer(u)) {
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
}
