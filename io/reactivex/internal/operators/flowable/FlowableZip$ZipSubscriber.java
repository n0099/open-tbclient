package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.x.c.f;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<d> implements g<T>, d {
    public static final long serialVersionUID = -4627193790118206028L;
    public volatile boolean done;
    public final int limit;
    public final FlowableZip$ZipCoordinator<T, R> parent;
    public final int prefetch;
    public long produced;
    public f<T> queue;
    public int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> flowableZip$ZipCoordinator, int i) {
        this.parent = flowableZip$ZipCoordinator;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.error(this, th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.sourceMode != 2) {
            this.queue.offer(t);
        }
        this.parent.drain();
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
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

    @Override // g.d.d
    public void request(long j) {
        if (this.sourceMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
                return;
            }
            this.produced = j2;
        }
    }
}
