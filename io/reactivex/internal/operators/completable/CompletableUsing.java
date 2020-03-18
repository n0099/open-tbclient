package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableUsing<R> extends a {
    final g<? super R> disposer;
    final boolean eager;
    final Callable<R> nyp;
    final h<? super R, ? extends e> nyq;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        try {
            R call = this.nyp.call();
            try {
                ((e) io.reactivex.internal.functions.a.h(this.nyq.apply(call), "The completableFunction returned a null CompletableSource")).a(new UsingObserver(cVar, call, this.disposer, this.eager));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                if (this.eager) {
                    try {
                        this.disposer.accept(call);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.H(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), cVar);
                        return;
                    }
                }
                EmptyDisposable.error(th, cVar);
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
            EmptyDisposable.error(th4, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class UsingObserver<R> extends AtomicReference<Object> implements c, b {
        private static final long serialVersionUID = -674404550052917487L;
        final c actual;
        b d;
        final g<? super R> disposer;
        final boolean eager;

        UsingObserver(c cVar, R r, g<? super R> gVar, boolean z) {
            super(r);
            this.actual = cVar;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
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

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
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
                disposeResourceAfter();
            }
        }

        @Override // io.reactivex.c
        public void onComplete() {
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
            this.actual.onComplete();
            if (!this.eager) {
                disposeResourceAfter();
            }
        }
    }
}
