package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableTakeUntil$TakeUntilObserver<T> extends AtomicBoolean implements o<T> {
    public static final long serialVersionUID = 3451719290311127173L;
    public final o<? super T> actual;
    public final ArrayCompositeDisposable frc;
    public b s;

    public ObservableTakeUntil$TakeUntilObserver(o<? super T> oVar, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.actual = oVar;
        this.frc = arrayCompositeDisposable;
    }

    @Override // f.b.o
    public void onComplete() {
        this.frc.dispose();
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.frc.dispose();
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.frc.setResource(0, bVar);
        }
    }
}
