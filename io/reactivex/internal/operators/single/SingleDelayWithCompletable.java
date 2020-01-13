package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class SingleDelayWithCompletable<T> extends w<T> {
    final e other;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.other.a(new OtherObserver(yVar, this.source));
    }

    /* loaded from: classes5.dex */
    static final class OtherObserver<T> extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = -8565274649390031272L;
        final y<? super T> actual;
        final aa<T> source;

        OtherObserver(y<? super T> yVar, aa<T> aaVar) {
            this.actual = yVar;
            this.source = aaVar;
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.source.a(new io.reactivex.internal.observers.c(this, this.actual));
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
