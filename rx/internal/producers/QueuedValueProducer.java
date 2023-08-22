package rx.internal.producers;

import com.baidu.tieba.k8c;
import com.baidu.tieba.kac;
import com.baidu.tieba.kbc;
import com.baidu.tieba.p7c;
import com.baidu.tieba.rbc;
import com.baidu.tieba.t7c;
import com.baidu.tieba.z7c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements p7c {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final t7c<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(t7c<? super T> t7cVar) {
        this(t7cVar, r0);
        Queue kacVar;
        if (rbc.b()) {
            kacVar = new kbc();
        } else {
            kacVar = new kac();
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

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                k8c.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(t7c<? super T> t7cVar, Queue<Object> queue) {
        this.child = t7cVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            t7c<? super T> t7cVar = this.child;
            Queue<Object> queue = this.queue;
            while (!t7cVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            t7cVar.onNext(null);
                        } else {
                            t7cVar.onNext(poll);
                        }
                        if (t7cVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        z7c.g(th, t7cVar, poll);
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
