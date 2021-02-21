package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableUnsubscribeOn<T> extends a<T, T> {
    final v scheduler;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qow.a((j) new UnsubscribeSubscriber(cVar, this.scheduler));
    }

    /* loaded from: classes5.dex */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements j<T>, d {
        private static final long serialVersionUID = 1015244841293359600L;
        final org.a.c<? super T> actual;
        d s;
        final v scheduler;

        UnsubscribeSubscriber(org.a.c<? super T> cVar, v vVar) {
            this.actual = cVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.d.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.D(new a());
            }
        }

        /* loaded from: classes5.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.s.cancel();
            }
        }
    }
}
