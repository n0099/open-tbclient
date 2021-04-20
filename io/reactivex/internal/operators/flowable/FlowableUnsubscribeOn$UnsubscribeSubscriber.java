package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.p;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements g<T>, d {
    public static final long serialVersionUID = 1015244841293359600L;
    public final c<? super T> actual;
    public d s;
    public final p scheduler;

    /* loaded from: classes7.dex */
    public final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableUnsubscribeOn$UnsubscribeSubscriber.this.s.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(c<? super T> cVar, p pVar) {
        this.actual = cVar;
        this.scheduler = pVar;
    }

    @Override // g.d.d
    public void cancel() {
        if (compareAndSet(false, true)) {
            this.scheduler.c(new a());
        }
    }

    @Override // g.d.c
    public void onComplete() {
        if (get()) {
            return;
        }
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (get()) {
            f.b.a0.a.f(th);
        } else {
            this.actual.onError(th);
        }
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (get()) {
            return;
        }
        this.actual.onNext(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        this.s.request(j);
    }
}
