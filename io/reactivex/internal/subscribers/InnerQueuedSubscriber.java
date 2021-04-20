package io.reactivex.internal.subscribers;

import f.b.g;
import f.b.x.c.f;
import f.b.x.h.a;
import f.b.x.i.i;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements g<T>, d {
    public static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final a<T> parent;
    public final int prefetch;
    public long produced;
    public volatile f<T> queue;

    public InnerQueuedSubscriber(a<T> aVar, int i) {
        this.parent = aVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // g.d.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof f.b.x.c.d) {
                f.b.x.c.d dVar2 = (f.b.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    i.f(dVar, this.prefetch);
                    return;
                }
            }
            this.queue = i.a(this.prefetch);
            i.f(dVar, this.prefetch);
        }
    }

    public f<T> queue() {
        return this.queue;
    }

    @Override // g.d.d
    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
                return;
            }
            this.produced = j2;
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }
    }

    public void setDone() {
        this.done = true;
    }
}
