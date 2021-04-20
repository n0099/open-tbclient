package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.h;
import f.b.x.e.a.m;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeout$TimeoutSubscriber<T> extends AtomicLong implements g<T>, d, m {
    public static final long serialVersionUID = 3764492702657003550L;
    public final c<? super T> actual;
    public final h<? super T, ? extends b<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableTimeout$TimeoutSubscriber(c<? super T> cVar, h<? super T, ? extends b<?>> hVar) {
        this.actual = cVar;
        this.itemTimeoutIndicator = hVar;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                f.b.t.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.actual.onNext(t);
                try {
                    b<?> apply = this.itemTimeoutIndicator.apply(t);
                    f.b.x.b.a.b(apply, "The itemTimeoutIndicator returned a null Publisher.");
                    b<?> bVar2 = apply;
                    FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(j2, this);
                    if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                        bVar2.subscribe(flowableTimeout$TimeoutConsumer);
                    }
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    this.upstream.get().cancel();
                    getAndSet(Long.MAX_VALUE);
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    @Override // f.b.x.e.a.o
    public void onTimeout(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.actual.onError(new TimeoutException());
        }
    }

    @Override // f.b.x.e.a.m
    public void onTimeoutError(long j, Throwable th) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void startFirstTimeout(b<?> bVar) {
        if (bVar != null) {
            FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(0L, this);
            if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                bVar.subscribe(flowableTimeout$TimeoutConsumer);
            }
        }
    }
}
