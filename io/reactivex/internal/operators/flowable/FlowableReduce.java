package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class FlowableReduce<T> extends a<T, T> {
    final io.reactivex.c.c<T, T, T> reducer;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omT.a((j) new ReduceSubscriber(cVar, this.reducer));
    }

    /* loaded from: classes7.dex */
    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final io.reactivex.c.c<T, T, T> reducer;
        org.b.d s;

        ReduceSubscriber(org.b.c<? super T> cVar, io.reactivex.c.c<T, T, T> cVar2) {
            super(cVar);
            this.reducer = cVar2;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = (T) io.reactivex.internal.functions.a.k(this.reducer.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (this.s == SubscriptionHelper.CANCELLED) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.s = SubscriptionHelper.CANCELLED;
                T t = this.value;
                if (t != null) {
                    complete(t);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.b.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
        }
    }
}
