package io.reactivex.internal.observers;

import io.reactivex.b.g;
import io.reactivex.b.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final j<? super T> onNext;

    public ForEachWhileObserver(j<? super T> jVar, g<? super Throwable> gVar, io.reactivex.b.a aVar) {
        this.onNext = jVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.J(th2);
            io.reactivex.d.a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.d.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }
}
