package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.j;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableAny<T> extends a<T, Boolean> {
    final j<? super T> predicate;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super Boolean> cVar) {
        this.nwE.a((io.reactivex.j) new AnySubscriber(cVar, this.predicate));
    }

    /* loaded from: classes7.dex */
    static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements io.reactivex.j<T> {
        private static final long serialVersionUID = -2311252482644620661L;
        boolean done;
        final j<? super T> predicate;
        org.a.d s;

        AnySubscriber(org.a.c<? super Boolean> cVar, j<? super T> jVar) {
            super(cVar);
            this.predicate = jVar;
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
            if (!this.done) {
                try {
                    if (this.predicate.test(t)) {
                        this.done = true;
                        this.s.cancel();
                        complete(true);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    this.s.cancel();
                    onError(th);
                }
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
                complete(false);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
