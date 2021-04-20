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
public final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -5677354903406201275L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public d s;
    public final p scheduler;
    public final long time;
    public final TimeUnit unit;

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(c<? super T> cVar, long j, long j2, TimeUnit timeUnit, p pVar, int i, boolean z) {
        this.actual = cVar;
        this.count = j;
        this.time = j2;
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

    public boolean checkTerminated(boolean z, c<? super T> cVar, boolean z2) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (z2) {
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            } else if (z) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.actual;
        a<Object> aVar = this.queue;
        boolean z = this.delayError;
        int i = 1;
        do {
            if (this.done) {
                if (checkTerminated(aVar.isEmpty(), cVar, z)) {
                    return;
                }
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    if (checkTerminated(aVar.peek() == null, cVar, z)) {
                        return;
                    }
                    if (j != j2) {
                        aVar.poll();
                        cVar.onNext(aVar.poll());
                        j2++;
                    } else if (j2 != 0) {
                        b.e(this.requested, j2);
                    }
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        trim(this.scheduler.b(this.unit), this.queue);
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.delayError) {
            trim(this.scheduler.b(this.unit), this.queue);
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        a<Object> aVar = this.queue;
        long b2 = this.scheduler.b(this.unit);
        aVar.l(Long.valueOf(b2), t);
        trim(b2, aVar);
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

    public void trim(long j, a<Object> aVar) {
        long j2 = this.time;
        long j3 = this.count;
        boolean z = j3 == Long.MAX_VALUE;
        while (!aVar.isEmpty()) {
            if (((Long) aVar.peek()).longValue() >= j - j2 && (z || (aVar.n() >> 1) <= j3)) {
                return;
            }
            aVar.poll();
            aVar.poll();
        }
    }
}
