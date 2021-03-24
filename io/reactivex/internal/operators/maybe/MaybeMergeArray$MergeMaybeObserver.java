package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.a;
import f.a.t.b;
import f.a.x.e.b.d;
import g.d.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements i<T> {
    public static final long serialVersionUID = -660395290758764731L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public long consumed;
    public boolean outputFused;
    public final d<Object> queue;
    public final int sourceCount;
    public final a set = new a();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicThrowable error = new AtomicThrowable();

    public MaybeMergeArray$MergeMaybeObserver(c<? super T> cVar, int i, d<Object> dVar) {
        this.actual = cVar;
        this.sourceCount = i;
        this.queue = dVar;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.set.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
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
        c<? super T> cVar = this.actual;
        d<Object> dVar = this.queue;
        int i = 1;
        while (!this.cancelled) {
            Throwable th = this.error.get();
            if (th != null) {
                dVar.clear();
                cVar.onError(th);
                return;
            }
            boolean z = dVar.producerIndex() == this.sourceCount;
            if (!dVar.isEmpty()) {
                cVar.onNext(null);
            }
            if (z) {
                cVar.onComplete();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        dVar.clear();
    }

    public void drainNormal() {
        c<? super T> cVar = this.actual;
        d<Object> dVar = this.queue;
        long j = this.consumed;
        int i = 1;
        do {
            long j2 = this.requested.get();
            while (j != j2) {
                if (this.cancelled) {
                    dVar.clear();
                    return;
                } else if (this.error.get() != null) {
                    dVar.clear();
                    cVar.onError(this.error.terminate());
                    return;
                } else if (dVar.consumerIndex() == this.sourceCount) {
                    cVar.onComplete();
                    return;
                } else {
                    Object poll = dVar.poll();
                    if (poll == null) {
                        break;
                    } else if (poll != NotificationLite.COMPLETE) {
                        cVar.onNext(poll);
                        j++;
                    }
                }
            }
            if (j == j2) {
                if (this.error.get() != null) {
                    dVar.clear();
                    cVar.onError(this.error.terminate());
                    return;
                }
                while (dVar.peek() == NotificationLite.COMPLETE) {
                    dVar.drop();
                }
                if (dVar.consumerIndex() == this.sourceCount) {
                    cVar.onComplete();
                    return;
                }
            }
            this.consumed = j;
            i = addAndGet(-i);
        } while (i != 0);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // f.a.i
    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        if (this.error.addThrowable(th)) {
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        this.set.b(bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() throws Exception {
        T t;
        do {
            t = (T) this.queue.poll();
        } while (t == NotificationLite.COMPLETE);
        return t;
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
}
