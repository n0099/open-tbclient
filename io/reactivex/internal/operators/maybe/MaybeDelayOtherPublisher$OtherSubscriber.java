package io.reactivex.internal.operators.maybe;

import f.b.g;
import f.b.i;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<d> implements g<Object> {
    public static final long serialVersionUID = -1215060610805418006L;
    public final i<? super T> actual;
    public Throwable error;
    public T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // g.d.c
    public void onComplete() {
        Throwable th = this.error;
        if (th != null) {
            this.actual.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.actual.onSuccess(t);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        Throwable th2 = this.error;
        if (th2 == null) {
            this.actual.onError(th);
        } else {
            this.actual.onError(new CompositeException(th2, th));
        }
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            dVar.cancel();
            onComplete();
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
