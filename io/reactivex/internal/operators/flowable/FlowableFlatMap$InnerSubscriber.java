package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.t.b;
import f.a.x.c.f;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<d> implements g<U>, b {
    public static final long serialVersionUID = -4606175640614850599L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber<T, U> parent;
    public long produced;
    public volatile f<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber, long j) {
        this.id = j;
        this.parent = flowableFlatMap$MergeSubscriber;
        int i = flowableFlatMap$MergeSubscriber.bufferSize;
        this.bufferSize = i;
        this.limit = i >> 2;
    }

    @Override // f.a.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, th);
    }

    @Override // g.d.c
    public void onNext(U u) {
        if (this.fusionMode != 2) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                }
            }
            dVar.request(this.bufferSize);
        }
    }

    public void requestMore(long j) {
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
}
