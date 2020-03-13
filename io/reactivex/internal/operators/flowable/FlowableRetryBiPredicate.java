package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRetryBiPredicate<T> extends a<T, T> {
    final io.reactivex.c.d<? super Integer, ? super Throwable> predicate;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        cVar.onSubscribe(subscriptionArbiter);
        new RetryBiSubscriber(cVar, this.predicate, subscriptionArbiter, this.nwE).subscribeNext();
    }

    /* loaded from: classes7.dex */
    static final class RetryBiSubscriber<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> actual;
        final io.reactivex.c.d<? super Integer, ? super Throwable> predicate;
        long produced;
        int retries;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;

        RetryBiSubscriber(org.a.c<? super T> cVar, io.reactivex.c.d<? super Integer, ? super Throwable> dVar, SubscriptionArbiter subscriptionArbiter, org.a.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = subscriptionArbiter;
            this.source = bVar;
            this.predicate = dVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            this.sa.setSubscription(dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            try {
                io.reactivex.c.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (!dVar.j(Integer.valueOf(i), th)) {
                    this.actual.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.H(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.sa.isCancelled()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0L;
                        this.sa.produced(j);
                    }
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
