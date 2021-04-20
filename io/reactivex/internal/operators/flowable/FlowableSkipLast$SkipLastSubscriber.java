package io.reactivex.internal.operators.flowable;

import f.b.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements g<T>, d {
    public static final long serialVersionUID = -3807491841935125653L;
    public final c<? super T> actual;
    public d s;
    public final int skip;

    public FlowableSkipLast$SkipLastSubscriber(c<? super T> cVar, int i) {
        super(i);
        this.actual = cVar;
        this.skip = i;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: T, ? super T */
    @Override // g.d.c
    public void onNext(T t) {
        if (this.skip == size()) {
            this.actual.onNext((T) poll());
        } else {
            this.s.request(1L);
        }
        offer(t);
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
