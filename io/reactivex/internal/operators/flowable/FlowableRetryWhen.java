package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableRetryWhen<T> extends a<T, T> {
    final h<? super g<Throwable>, ? extends org.a.b<?>> qez;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        io.reactivex.processors.a<T> eIs = UnicastProcessor.RV(8).eIs();
        try {
            org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.m(this.qez.apply(eIs), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.qdS);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(bVar, eIs, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            cVar.onSubscribe(retryWhenSubscriber);
            bVar2.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes5.dex */
    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(org.a.c<? super T> cVar, io.reactivex.processors.a<Throwable> aVar, d dVar) {
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
