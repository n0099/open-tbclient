package io.reactivex.internal.operators.single;

import f.a.i;
import f.a.j;
import f.a.r;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = -5843758257109742742L;
    public final i<? super R> actual;
    public final h<? super T, ? extends j<? extends R>> mapper;

    public SingleFlatMapMaybe$FlatMapSingleObserver(i<? super R> iVar, h<? super T, ? extends j<? extends R>> hVar) {
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

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            if (isDisposed()) {
                return;
            }
            jVar.a(new f.a.x.e.d.a(this, this.actual));
        } catch (Throwable th) {
            f.a.u.a.a(th);
            onError(th);
        }
    }
}
