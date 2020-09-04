package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRepeat<T> extends a<T, T> {
    final long count;

    @Override // io.reactivex.g
    public void a(org.b.c<? super T> cVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        cVar.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(cVar, this.count != Long.MAX_VALUE ? this.count - 1 : Long.MAX_VALUE, subscriptionArbiter, this.omT).subscribeNext();
    }

    /* loaded from: classes7.dex */
    static final class RepeatSubscriber<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.b.c<? super T> actual;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final org.b.b<? extends T> source;

        RepeatSubscriber(org.b.c<? super T> cVar, long j, SubscriptionArbiter subscriptionArbiter, org.b.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = subscriptionArbiter;
            this.source = bVar;
            this.remaining = j;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            this.sa.setSubscription(dVar);
        }

        @Override // org.b.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
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
