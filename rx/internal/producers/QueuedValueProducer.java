package rx.internal.producers;

import com.baidu.tieba.g7c;
import com.baidu.tieba.g9c;
import com.baidu.tieba.gac;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.nac;
import com.baidu.tieba.t6c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements j6c {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final n6c<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(n6c<? super T> n6cVar) {
        this(n6cVar, r0);
        Queue g9cVar;
        if (nac.b()) {
            g9cVar = new gac();
        } else {
            g9cVar = new g9c();
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

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                g7c.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(n6c<? super T> n6cVar, Queue<Object> queue) {
        this.child = n6cVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            n6c<? super T> n6cVar = this.child;
            Queue<Object> queue = this.queue;
            while (!n6cVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            n6cVar.onNext(null);
                        } else {
                            n6cVar.onNext(poll);
                        }
                        if (n6cVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        t6c.g(th, n6cVar, poll);
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
