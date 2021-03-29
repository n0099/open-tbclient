package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.j;
import f.a.t.b;
import f.a.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4375739915521278546L;
    public final i<? super R> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68047d;
    public final h<? super T, ? extends j<? extends R>> mapper;

    /* loaded from: classes7.dex */
    public final class a implements i<R> {
        public a() {
        }

        @Override // f.a.i
        public void onComplete() {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onComplete();
        }

        @Override // f.a.i
        public void onError(Throwable th) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onError(th);
        }

        @Override // f.a.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(MaybeFlatten$FlatMapMaybeObserver.this, bVar);
        }

        @Override // f.a.i
        public void onSuccess(R r) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onSuccess(r);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(i<? super R> iVar, h<? super T, ? extends j<? extends R>> hVar) {
        this.actual = iVar;
        this.mapper = hVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.f68047d.dispose();
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
        if (DisposableHelper.validate(this.f68047d, bVar)) {
            this.f68047d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            if (isDisposed()) {
                return;
            }
            jVar.a(new a());
        } catch (Exception e2) {
            f.a.u.a.a(e2);
            this.actual.onError(e2);
        }
    }
}
