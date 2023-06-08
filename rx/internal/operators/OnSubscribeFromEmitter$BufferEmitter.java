package rx.internal.operators;

import com.baidu.tieba.hpb;
import com.baidu.tieba.hqb;
import com.baidu.tieba.inb;
import com.baidu.tieba.nqb;
import com.baidu.tieba.tmb;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$BufferEmitter(tmb<? super T> tmbVar, int i) {
        super(tmbVar);
        Queue<Object> hpbVar;
        if (nqb.b()) {
            hpbVar = new hqb<>(i);
        } else {
            hpbVar = new hpb<>(i);
        }
        this.queue = hpbVar;
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i;
        boolean z;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        tmb<? super T> tmbVar = this.actual;
        Queue<Object> queue = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (tmbVar.isUnsubscribed()) {
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
                        tmbVar.onNext((Object) NotificationLite.e(poll));
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (tmbVar.isUnsubscribed()) {
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
                inb.g(this, j2);
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
        this.queue.offer(NotificationLite.h(t));
        drain();
    }
}
