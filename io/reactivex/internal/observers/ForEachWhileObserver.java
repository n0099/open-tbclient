package io.reactivex.internal.observers;

import f.a.o;
import f.a.t.b;
import f.a.w.a;
import f.a.w.g;
import f.a.w.i;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final i<? super T> onNext;

    public ForEachWhileObserver(i<? super T> iVar, g<? super Throwable> gVar, a aVar) {
        this.onNext = iVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
        }
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.done) {
            f.a.a0.a.f(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            f.a.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
