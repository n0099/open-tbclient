package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.d;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class SingleResumeNext<T> extends w<T> {
    final h<? super Throwable, ? extends aa<? extends T>> nextFunction;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.source.a(new ResumeMainSingleObserver(yVar, this.nextFunction));
    }

    /* loaded from: classes5.dex */
    static final class ResumeMainSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
        private static final long serialVersionUID = -5314538511045349925L;
        final y<? super T> actual;
        final h<? super Throwable, ? extends aa<? extends T>> nextFunction;

        ResumeMainSingleObserver(y<? super T> yVar, h<? super Throwable, ? extends aa<? extends T>> hVar) {
            this.actual = yVar;
            this.nextFunction = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            try {
                ((aa) io.reactivex.internal.functions.a.l(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).a(new d(this, this.actual));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
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
