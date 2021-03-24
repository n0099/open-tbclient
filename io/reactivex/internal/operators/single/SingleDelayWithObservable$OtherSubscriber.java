package io.reactivex.internal.operators.single;

import f.a.a0.a;
import f.a.o;
import f.a.r;
import f.a.s;
import f.a.t.b;
import f.a.x.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<b> implements o<U>, b {
    public static final long serialVersionUID = -8565274649390031272L;
    public final r<? super T> actual;
    public boolean done;
    public final s<T> source;

    public SingleDelayWithObservable$OtherSubscriber(r<? super T> rVar, s<T> sVar) {
        this.actual = rVar;
        this.source = sVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.a(new c(this, this.actual));
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(U u) {
        get().dispose();
        onComplete();
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.set(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }
}
