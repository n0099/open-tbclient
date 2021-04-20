package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.x.e.c.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements o<T>, b {
    public static final long serialVersionUID = -3517602651313910099L;
    public final o<? super T> actual;
    public final AtomicReference<b> other = new AtomicReference<>();
    public b s;
    public final n<?> sampler;

    public ObservableSampleWithObservable$SampleMainObserver(o<? super T> oVar, n<?> nVar) {
        this.actual = oVar;
        this.sampler = nVar;
    }

    public void complete() {
        this.s.dispose();
        completeOther();
    }

    public abstract void completeMain();

    public abstract void completeOther();

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.s.dispose();
    }

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            this.actual.onNext(andSet);
        }
    }

    public void error(Throwable th) {
        this.s.dispose();
        this.actual.onError(th);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.other.get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.o
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completeMain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.other);
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
            if (this.other.get() == null) {
                this.sampler.subscribe(new i(this));
            }
        }
    }

    public abstract void run();

    public boolean setOther(b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
