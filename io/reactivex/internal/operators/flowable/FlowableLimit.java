package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class FlowableLimit<T> extends a<T, T> {
    final long n;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.pOn.a((j) new LimitSubscriber(cVar, this.n));
    }

    /* loaded from: classes5.dex */
    static final class LimitSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = 2288246011222124525L;
        final org.a.c<? super T> actual;
        long remaining;
        org.a.d upstream;

        LimitSubscriber(org.a.c<? super T> cVar, long j) {
            this.actual = cVar;
            this.remaining = j;
            lazySet(j);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                if (this.remaining == 0) {
                    dVar.cancel();
                    EmptySubscription.complete(this.actual);
                    return;
                }
                this.upstream = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = this.remaining;
            if (j > 0) {
                long j2 = j - 1;
                this.remaining = j2;
                this.actual.onNext(t);
                if (j2 == 0) {
                    this.upstream.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.actual.onComplete();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != 0) {
                        j3 = j2 <= j ? j2 : j;
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j2 - j3));
                this.upstream.request(j3);
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }
    }
}
