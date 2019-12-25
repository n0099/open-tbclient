package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.b.j;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.d;
/* loaded from: classes4.dex */
public final class FlowableAll<T> extends a<T, Boolean> {
    final j<? super T> predicate;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super Boolean> cVar) {
        this.mTG.a((io.reactivex.j) new AllSubscriber(cVar, this.predicate));
    }

    /* loaded from: classes4.dex */
    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements io.reactivex.j<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final j<? super T> predicate;
        d s;

        AllSubscriber(org.a.c<? super Boolean> cVar, j<? super T> jVar) {
            super(cVar);
            this.predicate = jVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
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
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.s.cancel();
                        complete(false);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(true);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
