package io.reactivex.internal.observers;

import f.a.o;
import f.a.t.b;
import f.a.x.c.f;
import f.a.x.i.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final f.a.x.d.b<T> parent;
    public final int prefetch;
    public f<T> queue;

    public InnerQueuedObserver(f.a.x.d.b<T> bVar, int i) {
        this.parent = bVar;
        this.prefetch = i;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // f.a.o
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof f.a.x.c.b) {
                f.a.x.c.b bVar2 = (f.a.x.c.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = i.a(-this.prefetch);
        }
    }

    public f<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
