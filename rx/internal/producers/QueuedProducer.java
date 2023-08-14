package rx.internal.producers;

import com.baidu.tieba.a1c;
import com.baidu.tieba.b5c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.u3c;
import com.baidu.tieba.u4c;
import com.baidu.tieba.z0c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class QueuedProducer<T> extends AtomicLong implements a1c, z0c<T> {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final e1c<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    @Override // com.baidu.tieba.z0c
    public void onCompleted() {
        this.done = true;
        drain();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedProducer(e1c<? super T> e1cVar) {
        this(e1cVar, r0);
        Queue u3cVar;
        if (b5c.b()) {
            u3cVar = new u4c();
        } else {
            u3cVar = new u3c();
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

    @Override // com.baidu.tieba.z0c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.z0c
    public void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
    }

    @Override // com.baidu.tieba.a1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i > 0) {
                u1c.b(this, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedProducer(e1c<? super T> e1cVar, Queue<Object> queue) {
        this.child = e1cVar;
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
            e1c<? super T> e1cVar = this.child;
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
                            e1cVar.onNext(null);
                        } else {
                            e1cVar.onNext(poll);
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        k1c.g(th, e1cVar, poll);
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
