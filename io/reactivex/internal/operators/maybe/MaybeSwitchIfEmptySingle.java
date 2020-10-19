package io.reactivex.internal.operators.maybe;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class MaybeSwitchIfEmptySingle<T> extends w<T> {
    final aa<? extends T> other;
    final o<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.source.a(new SwitchIfEmptyMaybeObserver(yVar, this.other));
    }

    /* loaded from: classes17.dex */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4603919676453758899L;
        final y<? super T> actual;
        final aa<? extends T> other;

        SwitchIfEmptyMaybeObserver(y<? super T> yVar, aa<? extends T> aaVar) {
            this.actual = yVar;
            this.other = aaVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            io.reactivex.disposables.b bVar = get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, null)) {
                this.other.a(new a(this.actual, this));
            }
        }

        /* loaded from: classes17.dex */
        static final class a<T> implements y<T> {
            final y<? super T> actual;
            final AtomicReference<io.reactivex.disposables.b> oLL;

            a(y<? super T> yVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.actual = yVar;
                this.oLL = atomicReference;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.oLL, bVar);
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
}
