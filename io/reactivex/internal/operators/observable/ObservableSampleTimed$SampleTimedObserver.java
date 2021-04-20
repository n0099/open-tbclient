package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.p;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements o<T>, b, Runnable {
    public static final long serialVersionUID = -3517602651313910099L;
    public final o<? super T> actual;
    public final long period;
    public b s;
    public final p scheduler;
    public final AtomicReference<b> timer = new AtomicReference<>();
    public final TimeUnit unit;

    public ObservableSampleTimed$SampleTimedObserver(o<? super T> oVar, long j, TimeUnit timeUnit, p pVar) {
        this.actual = oVar;
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = pVar;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    @Override // f.b.t.b
    public void dispose() {
        cancelTimer();
        this.s.dispose();
    }

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            this.actual.onNext(andSet);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // f.b.o
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        cancelTimer();
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        lazySet(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
            p pVar = this.scheduler;
            long j = this.period;
            DisposableHelper.replace(this.timer, pVar.e(this, j, j, this.unit));
        }
    }
}
