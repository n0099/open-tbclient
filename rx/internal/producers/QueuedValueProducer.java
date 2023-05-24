package rx.internal.producers;

import com.baidu.tieba.bab;
import com.baidu.tieba.bbb;
import com.baidu.tieba.d8b;
import com.baidu.tieba.ibb;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements k7b {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final o7b<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(o7b<? super T> o7bVar) {
        this(o7bVar, r0);
        Queue babVar;
        if (ibb.b()) {
            babVar = new bbb();
        } else {
            babVar = new bab();
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

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                d8b.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(o7b<? super T> o7bVar, Queue<Object> queue) {
        this.child = o7bVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            o7b<? super T> o7bVar = this.child;
            Queue<Object> queue = this.queue;
            while (!o7bVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            o7bVar.onNext(null);
                        } else {
                            o7bVar.onNext(poll);
                        }
                        if (o7bVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        u7b.g(th, o7bVar, poll);
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
