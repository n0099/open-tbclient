package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSwitchIfEmpty<T> extends a<T, T> {
    final o<? extends T> other;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new SwitchIfEmptyMaybeObserver(mVar, this.other));
    }

    /* loaded from: classes7.dex */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2223459372976438024L;
        final m<? super T> actual;
        final o<? extends T> other;

        SwitchIfEmptyMaybeObserver(m<? super T> mVar, o<? extends T> oVar) {
            this.actual = mVar;
            this.other = oVar;
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

        /* loaded from: classes7.dex */
        static final class a<T> implements m<T> {
            final m<? super T> actual;
            final AtomicReference<io.reactivex.disposables.b> mRE;

            a(m<? super T> mVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.actual = mVar;
                this.mRE = atomicReference;
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.mRE, bVar);
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
                this.actual.onComplete();
            }
        }
    }
}
