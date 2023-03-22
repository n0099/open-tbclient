package rx.internal.operators;

import com.baidu.tieba.jsa;
import com.baidu.tieba.ora;
import com.baidu.tieba.qra;
import com.baidu.tieba.tsa;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements qra, vra, ora.a<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final tsa<?, K, T> parent;
    public final Queue<Object> queue = new ConcurrentLinkedQueue();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<ura<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();

    public OperatorGroupBy$State(int i, tsa<?, K, T> tsaVar, K k, boolean z) {
        this.parent = tsaVar;
        this.key = k;
        this.delayError = z;
    }

    public void call(ura<? super T> uraVar) {
        if (this.once.compareAndSet(false, true)) {
            uraVar.b(this);
            uraVar.f(this);
            this.actual.lazySet(uraVar);
            drain();
            return;
        }
        uraVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
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

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                jsa.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, ura<? super T> uraVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.g(this.key);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        uraVar.onError(th);
                    } else {
                        uraVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                uraVar.onError(th2);
                return true;
            } else if (z2) {
                uraVar.onCompleted();
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
        ura<? super T> uraVar = this.actual.get();
        int i = 1;
        while (true) {
            if (uraVar != null) {
                if (checkTerminated(this.done, queue.isEmpty(), uraVar, z2)) {
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
                    if (checkTerminated(z3, z, uraVar, z2)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    uraVar.onNext((Object) NotificationLite.e(poll));
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        jsa.g(this.requested, j2);
                    }
                    this.parent.e.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (uraVar == null) {
                uraVar = this.actual.get();
            }
        }
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.g(this.key);
        }
    }
}
