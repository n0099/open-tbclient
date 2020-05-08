package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.i;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final boolean delayError;
    final h<? super io.reactivex.g<T>, ? extends org.a.b<? extends R>> mSr;
    final int prefetch;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        a aVar = new a(this.prefetch, this.delayError);
        try {
            ((org.a.b) io.reactivex.internal.functions.a.h(this.mSr.apply(aVar), "selector returned a null Publisher")).subscribe(new b(cVar, aVar));
            this.mRM.a((j) aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class b<R> implements j<R>, org.a.d {
        final org.a.c<? super R> actual;
        final a<?> mSu;
        org.a.d s;

        b(org.a.c<? super R> cVar, a<?> aVar) {
            this.actual = cVar;
            this.mSu = aVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.mSu.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
            this.mSu.dispose();
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            this.mSu.dispose();
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> extends io.reactivex.g<T> implements io.reactivex.disposables.b, j<T> {
        static final MulticastSubscription[] mSs = new MulticastSubscription[0];
        static final MulticastSubscription[] mSt = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile io.reactivex.internal.a.g<T> queue;
        int sourceMode;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<org.a.d> s = new AtomicReference<>();
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(mSs);

        a(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this.s, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        i.a(dVar, this.prefetch);
                        return;
                    }
                }
                this.queue = i.Jb(this.prefetch);
                i.a(dVar, this.prefetch);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.internal.a.g<T> gVar;
            SubscriptionHelper.cancel(this.s);
            if (this.wip.getAndIncrement() == 0 && (gVar = this.queue) != null) {
                gVar.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.s.get());
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 0 && !this.queue.offer(t)) {
                    this.s.get().cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                drain();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        boolean a(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr == mSt) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        void b(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr != mSt && multicastSubscriptionArr != mSs) {
                    int length = multicastSubscriptionArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = mSs;
                        } else {
                            multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                            System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.g
        protected void a(org.a.c<? super T> cVar) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(cVar, this);
            cVar.onSubscribe(multicastSubscription);
            if (a(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    b(multicastSubscription);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            Throwable th = this.error;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                io.reactivex.internal.a.g<T> gVar = this.queue;
                int i2 = this.consumed;
                int i3 = this.limit;
                boolean z = this.sourceMode != 1;
                while (true) {
                    MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
                    int length = multicastSubscriptionArr.length;
                    if (gVar != null && length != 0) {
                        long j = Long.MAX_VALUE;
                        int length2 = multicastSubscriptionArr.length;
                        int i4 = 0;
                        while (i4 < length2) {
                            long j2 = multicastSubscriptionArr[i4].get();
                            if (j2 == Long.MIN_VALUE || j <= j2) {
                                j2 = j;
                            }
                            i4++;
                            j = j2;
                        }
                        long j3 = 0;
                        while (j3 != j) {
                            if (isDisposed()) {
                                gVar.clear();
                                return;
                            }
                            boolean z2 = this.done;
                            if (z2 && !this.delayError && (th2 = this.error) != null) {
                                errorAll(th2);
                                return;
                            }
                            try {
                                T poll = gVar.poll();
                                boolean z3 = poll == null;
                                if (z2 && z3) {
                                    Throwable th3 = this.error;
                                    if (th3 != null) {
                                        errorAll(th3);
                                        return;
                                    } else {
                                        dCK();
                                        return;
                                    }
                                } else if (z3) {
                                    break;
                                } else {
                                    for (MulticastSubscription<T> multicastSubscription : multicastSubscriptionArr) {
                                        if (multicastSubscription.get() != Long.MIN_VALUE) {
                                            multicastSubscription.actual.onNext(poll);
                                        }
                                    }
                                    j3++;
                                    if (z && (i2 = i2 + 1) == i3) {
                                        this.s.get().request(i3);
                                        i2 = 0;
                                    }
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.L(th4);
                                SubscriptionHelper.cancel(this.s);
                                errorAll(th4);
                                return;
                            }
                        }
                        if (j3 == j) {
                            if (isDisposed()) {
                                gVar.clear();
                                return;
                            }
                            boolean z4 = this.done;
                            if (z4 && !this.delayError && (th = this.error) != null) {
                                errorAll(th);
                                return;
                            } else if (z4 && gVar.isEmpty()) {
                                Throwable th5 = this.error;
                                if (th5 != null) {
                                    errorAll(th5);
                                    return;
                                } else {
                                    dCK();
                                    return;
                                }
                            }
                        }
                        for (MulticastSubscription<T> multicastSubscription2 : multicastSubscriptionArr) {
                            io.reactivex.internal.util.b.c(multicastSubscription2, j3);
                        }
                    }
                    int i5 = i2;
                    this.consumed = i5;
                    i = this.wip.addAndGet(-i);
                    if (i != 0) {
                        gVar = gVar == null ? this.queue : gVar;
                        i2 = i5;
                    } else {
                        return;
                    }
                }
            }
        }

        void errorAll(Throwable th) {
            MulticastSubscription<T>[] andSet;
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(mSt)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        void dCK() {
            MulticastSubscription<T>[] andSet;
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(mSt)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = 8664815189257569791L;
        final org.a.c<? super T> actual;
        final a<T> parent;

        MulticastSubscription(org.a.c<? super T> cVar, a<T> aVar) {
            this.actual = cVar;
            this.parent = aVar;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                this.parent.drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
