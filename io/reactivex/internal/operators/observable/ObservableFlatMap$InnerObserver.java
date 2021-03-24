package io.reactivex.internal.operators.observable;

import f.a.a0.a;
import f.a.o;
import f.a.t.b;
import f.a.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<b> implements o<U> {
    public static final long serialVersionUID = -4606175640614850599L;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final ObservableFlatMap$MergeObserver<T, U> parent;
    public volatile f<U> queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver, long j) {
        this.id = j;
        this.parent = observableFlatMap$MergeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.o
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.parent.errors.addThrowable(th)) {
            ObservableFlatMap$MergeObserver<T, U> observableFlatMap$MergeObserver = this.parent;
            if (!observableFlatMap$MergeObserver.delayErrors) {
                observableFlatMap$MergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
            return;
        }
        a.f(th);
    }

    @Override // f.a.o
    public void onNext(U u) {
        if (this.fusionMode == 0) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof f.a.x.c.b)) {
            f.a.x.c.b bVar2 = (f.a.x.c.b) bVar;
            int requestFusion = bVar2.requestFusion(7);
            if (requestFusion == 1) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
                this.done = true;
                this.parent.drain();
            } else if (requestFusion == 2) {
                this.fusionMode = requestFusion;
                this.queue = bVar2;
            }
        }
    }
}
