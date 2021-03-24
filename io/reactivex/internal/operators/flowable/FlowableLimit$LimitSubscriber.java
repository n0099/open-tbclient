package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableLimit$LimitSubscriber<T> extends AtomicLong implements g<T>, d {
    public static final long serialVersionUID = 2288246011222124525L;
    public final c<? super T> actual;
    public long remaining;
    public d upstream;

    public FlowableLimit$LimitSubscriber(c<? super T> cVar, long j) {
        this.actual = cVar;
        this.remaining = j;
        lazySet(j);
    }

    @Override // g.d.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.remaining > 0) {
            this.remaining = 0L;
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.remaining > 0) {
            this.remaining = 0L;
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        long j = this.remaining;
        if (j > 0) {
            long j2 = j - 1;
            this.remaining = j2;
            this.actual.onNext(t);
            if (j2 == 0) {
                this.upstream.cancel();
                this.actual.onComplete();
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            if (this.remaining == 0) {
                dVar.cancel();
                EmptySubscription.complete(this.actual);
                return;
            }
            this.upstream = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        long j2;
        long j3;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if (j2 == 0) {
                    return;
                }
                j3 = j2 <= j ? j2 : j;
            } while (!compareAndSet(j2, j2 - j3));
            this.upstream.request(j3);
        }
    }
}
