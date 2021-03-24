package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.u.a;
import f.a.w.i;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements g<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> actual;
    public final i<? super Throwable> predicate;
    public long produced;
    public long remaining;
    public final SubscriptionArbiter sa;
    public final b<? extends T> source;

    public FlowableRetryPredicate$RetrySubscriber(c<? super T> cVar, long j, i<? super Throwable> iVar, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.actual = cVar;
        this.sa = subscriptionArbiter;
        this.source = bVar;
        this.predicate = iVar;
        this.remaining = j;
    }

    @Override // g.d.c
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j == 0) {
            this.actual.onError(th);
            return;
        }
        try {
            if (!this.predicate.test(th)) {
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

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
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
