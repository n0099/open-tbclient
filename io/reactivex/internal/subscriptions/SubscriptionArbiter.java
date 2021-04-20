package io.reactivex.internal.subscriptions;

import f.b.x.b.a;
import f.b.x.i.b;
import g.d.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    public static final long serialVersionUID = -2189523197179400958L;
    public d actual;
    public volatile boolean cancelled;
    public long requested;
    public boolean unbounded;
    public final AtomicReference<d> missedSubscription = new AtomicReference<>();
    public final AtomicLong missedRequested = new AtomicLong();
    public final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    public final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    public final void drainLoop() {
        int i = 1;
        d dVar = null;
        long j = 0;
        do {
            d dVar2 = this.missedSubscription.get();
            if (dVar2 != null) {
                dVar2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = b.c(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (dVar2 != null) {
                    if (dVar3 != null) {
                        dVar3.cancel();
                    }
                    this.actual = dVar2;
                    if (j4 != 0) {
                        j = b.c(j, j4);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && j2 != 0) {
                    j = b.c(j, j2);
                    dVar = dVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            dVar.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                    j3 = 0;
                }
                this.requested = j3;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            drainLoop();
            return;
        }
        b.a(this.missedProduced, j);
        drain();
    }

    @Override // g.d.d
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long c2 = b.c(j2, j);
                this.requested = c2;
                if (c2 == Long.MAX_VALUE) {
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

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        a.b(dVar, "s is null");
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
}
