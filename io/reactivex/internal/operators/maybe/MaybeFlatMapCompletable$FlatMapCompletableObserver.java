package io.reactivex.internal.operators.maybe;

import f.b.c;
import f.b.i;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<b> implements i<T>, f.b.b, b {
    public static final long serialVersionUID = -2177128922851101253L;
    public final f.b.b actual;
    public final h<? super T, ? extends c> mapper;

    public MaybeFlatMapCompletable$FlatMapCompletableObserver(f.b.b bVar, h<? super T, ? extends c> hVar) {
        this.actual = bVar;
        this.mapper = hVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.i
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this, bVar);
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        try {
            c apply = this.mapper.apply(t);
            a.b(apply, "The mapper returned a null CompletableSource");
            c cVar = apply;
            if (isDisposed()) {
                return;
            }
            cVar.a(this);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            onError(th);
        }
    }
}
