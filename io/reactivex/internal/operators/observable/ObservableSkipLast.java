package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.ArrayDeque;
/* loaded from: classes25.dex */
public final class ObservableSkipLast<T> extends a<T, T> {
    final int skip;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new SkipLastObserver(uVar, this.skip));
    }

    /* loaded from: classes25.dex */
    static final class SkipLastObserver<T> extends ArrayDeque<T> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -3807491841935125653L;
        final u<? super T> actual;
        io.reactivex.disposables.b s;
        final int skip;

        SkipLastObserver(u<? super T> uVar, int i) {
            super(i);
            this.actual = uVar;
            this.skip = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.u
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext((T) poll());
            }
            offer(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
