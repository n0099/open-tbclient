package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.x.c.a;
import f.b.x.i.e;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements a<T>, d {
    public static final long serialVersionUID = -6270983465606289181L;
    public final c<? super T> actual;
    public volatile boolean gate;
    public final AtomicReference<d> s = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes7.dex */
    public final class OtherSubscriber extends AtomicReference<d> implements g<Object> {
        public static final long serialVersionUID = -5592042965931999169L;

        public OtherSubscriber() {
        }

        @Override // g.d.c
        public void onComplete() {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(FlowableSkipUntil$SkipUntilMainSubscriber.this.s);
            FlowableSkipUntil$SkipUntilMainSubscriber flowableSkipUntil$SkipUntilMainSubscriber = FlowableSkipUntil$SkipUntilMainSubscriber.this;
            e.d(flowableSkipUntil$SkipUntilMainSubscriber.actual, th, flowableSkipUntil$SkipUntilMainSubscriber, flowableSkipUntil$SkipUntilMainSubscriber.error);
        }

        @Override // g.d.c
        public void onNext(Object obj) {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
            get().cancel();
        }

        @Override // f.b.g, g.d.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSkipUntil$SkipUntilMainSubscriber(c<? super T> cVar) {
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
        if (tryOnNext(t)) {
            return;
        }
        this.s.get().request(1L);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }

    @Override // f.b.x.c.a
    public boolean tryOnNext(T t) {
        if (this.gate) {
            e.f(this.actual, t, this, this.error);
            return true;
        }
        return false;
    }
}
