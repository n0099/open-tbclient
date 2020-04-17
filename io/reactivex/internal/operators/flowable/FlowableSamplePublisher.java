package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSamplePublisher<T> extends io.reactivex.g<T> {
    final boolean mSB;
    final org.a.b<?> mSk;
    final org.a.b<T> source;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        if (this.mSB) {
            this.source.subscribe(new SampleMainEmitLast(bVar, this.mSk));
        } else {
            this.source.subscribe(new SampleMainNoLast(bVar, this.mSk));
        }
    }

    /* loaded from: classes7.dex */
    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements j<T>, org.a.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.a.c<? super T> actual;
        org.a.d s;
        final org.a.b<?> sampler;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<org.a.d> other = new AtomicReference<>();

        abstract void completeMain();

        abstract void completeOther();

        abstract void run();

        SamplePublisherSubscriber(org.a.c<? super T> cVar, org.a.b<?> bVar) {
            this.actual = cVar;
            this.sampler = bVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new a(this));
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            completeMain();
        }

        boolean setOther(org.a.d dVar) {
            return SubscriptionHelper.setOnce(this.other, dVar);
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
            }
        }

        @Override // org.a.d
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
        final SamplePublisherSubscriber<T> mSD;

        a(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.mSD = samplePublisherSubscriber;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (this.mSD.setOther(dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            this.mSD.run();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.mSD.error(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.mSD.complete();
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(org.a.c<? super T> cVar, org.a.b<?> bVar) {
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

        SampleMainEmitLast(org.a.c<? super T> cVar, org.a.b<?> bVar) {
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
