package io.reactivex.internal.operators.observable;

import f.a.a0.a;
import f.a.o;
import f.a.p;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<b> implements o<T>, b, Runnable {
    public static final long serialVersionUID = 786994795061867455L;
    public final o<? super T> actual;
    public boolean done;
    public volatile boolean gate;
    public b s;
    public final long timeout;
    public final TimeUnit unit;
    public final p.c worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar) {
        this.actual = oVar;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = cVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.s.dispose();
        this.worker.dispose();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
        this.worker.dispose();
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.gate || this.done) {
            return;
        }
        this.gate = true;
        this.actual.onNext(t);
        b bVar = get();
        if (bVar != null) {
            bVar.dispose();
        }
        DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
