package rx.internal.operators;

import com.baidu.tieba.a9c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements r7c, w7c, p7c.a<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final a9c<?, K, T> parent;
    public final Queue<Object> queue = new ConcurrentLinkedQueue();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<v7c<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();

    public OperatorGroupBy$State(int i, a9c<?, K, T> a9cVar, K k, boolean z) {
        this.parent = a9cVar;
        this.key = k;
        this.delayError = z;
    }

    public void call(v7c<? super T> v7cVar) {
        if (this.once.compareAndSet(false, true)) {
            v7cVar.b(this);
            v7cVar.f(this);
            this.actual.lazySet(v7cVar);
            drain();
            return;
        }
        v7cVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
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

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                m8c.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, v7c<? super T> v7cVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.g(this.key);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        v7cVar.onError(th);
                    } else {
                        v7cVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                v7cVar.onError(th2);
                return true;
            } else if (z2) {
                v7cVar.onCompleted();
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
        v7c<? super T> v7cVar = this.actual.get();
        int i = 1;
        while (true) {
            if (v7cVar != null) {
                if (checkTerminated(this.done, queue.isEmpty(), v7cVar, z2)) {
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
                    if (checkTerminated(z3, z, v7cVar, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    v7cVar.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        m8c.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (v7cVar == null) {
                v7cVar = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }
}
