package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes5.dex */
public final class FlowableTakeLastOne<T> extends a<T, T> {
    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nvK.a((j) new TakeLastOneSubscriber(cVar));
    }

    /* loaded from: classes5.dex */
    static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        org.a.d s;

        TakeLastOneSubscriber(org.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
