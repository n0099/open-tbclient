package rx.internal.producers;

import com.baidu.tieba.g7c;
import com.baidu.tieba.g9c;
import com.baidu.tieba.gac;
import com.baidu.tieba.i6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.nac;
import com.baidu.tieba.t6c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class QueuedProducer<T> extends AtomicLong implements j6c, i6c<T> {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final n6c<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    @Override // com.baidu.tieba.i6c
    public void onCompleted() {
        this.done = true;
        drain();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedProducer(n6c<? super T> n6cVar) {
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

    @Override // com.baidu.tieba.i6c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.i6c
    public void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
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

    public QueuedProducer(n6c<? super T> n6cVar, Queue<Object> queue) {
        this.child = n6cVar;
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
            n6c<? super T> n6cVar = this.child;
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
                            n6cVar.onNext(null);
                        } else {
                            n6cVar.onNext(poll);
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
