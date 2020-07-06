package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableAmb<T> extends io.reactivex.g<T> {
    final Iterable<? extends org.a.b<? extends T>> nJX;
    final org.a.b<? extends T>[] sources;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        int length;
        org.a.b<? extends T>[] bVarArr = this.sources;
        if (bVarArr == null) {
            org.a.b<? extends T>[] bVarArr2 = new org.a.b[8];
            try {
                int i = 0;
                for (org.a.b<? extends T> bVar : this.nJX) {
                    if (bVar == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (i == bVarArr2.length) {
                        org.a.b<? extends T>[] bVarArr3 = new org.a.b[(i >> 2) + i];
                        System.arraycopy(bVarArr2, 0, bVarArr3, 0, i);
                        bVarArr2 = bVarArr3;
                    }
                    int i2 = i + 1;
                    bVarArr2[i] = bVar;
                    i = i2;
                }
                length = i;
                bVarArr = bVarArr2;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                EmptySubscription.error(th, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(cVar);
        } else if (length == 1) {
            bVarArr[0].subscribe(cVar);
        } else {
            new a(cVar, length).a(bVarArr);
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements org.a.d {
        final org.a.c<? super T> actual;
        final AmbInnerSubscriber<T>[] nJY;
        final AtomicInteger nJZ = new AtomicInteger();

        a(org.a.c<? super T> cVar, int i) {
            this.actual = cVar;
            this.nJY = new AmbInnerSubscriber[i];
        }

        public void a(org.a.b<? extends T>[] bVarArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.nJY;
            int length = ambInnerSubscriberArr.length;
            for (int i = 0; i < length; i++) {
                ambInnerSubscriberArr[i] = new AmbInnerSubscriber<>(this, i + 1, this.actual);
            }
            this.nJZ.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && this.nJZ.get() == 0; i2++) {
                bVarArr[i2].subscribe(ambInnerSubscriberArr[i2]);
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.nJZ.get();
                if (i > 0) {
                    this.nJY[i - 1].request(j);
                } else if (i == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.nJY) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public boolean KQ(int i) {
            if (this.nJZ.get() == 0 && this.nJZ.compareAndSet(0, i)) {
                AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.nJY;
                int length = ambInnerSubscriberArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 + 1 != i) {
                        ambInnerSubscriberArr[i2].cancel();
                    }
                }
                return true;
            }
            return false;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.nJZ.get() != -1) {
                this.nJZ.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.nJY) {
                    ambInnerSubscriber.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AmbInnerSubscriber<T> extends AtomicReference<org.a.d> implements j<T>, org.a.d {
        private static final long serialVersionUID = -1185974347409665484L;
        final org.a.c<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final a<T> parent;
        boolean won;

        AmbInnerSubscriber(a<T> aVar, int i, org.a.c<? super T> cVar) {
            this.parent = aVar;
            this.index = i;
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dVar);
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (this.parent.KQ(this.index)) {
                this.won = true;
                this.actual.onNext(t);
            } else {
                get().cancel();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.KQ(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.KQ(this.index)) {
                this.won = true;
                this.actual.onComplete();
            } else {
                get().cancel();
            }
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
