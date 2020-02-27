package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableObserveOn extends a {
    final v scheduler;
    final e source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        this.source.a(new ObserveOnCompletableObserver(cVar, this.scheduler));
    }

    /* loaded from: classes7.dex */
    static final class ObserveOnCompletableObserver extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final c actual;
        Throwable error;
        final v scheduler;

        ObserveOnCompletableObserver(c cVar, v vVar) {
            this.actual = cVar;
            this.scheduler = vVar;
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
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.C(this));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.C(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            this.actual.onComplete();
        }
    }
}
