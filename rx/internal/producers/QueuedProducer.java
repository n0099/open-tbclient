package rx.internal.producers;

import com.baidu.tieba.b8c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.mac;
import com.baidu.tieba.mbc;
import com.baidu.tieba.q7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.tbc;
import com.baidu.tieba.v7c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class QueuedProducer<T> extends AtomicLong implements r7c, q7c<T> {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final v7c<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    @Override // com.baidu.tieba.q7c
    public void onCompleted() {
        this.done = true;
        drain();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedProducer(v7c<? super T> v7cVar) {
        this(v7cVar, r0);
        Queue macVar;
        if (tbc.b()) {
            macVar = new mbc();
        } else {
            macVar = new mac();
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

    @Override // com.baidu.tieba.q7c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.q7c
    public void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                m8c.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedProducer(v7c<? super T> v7cVar, Queue<Object> queue) {
        this.child = v7cVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private boolean checkTerminated(boolean z, boolean z2) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (z) {
            Throwable th = this.error;
            if (th != null) {
                this.queue.clear();
                this.child.onError(th);
                return true;
            } else if (z2) {
                this.child.onCompleted();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void drain() {
        boolean z;
        if (this.wip.getAndIncrement() == 0) {
            v7c<? super T> v7cVar = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0) {
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z2, z)) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    try {
                        if (poll == NULL_SENTINEL) {
                            v7cVar.onNext(null);
                        } else {
                            v7cVar.onNext(poll);
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        b8c.g(th, v7cVar, poll);
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
