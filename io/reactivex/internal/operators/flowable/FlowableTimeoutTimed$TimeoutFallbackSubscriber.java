package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.p;
import f.a.x.e.a.n;
import f.a.x.e.a.o;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements g<T>, o {
    public static final long serialVersionUID = 3764492702657003550L;
    public final c<? super T> actual;
    public long consumed;
    public b<? extends T> fallback;
    public final long timeout;
    public final TimeUnit unit;
    public final p.c worker;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final AtomicLong index = new AtomicLong();

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p.c cVar2, b<? extends T> bVar) {
        this.actual = cVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = cVar2;
        this.fallback = bVar;
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, g.d.d
    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onComplete();
            this.worker.dispose();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
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
                this.task.get().dispose();
                this.consumed++;
                this.actual.onNext(t);
                startTimeout(j2);
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            setSubscription(dVar);
        }
    }

    @Override // f.a.x.e.a.o
    public void onTimeout(long j) {
        if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            long j2 = this.consumed;
            if (j2 != 0) {
                produced(j2);
            }
            b<? extends T> bVar = this.fallback;
            this.fallback = null;
            bVar.subscribe(new n(this.actual, this));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j) {
        this.task.replace(this.worker.c(new f.a.x.e.a.p(j, this), this.timeout, this.unit));
    }
}
