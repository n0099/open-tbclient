package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableSkipUntil<T, U> extends a<T, T> {
    final org.a.b<U> qel;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(cVar);
        cVar.onSubscribe(skipUntilMainSubscriber);
        this.qel.subscribe(skipUntilMainSubscriber.other);
        this.qdR.a((j) skipUntilMainSubscriber);
    }

    /* loaded from: classes5.dex */
    static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements io.reactivex.internal.a.a<T>, d {
        private static final long serialVersionUID = -6270983465606289181L;
        final org.a.c<? super T> actual;
        volatile boolean gate;
        final AtomicReference<d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicThrowable error = new AtomicThrowable();

        SkipUntilMainSubscriber(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.s.get().request(1L);
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            if (this.gate) {
                e.a(this.actual, t, this, this.error);
                return true;
            }
            return false;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            e.a(this.actual, this, this.error);
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.s, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            SubscriptionHelper.cancel(this.other);
        }

        /* loaded from: classes5.dex */
        final class OtherSubscriber extends AtomicReference<d> implements j<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(d dVar) {
                if (SubscriptionHelper.setOnce(this, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                }
            }

            @Override // org.a.c
            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.gate = true;
                get().cancel();
            }

            @Override // org.a.c
            public void onError(Throwable th) {
                SubscriptionHelper.cancel(SkipUntilMainSubscriber.this.s);
                e.a((org.a.c<?>) SkipUntilMainSubscriber.this.actual, th, (AtomicInteger) SkipUntilMainSubscriber.this, SkipUntilMainSubscriber.this.error);
            }

            @Override // org.a.c
            public void onComplete() {
                SkipUntilMainSubscriber.this.gate = true;
            }
        }
    }
}
