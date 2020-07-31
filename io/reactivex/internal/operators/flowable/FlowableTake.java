package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableTake<T> extends a<T, T> {
    final long limit;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nSE.a((j) new TakeSubscriber(cVar, this.limit));
    }

    /* loaded from: classes7.dex */
    static final class TakeSubscriber<T> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = -5636543848937116287L;
        final org.a.c<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        org.a.d subscription;

        TakeSubscriber(org.a.c<? super T> cVar, long j) {
            this.actual = cVar;
            this.limit = j;
            this.remaining = j;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                if (this.limit == 0) {
                    dVar.cancel();
                    this.done = true;
                    EmptySubscription.complete(this.actual);
                    return;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.remaining;
            this.remaining = j - 1;
            if (j > 0) {
                boolean z = this.remaining == 0;
                this.actual.onNext(t);
                if (z) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.subscription.cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (!get() && compareAndSet(false, true) && j >= this.limit) {
                    this.subscription.request(Long.MAX_VALUE);
                } else {
                    this.subscription.request(j);
                }
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.subscription.cancel();
        }
    }
}
