package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements o<T>, b {
    public static final long serialVersionUID = 7240042530241604978L;
    public final o<? super T> actual;
    public volatile boolean cancelled;
    public final int count;
    public b s;

    public ObservableTakeLast$TakeLastObserver(o<? super T> oVar, int i) {
        this.actual = oVar;
        this.count = i;
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.dispose();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.b.o
    public void onComplete() {
        o<? super T> oVar = this.actual;
        while (!this.cancelled) {
            Object obj = (T) poll();
            if (obj == null) {
                if (this.cancelled) {
                    return;
                }
                oVar.onComplete();
                return;
            }
            oVar.onNext(obj);
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.count == size()) {
            poll();
        }
        offer(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
