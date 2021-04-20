package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.p;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements g<T>, d, Runnable {
    public static final long serialVersionUID = -3517602651313910099L;
    public final c<? super T> actual;
    public final long period;
    public d s;
    public final p scheduler;
    public final TimeUnit unit;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable timer = new SequentialDisposable();

    public FlowableSampleTimed$SampleTimedSubscriber(c<? super T> cVar, long j, TimeUnit timeUnit, p pVar) {
        this.actual = cVar;
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = pVar;
    }

    @Override // g.d.d
    public void cancel() {
        cancelTimer();
        this.s.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            if (this.requested.get() != 0) {
                this.actual.onNext(andSet);
                b.e(this.requested, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    @Override // g.d.c
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        cancelTimer();
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        lazySet(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            p pVar = this.scheduler;
            long j = this.period;
            sequentialDisposable.replace(pVar.e(this, j, j, this.unit));
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
        }
    }
}
