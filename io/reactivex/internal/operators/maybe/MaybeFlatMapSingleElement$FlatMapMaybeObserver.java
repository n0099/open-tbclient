package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.s;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import f.b.x.e.b.c;
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
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        try {
            s<? extends R> apply = this.mapper.apply(t);
            a.b(apply, "The mapper returned a null SingleSource");
            apply.a(new c(this, this.actual));
        } catch (Throwable th) {
            f.b.u.a.a(th);
            onError(th);
        }
    }
}
