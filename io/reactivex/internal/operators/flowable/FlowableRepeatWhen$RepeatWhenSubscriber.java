package io.reactivex.internal.operators.flowable;

import f.b.b0.a;
import g.d.c;
import g.d.d;
/* loaded from: classes7.dex */
public final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(c<? super T> cVar, a<Object> aVar, d dVar) {
        super(cVar, aVar, dVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, g.d.c
    public void onComplete() {
        again(0);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, g.d.c
    public void onError(Throwable th) {
        this.receiver.cancel();
        ((FlowableRepeatWhen$WhenSourceSubscriber) this).actual.onError(th);
    }
}
