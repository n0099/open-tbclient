package io.reactivex.internal.operators.observable;

import f.b.l;
import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableBufferBoundary$BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = -8466418554264089604L;
    public final o<? super C> actual;
    public final h<? super Open, ? extends n<? extends Close>> bufferClose;
    public final n<? extends Open> bufferOpen;
    public final Callable<C> bufferSupplier;
    public volatile boolean cancelled;
    public volatile boolean done;
    public long index;
    public final a<C> queue = new a<>(l.a());
    public final f.b.t.a observers = new f.b.t.a();
    public final AtomicReference<b> upstream = new AtomicReference<>();
    public Map<Long, C> buffers = new LinkedHashMap();
    public final AtomicThrowable errors = new AtomicThrowable();

    /* loaded from: classes7.dex */
    public static final class BufferOpenObserver<Open> extends AtomicReference<b> implements o<Open>, b {
        public static final long serialVersionUID = -8498650778633225126L;
        public final ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> parent;

        public BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> observableBufferBoundary$BufferBoundaryObserver) {
            this.parent = observableBufferBoundary$BufferBoundaryObserver;
        }

        @Override // f.b.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // f.b.o
        public void onComplete() {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.openComplete(this);
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, th);
        }

        @Override // f.b.o
        public void onNext(Open open) {
            this.parent.open(open);
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary$BufferBoundaryObserver(o<? super C> oVar, n<? extends Open> nVar, h<? super Open, ? extends n<? extends Close>> hVar, Callable<C> callable) {
        this.actual = oVar;
        this.bufferSupplier = callable;
        this.bufferOpen = nVar;
        this.bufferClose = hVar;
    }

    public void boundaryError(b bVar, Throwable th) {
        DisposableHelper.dispose(this.upstream);
        this.observers.c(bVar);
        onError(th);
    }

    public void close(ObservableBufferBoundary$BufferCloseObserver<T, C> observableBufferBoundary$BufferCloseObserver, long j) {
        boolean z;
        this.observers.c(observableBufferBoundary$BufferCloseObserver);
        if (this.observers.e() == 0) {
            DisposableHelper.dispose(this.upstream);
            z = true;
        } else {
            z = false;
        }
        synchronized (this) {
            if (this.buffers == null) {
                return;
            }
            this.queue.offer(this.buffers.remove(Long.valueOf(j)));
            if (z) {
                this.done = true;
            }
            drain();
        }
    }

    @Override // f.b.t.b
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

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        o<? super C> oVar = this.actual;
        a<C> aVar = this.queue;
        int i = 1;
        while (!this.cancelled) {
            boolean z = this.done;
            if (z && this.errors.get() != null) {
                aVar.clear();
                oVar.onError(this.errors.terminate());
                return;
            }
            C poll = aVar.poll();
            boolean z2 = poll == null;
            if (z && z2) {
                oVar.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                oVar.onNext(poll);
            }
        }
        aVar.clear();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // f.b.o
    public void onComplete() {
        this.observers.dispose();
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map == null) {
                return;
            }
            for (C c2 : map.values()) {
                this.queue.offer(c2);
            }
            this.buffers = null;
            this.done = true;
            drain();
        }
    }

    @Override // f.b.o
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
        f.b.a0.a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map == null) {
                return;
            }
            for (C c2 : map.values()) {
                c2.add(t);
            }
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
            this.observers.b(bufferOpenObserver);
            this.bufferOpen.subscribe(bufferOpenObserver);
        }
    }

    public void open(Open open) {
        try {
            C call = this.bufferSupplier.call();
            f.b.x.b.a.b(call, "The bufferSupplier returned a null Collection");
            C c2 = call;
            n<? extends Close> apply = this.bufferClose.apply(open);
            f.b.x.b.a.b(apply, "The bufferClose returned a null ObservableSource");
            n<? extends Close> nVar = apply;
            long j = this.index;
            this.index = 1 + j;
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                map.put(Long.valueOf(j), c2);
                ObservableBufferBoundary$BufferCloseObserver observableBufferBoundary$BufferCloseObserver = new ObservableBufferBoundary$BufferCloseObserver(this, j);
                this.observers.b(observableBufferBoundary$BufferCloseObserver);
                nVar.subscribe(observableBufferBoundary$BufferCloseObserver);
            }
        } catch (Throwable th) {
            f.b.u.a.a(th);
            DisposableHelper.dispose(this.upstream);
            onError(th);
        }
    }

    public void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
        this.observers.c(bufferOpenObserver);
        if (this.observers.e() == 0) {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }
    }
}
