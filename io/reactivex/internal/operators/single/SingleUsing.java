package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleUsing<T, U> extends w<T> {
    final g<? super U> disposer;
    final boolean eager;
    final Callable<U> nwp;
    final h<? super U, ? extends aa<? extends T>> nyF;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        try {
            U call = this.nwp.call();
            try {
                ((aa) io.reactivex.internal.functions.a.h(this.nyF.apply(call), "The singleFunction returned a null SingleSource")).a(new UsingSingleObserver(yVar, call, this.eager, this.disposer));
            } catch (Throwable th) {
                th = th;
                io.reactivex.exceptions.a.H(th);
                if (this.eager) {
                    try {
                        this.disposer.accept(call);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.H(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.error(th, yVar);
                if (!this.eager) {
                    try {
                        this.disposer.accept(call);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.H(th3);
                        io.reactivex.e.a.onError(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.H(th4);
            EmptyDisposable.error(th4, yVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements b, y<T> {
        private static final long serialVersionUID = -5331524057054083935L;
        final y<? super T> actual;
        b d;
        final g<? super U> disposer;
        final boolean eager;

        UsingSingleObserver(y<? super T> yVar, U u, boolean z, g<? super U> gVar) {
            super(u);
            this.actual = yVar;
            this.eager = z;
            this.disposer = gVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
            disposeAfter();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.y
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.H(th);
                        this.actual.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.actual.onSuccess(t);
            if (!this.eager) {
                disposeAfter();
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.H(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.actual.onError(th);
            if (!this.eager) {
                disposeAfter();
            }
        }

        void disposeAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }
}
