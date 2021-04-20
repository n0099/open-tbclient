package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.x.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<b> implements o<R> {
    public static final long serialVersionUID = 3837284832786408377L;
    public volatile boolean done;
    public final long index;
    public final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    public final a<R> queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> observableSwitchMap$SwitchMapObserver, long j, int i) {
        this.parent = observableSwitchMap$SwitchMapObserver;
        this.index = j;
        this.queue = new a<>(i);
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.index == this.parent.unique) {
            this.done = true;
            this.parent.drain();
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // f.b.o
    public void onNext(R r) {
        if (this.index == this.parent.unique) {
            this.queue.offer(r);
            this.parent.drain();
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
