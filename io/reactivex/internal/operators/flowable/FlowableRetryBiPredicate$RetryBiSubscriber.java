package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.u.a;
import f.b.w.d;
import g.d.b;
import g.d.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements g<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> actual;
    public final d<? super Integer, ? super Throwable> predicate;
    public long produced;
    public int retries;
    public final SubscriptionArbiter sa;
    public final b<? extends T> source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(c<? super T> cVar, d<? super Integer, ? super Throwable> dVar, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.actual = cVar;
        this.sa = subscriptionArbiter;
        this.source = bVar;
        this.predicate = dVar;
    }

    @Override // g.d.c
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        try {
            d<? super Integer, ? super Throwable> dVar = this.predicate;
            int i = this.retries + 1;
            this.retries = i;
            if (!dVar.a(Integer.valueOf(i), th)) {
                this.actual.onError(th);
            } else {
                subscribeNext();
            }
        } catch (Throwable th2) {
            a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        this.sa.setSubscription(dVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.sa.isCancelled()) {
                long j = this.produced;
                if (j != 0) {
                    this.produced = 0L;
                    this.sa.produced(j);
                }
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
