package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.x.i.e;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -4945480365982832967L;
    public final c<? super T> actual;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> s = new AtomicReference<>();
    public final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes7.dex */
    public final class OtherSubscriber extends AtomicReference<d> implements g<Object> {
        public static final long serialVersionUID = -3592821756711087922L;

        public OtherSubscriber() {
        }

        @Override // g.d.c
        public void onComplete() {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.s);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            e.b(flowableTakeUntil$TakeUntilMainSubscriber.actual, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.s);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            e.d(flowableTakeUntil$TakeUntilMainSubscriber.actual, th, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        @Override // g.d.c
        public void onNext(Object obj) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        @Override // f.a.g, g.d.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableTakeUntil$TakeUntilMainSubscriber(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.s);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // g.d.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        e.b(this.actual, this, this.error);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        e.d(this.actual, th, this, this.error);
    }

    @Override // g.d.c
    public void onNext(T t) {
        e.f(this.actual, t, this, this.error);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }
}
