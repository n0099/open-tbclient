package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {
    final h<? super Open, ? extends t<? extends Close>> bufferClose;
    final t<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    @Override // io.reactivex.q
    protected void a(u<? super U> uVar) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(uVar, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        uVar.onSubscribe(bufferBoundaryObserver);
        this.source.subscribe(bufferBoundaryObserver);
    }

    /* loaded from: classes7.dex */
    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -8466418554264089604L;
        final u<? super C> actual;
        final h<? super Open, ? extends t<? extends Close>> bufferClose;
        final t<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        long index;
        final io.reactivex.internal.queue.a<C> queue = new io.reactivex.internal.queue.a<>(q.dCx());
        final io.reactivex.disposables.a observers = new io.reactivex.disposables.a();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        BufferBoundaryObserver(u<? super C> uVar, t<? extends Open> tVar, h<? super Open, ? extends t<? extends Close>> hVar, Callable<C> callable) {
            this.actual = uVar;
            this.bufferSupplier = callable;
            this.bufferOpen = tVar;
            this.bufferClose = hVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.a(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C c : map.values()) {
                        c.add(t);
                    }
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C c : map.values()) {
                        this.queue.offer(c);
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.Map<java.lang.Long, C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        void open(Open open) {
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.h(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                t tVar = (t) io.reactivex.internal.functions.a.h(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map != 0) {
                        map.put(Long.valueOf(j), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
                        this.observers.a(bufferCloseObserver);
                        tVar.subscribe(bufferCloseObserver);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                DisposableHelper.dispose(this.upstream);
                onError(th);
            }
        }

        void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.c(bufferOpenObserver);
            if (this.observers.size() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }

        void close(BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            this.observers.c(bufferCloseObserver);
            boolean z = false;
            if (this.observers.size() == 0) {
                DisposableHelper.dispose(this.upstream);
                z = true;
            }
            synchronized (this) {
                if (this.buffers != null) {
                    this.queue.offer(this.buffers.remove(Long.valueOf(j)));
                    if (z) {
                        this.done = true;
                    }
                    drain();
                }
            }
        }

        void boundaryError(io.reactivex.disposables.b bVar, Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.observers.c(bVar);
            onError(th);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                u<? super C> uVar = this.actual;
                io.reactivex.internal.queue.a<C> aVar = this.queue;
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        aVar.clear();
                        uVar.onError(this.errors.terminate());
                        return;
                    }
                    C poll = aVar.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        uVar.onComplete();
                        return;
                    } else if (!z2) {
                        uVar.onNext(poll);
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                aVar.clear();
            }
        }

        /* loaded from: classes7.dex */
        static final class BufferOpenObserver<Open> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<Open> {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> parent;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // io.reactivex.u
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.u
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.u
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
            }

            @Override // io.reactivex.u
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<Object> {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundaryObserver<T, C, ?, ?> parent;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.parent = bufferBoundaryObserver;
            this.index = j;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                bVar.dispose();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }
    }
}
