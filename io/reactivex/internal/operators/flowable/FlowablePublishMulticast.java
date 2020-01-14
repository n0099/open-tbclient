package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.i;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final boolean delayError;
    final h<? super io.reactivex.g<T>, ? extends org.a.b<? extends R>> nws;
    final int prefetch;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        a aVar = new a(this.prefetch, this.delayError);
        try {
            ((org.a.b) io.reactivex.internal.functions.a.h(this.nws.apply(aVar), "selector returned a null Publisher")).subscribe(new b(cVar, aVar));
            this.nvP.a((j) aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.I(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes5.dex */
    static final class b<R> implements j<R>, org.a.d {
        final org.a.c<? super R> actual;
        final a<?> nwv;
        org.a.d s;

        b(org.a.c<? super R> cVar, a<?> aVar) {
            this.actual = cVar;
            this.nwv = aVar;
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
            this.nwv.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
            this.nwv.dispose();
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            this.nwv.dispose();
        }
    }

    /* loaded from: classes5.dex */
    static final class a<T> extends io.reactivex.g<T> implements io.reactivex.disposables.b, j<T> {
        static final MulticastSubscription[] nwt = new MulticastSubscription[0];
        static final MulticastSubscription[] nwu = new MulticastSubscription[0];
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
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(nwt);

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
                this.queue = i.Ny(this.prefetch);
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
                if (multicastSubscriptionArr == nwu) {
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
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
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
                            multicastSubscriptionArr2 = nwt;
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
            int i;
            int i2;
            Throwable th;
            boolean z;
            Throwable th2;
            if (this.wip.getAndIncrement() == 0) {
                io.reactivex.internal.a.g<T> gVar = this.queue;
                int i3 = this.consumed;
                int i4 = this.limit;
                boolean z2 = this.sourceMode != 1;
                AtomicReference<MulticastSubscription<T>[]> atomicReference = this.subscribers;
                int i5 = 1;
                io.reactivex.internal.a.g<T> gVar2 = gVar;
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                int i6 = i3;
                while (true) {
                    int length = multicastSubscriptionArr.length;
                    if (gVar2 == null || length == 0) {
                        i = i6;
                    } else {
                        long j = Format.OFFSET_SAMPLE_RELATIVE;
                        int length2 = multicastSubscriptionArr.length;
                        int i7 = 0;
                        int i8 = length;
                        while (i7 < length2) {
                            MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i7];
                            long j2 = multicastSubscription.get() - multicastSubscription.emitted;
                            if (j2 != Long.MIN_VALUE) {
                                if (j <= j2) {
                                    j2 = j;
                                }
                            } else {
                                i8--;
                                j2 = j;
                            }
                            i7++;
                            j = j2;
                        }
                        if (i8 == 0) {
                            j = 0;
                            i2 = i6;
                        } else {
                            i2 = i6;
                        }
                        while (j != 0) {
                            if (isDisposed()) {
                                gVar2.clear();
                                return;
                            }
                            boolean z3 = this.done;
                            if (z3 && !this.delayError && (th2 = this.error) != null) {
                                errorAll(th2);
                                return;
                            }
                            try {
                                T poll = gVar2.poll();
                                boolean z4 = poll == null;
                                if (z3 && z4) {
                                    Throwable th3 = this.error;
                                    if (th3 != null) {
                                        errorAll(th3);
                                        return;
                                    } else {
                                        dIf();
                                        return;
                                    }
                                } else if (!z4) {
                                    boolean z5 = false;
                                    int length3 = multicastSubscriptionArr.length;
                                    int i9 = 0;
                                    while (i9 < length3) {
                                        MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i9];
                                        long j3 = multicastSubscription2.get();
                                        if (j3 != Long.MIN_VALUE) {
                                            if (j3 != Format.OFFSET_SAMPLE_RELATIVE) {
                                                multicastSubscription2.emitted++;
                                            }
                                            multicastSubscription2.actual.onNext(poll);
                                            z = z5;
                                        } else {
                                            z = true;
                                        }
                                        i9++;
                                        z5 = z;
                                    }
                                    j--;
                                    if (z2 && (i2 = i2 + 1) == i4) {
                                        i2 = 0;
                                        this.s.get().request(i4);
                                    }
                                    MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                                    if (!z5) {
                                        if (multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                        }
                                    }
                                    multicastSubscriptionArr = multicastSubscriptionArr2;
                                    i6 = i2;
                                    break;
                                } else {
                                    break;
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.I(th4);
                                SubscriptionHelper.cancel(this.s);
                                errorAll(th4);
                                return;
                            }
                        }
                        if (j == 0) {
                            if (isDisposed()) {
                                gVar2.clear();
                                return;
                            }
                            boolean z6 = this.done;
                            if (z6 && !this.delayError && (th = this.error) != null) {
                                errorAll(th);
                                return;
                            } else if (z6 && gVar2.isEmpty()) {
                                Throwable th5 = this.error;
                                if (th5 != null) {
                                    errorAll(th5);
                                    return;
                                } else {
                                    dIf();
                                    return;
                                }
                            }
                        }
                        i = i2;
                    }
                    this.consumed = i;
                    i5 = this.wip.addAndGet(-i5);
                    if (i5 != 0) {
                        gVar2 = gVar2 == null ? this.queue : gVar2;
                        int i10 = i;
                        multicastSubscriptionArr = atomicReference.get();
                        i6 = i10;
                    } else {
                        return;
                    }
                }
            }
        }

        void errorAll(Throwable th) {
            MulticastSubscription<T>[] andSet;
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(nwu)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        void dIf() {
            MulticastSubscription<T>[] andSet;
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(nwu)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements org.a.d {
        private static final long serialVersionUID = 8664815189257569791L;
        final org.a.c<? super T> actual;
        long emitted;
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
