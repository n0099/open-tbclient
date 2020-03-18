package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableRepeatWhen<T> extends a<T, T> {
    final h<? super io.reactivex.g<Object>, ? extends org.a.b<?>> nza;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        io.reactivex.processors.a<T> dKk = UnicastProcessor.NI(8).dKk();
        try {
            org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.h(this.nza.apply(dKk), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.nyr);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(bVar, dKk, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            cVar.onSubscribe(repeatWhenSubscriber);
            bVar2.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.H(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class WhenReceiver<T, U> extends AtomicInteger implements j<Object>, org.a.d {
        private static final long serialVersionUID = 2827772011130406689L;
        final org.a.b<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<org.a.d> subscription = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenReceiver(org.a.b<T> bVar) {
            this.source = bVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.subscription, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled(this.subscription.get())) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.actual.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.subscription, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.subscription);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements j<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final org.a.c<? super T> actual;
        protected final io.reactivex.processors.a<U> processor;
        private long produced;
        protected final org.a.d receiver;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WhenSourceSubscriber(org.a.c<? super T> cVar, io.reactivex.processors.a<U> aVar, org.a.d dVar) {
            this.actual = cVar;
            this.processor = aVar;
            this.receiver = dVar;
        }

        @Override // io.reactivex.j, org.a.c
        public final void onSubscribe(org.a.d dVar) {
            setSubscription(dVar);
        }

        @Override // org.a.c
        public final void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void again(U u) {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }
    }

    /* loaded from: classes7.dex */
    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(org.a.c<? super T> cVar, io.reactivex.processors.a<Object> aVar, org.a.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.receiver.cancel();
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            again(0);
        }
    }
}
