package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
/* loaded from: classes5.dex */
public final class b<T> extends q<T> {
    final aa<? extends T> source;

    public b(aa<? extends T> aaVar) {
        this.source = aaVar;
    }

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.a(new a(uVar));
    }

    /* loaded from: classes5.dex */
    static final class a<T> implements io.reactivex.disposables.b, y<T> {
        final u<? super T> actual;
        io.reactivex.disposables.b d;

        a(u<? super T> uVar) {
            this.actual = uVar;
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
            this.actual.onNext(t);
            this.actual.onComplete();
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }
    }
}
