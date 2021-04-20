package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.x.e.a.k;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements g<T>, d {
    public static final long serialVersionUID = -3517602651313910099L;
    public final c<? super T> actual;
    public d s;
    public final b<?> sampler;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> other = new AtomicReference<>();

    public FlowableSamplePublisher$SamplePublisherSubscriber(c<? super T> cVar, b<?> bVar) {
        this.actual = cVar;
        this.sampler = bVar;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.s.cancel();
    }

    public void complete() {
        this.s.cancel();
        completeOther();
    }

    public abstract void completeMain();

    public abstract void completeOther();

    public void emit() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            if (this.requested.get() != 0) {
                this.actual.onNext(andSet);
                f.b.x.i.b.e(this.requested, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    public void error(Throwable th) {
        this.s.cancel();
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completeMain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        lazySet(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            if (this.other.get() == null) {
                this.sampler.subscribe(new k(this));
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
        }
    }

    public abstract void run();

    public boolean setOther(d dVar) {
        return SubscriptionHelper.setOnce(this.other, dVar);
    }
}
