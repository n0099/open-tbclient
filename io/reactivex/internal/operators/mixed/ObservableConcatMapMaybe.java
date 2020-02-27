package io.reactivex.internal.operators.mixed;

import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMapMaybe<T, R> extends q<R> {
    final ErrorMode errorMode;
    final h<? super T, ? extends o<? extends R>> mapper;
    final q<T> nxK;
    final int prefetch;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        if (!a.a(this.nxK, this.mapper, uVar)) {
            this.nxK.subscribe(new ConcatMapMaybeMainObserver(uVar, this.mapper, this.prefetch, this.errorMode));
        }
    }

    /* loaded from: classes7.dex */
    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements b, u<T> {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final u<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);
        R item;
        final h<? super T, ? extends o<? extends R>> mapper;
        final f<T> queue;
        volatile int state;
        b upstream;

        ConcatMapMaybeMainObserver(u<? super R> uVar, h<? super T, ? extends o<? extends R>> hVar, int i, ErrorMode errorMode) {
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

        void innerComplete() {
            this.state = 0;
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
                                        o oVar = (o) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null MaybeSource");
                                        this.state = 1;
                                        oVar.a(this.inner);
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.H(th);
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
        /* loaded from: classes7.dex */
        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<b> implements m<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeMainObserver<?, R> parent;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.parent = concatMapMaybeMainObserver;
            }

            @Override // io.reactivex.m
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
