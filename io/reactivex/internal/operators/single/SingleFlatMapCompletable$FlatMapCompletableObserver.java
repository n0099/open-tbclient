package io.reactivex.internal.operators.single;

import f.a.c;
import f.a.r;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<b> implements r<T>, f.a.b, b {
    public static final long serialVersionUID = -2177128922851101253L;
    public final f.a.b actual;
    public final h<? super T, ? extends c> mapper;

    public SingleFlatMapCompletable$FlatMapCompletableObserver(f.a.b bVar, h<? super T, ? extends c> hVar) {
        this.actual = bVar;
        this.mapper = hVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.b
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this, bVar);
    }

    @Override // f.a.r
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
            f.a.u.a.a(th);
            onError(th);
        }
    }
}
