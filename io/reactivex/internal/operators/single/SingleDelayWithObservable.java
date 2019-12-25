package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.c;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class SingleDelayWithObservable<T, U> extends w<T> {
    final t<U> other;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.other.subscribe(new OtherSubscriber(yVar, this.source));
    }

    /* loaded from: classes4.dex */
    static final class OtherSubscriber<T, U> extends AtomicReference<b> implements b, u<U> {
        private static final long serialVersionUID = -8565274649390031272L;
        final y<? super T> actual;
        boolean done;
        final aa<T> source;

        OtherSubscriber(y<? super T> yVar, aa<T> aaVar) {
            this.actual = yVar;
            this.source = aaVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(b bVar) {
            if (DisposableHelper.set(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.source.a(new c(this, this.actual));
            }
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
