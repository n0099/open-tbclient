package io.reactivex.internal.operators.maybe;

import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.m;
import io.reactivex.o;
import org.a.c;
/* loaded from: classes5.dex */
public final class MaybeToFlowable<T> extends g<T> {
    final o<T> source;

    public MaybeToFlowable(o<T> oVar) {
        this.source = oVar;
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        this.source.a(new MaybeToFlowableSubscriber(cVar));
    }

    /* loaded from: classes5.dex */
    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements m<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b d;

        MaybeToFlowableSubscriber(c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            complete(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.d.dispose();
        }
    }
}
