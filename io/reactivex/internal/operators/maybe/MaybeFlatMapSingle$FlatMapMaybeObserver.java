package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.r;
import f.a.s;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapSingle$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4827726964688405508L;
    public final r<? super R> actual;
    public final h<? super T, ? extends s<? extends R>> mapper;

    public MaybeFlatMapSingle$FlatMapMaybeObserver(r<? super R> rVar, h<? super T, ? extends s<? extends R>> hVar) {
        this.actual = rVar;
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
        this.actual.onError(new NoSuchElementException());
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
            s<? extends R> sVar = apply;
            if (isDisposed()) {
                return;
            }
            sVar.a(new f.a.x.e.b.b(this, this.actual));
        } catch (Throwable th) {
            f.a.u.a.a(th);
            onError(th);
        }
    }
}
