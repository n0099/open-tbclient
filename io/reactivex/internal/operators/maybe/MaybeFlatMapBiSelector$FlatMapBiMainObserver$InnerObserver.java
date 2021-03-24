package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import f.a.w.c;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<b> implements i<U> {
    public static final long serialVersionUID = -2897979525538174559L;
    public final i<? super R> actual;
    public final c<? super T, ? super U, ? extends R> resultSelector;
    public T value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(i<? super R> iVar, c<? super T, ? super U, ? extends R> cVar) {
        this.actual = iVar;
        this.resultSelector = cVar;
    }

    @Override // f.a.i
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(U u) {
        T t = this.value;
        this.value = null;
        try {
            R apply = this.resultSelector.apply(t, u);
            a.b(apply, "The resultSelector returned a null value");
            this.actual.onSuccess(apply);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.actual.onError(th);
        }
    }
}
