package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.p;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements g<T>, d, Runnable {
    public static final long serialVersionUID = -9102637559663639004L;
    public final c<? super T> actual;
    public boolean done;
    public volatile boolean gate;
    public d s;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public final p.c worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p.c cVar2) {
        this.actual = cVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
        this.worker.dispose();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done || this.gate) {
            return;
        }
        this.gate = true;
        if (get() != 0) {
            this.actual.onNext(t);
            b.e(this, 1L);
            f.b.t.b bVar = this.timer.get();
            if (bVar != null) {
                bVar.dispose();
            }
            this.timer.replace(this.worker.c(this, this.timeout, this.unit));
            return;
        }
        this.done = true;
        cancel();
        this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
