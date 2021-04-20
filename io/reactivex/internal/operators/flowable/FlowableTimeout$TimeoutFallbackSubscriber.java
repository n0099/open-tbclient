package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.h;
import f.b.x.e.a.m;
import f.b.x.e.a.n;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeout$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements g<T>, m {
    public static final long serialVersionUID = 3764492702657003550L;
    public final c<? super T> actual;
    public long consumed;
    public b<? extends T> fallback;
    public final h<? super T, ? extends b<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final AtomicLong index = new AtomicLong();

    public FlowableTimeout$TimeoutFallbackSubscriber(c<? super T> cVar, h<? super T, ? extends b<?>> hVar, b<? extends T> bVar) {
        this.actual = cVar;
        this.itemTimeoutIndicator = hVar;
        this.fallback = bVar;
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, g.d.d
    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onComplete();
            this.task.dispose();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onError(th);
            this.task.dispose();
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        long j = this.index.get();
        if (j != Long.MAX_VALUE) {
            long j2 = j + 1;
            if (this.index.compareAndSet(j, j2)) {
                f.b.t.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.consumed++;
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
                    this.index.getAndSet(Long.MAX_VALUE);
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            setSubscription(dVar);
        }
    }

    @Override // f.b.x.e.a.o
    public void onTimeout(long j) {
        if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            b<? extends T> bVar = this.fallback;
            this.fallback = null;
            long j2 = this.consumed;
            if (j2 != 0) {
                produced(j2);
            }
            bVar.subscribe(new n(this.actual, this));
        }
    }

    @Override // f.b.x.e.a.m
    public void onTimeoutError(long j, Throwable th) {
        if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.actual.onError(th);
            return;
        }
        a.f(th);
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
