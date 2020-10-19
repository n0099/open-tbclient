package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {
    final h<? super Open, ? extends org.a.b<? extends Close>> bufferClose;
    final org.a.b<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super U> cVar) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(cVar, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        cVar.onSubscribe(bufferBoundarySubscriber);
        this.oLT.a((j) bufferBoundarySubscriber);
    }

    /* loaded from: classes17.dex */
    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -8466418554264089604L;
        final org.a.c<? super C> actual;
        final h<? super Open, ? extends org.a.b<? extends Close>> bufferClose;
        final org.a.b<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        long emitted;
        long index;
        final io.reactivex.internal.queue.a<C> queue = new io.reactivex.internal.queue.a<>(io.reactivex.g.emG());
        final io.reactivex.disposables.a subscribers = new io.reactivex.disposables.a();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<org.a.d> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        BufferBoundarySubscriber(org.a.c<? super C> cVar, org.a.b<? extends Open> bVar, h<? super Open, ? extends org.a.b<? extends Close>> hVar, Callable<C> callable) {
            this.actual = cVar;
            this.bufferSupplier = callable;
            this.bufferOpen = bVar;
            this.bufferClose = hVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.a(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
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

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.subscribers.dispose();
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

        @Override // org.a.d
        public void request(long j) {
            io.reactivex.internal.util.b.a(this.requested, j);
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.Map<java.lang.Long, C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        void open(Open open) {
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.l(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.l(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map != 0) {
                        map.put(Long.valueOf(j), collection);
                        BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                        this.subscribers.a(bufferCloseSubscriber);
                        bVar.subscribe(bufferCloseSubscriber);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.c(bufferOpenSubscriber);
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                drain();
            }
        }

        void close(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            this.subscribers.c(bufferCloseSubscriber);
            boolean z = false;
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
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
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.c(bVar);
            onError(th);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                long j = this.emitted;
                org.a.c<? super C> cVar = this.actual;
                io.reactivex.internal.queue.a<C> aVar = this.queue;
                int i = 1;
                while (true) {
                    long j2 = this.requested.get();
                    long j3 = j;
                    while (j3 != j2) {
                        if (this.cancelled) {
                            aVar.clear();
                            return;
                        }
                        boolean z = this.done;
                        if (z && this.errors.get() != null) {
                            aVar.clear();
                            cVar.onError(this.errors.terminate());
                            return;
                        }
                        C poll = aVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            cVar.onComplete();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(poll);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (this.cancelled) {
                            aVar.clear();
                            return;
                        } else if (this.done) {
                            if (this.errors.get() != null) {
                                aVar.clear();
                                cVar.onError(this.errors.terminate());
                                return;
                            } else if (aVar.isEmpty()) {
                                cVar.onComplete();
                                return;
                            }
                        }
                    }
                    this.emitted = j3;
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                    j = j3;
                }
            }
        }

        /* loaded from: classes17.dex */
        static final class BufferOpenSubscriber<Open> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Open> {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(org.a.d dVar) {
                if (SubscriptionHelper.setOnce(this, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                }
            }

            @Override // org.a.c
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // org.a.c
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
            }

            @Override // org.a.c
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundarySubscriber<T, C, ?, ?> parent;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.parent = bufferBoundarySubscriber;
            this.index = j;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            org.a.d dVar = get();
            if (dVar != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                dVar.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
