package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.y8c;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements p7c, u7c, n7c.a<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final y8c<?, K, T> parent;
    public final Queue<Object> queue = new ConcurrentLinkedQueue();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<t7c<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();

    public OperatorGroupBy$State(int i, y8c<?, K, T> y8cVar, K k, boolean z) {
        this.parent = y8cVar;
        this.key = k;
        this.delayError = z;
    }

    public void call(t7c<? super T> t7cVar) {
        if (this.once.compareAndSet(false, true)) {
            t7cVar.b(this);
            t7cVar.f(this);
            this.actual.lazySet(t7cVar);
            drain();
            return;
        }
        t7cVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (t == null) {
            this.error = new NullPointerException();
            this.done = true;
        } else {
            this.queue.offer(NotificationLite.i(t));
        }
        drain();
    }

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                k8c.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, t7c<? super T> t7cVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.g(this.key);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        t7cVar.onError(th);
                    } else {
                        t7cVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                t7cVar.onError(th2);
                return true;
            } else if (z2) {
                t7cVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void drain() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<Object> queue = this.queue;
        boolean z2 = this.delayError;
        t7c<? super T> t7cVar = this.actual.get();
        int i = 1;
        while (true) {
            if (t7cVar != null) {
                if (checkTerminated(this.done, queue.isEmpty(), t7cVar, z2)) {
                    return;
                }
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z3 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z3, z, t7cVar, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    t7cVar.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        k8c.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (t7cVar == null) {
                t7cVar = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }
}
