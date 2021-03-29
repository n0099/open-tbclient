package rx.internal.operators;

import h.j;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class OnSubscribeFromEmitter$LatestEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$LatestEmitter(j<? super T> jVar) {
        super(jVar);
        this.queue = new AtomicReference<>();
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        j<? super T> jVar = this.actual;
        AtomicReference<Object> atomicReference = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (jVar.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                } else {
                    boolean z = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (z2) {
                        break;
                    } else {
                        jVar.onNext((Object) NotificationLite.e(andSet));
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (jVar.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z3 = this.done;
                boolean z4 = atomicReference.get() == null;
                if (z3 && z4) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        super.onError(th2);
                        return;
                    } else {
                        super.onCompleted();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                a.g(this, j2);
            }
            i2 = this.wip.addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        this.queue.set(NotificationLite.h(t));
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet(null);
        }
    }
}
