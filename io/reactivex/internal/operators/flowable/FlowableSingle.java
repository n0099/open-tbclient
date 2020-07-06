package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class FlowableSingle<T> extends a<T, T> {
    final T defaultValue;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nJW.a((j) new SingleElementSubscriber(cVar, this.defaultValue));
    }

    /* loaded from: classes7.dex */
    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        org.a.d s;

        SingleElementSubscriber(org.a.c<? super T> cVar, T t) {
            super(cVar);
            this.defaultValue = t;
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
        public void onNext(T t) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.s.cancel();
                    this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t = this.value;
                this.value = null;
                if (t == null) {
                    t = this.defaultValue;
                }
                if (t == null) {
                    this.actual.onComplete();
                } else {
                    complete(t);
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
