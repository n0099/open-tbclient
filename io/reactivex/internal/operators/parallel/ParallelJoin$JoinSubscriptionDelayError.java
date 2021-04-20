package io.reactivex.internal.operators.parallel;

import f.b.x.c.e;
import g.d.c;
import io.reactivex.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    public static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(c<? super T> cVar, int i, int i2) {
        super(cVar, i, i2);
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        if (r13 == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        if (r15 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r18.errors.get() == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        r3.onError(r18.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        r3.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r15 == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
        return;
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
                boolean z2 = this.done.get() == 0;
                int i2 = 0;
                boolean z3 = true;
                while (true) {
                    if (i2 >= length) {
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
                    if (this.errors.get() != null) {
                        cVar.onError(this.errors.terminate());
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
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
        this.errors.addThrowable(th);
        this.done.decrementAndGet();
        drain();
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
                parallelJoin$JoinInnerSubscriber.cancel();
                this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
                drainLoop();
                return;
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t) && parallelJoin$JoinInnerSubscriber.cancel()) {
                this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }
}
