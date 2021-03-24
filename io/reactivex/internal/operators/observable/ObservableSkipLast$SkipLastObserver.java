package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class ObservableSkipLast$SkipLastObserver<T> extends ArrayDeque<T> implements o<T>, b {
    public static final long serialVersionUID = -3807491841935125653L;
    public final o<? super T> actual;
    public b s;
    public final int skip;

    public ObservableSkipLast$SkipLastObserver(o<? super T> oVar, int i) {
        super(i);
        this.actual = oVar;
        this.skip = i;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.s.dispose();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // f.a.o
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    @Override // f.a.o
    public void onNext(T t) {
        if (this.skip == size()) {
            this.actual.onNext((T) poll());
        }
        offer(t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
