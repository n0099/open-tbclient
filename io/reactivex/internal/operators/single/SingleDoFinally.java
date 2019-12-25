package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class SingleDoFinally<T> extends w<T> {
    final io.reactivex.b.a onFinally;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.source.a(new DoFinallyObserver(yVar, this.onFinally));
    }

    /* loaded from: classes4.dex */
    static final class DoFinallyObserver<T> extends AtomicInteger implements b, y<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final y<? super T> actual;
        b d;
        final io.reactivex.b.a onFinally;

        DoFinallyObserver(y<? super T> yVar, io.reactivex.b.a aVar) {
            this.actual = yVar;
            this.onFinally = aVar;
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
            this.actual.onSuccess(t);
            runFinally();
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    io.reactivex.d.a.onError(th);
                }
            }
        }
    }
}
