package io.reactivex.internal.operators.single;

import f.b.a0.a;
import f.b.o;
import f.b.r;
import f.b.s;
import f.b.t.b;
import f.b.x.d.c;
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

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.a(new c(this, this.actual));
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(U u) {
        get().dispose();
        onComplete();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.set(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }
}
