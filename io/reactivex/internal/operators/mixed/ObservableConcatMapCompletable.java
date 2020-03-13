package io.reactivex.internal.operators.mixed;

import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMapCompletable<T> extends io.reactivex.a {
    final ErrorMode errorMode;
    final h<? super T, ? extends e> mapper;
    final q<T> nxX;
    final int prefetch;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        if (!a.a(this.nxX, this.mapper, cVar)) {
            this.nxX.subscribe(new ConcatMapCompletableObserver(cVar, this.mapper, this.errorMode, this.prefetch));
        }
    }

    /* loaded from: classes7.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements b, u<T> {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final c downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final h<? super T, ? extends e> mapper;
        final int prefetch;
        g<T> queue;
        b upstream;

        ConcatMapCompletableObserver(c cVar, h<? super T, ? extends e> hVar, ErrorMode errorMode, int i) {
            this.downstream = cVar;
            this.mapper = hVar;
            this.errorMode = errorMode;
            this.prefetch = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.disposed = true;
                    this.inner.dispose();
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.downstream.onError(terminate);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.disposed = true;
                    this.upstream.dispose();
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.downstream.onError(terminate);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
                this.active = false;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.errors;
                ErrorMode errorMode = this.errorMode;
                while (!this.disposed) {
                    if (!this.active) {
                        if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                            this.disposed = true;
                            this.queue.clear();
                            this.downstream.onError(atomicThrowable.terminate());
                            return;
                        }
                        boolean z2 = this.done;
                        e eVar = null;
                        try {
                            T poll = this.queue.poll();
                            if (poll != null) {
                                eVar = (e) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z2 && z) {
                                this.disposed = true;
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    this.downstream.onError(terminate);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            } else if (!z) {
                                this.active = true;
                                eVar.a(this.inner);
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.H(th);
                            this.disposed = true;
                            this.queue.clear();
                            this.upstream.dispose();
                            atomicThrowable.addThrowable(th);
                            this.downstream.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class ConcatMapInnerObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            @Override // io.reactivex.c
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
