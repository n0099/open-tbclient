package rx.internal.producers;

import com.baidu.tieba.a2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.q4c;
import com.baidu.tieba.q5c;
import com.baidu.tieba.w1c;
import com.baidu.tieba.x5c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements w1c {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final a2c<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(a2c<? super T> a2cVar) {
        this(a2cVar, r0);
        Queue q4cVar;
        if (x5c.b()) {
            q4cVar = new q5c();
        } else {
            q4cVar = new q4c();
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

    @Override // com.baidu.tieba.w1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                q2c.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(a2c<? super T> a2cVar, Queue<Object> queue) {
        this.child = a2cVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            a2c<? super T> a2cVar = this.child;
            Queue<Object> queue = this.queue;
            while (!a2cVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            a2cVar.onNext(null);
                        } else {
                            a2cVar.onNext(poll);
                        }
                        if (a2cVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        g2c.g(th, a2cVar, poll);
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
