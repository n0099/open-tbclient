package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.w.c;
import f.a.x.c.e;
import f.a.x.i.b;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -1776795561228106469L;
    public final c<R, ? super T, R> accumulator;
    public final g.d.c<? super R> actual;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final e<R> queue;
    public final AtomicLong requested;
    public d s;
    public R value;

    public FlowableScanSeed$ScanSeedSubscriber(g.d.c<? super R> cVar, c<R, ? super T, R> cVar2, R r, int i) {
        this.actual = cVar;
        this.accumulator = cVar2;
        this.value = r;
        this.prefetch = i;
        this.limit = i - (i >> 2);
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i);
        this.queue = spscArrayQueue;
        spscArrayQueue.offer(r);
        this.requested = new AtomicLong();
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        int i;
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        g.d.c<? super R> cVar = this.actual;
        e<R> eVar = this.queue;
        int i2 = this.limit;
        int i3 = this.consumed;
        int i4 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (this.cancelled) {
                    eVar.clear();
                    return;
                } else {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        eVar.clear();
                        cVar.onError(th);
                        return;
                    }
                    Object obj = (R) eVar.poll();
                    boolean z2 = obj == null;
                    if (z && z2) {
                        cVar.onComplete();
                        return;
                    } else if (z2) {
                        break;
                    } else {
                        cVar.onNext(obj);
                        j2++;
                        i3++;
                        if (i3 == i2) {
                            this.s.request(i2);
                            i3 = 0;
                        }
                    }
                }
            }
            if (i == 0 && this.done) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    eVar.clear();
                    cVar.onError(th2);
                    return;
                } else if (eVar.isEmpty()) {
                    cVar.onComplete();
                    return;
                }
            }
            if (j2 != 0) {
                b.e(this.requested, j2);
            }
            this.consumed = i3;
            i4 = addAndGet(-i4);
        } while (i4 != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            R apply = this.accumulator.apply(this.value, t);
            f.a.x.b.a.b(apply, "The accumulator returned a null value");
            this.value = apply;
            this.queue.offer(apply);
            drain();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(this.prefetch - 1);
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
