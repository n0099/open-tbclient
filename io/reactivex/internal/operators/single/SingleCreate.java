package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.y;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleCreate<T> extends w<T> {
    final z<T> nyC;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        Emitter emitter = new Emitter(yVar);
        yVar.onSubscribe(emitter);
        try {
            this.nyC.a(emitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.H(th);
            emitter.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class Emitter<T> extends AtomicReference<b> implements b, x<T> {
        private static final long serialVersionUID = -2467358622224974244L;
        final y<? super T> actual;

        Emitter(y<? super T> yVar) {
            this.actual = yVar;
        }

        public void onSuccess(T t) {
            b andSet;
            if (get() != DisposableHelper.DISPOSED && (andSet = getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    if (t == null) {
                        this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } else {
                        this.actual.onSuccess(t);
                    }
                    if (andSet != null) {
                        andSet.dispose();
                    }
                } catch (Throwable th) {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                    throw th;
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
