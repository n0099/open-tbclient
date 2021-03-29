package io.reactivex.internal.operators.flowable;

import f.a.e;
import f.a.g;
import f.a.w.h;
import f.a.x.f.a;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -8466418554264089604L;
    public final c<? super C> actual;
    public final h<? super Open, ? extends b<? extends Close>> bufferClose;
    public final b<? extends Open> bufferOpen;
    public final Callable<C> bufferSupplier;
    public volatile boolean cancelled;
    public volatile boolean done;
    public long emitted;
    public long index;
    public final a<C> queue = new a<>(e.a());
    public final f.a.t.a subscribers = new f.a.t.a();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public Map<Long, C> buffers = new LinkedHashMap();
    public final AtomicThrowable errors = new AtomicThrowable();

    /* loaded from: classes7.dex */
    public static final class BufferOpenSubscriber<Open> extends AtomicReference<d> implements g<Open>, f.a.t.b {
        public static final long serialVersionUID = -8498650778633225126L;
        public final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        public BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> flowableBufferBoundary$BufferBoundarySubscriber) {
            this.parent = flowableBufferBoundary$BufferBoundarySubscriber;
        }

        @Override // f.a.t.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // g.d.c
        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, th);
        }

        @Override // g.d.c
        public void onNext(Open open) {
            this.parent.open(open);
        }

        @Override // f.a.g, g.d.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableBufferBoundary$BufferBoundarySubscriber(c<? super C> cVar, b<? extends Open> bVar, h<? super Open, ? extends b<? extends Close>> hVar, Callable<C> callable) {
        this.actual = cVar;
        this.bufferSupplier = callable;
        this.bufferOpen = bVar;
        this.bufferClose = hVar;
    }

    public void boundaryError(f.a.t.b bVar, Throwable th) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.c(bVar);
        onError(th);
    }

    @Override // g.d.d
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

    public void close(FlowableBufferBoundary$BufferCloseSubscriber<T, C> flowableBufferBoundary$BufferCloseSubscriber, long j) {
        boolean z;
        this.subscribers.c(flowableBufferBoundary$BufferCloseSubscriber);
        if (this.subscribers.e() == 0) {
            SubscriptionHelper.cancel(this.upstream);
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        if (r8 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r12.cancelled == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
        r3.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
        if (r12.done == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
        if (r12.errors.get() == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
        r3.clear();
        r2.onError(r12.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
        if (r3.isEmpty() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
        r2.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
        r12.emitted = r0;
        r5 = addAndGet(-r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        long j = this.emitted;
        c<? super C> cVar = this.actual;
        a<C> aVar = this.queue;
        int i = 1;
        do {
            long j2 = this.requested.get();
            while (true) {
                int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    aVar.clear();
                    return;
                } else {
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
                        j++;
                    }
                }
            }
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        this.subscribers.dispose();
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

    @Override // g.d.c
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
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
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

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
            this.subscribers.b(bufferOpenSubscriber);
            this.bufferOpen.subscribe(bufferOpenSubscriber);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void open(Open open) {
        try {
            C call = this.bufferSupplier.call();
            f.a.x.b.a.b(call, "The bufferSupplier returned a null Collection");
            C c2 = call;
            b<? extends Close> apply = this.bufferClose.apply(open);
            f.a.x.b.a.b(apply, "The bufferClose returned a null Publisher");
            b<? extends Close> bVar = apply;
            long j = this.index;
            this.index = 1 + j;
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                map.put(Long.valueOf(j), c2);
                FlowableBufferBoundary$BufferCloseSubscriber flowableBufferBoundary$BufferCloseSubscriber = new FlowableBufferBoundary$BufferCloseSubscriber(this, j);
                this.subscribers.b(flowableBufferBoundary$BufferCloseSubscriber);
                bVar.subscribe(flowableBufferBoundary$BufferCloseSubscriber);
            }
        } catch (Throwable th) {
            f.a.u.a.a(th);
            SubscriptionHelper.cancel(this.upstream);
            onError(th);
        }
    }

    public void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
        this.subscribers.c(bufferOpenSubscriber);
        if (this.subscribers.e() == 0) {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
        }
    }

    @Override // g.d.d
    public void request(long j) {
        f.a.x.i.b.a(this.requested, j);
        drain();
    }
}
