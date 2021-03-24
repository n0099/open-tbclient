package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.w.c;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableWithLatestFrom$WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements o<T>, b {
    public static final long serialVersionUID = -312246233408980075L;
    public final o<? super R> actual;
    public final c<? super T, ? super U, ? extends R> combiner;
    public final AtomicReference<b> s = new AtomicReference<>();
    public final AtomicReference<b> other = new AtomicReference<>();

    public ObservableWithLatestFrom$WithLatestFromObserver(o<? super R> oVar, c<? super T, ? super U, ? extends R> cVar) {
        this.actual = oVar;
        this.combiner = cVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this.s);
        DisposableHelper.dispose(this.other);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.s.get());
    }

    @Override // f.a.o
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.other);
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        U u = get();
        if (u != null) {
            try {
                R apply = this.combiner.apply(t, u);
                a.b(apply, "The combiner returned a null value");
                this.actual.onNext(apply);
            } catch (Throwable th) {
                f.a.u.a.a(th);
                dispose();
                this.actual.onError(th);
            }
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.s, bVar);
    }

    public void otherError(Throwable th) {
        DisposableHelper.dispose(this.s);
        this.actual.onError(th);
    }

    public boolean setOther(b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
