package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements g<T>, d {
    public static final long serialVersionUID = 7240042530241604978L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final int count;
    public volatile boolean done;
    public d s;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableTakeLast$TakeLastSubscriber(c<? super T> cVar, int i) {
        this.actual = cVar;
        this.count = i;
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            c<? super T> cVar = this.actual;
            long j = this.requested.get();
            while (!this.cancelled) {
                if (this.done) {
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        Object obj = (T) poll();
                        if (obj == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onNext(obj);
                            j2++;
                        }
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        j = this.requested.addAndGet(-j2);
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.count == size()) {
            poll();
        }
        offer(t);
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
