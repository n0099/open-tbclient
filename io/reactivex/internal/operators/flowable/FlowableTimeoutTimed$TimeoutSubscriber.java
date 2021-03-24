package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.p;
import f.a.x.e.a.o;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements g<T>, d, o {
    public static final long serialVersionUID = 3764492702657003550L;
    public final c<? super T> actual;
    public final long timeout;
    public final TimeUnit unit;
    public final p.c worker;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<d> upstream = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableTimeoutTimed$TimeoutSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p.c cVar2) {
        this.actual = cVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onComplete();
            this.worker.dispose();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.actual.onError(th);
            this.worker.dispose();
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
                this.task.get().dispose();
                this.actual.onNext(t);
                startTimeout(j2);
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
    }

    @Override // f.a.x.e.a.o
    public void onTimeout(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.actual.onError(new TimeoutException());
            this.worker.dispose();
        }
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void startTimeout(long j) {
        this.task.replace(this.worker.c(new f.a.x.e.a.p(j, this), this.timeout, this.unit));
    }
}
