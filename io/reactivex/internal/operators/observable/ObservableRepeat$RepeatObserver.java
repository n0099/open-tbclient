package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements o<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final o<? super T> actual;
    public long remaining;
    public final SequentialDisposable sd;
    public final n<? extends T> source;

    public ObservableRepeat$RepeatObserver(o<? super T> oVar, long j, SequentialDisposable sequentialDisposable, n<? extends T> nVar) {
        this.actual = oVar;
        this.sd = sequentialDisposable;
        this.source = nVar;
        this.remaining = j;
    }

    @Override // f.b.o
    public void onComplete() {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j != 0) {
            subscribeNext();
        } else {
            this.actual.onComplete();
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        this.sd.replace(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.sd.isDisposed()) {
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
