package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.j;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4375739915521278546L;
    public final i<? super R> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69198d;
    public final Callable<? extends j<? extends R>> onCompleteSupplier;
    public final h<? super Throwable, ? extends j<? extends R>> onErrorMapper;
    public final h<? super T, ? extends j<? extends R>> onSuccessMapper;

    /* loaded from: classes7.dex */
    public final class a implements i<R> {
        public a() {
        }

        @Override // f.b.i
        public void onComplete() {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onComplete();
        }

        @Override // f.b.i
        public void onError(Throwable th) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onError(th);
        }

        @Override // f.b.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(MaybeFlatMapNotification$FlatMapMaybeObserver.this, bVar);
        }

        @Override // f.b.i
        public void onSuccess(R r) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onSuccess(r);
        }
    }

    public MaybeFlatMapNotification$FlatMapMaybeObserver(i<? super R> iVar, h<? super T, ? extends j<? extends R>> hVar, h<? super Throwable, ? extends j<? extends R>> hVar2, Callable<? extends j<? extends R>> callable) {
        this.actual = iVar;
        this.onSuccessMapper = hVar;
        this.onErrorMapper = hVar2;
        this.onCompleteSupplier = callable;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.f69198d.dispose();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.i
    public void onComplete() {
        try {
            j<? extends R> call = this.onCompleteSupplier.call();
            f.b.x.b.a.b(call, "The onCompleteSupplier returned a null MaybeSource");
            call.a(new a());
        } catch (Exception e2) {
            f.b.u.a.a(e2);
            this.actual.onError(e2);
        }
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        try {
            j<? extends R> apply = this.onErrorMapper.apply(th);
            f.b.x.b.a.b(apply, "The onErrorMapper returned a null MaybeSource");
            apply.a(new a());
        } catch (Exception e2) {
            f.b.u.a.a(e2);
            this.actual.onError(new CompositeException(th, e2));
        }
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69198d, bVar)) {
            this.f69198d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        try {
            j<? extends R> apply = this.onSuccessMapper.apply(t);
            f.b.x.b.a.b(apply, "The onSuccessMapper returned a null MaybeSource");
            apply.a(new a());
        } catch (Exception e2) {
            f.b.u.a.a(e2);
            this.actual.onError(e2);
        }
    }
}
