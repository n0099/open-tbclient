package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.x.c.f;
import f.a.x.e.a.l;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<d> implements g<T> {
    public static final long serialVersionUID = 4804128302091633067L;
    public volatile boolean done;
    public final int limit;
    public final l parent;
    public final int prefetch;
    public long produced;
    public volatile f<T> queue;
    public int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(l lVar, int i) {
        this.parent = lVar;
        this.limit = i - (i >> 2);
        this.prefetch = i;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        f<T> fVar = this.queue;
        if (fVar != null) {
            fVar.clear();
        }
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            onError(new MissingBackpressureException());
        } else {
            this.parent.drain();
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            dVar.request(this.prefetch);
        }
    }

    public void request() {
        if (this.sourceMode != 1) {
            long j = this.produced + 1;
            if (j >= this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }
    }
}
