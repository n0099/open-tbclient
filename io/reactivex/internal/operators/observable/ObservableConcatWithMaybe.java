package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatWithMaybe<T> extends a<T, T> {
    final o<? extends T> other;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new ConcatWithObserver(uVar, this.other));
    }

    /* loaded from: classes7.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, u<T> {
        private static final long serialVersionUID = -1953724749712440952L;
        final u<? super T> actual;
        boolean inMaybe;
        o<? extends T> other;

        ConcatWithObserver(u<? super T> uVar, o<? extends T> oVar) {
            this.actual = uVar;
            this.other = oVar;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && !this.inMaybe) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onNext(t);
            this.actual.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            if (this.inMaybe) {
                this.actual.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            o<? extends T> oVar = this.other;
            this.other = null;
            oVar.a(this);
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
