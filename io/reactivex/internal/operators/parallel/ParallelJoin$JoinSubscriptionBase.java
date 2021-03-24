package io.reactivex.internal.operators.parallel;

import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements d {
    public static final long serialVersionUID = 3100232009247827843L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger done = new AtomicInteger();

    public ParallelJoin$JoinSubscriptionBase(c<? super T> cVar, int i, int i2) {
        this.actual = cVar;
        ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = new ParallelJoin$JoinInnerSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            parallelJoin$JoinInnerSubscriberArr[i3] = new ParallelJoin$JoinInnerSubscriber<>(this, i2);
        }
        this.subscribers = parallelJoin$JoinInnerSubscriberArr;
        this.done.lazySet(i);
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() == 0) {
            cleanup();
        }
    }

    public void cancelAll() {
        int i = 0;
        while (true) {
            ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = this.subscribers;
            if (i >= parallelJoin$JoinInnerSubscriberArr.length) {
                return;
            }
            parallelJoin$JoinInnerSubscriberArr[i].cancel();
            i++;
        }
    }

    public void cleanup() {
        int i = 0;
        while (true) {
            ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = this.subscribers;
            if (i >= parallelJoin$JoinInnerSubscriberArr.length) {
                return;
            }
            parallelJoin$JoinInnerSubscriberArr[i].queue = null;
            i++;
        }
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable th);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t);

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }
}
