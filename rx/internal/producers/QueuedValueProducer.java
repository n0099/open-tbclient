package rx.internal.producers;

import com.baidu.tieba.ebc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.pdc;
import com.baidu.tieba.pec;
import com.baidu.tieba.uac;
import com.baidu.tieba.wec;
import com.baidu.tieba.yac;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements uac {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final yac<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(yac<? super T> yacVar) {
        this(yacVar, r0);
        Queue pdcVar;
        if (wec.b()) {
            pdcVar = new pec();
        } else {
            pdcVar = new pdc();
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // com.baidu.tieba.uac
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                pbc.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(yac<? super T> yacVar, Queue<Object> queue) {
        this.child = yacVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            yac<? super T> yacVar = this.child;
            Queue<Object> queue = this.queue;
            while (!yacVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            yacVar.onNext(null);
                        } else {
                            yacVar.onNext(poll);
                        }
                        if (yacVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        ebc.g(th, yacVar, poll);
                        return;
                    }
                }
                if (j2 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
