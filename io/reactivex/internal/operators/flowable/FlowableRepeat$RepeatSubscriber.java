package io.reactivex.internal.operators.flowable;

import f.a.g;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableRepeat$RepeatSubscriber<T> extends AtomicInteger implements g<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final c<? super T> actual;
    public long produced;
    public long remaining;
    public final SubscriptionArbiter sa;
    public final b<? extends T> source;

    public FlowableRepeat$RepeatSubscriber(c<? super T> cVar, long j, SubscriptionArbiter subscriptionArbiter, b<? extends T> bVar) {
        this.actual = cVar;
        this.sa = subscriptionArbiter;
        this.source = bVar;
        this.remaining = j;
    }

    @Override // g.d.c
    public void onComplete() {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j != 0) {
            subscribeNext();
        } else {
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
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
