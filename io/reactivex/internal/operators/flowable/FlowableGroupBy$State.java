package io.reactivex.internal.operators.flowable;

import f.a.x.f.a;
import g.d.b;
import g.d.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements b<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public boolean outputFused;
    public final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    public int produced;
    public final a<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<c<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public FlowableGroupBy$State(int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k, boolean z) {
        this.queue = new a<>(i);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k;
        this.delayError = z;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<? super T> cVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            } else if (z2) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void drainFused() {
        Throwable th;
        a<T> aVar = this.queue;
        c<? super T> cVar = this.actual.get();
        int i = 1;
        while (true) {
            if (cVar != null) {
                if (this.cancelled.get()) {
                    aVar.clear();
                    return;
                }
                boolean z = this.done;
                if (z && !this.delayError && (th = this.error) != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return;
                }
                cVar.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        cVar.onError(th2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (cVar == null) {
                cVar = this.actual.get();
            }
        }
    }

    public void drainNormal() {
        int i;
        a<T> aVar = this.queue;
        boolean z = this.delayError;
        c<? super T> cVar = this.actual.get();
        int i2 = 1;
        while (true) {
            if (cVar != null) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z2 = this.done;
                    Object obj = (T) aVar.poll();
                    boolean z3 = obj == null;
                    if (checkTerminated(z2, z3, cVar, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    cVar.onNext(obj);
                    j2++;
                }
                if (i == 0 && checkTerminated(this.done, aVar.isEmpty(), cVar, z)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.parent.s.request(j2);
                }
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            if (cVar == null) {
                cVar = this.actual.get();
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() {
        T poll = this.queue.poll();
        if (poll != null) {
            this.produced++;
            return poll;
        }
        int i = this.produced;
        if (i != 0) {
            this.produced = 0;
            this.parent.s.request(i);
            return null;
        }
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.a.x.i.b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    @Override // g.d.b
    public void subscribe(c<? super T> cVar) {
        if (this.once.compareAndSet(false, true)) {
            cVar.onSubscribe(this);
            this.actual.lazySet(cVar);
            drain();
            return;
        }
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
    }
}
