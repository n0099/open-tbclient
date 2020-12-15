package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableTakeUntil<T, U> extends a<T, T> {
    final org.a.b<? extends U> pFC;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(cVar);
        cVar.onSubscribe(takeUntilMainSubscriber);
        this.pFC.subscribe(takeUntilMainSubscriber.other);
        this.pFi.a((j) takeUntilMainSubscriber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements j<T>, d {
        private static final long serialVersionUID = -4945480365982832967L;
        final org.a.c<? super T> actual;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<d> s = new AtomicReference<>();
        final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicThrowable error = new AtomicThrowable();

        TakeUntilMainSubscriber(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            e.a(this.actual, t, this, this.error);
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

        /* loaded from: classes9.dex */
        final class OtherSubscriber extends AtomicReference<d> implements j<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

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
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // org.a.c
            public void onError(Throwable th) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.s);
                e.a((org.a.c<?>) TakeUntilMainSubscriber.this.actual, th, (AtomicInteger) TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }

            @Override // org.a.c
            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.s);
                e.a(TakeUntilMainSubscriber.this.actual, TakeUntilMainSubscriber.this, TakeUntilMainSubscriber.this.error);
            }
        }
    }
}
