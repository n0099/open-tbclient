package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSamplePublisher<T> extends io.reactivex.g<T> {
    final org.b.b<?> onb;
    final boolean ons;
    final org.b.b<T> source;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        if (this.ons) {
            this.source.subscribe(new SampleMainEmitLast(bVar, this.onb));
        } else {
            this.source.subscribe(new SampleMainNoLast(bVar, this.onb));
        }
    }

    /* loaded from: classes7.dex */
    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements j<T>, org.b.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.b.c<? super T> actual;
        org.b.d s;
        final org.b.b<?> sampler;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<org.b.d> other = new AtomicReference<>();

        abstract void completeMain();

        abstract void completeOther();

        abstract void run();

        SamplePublisherSubscriber(org.b.c<? super T> cVar, org.b.b<?> bVar) {
            this.actual = cVar;
            this.sampler = bVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new a(this));
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            completeMain();
        }

        boolean setOther(org.b.d dVar) {
            return SubscriptionHelper.setOnce(this.other, dVar);
        }

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
            }
        }

        @Override // org.b.d
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.s.cancel();
        }

        public void error(Throwable th) {
            this.s.cancel();
            this.actual.onError(th);
        }

        public void complete() {
            this.s.cancel();
            completeOther();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    io.reactivex.internal.util.b.c(this.requested, 1L);
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements j<Object> {
        final SamplePublisherSubscriber<T> ont;

        a(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.ont = samplePublisherSubscriber;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (this.ont.setOther(dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(Object obj) {
            this.ont.run();
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.ont.error(th);
        }

        @Override // org.b.c
        public void onComplete() {
            this.ont.complete();
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(org.b.c<? super T> cVar, org.b.b<?> bVar) {
            super(cVar, bVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            emit();
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(org.b.c<? super T> cVar, org.b.b<?> bVar) {
            super(cVar, bVar);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }
}
