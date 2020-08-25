package io.reactivex.internal.operators.maybe;

import io.reactivex.c.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.l;
import io.reactivex.m;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeCreate<T> extends k<T> {
    final n<T> onL;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        Emitter emitter = new Emitter(mVar);
        mVar.onSubscribe(emitter);
        try {
            this.onL.a(emitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            emitter.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, l<T> {
        private static final long serialVersionUID = -2467358622224974244L;
        final m<? super T> actual;

        Emitter(m<? super T> mVar) {
            this.actual = mVar;
        }

        public void onSuccess(T t) {
            io.reactivex.disposables.b andSet;
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
            io.reactivex.disposables.b andSet;
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

        public void onComplete() {
            io.reactivex.disposables.b andSet;
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

        public void setDisposable(io.reactivex.disposables.b bVar) {
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
    }
}
