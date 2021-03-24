package io.reactivex.internal.operators.flowable;

import f.a.x.f.a;
import f.a.x.i.b;
import g.d.c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final a<T> queue;
    public final AtomicInteger wip;

    public FlowableCreate$BufferAsyncEmitter(c<? super T> cVar, int i) {
        super(cVar);
        this.queue = new a<>(i);
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        a<T> aVar = this.queue;
        int i = 1;
        do {
            long j = get();
            long j2 = 0;
            while (j2 != j) {
                if (isCancelled()) {
                    aVar.clear();
                    return;
                }
                boolean z = this.done;
                Object obj = (T) aVar.poll();
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
            if (j2 == j) {
                if (isCancelled()) {
                    aVar.clear();
                    return;
                }
                boolean z3 = this.done;
                boolean isEmpty = aVar.isEmpty();
                if (z3 && isEmpty) {
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
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public boolean tryOnError(Throwable th) {
        if (this.done || isCancelled()) {
            return false;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = th;
        this.done = true;
        drain();
        return true;
    }
}
