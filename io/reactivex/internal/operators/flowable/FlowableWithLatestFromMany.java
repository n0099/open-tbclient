package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class FlowableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final h<? super Object[], R> combiner;
    final org.a.b<?>[] nnX;
    final Iterable<? extends org.a.b<?>> nnY;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        int length;
        org.a.b<?>[] bVarArr = this.nnX;
        int i = 0;
        if (bVarArr == null) {
            bVarArr = new org.a.b[8];
            try {
                for (org.a.b<?> bVar : this.nnY) {
                    if (i == bVarArr.length) {
                        bVarArr = (org.a.b[]) Arrays.copyOf(bVarArr, (i >> 1) + i);
                    }
                    int i2 = i + 1;
                    bVarArr[i] = bVar;
                    i = i2;
                }
                length = i;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                EmptySubscription.error(th, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            new f(this.nmU, new a()).a(cVar);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(cVar, this.combiner, length);
        cVar.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.subscribe(bVarArr, length);
        this.nmU.a((j) withLatestFromSubscriber);
    }

    /* loaded from: classes7.dex */
    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements io.reactivex.internal.a.a<T>, org.a.d {
        private static final long serialVersionUID = 1577321883966341961L;
        final org.a.c<? super R> actual;
        final h<? super Object[], R> combiner;
        volatile boolean done;
        final AtomicThrowable error;
        final AtomicLong requested;
        final AtomicReference<org.a.d> s;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReferenceArray<Object> values;

        WithLatestFromSubscriber(org.a.c<? super R> cVar, h<? super Object[], R> hVar, int i) {
            this.actual = cVar;
            this.combiner = hVar;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerSubscriberArr[i2] = new WithLatestInnerSubscriber(this, i2);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i);
            this.s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        void subscribe(org.a.b<?>[] bVarArr, int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            AtomicReference<org.a.d> atomicReference = this.s;
            for (int i2 = 0; i2 < i && !SubscriptionHelper.isCancelled(atomicReference.get()); i2++) {
                bVarArr[i2].subscribe(withLatestInnerSubscriberArr[i2]);
            }
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.s.get().request(1L);
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            for (int i = 0; i < length; i++) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return false;
                }
                objArr[i + 1] = obj;
            }
            try {
                io.reactivex.internal.util.e.a(this.actual, io.reactivex.internal.functions.a.k(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.s, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                withLatestInnerSubscriber.dispose();
            }
        }

        void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        void innerError(int i, Throwable th) {
            this.done = true;
            SubscriptionHelper.cancel(this.s);
            cancelAllBut(i);
            io.reactivex.internal.util.e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerComplete(int i, boolean z) {
            if (!z) {
                this.done = true;
                SubscriptionHelper.cancel(this.s);
                cancelAllBut(i);
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        void cancelAllBut(int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerSubscriberArr[i2].dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class WithLatestInnerSubscriber extends AtomicReference<org.a.d> implements j<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            this.parent = withLatestFromSubscriber;
            this.index = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements h<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.c.h
        public R apply(T t) throws Exception {
            return (R) io.reactivex.internal.functions.a.k(FlowableWithLatestFromMany.this.combiner.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }
}
