package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableUnsubscribeOn<T> extends a<T, T> {
    final v scheduler;

    public FlowableUnsubscribeOn(io.reactivex.g<T> gVar, v vVar) {
        super(gVar);
        this.scheduler = vVar;
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nJT.a((j) new UnsubscribeSubscriber(cVar, this.scheduler));
    }

    /* loaded from: classes7.dex */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = 1015244841293359600L;
        final org.a.c<? super T> actual;
        org.a.d s;
        final v scheduler;

        UnsubscribeSubscriber(org.a.c<? super T> cVar, v vVar) {
            this.actual = cVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
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
                io.reactivex.e.a.onError(th);
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
                this.scheduler.J(new a());
            }
        }

        /* loaded from: classes7.dex */
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
