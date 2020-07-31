package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;
import rx.internal.util.a.ae;
import rx.internal.util.a.x;
import rx.internal.util.atomic.e;
import rx.j;
/* loaded from: classes6.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements f {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final j<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(j<? super T> jVar) {
        this(jVar, ae.dYB() ? new x() : new e());
    }

    public QueuedValueProducer(j<? super T> jVar, Queue<Object> queue) {
        this.child = jVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    @Override // rx.f
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j > 0) {
            rx.internal.operators.a.e(this, j);
            drain();
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

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            j<? super T> jVar = this.child;
            Queue<Object> queue = this.queue;
            while (!jVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            jVar.onNext(null);
                        } else {
                            jVar.onNext(poll);
                        }
                        if (!jVar.isUnsubscribed()) {
                            j--;
                            j2++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        rx.exceptions.a.a(th, jVar, poll);
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
