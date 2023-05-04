package rx.internal.producers;

import com.baidu.tieba.b8b;
import com.baidu.tieba.b9b;
import com.baidu.tieba.e6b;
import com.baidu.tieba.i9b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.v5b;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements l5b {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final p5b<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(p5b<? super T> p5bVar) {
        this(p5bVar, r0);
        Queue b8bVar;
        if (i9b.b()) {
            b8bVar = new b9b();
        } else {
            b8bVar = new b8b();
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

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                e6b.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedValueProducer(p5b<? super T> p5bVar, Queue<Object> queue) {
        this.child = p5bVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            p5b<? super T> p5bVar = this.child;
            Queue<Object> queue = this.queue;
            while (!p5bVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            p5bVar.onNext(null);
                        } else {
                            p5bVar.onNext(poll);
                        }
                        if (p5bVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        v5b.g(th, p5bVar, poll);
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
