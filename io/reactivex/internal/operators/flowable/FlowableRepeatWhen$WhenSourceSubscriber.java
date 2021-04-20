package io.reactivex.internal.operators.flowable;

import f.b.b0.a;
import f.b.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
/* loaded from: classes7.dex */
public abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements g<T> {
    public static final long serialVersionUID = -5604623027276966720L;
    public final c<? super T> actual;
    public final a<U> processor;
    public long produced;
    public final d receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(c<? super T> cVar, a<U> aVar, d dVar) {
        this.actual = cVar;
        this.processor = aVar;
        this.receiver = dVar;
    }

    public final void again(U u) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.receiver.request(1L);
        this.processor.onNext(u);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, g.d.d
    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable th);

    @Override // g.d.c
    public final void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }

    @Override // f.b.g, g.d.c
    public final void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
