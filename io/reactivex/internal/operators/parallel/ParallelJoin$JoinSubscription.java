package io.reactivex.internal.operators.parallel;

import f.a.a0.a;
import f.a.x.c.e;
import g.d.c;
import io.reactivex.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class ParallelJoin$JoinSubscription<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    public static final long serialVersionUID = 6312374661811000451L;

    public ParallelJoin$JoinSubscription(c<? super T> cVar, int i, int i2) {
        super(cVar, i, i2);
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
        if (r13 == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
        if (r15 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        r3.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        if (r15 == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        boolean z;
        Object obj;
        ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = this.subscribers;
        int length = parallelJoin$JoinInnerSubscriberArr.length;
        c<? super T> cVar = this.actual;
        int i = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.cancelled) {
                    cleanup();
                    return;
                }
                Throwable th = this.errors.get();
                if (th != null) {
                    cleanup();
                    cVar.onError(th);
                    return;
                }
                boolean z2 = this.done.get() == 0;
                int i2 = 0;
                boolean z3 = true;
                while (true) {
                    if (i2 >= parallelJoin$JoinInnerSubscriberArr.length) {
                        break;
                    }
                    ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber = parallelJoin$JoinInnerSubscriberArr[i2];
                    e<T> eVar = parallelJoin$JoinInnerSubscriber.queue;
                    if (eVar != null && (obj = (T) eVar.poll()) != null) {
                        cVar.onNext(obj);
                        parallelJoin$JoinInnerSubscriber.requestOne();
                        j2++;
                        if (j2 == j) {
                            break;
                        }
                        z3 = false;
                    }
                    i2++;
                }
            }
            if (j2 == j) {
                if (this.cancelled) {
                    cleanup();
                    return;
                }
                Throwable th2 = this.errors.get();
                if (th2 != null) {
                    cleanup();
                    cVar.onError(th2);
                    return;
                }
                boolean z4 = this.done.get() == 0;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        e<T> eVar2 = parallelJoin$JoinInnerSubscriberArr[i3].queue;
                        if (eVar2 != null && !eVar2.isEmpty()) {
                            z = false;
                            break;
                        }
                        i3++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z4 && z) {
                    cVar.onComplete();
                    return;
                }
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            int i4 = get();
            if (i4 == i && (i4 = addAndGet(-i)) == 0) {
                return;
            }
            i = i4;
        }
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable th) {
        if (this.errors.compareAndSet(null, th)) {
            cancelAll();
            drain();
        } else if (th != this.errors.get()) {
            a.f(th);
        }
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t) {
        if (get() == 0 && compareAndSet(0, 1)) {
            if (this.requested.get() != 0) {
                this.actual.onNext(t);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                parallelJoin$JoinInnerSubscriber.request(1L);
            } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                if (this.errors.compareAndSet(null, missingBackpressureException)) {
                    this.actual.onError(missingBackpressureException);
                    return;
                } else {
                    a.f(missingBackpressureException);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t)) {
            cancelAll();
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }
}
