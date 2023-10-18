package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.h9c;
import com.baidu.tieba.hac;
import com.baidu.tieba.n6c;
import com.baidu.tieba.nac;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$BufferEmitter(n6c<? super T> n6cVar, int i) {
        super(n6cVar);
        Queue<Object> h9cVar;
        if (nac.b()) {
            h9cVar = new hac<>(i);
        } else {
            h9cVar = new h9c<>(i);
        }
        this.queue = h9cVar;
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i;
        boolean z;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        n6c<? super T> n6cVar = this.actual;
        Queue<Object> queue = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (n6cVar.isUnsubscribed()) {
                    queue.clear();
                    return;
                } else {
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (z) {
                        break;
                    } else {
                        n6cVar.onNext((Object) NotificationLite.e(poll));
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (n6cVar.isUnsubscribed()) {
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
                g7c.g(this, j2);
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
            this.queue.clear();
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        this.queue.offer(NotificationLite.i(t));
        drain();
    }
}
