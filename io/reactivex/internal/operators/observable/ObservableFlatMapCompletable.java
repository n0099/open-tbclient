package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapCompletable<T> extends a<T, T> {
    final boolean delayErrors;
    final h<? super T, ? extends e> mapper;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new FlatMapCompletableMainObserver(uVar, this.mapper, this.delayErrors));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements u<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final u<? super T> actual;
        io.reactivex.disposables.b d;
        final boolean delayErrors;
        volatile boolean disposed;
        final h<? super T, ? extends e> mapper;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        FlatMapCompletableMainObserver(u<? super T> uVar, h<? super T, ? extends e> hVar, boolean z) {
            this.actual = uVar;
            this.mapper = hVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            try {
                e eVar = (e) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.disposed && this.set.a(innerObserver)) {
                    eVar.a(innerObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                this.d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.d.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return i & 2;
        }

        void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            onError(th);
        }

        /* loaded from: classes7.dex */
        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.innerError(this, th);
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
}
