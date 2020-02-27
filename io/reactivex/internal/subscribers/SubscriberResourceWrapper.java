package io.reactivex.internal.subscribers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes7.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, j<T>, d {
    private static final long serialVersionUID = -8612022020200669122L;
    final org.a.c<? super T> actual;
    final AtomicReference<d> subscription = new AtomicReference<>();

    public SubscriberResourceWrapper(org.a.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.subscription, dVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.actual.onError(th);
    }

    @Override // org.a.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // org.a.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.subscription.get().request(j);
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.subscription.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.a.d
    public void cancel() {
        dispose();
    }

    public void setResource(io.reactivex.disposables.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
