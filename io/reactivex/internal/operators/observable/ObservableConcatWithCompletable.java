package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatWithCompletable<T> extends a<T, T> {
    final e other;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new ConcatWithObserver(uVar, this.other));
    }

    /* loaded from: classes7.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -1953724749712440952L;
        final u<? super T> actual;
        boolean inCompletable;
        e other;

        ConcatWithObserver(u<? super T> uVar, e eVar) {
            this.actual = uVar;
            this.other = eVar;
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && !this.inCompletable) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.inCompletable) {
                this.actual.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            e eVar = this.other;
            this.other = null;
            eVar.a(this);
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
