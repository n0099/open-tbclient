package io.reactivex.internal.operators.flowable;

import f.b.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
/* loaded from: classes7.dex */
public final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements g<T>, d {
    public static final long serialVersionUID = -8134157938864266736L;
    public d s;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: U extends java.util.Collection<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowableToList$ToListSubscriber(c<? super U> cVar, U u) {
        super(cVar);
        this.value = u;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        complete(this.value);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        Collection collection = (Collection) this.value;
        if (collection != null) {
            collection.add(t);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
