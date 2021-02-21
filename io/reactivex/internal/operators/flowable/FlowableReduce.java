package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableReduce<T> extends a<T, T> {
    final io.reactivex.b.c<T, T, T> reducer;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qow.a((j) new ReduceSubscriber(cVar, this.reducer));
    }

    /* loaded from: classes5.dex */
    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final io.reactivex.b.c<T, T, T> reducer;
        d s;

        ReduceSubscriber(org.a.c<? super T> cVar, io.reactivex.b.c<T, T, T> cVar2) {
            super(cVar);
            this.reducer = cVar2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = (T) io.reactivex.internal.functions.a.m(this.reducer.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.N(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.s == SubscriptionHelper.CANCELLED) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.a.c
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

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
        }
    }
}
