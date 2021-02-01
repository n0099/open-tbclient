package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.a.b;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class ParallelFromPublisher<T> extends a<T> {
    final int prefetch;
    final int qpX;
    final b<? extends T> source;

    @Override // io.reactivex.parallel.a
    public int eKq() {
        return this.qpX;
    }

    @Override // io.reactivex.parallel.a
    public void a(c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            this.source.subscribe(new ParallelDispatcher(cVarArr, this.prefetch));
        }
    }

    /* loaded from: classes5.dex */
    static final class ParallelDispatcher<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        f<T> queue;
        final AtomicLongArray requests;
        d s;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final c<? super T>[] subscribers;

        ParallelDispatcher(c<? super T>[] cVarArr, int i) {
            this.subscribers = cVarArr;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            int length = cVarArr.length;
            this.requests = new AtomicLongArray(length + length + 1);
            this.requests.lazySet(length + length, length);
            this.emissions = new long[length];
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
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

        void setupSubscribers() {
            c<? super T>[] cVarArr = this.subscribers;
            int length = cVarArr.length;
            for (int i = 0; i < length && !this.cancelled; i++) {
                this.subscriberCount.lazySet(i + 1);
                cVarArr[i].onSubscribe(new a(i, length));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class a implements d {
            final int j;
            final int m;

            a(int i, int i2) {
                this.j = i;
                this.m = i2;
            }

            @Override // org.a.d
            public void request(long j) {
                long j2;
                if (SubscriptionHelper.validate(j)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j2 = atomicLongArray.get(this.j);
                        if (j2 != Long.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.j, j2, io.reactivex.internal.util.b.X(j2, j)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }

            @Override // org.a.d
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.m + this.j, 0L, 1L)) {
                    ParallelDispatcher.this.cancel(this.m + this.m);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                this.s.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
                return;
            }
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        void cancel(int i) {
            if (this.requests.decrementAndGet(i) == 0) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drainAsync() {
            int i;
            Throwable th;
            int i2 = 1;
            f<T> fVar = this.queue;
            c<? super T>[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i3 = this.index;
            int i4 = this.produced;
            while (true) {
                int i5 = 0;
                int i6 = i4;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        fVar.clear();
                        for (c<? super T> cVar : cVarArr) {
                            cVar.onError(th);
                        }
                        return;
                    }
                    boolean isEmpty = fVar.isEmpty();
                    if (z && isEmpty) {
                        for (c<? super T> cVar2 : cVarArr) {
                            cVar2.onComplete();
                        }
                        return;
                    }
                    if (isEmpty) {
                        i4 = i6;
                    } else {
                        long j = atomicLongArray.get(i3);
                        long j2 = jArr[i3];
                        if (j != j2 && atomicLongArray.get(length + i3) == 0) {
                            try {
                                T poll = fVar.poll();
                                if (poll == null) {
                                    i4 = i6;
                                } else {
                                    cVarArr[i3].onNext(poll);
                                    jArr[i3] = 1 + j2;
                                    int i7 = i6 + 1;
                                    if (i7 == this.limit) {
                                        this.s.request(i7);
                                        i7 = 0;
                                    }
                                    i = 0;
                                    i6 = i7;
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.N(th2);
                                this.s.cancel();
                                for (c<? super T> cVar3 : cVarArr) {
                                    cVar3.onError(th2);
                                }
                                return;
                            }
                        } else {
                            i = i5 + 1;
                        }
                        i3++;
                        if (i3 == length) {
                            i3 = 0;
                        }
                        if (i == length) {
                            i4 = i6;
                        } else {
                            i5 = i;
                        }
                    }
                    int i8 = get();
                    if (i8 == i2) {
                        this.index = i3;
                        this.produced = i4;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i8;
                    }
                }
                fVar.clear();
                return;
            }
        }

        void drainSync() {
            int i = 1;
            f<T> fVar = this.queue;
            c<? super T>[] cVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            while (true) {
                int i3 = 0;
                while (!this.cancelled) {
                    if (fVar.isEmpty()) {
                        for (c<? super T> cVar : cVarArr) {
                            cVar.onComplete();
                        }
                        return;
                    }
                    long j = atomicLongArray.get(i2);
                    long j2 = jArr[i2];
                    if (j != j2 && atomicLongArray.get(length + i2) == 0) {
                        try {
                            T poll = fVar.poll();
                            if (poll == null) {
                                for (c<? super T> cVar2 : cVarArr) {
                                    cVar2.onComplete();
                                }
                                return;
                            }
                            cVarArr[i2].onNext(poll);
                            jArr[i2] = 1 + j2;
                            i3 = 0;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.N(th);
                            this.s.cancel();
                            for (c<? super T> cVar3 : cVarArr) {
                                cVar3.onError(th);
                            }
                            return;
                        }
                    } else {
                        i3++;
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                        continue;
                    }
                    if (i3 == length) {
                        int i4 = get();
                        if (i4 == i) {
                            this.index = i2;
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            i = i4;
                        }
                    }
                }
                fVar.clear();
                return;
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.sourceMode == 1) {
                    drainSync();
                } else {
                    drainAsync();
                }
            }
        }
    }
}
