package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.operators.flowable.b;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableCombineLatest<T, R> extends g<R> {
    final int bufferSize;
    final h<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final org.a.b<? extends T>[] qiC;
    final Iterable<? extends org.a.b<? extends T>> qiD;

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> cVar) {
        int length;
        org.a.b<? extends T>[] bVarArr;
        org.a.b<? extends T>[] bVarArr2;
        org.a.b<? extends T>[] bVarArr3 = this.qiC;
        if (bVarArr3 == null) {
            org.a.b<? extends T>[] bVarArr4 = new org.a.b[8];
            try {
                Iterator it = (Iterator) io.reactivex.internal.functions.a.m(this.qiD.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            org.a.b<? extends T> bVar = (org.a.b) io.reactivex.internal.functions.a.m(it.next(), "The publisher returned by the iterator is null");
                            if (length == bVarArr4.length) {
                                bVarArr2 = new org.a.b[(length >> 2) + length];
                                System.arraycopy(bVarArr4, 0, bVarArr2, 0, length);
                            } else {
                                bVarArr2 = bVarArr4;
                            }
                            bVarArr2[length] = bVar;
                            length++;
                            bVarArr4 = bVarArr2;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.O(th);
                            EmptySubscription.error(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.O(th2);
                        EmptySubscription.error(th2, cVar);
                        return;
                    }
                }
                bVarArr = bVarArr4;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.O(th3);
                EmptySubscription.error(th3, cVar);
                return;
            }
        } else {
            length = bVarArr3.length;
            bVarArr = bVarArr3;
        }
        if (length == 0) {
            EmptySubscription.complete(cVar);
        } else if (length == 1) {
            bVarArr[0].subscribe(new b.C1307b(cVar, new a()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(cVar, this.combiner, length, this.bufferSize, this.delayErrors);
            cVar.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.subscribe(bVarArr, length);
        }
    }

    /* loaded from: classes5.dex */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        final h<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(org.a.c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
            this.actual = cVar;
            this.combiner = hVar;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new io.reactivex.internal.queue.a<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
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
            this.cancelled = true;
            cancelAll();
        }

        void subscribe(org.a.b<? extends T>[] bVarArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                bVarArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }

        void innerValue(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i2 = this.nonEmptySources;
                if (objArr[i] == null) {
                    i2++;
                    this.nonEmptySources = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    this.queue.offer(this.subscribers[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i].requestOne();
            } else {
                drain();
            }
        }

        void innerComplete(int i) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i] != null) {
                    int i2 = this.completedSources + 1;
                    if (i2 == objArr.length) {
                        this.done = true;
                    } else {
                        this.completedSources = i2;
                        return;
                    }
                } else {
                    this.done = true;
                }
                drain();
            }
        }

        void innerError(int i, Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                if (!this.delayErrors) {
                    cancelAll();
                    this.done = true;
                    drain();
                    return;
                }
                innerComplete(i);
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        void drainOutput() {
            org.a.c<? super R> cVar = this.actual;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            int i = 1;
            while (true) {
                int i2 = i;
                if (this.cancelled) {
                    aVar.clear();
                    return;
                }
                Throwable th = this.error.get();
                if (th != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean isEmpty = aVar.isEmpty();
                if (!isEmpty) {
                    cVar.onNext(null);
                }
                if (z && isEmpty) {
                    cVar.onComplete();
                    return;
                }
                i = addAndGet(-i2);
                if (i == 0) {
                    return;
                }
            }
        }

        void drainAsync() {
            org.a.c<? super R> cVar = this.actual;
            io.reactivex.internal.queue.a<?> aVar = this.queue;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = aVar.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, cVar, aVar)) {
                        if (z2) {
                            break;
                        }
                        try {
                            cVar.onNext((Object) io.reactivex.internal.functions.a.m(this.combiner.apply((Object[]) aVar.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j2 = 1 + j2;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.O(th);
                            cancelAll();
                            ExceptionHelper.addThrowable(this.error, th);
                            cVar.onError(ExceptionHelper.terminate(this.error));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != j || !checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                } else {
                    return;
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainOutput();
                } else {
                    drainAsync();
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                cancelAll();
                aVar.clear();
                return true;
            }
            if (z) {
                if (this.delayErrors) {
                    if (z2) {
                        cancelAll();
                        Throwable terminate = ExceptionHelper.terminate(this.error);
                        if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                            cVar.onError(terminate);
                            return true;
                        }
                        cVar.onComplete();
                        return true;
                    }
                } else {
                    Throwable terminate2 = ExceptionHelper.terminate(this.error);
                    if (terminate2 != null && terminate2 != ExceptionHelper.TERMINATED) {
                        cancelAll();
                        aVar.clear();
                        cVar.onError(terminate2);
                        return true;
                    } else if (z2) {
                        cancelAll();
                        cVar.onComplete();
                        return true;
                    }
                }
            }
            return false;
        }

        void cancelAll() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.cancel();
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            this.outputFused = i2 != 0;
            return i2;
        }

        @Override // io.reactivex.internal.a.f
        public R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) io.reactivex.internal.functions.a.m(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return r;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<d> implements j<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void requestOne() {
            int i = this.produced + 1;
            if (i == this.limit) {
                this.produced = 0;
                get().request(i);
                return;
            }
            this.produced = i;
        }
    }

    /* loaded from: classes5.dex */
    final class a implements h<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.b.h
        public R apply(T t) throws Exception {
            return FlowableCombineLatest.this.combiner.apply(new Object[]{t});
        }
    }
}
