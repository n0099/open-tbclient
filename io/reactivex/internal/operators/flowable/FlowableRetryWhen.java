package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
/* loaded from: classes7.dex */
public final class FlowableRetryWhen<T> extends a<T, T> {
    final h<? super io.reactivex.g<Throwable>, ? extends org.a.b<?>> mSB;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        io.reactivex.processors.a<T> dDf = UnicastProcessor.Jc(8).dDf();
        try {
            org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.h(this.mSB.apply(dDf), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.mRM);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(bVar, dDf, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            cVar.onSubscribe(retryWhenSubscriber);
            bVar2.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(org.a.c<? super T> cVar, io.reactivex.processors.a<Throwable> aVar, org.a.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            again(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.receiver.cancel();
            this.actual.onComplete();
        }
    }
}
