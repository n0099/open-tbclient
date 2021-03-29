package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.j;
import f.a.t.b;
import f.a.w.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 2026620218879969836L;
    public final i<? super T> actual;
    public final boolean allowFatal;
    public final h<? super Throwable, ? extends j<? extends T>> resumeFunction;

    /* loaded from: classes7.dex */
    public static final class a<T> implements i<T> {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f68049e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<b> f68050f;

        public a(i<? super T> iVar, AtomicReference<b> atomicReference) {
            this.f68049e = iVar;
            this.f68050f = atomicReference;
        }

        @Override // f.a.i
        public void onComplete() {
            this.f68049e.onComplete();
        }

        @Override // f.a.i
        public void onError(Throwable th) {
            this.f68049e.onError(th);
        }

        @Override // f.a.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f68050f, bVar);
        }

        @Override // f.a.i
        public void onSuccess(T t) {
            this.f68049e.onSuccess(t);
        }
    }

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(i<? super T> iVar, h<? super Throwable, ? extends j<? extends T>> hVar, boolean z) {
        this.actual = iVar;
        this.resumeFunction = hVar;
        this.allowFatal = z;
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
        if (!this.allowFatal && !(th instanceof Exception)) {
            this.actual.onError(th);
            return;
        }
        try {
            j<? extends T> apply = this.resumeFunction.apply(th);
            f.a.x.b.a.b(apply, "The resumeFunction returned a null MaybeSource");
            j<? extends T> jVar = apply;
            DisposableHelper.replace(this, null);
            jVar.a(new a(this.actual, this));
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
