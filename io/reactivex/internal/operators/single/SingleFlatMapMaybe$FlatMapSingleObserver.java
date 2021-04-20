package io.reactivex.internal.operators.single;

import f.b.i;
import f.b.j;
import f.b.r;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
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

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            if (isDisposed()) {
                return;
            }
            jVar.a(new f.b.x.e.d.a(this, this.actual));
        } catch (Throwable th) {
            f.b.u.a.a(th);
            onError(th);
        }
    }
}
