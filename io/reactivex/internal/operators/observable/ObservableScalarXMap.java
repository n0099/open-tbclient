package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public final class ObservableScalarXMap {
    public static <T, R> boolean a(t<T> tVar, u<? super R> uVar, h<? super T, ? extends t<? extends R>> hVar) {
        if (tVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) tVar).call();
                if (obj == 0) {
                    EmptyDisposable.complete(uVar);
                    return true;
                }
                try {
                    t tVar2 = (t) io.reactivex.internal.functions.a.l(hVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (tVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) tVar2).call();
                            if (call == null) {
                                EmptyDisposable.complete(uVar);
                                return true;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(uVar, call);
                            uVar.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.J(th);
                            EmptyDisposable.error(th, uVar);
                            return true;
                        }
                    } else {
                        tVar2.subscribe(uVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.J(th2);
                    EmptyDisposable.error(th2, uVar);
                    return true;
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.J(th3);
                EmptyDisposable.error(th3, uVar);
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes17.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements io.reactivex.internal.a.b<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final u<? super T> observer;
        final T value;

        public ScalarDisposable(u<? super T> uVar, T t) {
            this.observer = uVar;
            this.value = t;
        }

        @Override // io.reactivex.internal.a.g
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.value;
            }
            return null;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext((T) this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }
}
