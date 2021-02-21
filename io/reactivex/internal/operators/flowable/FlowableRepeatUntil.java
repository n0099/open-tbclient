package io.reactivex.internal.operators.flowable;

import io.reactivex.b.e;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableRepeatUntil<T> extends a<T, T> {
    final e qpc;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        cVar.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(cVar, this.qpc, subscriptionArbiter, this.qow).subscribeNext();
    }

    /* loaded from: classes5.dex */
    static final class RepeatSubscriber<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> actual;
        long produced;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;
        final e stop;

        RepeatSubscriber(org.a.c<? super T> cVar, e eVar, SubscriptionArbiter subscriptionArbiter, org.a.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = subscriptionArbiter;
            this.source = bVar;
            this.stop = eVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            this.sa.setSubscription(dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                this.actual.onError(th);
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
