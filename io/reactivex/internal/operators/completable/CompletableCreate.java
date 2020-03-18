package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.c.f;
import io.reactivex.d;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableCreate extends a {
    final d nyn;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        Emitter emitter = new Emitter(cVar);
        cVar.onSubscribe(emitter);
        try {
            this.nyn.a(emitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.H(th);
            emitter.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class Emitter extends AtomicReference<b> implements io.reactivex.b, b {
        private static final long serialVersionUID = -2467358622224974244L;
        final c actual;

        Emitter(c cVar) {
            this.actual = cVar;
        }

        public void onComplete() {
            b andSet;
            if (get() != DisposableHelper.DISPOSED && (andSet = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    this.actual.onComplete();
                } finally {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.e.a.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            b andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() != DisposableHelper.DISPOSED && (andSet = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    this.actual.onError(th);
                    return true;
                } finally {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
            return false;
        }

        public void setDisposable(b bVar) {
            DisposableHelper.set(this, bVar);
        }

        public void setCancellable(f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}
