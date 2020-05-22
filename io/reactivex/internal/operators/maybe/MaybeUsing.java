package io.reactivex.internal.operators.maybe;

import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeUsing<T, D> extends k<T> {
    final boolean eager;
    final Callable<? extends D> nmS;
    final h<? super D, ? extends o<? extends T>> nnU;
    final g<? super D> noo;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        try {
            D call = this.nmS.call();
            try {
                ((o) io.reactivex.internal.functions.a.k(this.nnU.apply(call), "The sourceSupplier returned a null MaybeSource")).a(new UsingObserver(mVar, call, this.noo, this.eager));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                if (this.eager) {
                    try {
                        this.noo.accept(call);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.L(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), mVar);
                        return;
                    }
                }
                EmptyDisposable.error(th, mVar);
                if (!this.eager) {
                    try {
                        this.noo.accept(call);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.L(th3);
                        io.reactivex.e.a.onError(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.L(th4);
            EmptyDisposable.error(th4, mVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class UsingObserver<T, D> extends AtomicReference<Object> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -674404550052917487L;
        final m<? super T> actual;
        io.reactivex.disposables.b d;
        final g<? super D> disposer;
        final boolean eager;

        UsingObserver(m<? super T> mVar, D d, g<? super D> gVar, boolean z) {
            super(d);
            this.actual = mVar;
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
                    io.reactivex.exceptions.a.L(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        this.actual.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.actual.onSuccess(t);
            if (!this.eager) {
                disposeResourceAfter();
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.L(th2);
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

        @Override // io.reactivex.m
        public void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
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
