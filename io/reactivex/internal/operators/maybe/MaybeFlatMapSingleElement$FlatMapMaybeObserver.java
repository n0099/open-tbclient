package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.s;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import f.a.x.e.b.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapSingleElement$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4827726964688405508L;
    public final i<? super R> actual;
    public final h<? super T, ? extends s<? extends R>> mapper;

    public MaybeFlatMapSingleElement$FlatMapMaybeObserver(i<? super R> iVar, h<? super T, ? extends s<? extends R>> hVar) {
        this.actual = iVar;
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
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        try {
            s<? extends R> apply = this.mapper.apply(t);
            a.b(apply, "The mapper returned a null SingleSource");
            apply.a(new c(this, this.actual));
        } catch (Throwable th) {
            f.a.u.a.a(th);
            onError(th);
        }
    }
}
