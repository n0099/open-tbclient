package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class MaybeDoFinally<T> extends a<T, T> {
    final io.reactivex.b.a onFinally;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new DoFinallyObserver(mVar, this.onFinally));
    }

    /* loaded from: classes4.dex */
    static final class DoFinallyObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final m<? super T> actual;
        io.reactivex.disposables.b d;
        final io.reactivex.b.a onFinally;

        DoFinallyObserver(m<? super T> mVar, io.reactivex.b.a aVar) {
            this.actual = mVar;
            this.onFinally = aVar;
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
            this.actual.onSuccess(t);
            runFinally();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // io.reactivex.m
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
                    io.reactivex.exceptions.a.I(th);
                    io.reactivex.d.a.onError(th);
                }
            }
        }
    }
}
