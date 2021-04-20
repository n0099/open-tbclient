package io.reactivex.internal.operators.parallel;

import f.b.g;
import f.b.x.c.f;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes7.dex */
public final class ParallelFromPublisher$ParallelDispatcher<T> extends AtomicInteger implements g<T> {
    public static final long serialVersionUID = -4470634016609963609L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final long[] emissions;
    public Throwable error;
    public int index;
    public final int limit;
    public final int prefetch;
    public int produced;
    public f<T> queue;
    public final AtomicLongArray requests;
    public d s;
    public int sourceMode;
    public final AtomicInteger subscriberCount = new AtomicInteger();
    public final c<? super T>[] subscribers;

    /* loaded from: classes7.dex */
    public final class a implements d {

        /* renamed from: e  reason: collision with root package name */
        public final int f69087e;

        /* renamed from: f  reason: collision with root package name */
        public final int f69088f;

        public a(int i, int i2) {
            this.f69087e = i;
            this.f69088f = i2;
        }

        @Override // g.d.d
        public void cancel() {
            if (ParallelFromPublisher$ParallelDispatcher.this.requests.compareAndSet(this.f69087e + this.f69088f, 0L, 1L)) {
                ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = ParallelFromPublisher$ParallelDispatcher.this;
                int i = this.f69088f;
                parallelFromPublisher$ParallelDispatcher.cancel(i + i);
            }
        }

        @Override // g.d.d
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                AtomicLongArray atomicLongArray = ParallelFromPublisher$ParallelDispatcher.this.requests;
                do {
                    j2 = atomicLongArray.get(this.f69087e);
                    if (j2 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!atomicLongArray.compareAndSet(this.f69087e, j2, b.c(j2, j)));
                if (ParallelFromPublisher$ParallelDispatcher.this.subscriberCount.get() == this.f69088f) {
                    ParallelFromPublisher$ParallelDispatcher.this.drain();
                }
            }
        }
    }

    public ParallelFromPublisher$ParallelDispatcher(c<? super T>[] cVarArr, int i) {
        this.subscribers = cVarArr;
        this.prefetch = i;
        this.limit = i - (i >> 2);
        int length = cVarArr.length;
        int i2 = length + length;
        AtomicLongArray atomicLongArray = new AtomicLongArray(i2 + 1);
        this.requests = atomicLongArray;
        atomicLongArray.lazySet(i2, length);
        this.emissions = new long[length];
    }

    public void cancel(int i) {
        if (this.requests.decrementAndGet(i) == 0) {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.sourceMode == 1) {
            drainSync();
        } else {
            drainAsync();
        }
    }

    public void drainAsync() {
        Throwable th;
        f<T> fVar = this.queue;
        c<? super T>[] cVarArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i = this.index;
        int i2 = this.produced;
        int i3 = 1;
        while (true) {
            int i4 = 0;
            int i5 = 0;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && (th = this.error) != null) {
                    fVar.clear();
                    int length2 = cVarArr.length;
                    while (i4 < length2) {
                        cVarArr[i4].onError(th);
                        i4++;
                    }
                    return;
                }
                boolean isEmpty = fVar.isEmpty();
                if (z && isEmpty) {
                    int length3 = cVarArr.length;
                    while (i4 < length3) {
                        cVarArr[i4].onComplete();
                        i4++;
                    }
                    return;
                }
                if (!isEmpty) {
                    long j = atomicLongArray.get(i);
                    long j2 = jArr[i];
                    if (j == j2 || atomicLongArray.get(length + i) != 0) {
                        i5++;
                    } else {
                        try {
                            T poll = fVar.poll();
                            if (poll != null) {
                                cVarArr[i].onNext(poll);
                                jArr[i] = j2 + 1;
                                i2++;
                                if (i2 == this.limit) {
                                    this.s.request(i2);
                                    i2 = 0;
                                }
                                i5 = 0;
                            }
                        } catch (Throwable th2) {
                            f.b.u.a.a(th2);
                            this.s.cancel();
                            int length4 = cVarArr.length;
                            while (i4 < length4) {
                                cVarArr[i4].onError(th2);
                                i4++;
                            }
                            return;
                        }
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                        continue;
                    }
                    if (i5 == length) {
                    }
                }
                int i6 = get();
                if (i6 == i3) {
                    this.index = i;
                    this.produced = i2;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i6;
                }
            }
            fVar.clear();
            return;
        }
    }

    public void drainSync() {
        f<T> fVar = this.queue;
        c<? super T>[] cVarArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i = this.index;
        int i2 = 1;
        while (true) {
            int i3 = 0;
            int i4 = 0;
            while (!this.cancelled) {
                if (fVar.isEmpty()) {
                    int length2 = cVarArr.length;
                    while (i3 < length2) {
                        cVarArr[i3].onComplete();
                        i3++;
                    }
                    return;
                }
                long j = atomicLongArray.get(i);
                long j2 = jArr[i];
                if (j == j2 || atomicLongArray.get(length + i) != 0) {
                    i4++;
                } else {
                    try {
                        T poll = fVar.poll();
                        if (poll == null) {
                            int length3 = cVarArr.length;
                            while (i3 < length3) {
                                cVarArr[i3].onComplete();
                                i3++;
                            }
                            return;
                        }
                        cVarArr[i].onNext(poll);
                        jArr[i] = j2 + 1;
                        i4 = 0;
                    } catch (Throwable th) {
                        f.b.u.a.a(th);
                        this.s.cancel();
                        int length4 = cVarArr.length;
                        while (i3 < length4) {
                            cVarArr[i3].onError(th);
                            i3++;
                        }
                        return;
                    }
                }
                i++;
                if (i == length) {
                    i = 0;
                    continue;
                }
                if (i4 == length) {
                    int i5 = get();
                    if (i5 == i2) {
                        this.index = i;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i5;
                    }
                }
            }
            fVar.clear();
            return;
        }
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.s.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
            return;
        }
        drain();
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof f.b.x.c.d) {
                f.b.x.c.d dVar2 = (f.b.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    setupSubscribers();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    setupSubscribers();
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            dVar.request(this.prefetch);
        }
    }

    public void setupSubscribers() {
        c<? super T>[] cVarArr = this.subscribers;
        int length = cVarArr.length;
        int i = 0;
        while (i < length && !this.cancelled) {
            int i2 = i + 1;
            this.subscriberCount.lazySet(i2);
            cVarArr[i].onSubscribe(new a(i, length));
            i = i2;
        }
    }
}
