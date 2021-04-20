package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.w.h;
import f.b.x.c.f;
import f.b.x.e.a.d;
import g.d.b;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements g<T>, d<R>, g.d.d {
    public static final long serialVersionUID = -3511336836796789179L;
    public volatile boolean active;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final int limit;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final int prefetch;
    public f<T> queue;
    public g.d.d s;
    public int sourceMode;
    public final FlowableConcatMap$ConcatMapInner<R> inner = new FlowableConcatMap$ConcatMapInner<>(this);
    public final AtomicThrowable errors = new AtomicThrowable();

    public FlowableConcatMap$BaseConcatMapSubscriber(h<? super T, ? extends b<? extends R>> hVar, int i) {
        this.mapper = hVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // g.d.d
    public abstract /* synthetic */ void cancel();

    public abstract void drain();

    @Override // f.b.x.e.a.d
    public final void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // f.b.x.e.a.d
    public abstract /* synthetic */ void innerError(Throwable th);

    @Override // f.b.x.e.a.d
    public abstract /* synthetic */ void innerNext(T t);

    @Override // g.d.c
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // g.d.c
    public final void onNext(T t) {
        if (this.sourceMode != 2 && !this.queue.offer(t)) {
            this.s.cancel();
            onError(new IllegalStateException("Queue full?!"));
            return;
        }
        drain();
    }

    @Override // f.b.g, g.d.c
    public final void onSubscribe(g.d.d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof f.b.x.c.d) {
                f.b.x.c.d dVar2 = (f.b.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    subscribeActual();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    subscribeActual();
                    dVar.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            dVar.request(this.prefetch);
        }
    }

    @Override // g.d.d
    public abstract /* synthetic */ void request(long j);

    public abstract void subscribeActual();
}
