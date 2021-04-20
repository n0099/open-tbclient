package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.s;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import f.b.x.d.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = -5314538511045349925L;
    public final r<? super T> actual;
    public final h<? super Throwable, ? extends s<? extends T>> nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(r<? super T> rVar, h<? super Throwable, ? extends s<? extends T>> hVar) {
        this.actual = rVar;
        this.nextFunction = hVar;
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
        try {
            s<? extends T> apply = this.nextFunction.apply(th);
            a.b(apply, "The nextFunction returned a null SingleSource.");
            apply.a(new c(this, this.actual));
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
