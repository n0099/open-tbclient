package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.j;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4375739915521278546L;
    public final i<? super R> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69200d;
    public final h<? super T, ? extends j<? extends R>> mapper;

    /* loaded from: classes7.dex */
    public final class a implements i<R> {
        public a() {
        }

        @Override // f.b.i
        public void onComplete() {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onComplete();
        }

        @Override // f.b.i
        public void onError(Throwable th) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onError(th);
        }

        @Override // f.b.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(MaybeFlatten$FlatMapMaybeObserver.this, bVar);
        }

        @Override // f.b.i
        public void onSuccess(R r) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onSuccess(r);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(i<? super R> iVar, h<? super T, ? extends j<? extends R>> hVar) {
        this.actual = iVar;
        this.mapper = hVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.f69200d.dispose();
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
        if (DisposableHelper.validate(this.f69200d, bVar)) {
            this.f69200d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            if (isDisposed()) {
                return;
            }
            jVar.a(new a());
        } catch (Exception e2) {
            f.b.u.a.a(e2);
            this.actual.onError(e2);
        }
    }
}
