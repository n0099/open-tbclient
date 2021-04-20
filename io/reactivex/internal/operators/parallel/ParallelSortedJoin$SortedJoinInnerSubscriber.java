package io.reactivex.internal.operators.parallel;

import f.b.g;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<d> implements g<List<T>> {
    public static final long serialVersionUID = 6751017204873808094L;
    public final int index;
    public final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> parallelSortedJoin$SortedJoinSubscription, int i) {
        this.parent = parallelSortedJoin$SortedJoinSubscription;
        this.index = i;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // g.d.c
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext((List) ((List) obj));
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void onNext(List<T> list) {
        this.parent.innerNext(list, this.index);
    }
}
