package io.reactivex.internal.operators.single;

import f.a.p;
import f.a.r;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    public static final long serialVersionUID = 3256698449646456986L;
    public final r<? super T> actual;
    public b ds;
    public final p scheduler;

    public SingleUnsubscribeOn$UnsubscribeOnSingleObserver(r<? super T> rVar, p pVar) {
        this.actual = rVar;
        this.scheduler = pVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        b andSet = getAndSet(DisposableHelper.DISPOSED);
        if (andSet != DisposableHelper.DISPOSED) {
            this.ds = andSet;
            this.scheduler.c(this);
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ds.dispose();
    }
}
