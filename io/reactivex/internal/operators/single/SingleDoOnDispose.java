package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDoOnDispose<T> extends w<T> {
    final io.reactivex.c.a nMl;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.source.a(new DoOnDisposeObserver(yVar, this.nMl));
    }

    /* loaded from: classes7.dex */
    static final class DoOnDisposeObserver<T> extends AtomicReference<io.reactivex.c.a> implements io.reactivex.disposables.b, y<T> {
        private static final long serialVersionUID = -8583764624474935784L;
        final y<? super T> actual;
        io.reactivex.disposables.b d;

        DoOnDisposeObserver(y<? super T> yVar, io.reactivex.c.a aVar) {
            this.actual = yVar;
            lazySet(aVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.c.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    io.reactivex.e.a.onError(th);
                }
                this.d.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
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
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }
}
