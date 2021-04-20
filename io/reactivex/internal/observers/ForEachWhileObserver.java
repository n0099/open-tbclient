package io.reactivex.internal.observers;

import f.b.o;
import f.b.t.b;
import f.b.w.a;
import f.b.w.g;
import f.b.w.i;
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

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.b.u.a.a(th);
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            f.b.a0.a.f(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            f.b.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.b.o
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
            f.b.u.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
