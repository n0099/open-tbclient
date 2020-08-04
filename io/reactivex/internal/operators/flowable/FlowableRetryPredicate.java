package io.reactivex.internal.operators.flowable;

import io.reactivex.c.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRetryPredicate<T> extends a<T, T> {
    final long count;
    final j<? super Throwable> predicate;

    public FlowableRetryPredicate(io.reactivex.g<T> gVar, long j, j<? super Throwable> jVar) {
        super(gVar);
        this.predicate = jVar;
        this.count = j;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        cVar.onSubscribe(subscriptionArbiter);
        new RetrySubscriber(cVar, this.count, this.predicate, subscriptionArbiter, this.nSG).subscribeNext();
    }

    /* loaded from: classes7.dex */
    static final class RetrySubscriber<T> extends AtomicInteger implements io.reactivex.j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> actual;
        final j<? super Throwable> predicate;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;

        RetrySubscriber(org.a.c<? super T> cVar, long j, j<? super Throwable> jVar, SubscriptionArbiter subscriptionArbiter, org.a.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = subscriptionArbiter;
            this.source = bVar;
            this.predicate = jVar;
            this.remaining = j;
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
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    this.actual.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.K(th2);
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
