package io.reactivex.internal.operators.mixed;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableConcatMapSingle<T, R> extends q<R> {
    final ErrorMode errorMode;
    final h<? super T, ? extends aa<? extends R>> mapper;
    final q<T> nxd;
    final int prefetch;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        if (!a.b(this.nxd, this.mapper, uVar)) {
            this.nxd.subscribe(new ConcatMapSingleMainObserver(uVar, this.mapper, this.prefetch, this.errorMode));
        }
    }

    /* loaded from: classes5.dex */
    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements b, u<T> {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final u<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        R item;
        final h<? super T, ? extends aa<? extends R>> mapper;
        final f<T> queue;
        volatile int state;
        b upstream;

        ConcatMapSingleMainObserver(u<? super R> uVar, h<? super T, ? extends aa<? extends R>> hVar, int i, ErrorMode errorMode) {
            this.downstream = uVar;
            this.mapper = hVar;
            this.errorMode = errorMode;
            this.queue = new io.reactivex.internal.queue.a(i);
        }

        @Override // io.reactivex.u
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
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
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r0v15. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                u<? super R> uVar = this.downstream;
                ErrorMode errorMode = this.errorMode;
                f<T> fVar = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i = 1;
                while (true) {
                    if (this.cancelled) {
                        fVar.clear();
                        this.item = null;
                    } else {
                        int i2 = this.state;
                        if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i2 != 0))) {
                            if (i2 == 0) {
                                boolean z = this.done;
                                T poll = fVar.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        uVar.onComplete();
                                        return;
                                    } else {
                                        uVar.onError(terminate);
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        aa aaVar = (aa) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        aaVar.a(this.inner);
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.I(th);
                                        this.upstream.dispose();
                                        fVar.clear();
                                        atomicThrowable.addThrowable(th);
                                        uVar.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i2 == 2) {
                                this.item = null;
                                uVar.onNext((R) this.item);
                                this.state = 0;
                            }
                        }
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
                fVar.clear();
                this.item = null;
                uVar.onError(atomicThrowable.terminate());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements y<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleMainObserver<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.parent = concatMapSingleMainObserver;
            }

            @Override // io.reactivex.y
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
