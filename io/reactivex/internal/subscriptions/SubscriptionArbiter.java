package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.a;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes17.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        a.l(dVar, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            d dVar2 = this.actual;
            if (dVar2 != null) {
                dVar2.cancel();
            }
            this.actual = dVar;
            long j = this.requested;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (j != 0) {
                dVar.request(j);
                return;
            }
            return;
        }
        d andSet = this.missedSubscription.getAndSet(dVar);
        if (andSet != null) {
            andSet.cancel();
        }
        drain();
    }

    @Override // org.a.d
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != Long.MAX_VALUE) {
                    long N = b.N(j2, j);
                    this.requested = N;
                    if (N == Long.MAX_VALUE) {
                        this.unbounded = true;
                    }
                }
                d dVar = this.actual;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (dVar != null) {
                    dVar.request(j);
                    return;
                }
                return;
            }
            b.a(this.missedRequested, j);
            drain();
        }
    }

    public final void produced(long j) {
        long j2 = 0;
        if (!this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j3 = this.requested;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 - j;
                    if (j4 < 0) {
                        SubscriptionHelper.reportMoreProduced(j4);
                    } else {
                        j2 = j4;
                    }
                    this.requested = j2;
                }
                if (decrementAndGet() != 0) {
                    drainLoop();
                    return;
                }
                return;
            }
            b.a(this.missedProduced, j);
            drain();
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    final void drainLoop() {
        d dVar;
        long j;
        long N;
        long j2 = 0;
        d dVar2 = null;
        int i = 1;
        while (true) {
            dVar = this.missedSubscription.get();
            if (dVar != null) {
                dVar = this.missedSubscription.getAndSet(null);
            }
            long j3 = this.missedRequested.get();
            long andSet = j3 != 0 ? this.missedRequested.getAndSet(0L) : j3;
            long j4 = this.missedProduced.get();
            long andSet2 = j4 != 0 ? this.missedProduced.getAndSet(0L) : j4;
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar != null) {
                    dVar.cancel();
                    dVar = dVar2;
                    N = j2;
                }
                dVar = dVar2;
                N = j2;
            } else {
                long j5 = this.requested;
                if (j5 != Long.MAX_VALUE) {
                    long N2 = b.N(j5, andSet);
                    if (N2 != Long.MAX_VALUE) {
                        j = N2 - andSet2;
                        if (j < 0) {
                            SubscriptionHelper.reportMoreProduced(j);
                            j = 0;
                        }
                    } else {
                        j = N2;
                    }
                    this.requested = j;
                } else {
                    j = j5;
                }
                if (dVar != null) {
                    if (dVar3 != null) {
                        dVar3.cancel();
                    }
                    this.actual = dVar;
                    if (j != 0) {
                        N = b.N(j2, j);
                    }
                    dVar = dVar2;
                    N = j2;
                } else {
                    if (dVar3 != null && andSet != 0) {
                        N = b.N(j2, andSet);
                        dVar = dVar3;
                    }
                    dVar = dVar2;
                    N = j2;
                }
            }
            int addAndGet = addAndGet(-i);
            if (addAndGet == 0) {
                break;
            }
            j2 = N;
            i = addAndGet;
            dVar2 = dVar;
        }
        if (N != 0) {
            dVar.request(N);
        }
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
