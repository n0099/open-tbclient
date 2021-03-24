package io.reactivex.internal.operators.completable;

import f.a.b;
import f.a.t.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements b {
    public static final long serialVersionUID = -7730517613164279224L;
    public final b actual;
    public final a set;
    public final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(b bVar, a aVar, AtomicInteger atomicInteger) {
        this.actual = bVar;
        this.set = aVar;
        this.wip = atomicInteger;
    }

    @Override // f.a.b
    public void onComplete() {
        if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
            this.actual.onComplete();
        }
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.set.dispose();
        if (compareAndSet(false, true)) {
            this.actual.onError(th);
        } else {
            f.a.a0.a.f(th);
        }
    }

    @Override // f.a.b
    public void onSubscribe(f.a.t.b bVar) {
        this.set.b(bVar);
    }
}
