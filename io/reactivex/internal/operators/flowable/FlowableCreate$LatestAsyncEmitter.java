package io.reactivex.internal.operators.flowable;

import f.a.x.i.b;
import g.d.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<T> queue;
    public final AtomicInteger wip;

    public FlowableCreate$LatestAsyncEmitter(c<? super T> cVar) {
        super(cVar);
        this.queue = new AtomicReference<>();
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        AtomicReference<T> atomicReference = this.queue;
        int i = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    break;
                } else if (isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                } else {
                    boolean z = this.done;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z2 = obj == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    } else if (z2) {
                        break;
                    } else {
                        cVar.onNext(obj);
                        j2++;
                    }
                }
            }
            if (j2 == j) {
                if (isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z3 = this.done;
                boolean z4 = atomicReference.get() == null;
                if (z3 && z4) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        error(th2);
                        return;
                    } else {
                        complete();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                b.e(this, j2);
            }
            i = this.wip.addAndGet(-i);
        } while (i != 0);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, f.a.d
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, f.a.d
    public void onNext(T t) {
        if (this.done || isCancelled()) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.queue.set(t);
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet(null);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public boolean tryOnError(Throwable th) {
        if (this.done || isCancelled()) {
            return false;
        }
        if (th == null) {
            onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
        this.error = th;
        this.done = true;
        drain();
        return true;
    }
}
