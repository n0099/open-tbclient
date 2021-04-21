package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.j;
import f.b.t.b;
import f.b.w.h;
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
        public final i<? super T> f69202e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<b> f69203f;

        public a(i<? super T> iVar, AtomicReference<b> atomicReference) {
            this.f69202e = iVar;
            this.f69203f = atomicReference;
        }

        @Override // f.b.i
        public void onComplete() {
            this.f69202e.onComplete();
        }

        @Override // f.b.i
        public void onError(Throwable th) {
            this.f69202e.onError(th);
        }

        @Override // f.b.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f69203f, bVar);
        }

        @Override // f.b.i
        public void onSuccess(T t) {
            this.f69202e.onSuccess(t);
        }
    }

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(i<? super T> iVar, h<? super Throwable, ? extends j<? extends T>> hVar, boolean z) {
        this.actual = iVar;
        this.resumeFunction = hVar;
        this.allowFatal = z;
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
        if (!this.allowFatal && !(th instanceof Exception)) {
            this.actual.onError(th);
            return;
        }
        try {
            j<? extends T> apply = this.resumeFunction.apply(th);
            f.b.x.b.a.b(apply, "The resumeFunction returned a null MaybeSource");
            j<? extends T> jVar = apply;
            DisposableHelper.replace(this, null);
            jVar.a(new a(this.actual, this));
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
