package io.reactivex.internal.operators.flowable;

import f.a.b0.a;
import g.d.c;
import g.d.d;
/* loaded from: classes7.dex */
public final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(c<? super T> cVar, a<Throwable> aVar, d dVar) {
        super(cVar, aVar, dVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, g.d.c
    public void onComplete() {
        this.receiver.cancel();
        ((FlowableRepeatWhen$WhenSourceSubscriber) this).actual.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, g.d.c
    public void onError(Throwable th) {
        again(th);
    }
}
