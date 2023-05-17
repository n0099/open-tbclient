package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p8b;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements j7b, o7b, h7b.a<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final p8b<?, K, T> parent;
    public final Queue<Object> queue = new ConcurrentLinkedQueue();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<n7b<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();

    public OperatorGroupBy$State(int i, p8b<?, K, T> p8bVar, K k, boolean z) {
        this.parent = p8bVar;
        this.key = k;
        this.delayError = z;
    }

    public void call(n7b<? super T> n7bVar) {
        if (this.once.compareAndSet(false, true)) {
            n7bVar.b(this);
            n7bVar.f(this);
            this.actual.lazySet(n7bVar);
            drain();
            return;
        }
        n7bVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
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
            this.queue.offer(NotificationLite.h(t));
        }
        drain();
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                c8b.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n7b) ((n7b) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, n7b<? super T> n7bVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.g(this.key);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        n7bVar.onError(th);
                    } else {
                        n7bVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                n7bVar.onError(th2);
                return true;
            } else if (z2) {
                n7bVar.onCompleted();
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
        n7b<? super T> n7bVar = this.actual.get();
        int i = 1;
        while (true) {
            if (n7bVar != null) {
                if (checkTerminated(this.done, queue.isEmpty(), n7bVar, z2)) {
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
                    if (checkTerminated(z3, z, n7bVar, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    n7bVar.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        c8b.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (n7bVar == null) {
                n7bVar = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }
}
