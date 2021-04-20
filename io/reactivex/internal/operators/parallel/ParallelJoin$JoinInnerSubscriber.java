package io.reactivex.internal.operators.parallel;

import f.b.g;
import f.b.x.c.e;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<d> implements g<T> {
    public static final long serialVersionUID = 8410034718427740355L;
    public final int limit;
    public final ParallelJoin$JoinSubscriptionBase<T> parent;
    public final int prefetch;
    public long produced;
    public volatile e<T> queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> parallelJoin$JoinSubscriptionBase, int i) {
        this.parent = parallelJoin$JoinSubscriptionBase;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public e<T> getQueue() {
        e<T> eVar = this.queue;
        if (eVar == null) {
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }
        return eVar;
    }

    @Override // g.d.c
    public void onComplete() {
        this.parent.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.parent.onNext(this, t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(this.prefetch);
        }
    }

    public void request(long j) {
        long j2 = this.produced + j;
        if (j2 >= this.limit) {
            this.produced = 0L;
            get().request(j2);
            return;
        }
        this.produced = j2;
    }

    public void requestOne() {
        long j = this.produced + 1;
        if (j == this.limit) {
            this.produced = 0L;
            get().request(j);
            return;
        }
        this.produced = j;
    }
}
