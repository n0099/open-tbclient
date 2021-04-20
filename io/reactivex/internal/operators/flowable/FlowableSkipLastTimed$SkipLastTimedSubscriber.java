package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.p;
import f.b.x.f.a;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -5677354903406201275L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public d s;
    public final p scheduler;
    public final long time;
    public final TimeUnit unit;

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p pVar, int i, boolean z) {
        this.actual = cVar;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = pVar;
        this.queue = new a<>(i);
        this.delayError = z;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<? super T> cVar, boolean z3) {
        if (this.cancelled) {
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

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        a<Object> aVar = this.queue;
        boolean z = this.delayError;
        TimeUnit timeUnit = this.unit;
        p pVar = this.scheduler;
        long j = this.time;
        int i = 1;
        do {
            long j2 = this.requested.get();
            long j3 = 0;
            while (j3 != j2) {
                boolean z2 = this.done;
                Long l = (Long) aVar.peek();
                boolean z3 = l == null;
                boolean z4 = (z3 || l.longValue() <= pVar.b(timeUnit) - j) ? z3 : true;
                if (checkTerminated(z2, z4, cVar, z)) {
                    return;
                }
                if (z4) {
                    break;
                }
                aVar.poll();
                cVar.onNext(aVar.poll());
                j3++;
            }
            if (j3 != 0) {
                b.e(this.requested, j3);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t);
        drain();
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }
}
