package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableConcatMap<T, U> extends a<T, U> {
    final int bufferSize;
    final h<? super T, ? extends t<? extends U>> mapper;
    final ErrorMode nxk;

    @Override // io.reactivex.q
    public void a(u<? super U> uVar) {
        if (!ObservableScalarXMap.a(this.source, uVar, this.mapper)) {
            if (this.nxk == ErrorMode.IMMEDIATE) {
                this.source.subscribe(new SourceObserver(new io.reactivex.observers.b(uVar), this.mapper, this.bufferSize));
            } else {
                this.source.subscribe(new ConcatMapDelayErrorObserver(uVar, this.mapper, this.bufferSize, this.nxk == ErrorMode.END));
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SourceObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final u<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final InnerObserver<U> inner;
        final h<? super T, ? extends t<? extends U>> mapper;
        g<T> queue;
        io.reactivex.disposables.b s;

        SourceObserver(u<? super U> uVar, h<? super T, ? extends t<? extends U>> hVar, int i) {
            this.actual = uVar;
            this.mapper = hVar;
            this.bufferSize = i;
            this.inner = new InnerObserver<>(uVar, this);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar2;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t);
                }
                drain();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.actual.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    t tVar = (t) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    this.active = true;
                                    tVar.subscribe(this.inner);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.I(th);
                                    dispose();
                                    this.queue.clear();
                                    this.actual.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.I(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th2);
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
        /* loaded from: classes5.dex */
        public static final class InnerObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements u<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final u<? super U> actual;
            final SourceObserver<?, ?> parent;

            InnerObserver(u<? super U> uVar, SourceObserver<?, ?> sourceObserver) {
                this.actual = uVar;
                this.parent = sourceObserver;
            }

            @Override // io.reactivex.u
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.set(this, bVar);
            }

            @Override // io.reactivex.u
            public void onNext(U u) {
                this.actual.onNext(u);
            }

            @Override // io.reactivex.u
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // io.reactivex.u
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final u<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        io.reactivex.disposables.b d;
        volatile boolean done;
        final AtomicThrowable error = new AtomicThrowable();
        final h<? super T, ? extends t<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        g<T> queue;
        int sourceMode;
        final boolean tillTheEnd;

        ConcatMapDelayErrorObserver(u<? super R> uVar, h<? super T, ? extends t<? extends R>> hVar, int i, boolean z) {
            this.actual = uVar;
            this.mapper = hVar;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(uVar, this);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
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
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.d.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                u<? super R> uVar = this.actual;
                g<T> gVar = this.queue;
                AtomicThrowable atomicThrowable = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            gVar.clear();
                            return;
                        } else if (!this.tillTheEnd && atomicThrowable.get() != null) {
                            gVar.clear();
                            this.cancelled = true;
                            uVar.onError(atomicThrowable.terminate());
                            return;
                        } else {
                            boolean z = this.done;
                            try {
                                T poll = gVar.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.cancelled = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        uVar.onError(terminate);
                                        return;
                                    } else {
                                        uVar.onComplete();
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        t tVar = (t) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                        if (tVar instanceof Callable) {
                                            try {
                                                Object obj = (Object) ((Callable) tVar).call();
                                                if (obj != 0 && !this.cancelled) {
                                                    uVar.onNext(obj);
                                                }
                                            } catch (Throwable th) {
                                                io.reactivex.exceptions.a.I(th);
                                                atomicThrowable.addThrowable(th);
                                            }
                                        } else {
                                            this.active = true;
                                            tVar.subscribe(this.observer);
                                        }
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.I(th2);
                                        this.cancelled = true;
                                        this.d.dispose();
                                        gVar.clear();
                                        atomicThrowable.addThrowable(th2);
                                        uVar.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.I(th3);
                                this.cancelled = true;
                                this.d.dispose();
                                atomicThrowable.addThrowable(th3);
                                uVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements u<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final u<? super R> actual;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(u<? super R> uVar, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.actual = uVar;
                this.parent = concatMapDelayErrorObserver;
            }

            @Override // io.reactivex.u
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.u
            public void onNext(R r) {
                this.actual.onNext(r);
            }

            @Override // io.reactivex.u
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (concatMapDelayErrorObserver.error.addThrowable(th)) {
                    if (!concatMapDelayErrorObserver.tillTheEnd) {
                        concatMapDelayErrorObserver.d.dispose();
                    }
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                    return;
                }
                io.reactivex.e.a.onError(th);
            }

            @Override // io.reactivex.u
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
