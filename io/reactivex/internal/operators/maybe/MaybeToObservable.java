package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.u;
/* loaded from: classes5.dex */
public final class MaybeToObservable<T> extends q<T> {
    final o<T> source;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.a(new MaybeToFlowableSubscriber(uVar));
    }

    /* loaded from: classes5.dex */
    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarDisposable<T> implements m<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b d;

        MaybeToFlowableSubscriber(u<? super T> uVar) {
            super(uVar);
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
            error(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.d.dispose();
        }
    }
}
