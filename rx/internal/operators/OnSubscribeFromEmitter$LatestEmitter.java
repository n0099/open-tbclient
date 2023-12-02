package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.joc;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$LatestEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$LatestEmitter(joc<? super T> jocVar) {
        super(jocVar);
        this.queue = new AtomicReference<>();
        this.wip = new AtomicInteger();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        this.queue.set(NotificationLite.i(t));
        drain();
    }

    public void drain() {
        boolean z;
        int i;
        boolean z2;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        joc<? super T> jocVar = this.actual;
        AtomicReference<Object> atomicReference = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                z = false;
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (jocVar.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                } else {
                    boolean z3 = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    if (andSet == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z3 && z2) {
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
                        jocVar.onNext((Object) NotificationLite.e(andSet));
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (jocVar.isUnsubscribed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                boolean z4 = this.done;
                if (atomicReference.get() == null) {
                    z = true;
                }
                if (z4 && z) {
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
                cpc.g(this, j2);
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
