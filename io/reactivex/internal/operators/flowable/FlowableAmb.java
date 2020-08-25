package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableAmb<T> extends io.reactivex.g<T> {
    final Iterable<? extends org.b.b<? extends T>> omC;
    final org.b.b<? extends T>[] sources;

    @Override // io.reactivex.g
    public void a(org.b.c<? super T> cVar) {
        int length;
        org.b.b<? extends T>[] bVarArr = this.sources;
        if (bVarArr == null) {
            org.b.b<? extends T>[] bVarArr2 = new org.b.b[8];
            try {
                int i = 0;
                for (org.b.b<? extends T> bVar : this.omC) {
                    if (bVar == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (i == bVarArr2.length) {
                        org.b.b<? extends T>[] bVarArr3 = new org.b.b[(i >> 2) + i];
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
                io.reactivex.exceptions.a.J(th);
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
    static final class a<T> implements org.b.d {
        final org.b.c<? super T> actual;
        final AmbInnerSubscriber<T>[] omD;
        final AtomicInteger omE = new AtomicInteger();

        a(org.b.c<? super T> cVar, int i) {
            this.actual = cVar;
            this.omD = new AmbInnerSubscriber[i];
        }

        public void a(org.b.b<? extends T>[] bVarArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.omD;
            int length = ambInnerSubscriberArr.length;
            for (int i = 0; i < length; i++) {
                ambInnerSubscriberArr[i] = new AmbInnerSubscriber<>(this, i + 1, this.actual);
            }
            this.omE.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && this.omE.get() == 0; i2++) {
                bVarArr[i2].subscribe(ambInnerSubscriberArr[i2]);
            }
        }

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.omE.get();
                if (i > 0) {
                    this.omD[i - 1].request(j);
                } else if (i == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.omD) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public boolean NN(int i) {
            if (this.omE.get() == 0 && this.omE.compareAndSet(0, i)) {
                AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.omD;
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

        @Override // org.b.d
        public void cancel() {
            if (this.omE.get() != -1) {
                this.omE.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.omD) {
                    ambInnerSubscriber.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AmbInnerSubscriber<T> extends AtomicReference<org.b.d> implements j<T>, org.b.d {
        private static final long serialVersionUID = -1185974347409665484L;
        final org.b.c<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final a<T> parent;
        boolean won;

        AmbInnerSubscriber(a<T> aVar, int i, org.b.c<? super T> cVar) {
            this.parent = aVar;
            this.index = i;
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dVar);
        }

        @Override // org.b.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (this.parent.NN(this.index)) {
                this.won = true;
                this.actual.onNext(t);
            } else {
                get().cancel();
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.NN(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.b.c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.NN(this.index)) {
                this.won = true;
                this.actual.onComplete();
            } else {
                get().cancel();
            }
        }

        @Override // org.b.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
