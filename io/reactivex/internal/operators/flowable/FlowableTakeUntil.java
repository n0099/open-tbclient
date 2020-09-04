package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTakeUntil<T, U> extends a<T, T> {
    final org.b.b<? extends U> onu;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(cVar);
        cVar.onSubscribe(takeUntilMainSubscriber);
        this.onu.subscribe(takeUntilMainSubscriber.other);
        this.omT.a((j) takeUntilMainSubscriber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements j<T>, org.b.d {
        private static final long serialVersionUID = -4945480365982832967L;
        final org.b.c<? super T> actual;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<org.b.d> s = new AtomicReference<>();
        final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicThrowable error = new AtomicThrowable();

        TakeUntilMainSubscriber(org.b.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.b.c
        public void onNext(T t) {
            io.reactivex.internal.util.e.a(this.actual, t, this, this.error);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.e.a((org.b.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // org.b.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.e.a(this.actual, this, this.error);
        }

        @Override // org.b.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.s, this.requested, j);
        }

        @Override // org.b.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            SubscriptionHelper.cancel(this.other);
        }

        /* loaded from: classes7.dex */
        final class OtherSubscriber extends AtomicReference<org.b.d> implements j<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.j, org.b.c
            public void onSubscribe(org.b.d dVar) {
                if (SubscriptionHelper.setOnce(this, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                }
            }

            @Override // org.b.c
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // org.b.c
            public void onError(Throwable th) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.s);
                io.reactivex.internal.util.e.a((org.b.c<?>) TakeUntilMainSubscriber.this.actual, th, (AtomicInteger) TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }

            @Override // org.b.c
            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.s);
                io.reactivex.internal.util.e.a(TakeUntilMainSubscriber.this.actual, TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }
        }
    }
}
