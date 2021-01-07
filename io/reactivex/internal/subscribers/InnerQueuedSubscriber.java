package io.reactivex.internal.subscribers;

import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.i;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements j<T>, d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final c<T> parent;
    final int prefetch;
    long produced;
    volatile f<T> queue;

    public InnerQueuedSubscriber(c<T> cVar, int i) {
        this.parent = cVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof io.reactivex.internal.a.d) {
                io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
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
                    i.a(dVar, this.prefetch);
                    return;
                }
            }
            this.queue = i.TB(this.prefetch);
            i.a(dVar, this.prefetch);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // org.a.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.a.d
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
            long j = 1 + this.produced;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }
    }

    @Override // org.a.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone() {
        this.done = true;
    }

    public f<T> queue() {
        return this.queue;
    }
}
