package io.reactivex.internal.operators.parallel;

import f.b.a0.a;
import f.b.g;
import f.b.w.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements g<T> {
    public static final long serialVersionUID = -7954444275102466525L;
    public boolean done;
    public final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    public final c<T, T, T> reducer;
    public T value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parallelReduceFull$ParallelReduceFullMainSubscriber, c<T, T, T> cVar) {
        this.parent = parallelReduceFull$ParallelReduceFullMainSubscriber;
        this.reducer = cVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.parent.innerComplete(this.value);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.parent.innerError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        T t2 = this.value;
        if (t2 == null) {
            this.value = t;
            return;
        }
        try {
            T apply = this.reducer.apply(t2, t);
            f.b.x.b.a.b(apply, "The reducer returned a null value");
            this.value = apply;
        } catch (Throwable th) {
            f.b.u.a.a(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
