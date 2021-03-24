package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.w.a;
import f.a.x.c.d;
import g.d.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableDoFinally$DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements g<T> {
    public static final long serialVersionUID = 4109457741734051389L;
    public final c<? super T> actual;
    public final a onFinally;
    public d<T> qs;
    public g.d.d s;
    public boolean syncFused;

    public FlowableDoFinally$DoFinallySubscriber(c<? super T> cVar, a aVar) {
        this.actual = cVar;
        this.onFinally = aVar;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        this.s.cancel();
        runFinally();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // g.d.c
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof d) {
                this.qs = (d) dVar;
            }
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() throws Exception {
        T poll = this.qs.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        this.s.request(j);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public int requestFusion(int i) {
        d<T> dVar = this.qs;
        if (dVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i);
        if (requestFusion != 0) {
            this.syncFused = requestFusion == 1;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }
}
