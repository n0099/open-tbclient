package io.reactivex.internal.operators.parallel;

import f.a.w.c;
import f.a.x.b.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    public static final long serialVersionUID = -5370107872170712765L;
    public final AtomicReference<ParallelReduceFull$SlotPair<T>> current;
    public final AtomicReference<Throwable> error;
    public final c<T, T, T> reducer;
    public final AtomicInteger remaining;
    public final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(g.d.c<? super T> cVar, int i, c<T, T, T> cVar2) {
        super(cVar);
        this.current = new AtomicReference<>();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference<>();
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] parallelReduceFull$ParallelReduceFullInnerSubscriberArr = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[i];
        for (int i2 = 0; i2 < i; i2++) {
            parallelReduceFull$ParallelReduceFullInnerSubscriberArr[i2] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber<>(this, cVar2);
        }
        this.subscribers = parallelReduceFull$ParallelReduceFullInnerSubscriberArr;
        this.reducer = cVar2;
        this.remaining.lazySet(i);
    }

    public ParallelReduceFull$SlotPair<T> addValue(T t) {
        ParallelReduceFull$SlotPair<T> parallelReduceFull$SlotPair;
        int tryAcquireSlot;
        while (true) {
            parallelReduceFull$SlotPair = this.current.get();
            if (parallelReduceFull$SlotPair == null) {
                parallelReduceFull$SlotPair = new ParallelReduceFull$SlotPair<>();
                if (!this.current.compareAndSet(null, parallelReduceFull$SlotPair)) {
                    continue;
                }
            }
            tryAcquireSlot = parallelReduceFull$SlotPair.tryAcquireSlot();
            if (tryAcquireSlot >= 0) {
                break;
            }
            this.current.compareAndSet(parallelReduceFull$SlotPair, null);
        }
        if (tryAcquireSlot == 0) {
            parallelReduceFull$SlotPair.first = t;
        } else {
            parallelReduceFull$SlotPair.second = t;
        }
        if (parallelReduceFull$SlotPair.releaseSlot()) {
            this.current.compareAndSet(parallelReduceFull$SlotPair, null);
            return parallelReduceFull$SlotPair;
        }
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        for (ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> parallelReduceFull$ParallelReduceFullInnerSubscriber : this.subscribers) {
            parallelReduceFull$ParallelReduceFullInnerSubscriber.cancel();
        }
    }

    public void innerComplete(T t) {
        if (t != null) {
            while (true) {
                ParallelReduceFull$SlotPair<T> addValue = addValue(t);
                if (addValue == null) {
                    break;
                }
                try {
                    t = this.reducer.apply(addValue.first, addValue.second);
                    a.b(t, "The reducer returned a null value");
                } catch (Throwable th) {
                    f.a.u.a.a(th);
                    innerError(th);
                    return;
                }
            }
        }
        if (this.remaining.decrementAndGet() == 0) {
            ParallelReduceFull$SlotPair<T> parallelReduceFull$SlotPair = this.current.get();
            this.current.lazySet(null);
            if (parallelReduceFull$SlotPair != null) {
                complete(parallelReduceFull$SlotPair.first);
            } else {
                this.actual.onComplete();
            }
        }
    }

    public void innerError(Throwable th) {
        if (this.error.compareAndSet(null, th)) {
            cancel();
            this.actual.onError(th);
        } else if (th != this.error.get()) {
            f.a.a0.a.f(th);
        }
    }
}
