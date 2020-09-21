package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.y;
import org.a.c;
/* loaded from: classes25.dex */
public final class SingleToFlowable<T> extends g<T> {
    final aa<? extends T> source;

    public SingleToFlowable(aa<? extends T> aaVar) {
        this.source = aaVar;
    }

    @Override // io.reactivex.g
    public void a(c<? super T> cVar) {
        this.source.a(new SingleToFlowableObserver(cVar));
    }

    /* loaded from: classes25.dex */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements y<T> {
        private static final long serialVersionUID = 187782011903685568L;
        io.reactivex.disposables.b d;

        SingleToFlowableObserver(c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            complete(t);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.d.dispose();
        }
    }
}
