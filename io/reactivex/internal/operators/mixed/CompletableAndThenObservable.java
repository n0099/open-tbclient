package io.reactivex.internal.operators.mixed;

import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class CompletableAndThenObservable<R> extends q<R> {
    final t<? extends R> other;
    final e source;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(uVar, this.other);
        uVar.onSubscribe(andThenObservableObserver);
        this.source.a(andThenObservableObserver);
    }

    /* loaded from: classes4.dex */
    static final class AndThenObservableObserver<R> extends AtomicReference<b> implements c, b, u<R> {
        private static final long serialVersionUID = -8948264376121066672L;
        final u<? super R> downstream;
        t<? extends R> other;

        AndThenObservableObserver(u<? super R> uVar, t<? extends R> tVar) {
            this.other = tVar;
            this.downstream = uVar;
        }

        @Override // io.reactivex.u
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            t<? extends R> tVar = this.other;
            if (tVar == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            tVar.subscribe(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }
}
