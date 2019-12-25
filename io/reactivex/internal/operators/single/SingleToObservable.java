package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
/* loaded from: classes4.dex */
public final class SingleToObservable<T> extends q<T> {
    final aa<? extends T> source;

    public SingleToObservable(aa<? extends T> aaVar) {
        this.source = aaVar;
    }

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.a(c(uVar));
    }

    public static <T> y<T> c(u<? super T> uVar) {
        return new SingleToObservableObserver(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements y<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        b d;

        SingleToObservableObserver(u<? super T> uVar) {
            super(uVar);
        }

        @Override // io.reactivex.y
        public void onSubscribe(b bVar) {
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
            error(th);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.d.dispose();
        }
    }
}
