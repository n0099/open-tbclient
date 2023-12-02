package rx.internal.producers;

import com.baidu.tieba.cpc;
import com.baidu.tieba.crc;
import com.baidu.tieba.csc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.jsc;
import com.baidu.tieba.poc;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements foc {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final joc<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(joc<? super T> jocVar) {
        this(jocVar, r0);
        Queue crcVar;
        if (jsc.b()) {
            crcVar = new csc();
        } else {
            crcVar = new crc();
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

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                cpc.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(joc<? super T> jocVar, Queue<Object> queue) {
        this.child = jocVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            joc<? super T> jocVar = this.child;
            Queue<Object> queue = this.queue;
            while (!jocVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            jocVar.onNext(null);
                        } else {
                            jocVar.onNext(poll);
                        }
                        if (jocVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        poc.g(th, jocVar, poll);
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
