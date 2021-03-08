package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.d;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class SingleDelayWithSingle<T, U> extends w<T> {
    final aa<U> other;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.other.a(new OtherObserver(yVar, this.source));
    }

    /* loaded from: classes6.dex */
    static final class OtherObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<U> {
        private static final long serialVersionUID = -8565274649390031272L;
        final y<? super T> actual;
        final aa<T> source;

        OtherObserver(y<? super T> yVar, aa<T> aaVar) {
            this.actual = yVar;
            this.source = aaVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.set(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(U u) {
            this.source.a(new d(this, this.actual));
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
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
