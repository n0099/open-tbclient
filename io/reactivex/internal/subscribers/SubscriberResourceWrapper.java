package io.reactivex.internal.subscribers;

import f.a.g;
import f.a.t.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<b> implements g<T>, b, d {
    public static final long serialVersionUID = -8612022020200669122L;
    public final c<? super T> actual;
    public final AtomicReference<d> subscription = new AtomicReference<>();

    public SubscriberResourceWrapper(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        dispose();
    }

    @Override // f.a.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.subscription.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.subscription, dVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.subscription.get().request(j);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
