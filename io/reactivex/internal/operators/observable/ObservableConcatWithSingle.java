package io.reactivex.internal.operators.observable;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableConcatWithSingle<T> extends a<T, T> {
    final aa<? extends T> other;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new ConcatWithObserver(uVar, this.other));
    }

    /* loaded from: classes5.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T>, y<T> {
        private static final long serialVersionUID = -1953724749712440952L;
        final u<? super T> actual;
        boolean inSingle;
        aa<? extends T> other;

        ConcatWithObserver(u<? super T> uVar, aa<? extends T> aaVar) {
            this.actual = uVar;
            this.other = aaVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && !this.inSingle) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.actual.onNext(t);
            this.actual.onComplete();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.inSingle = true;
            DisposableHelper.replace(this, null);
            aa<? extends T> aaVar = this.other;
            this.other = null;
            aaVar.a(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
