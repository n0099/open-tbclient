package io.reactivex.internal.operators.observable;

import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableUsing<T, D> extends q<T> {
    final g<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> nwr;
    final h<? super D, ? extends t<? extends T>> nxo;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        try {
            D call = this.nwr.call();
            try {
                ((t) io.reactivex.internal.functions.a.h(this.nxo.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(uVar, call, this.disposer, this.eager));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                try {
                    this.disposer.accept(call);
                    EmptyDisposable.error(th, uVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.H(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), uVar);
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.H(th3);
            EmptyDisposable.error(th3, uVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class UsingObserver<T, D> extends AtomicBoolean implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 5904473792286235046L;
        final u<? super T> actual;
        final g<? super D> disposer;
        final boolean eager;
        final D resource;
        io.reactivex.disposables.b s;

        UsingObserver(u<? super T> uVar, D d, g<? super D> gVar, boolean z) {
            this.actual = uVar;
            this.resource = d;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.H(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.s.dispose();
                this.actual.onError(th);
                return;
            }
            this.actual.onError(th);
            this.s.dispose();
            disposeAfter();
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: D, ? super D */
        @Override // io.reactivex.u
        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.H(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.s.dispose();
                this.actual.onComplete();
                return;
            }
            this.actual.onComplete();
            this.s.dispose();
            disposeAfter();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            disposeAfter();
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }
}
