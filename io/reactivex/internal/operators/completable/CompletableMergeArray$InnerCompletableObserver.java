package io.reactivex.internal.operators.completable;

import f.b.b;
import f.b.t.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements b {
    public static final long serialVersionUID = -8360547806504310570L;
    public final b actual;
    public final AtomicBoolean once;
    public final a set;

    public CompletableMergeArray$InnerCompletableObserver(b bVar, AtomicBoolean atomicBoolean, a aVar, int i) {
        this.actual = bVar;
        this.once = atomicBoolean;
        this.set = aVar;
        lazySet(i);
    }

    @Override // f.b.b
    public void onComplete() {
        if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
            this.actual.onComplete();
        }
    }

    @Override // f.b.b
    public void onError(Throwable th) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true)) {
            this.actual.onError(th);
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.b
    public void onSubscribe(f.b.t.b bVar) {
        this.set.b(bVar);
    }
}
