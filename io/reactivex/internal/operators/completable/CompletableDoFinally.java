package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableDoFinally extends a {
    final io.reactivex.b.a onFinally;
    final e source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        this.source.a(new DoFinallyObserver(cVar, this.onFinally));
    }

    /* loaded from: classes9.dex */
    static final class DoFinallyObserver extends AtomicInteger implements c, b {
        private static final long serialVersionUID = 4109457741734051389L;
        final c actual;
        b d;
        final io.reactivex.b.a onFinally;

        DoFinallyObserver(c cVar, io.reactivex.b.a aVar) {
            this.actual = cVar;
            this.onFinally = aVar;
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.actual.onComplete();
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
                    io.reactivex.exceptions.a.J(th);
                    io.reactivex.d.a.onError(th);
                }
            }
        }
    }
}
