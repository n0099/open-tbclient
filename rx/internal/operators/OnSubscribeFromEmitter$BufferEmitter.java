package rx.internal.operators;

import h.j;
import h.o.a.a;
import h.o.d.j.f;
import h.o.d.k.f0;
import h.o.d.k.z;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$BufferEmitter(j<? super T> jVar, int i) {
        super(jVar);
        this.queue = f0.b() ? new z<>(i) : new f<>(i);
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        j<? super T> jVar = this.actual;
        Queue<Object> queue = this.queue;
        int i = 1;
        do {
            long j = get();
            long j2 = 0;
            while (j2 != j) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return;
                }
                boolean z = this.done;
                Object poll = queue.poll();
                boolean z2 = poll == null;
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
                    jVar.onNext((Object) NotificationLite.d(poll));
                    j2++;
                }
            }
            if (j2 == j) {
                if (jVar.isUnsubscribed()) {
                    queue.clear();
                    return;
                }
                boolean z3 = this.done;
                boolean isEmpty = queue.isEmpty();
                if (z3 && isEmpty) {
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
            i = this.wip.addAndGet(-i);
        } while (i != 0);
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
        this.queue.offer(NotificationLite.g(t));
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }
}
