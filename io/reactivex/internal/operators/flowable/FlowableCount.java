package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes5.dex */
public final class FlowableCount<T> extends a<T, Long> {
    @Override // io.reactivex.g
    protected void a(org.a.c<? super Long> cVar) {
        this.pOn.a((j) new CountSubscriber(cVar));
    }

    /* loaded from: classes5.dex */
    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements j<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        org.a.d s;

        CountSubscriber(org.a.c<? super Long> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            this.count++;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
