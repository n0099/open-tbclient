package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.u.a;
import f.a.w.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableRetryBiPredicate$RetryBiObserver<T> extends AtomicInteger implements o<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final o<? super T> actual;
    public final d<? super Integer, ? super Throwable> predicate;
    public int retries;
    public final SequentialDisposable sa;
    public final n<? extends T> source;

    public ObservableRetryBiPredicate$RetryBiObserver(o<? super T> oVar, d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, n<? extends T> nVar) {
        this.actual = oVar;
        this.sa = sequentialDisposable;
        this.source = nVar;
        this.predicate = dVar;
    }

    @Override // f.a.o
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        try {
            d<? super Integer, ? super Throwable> dVar = this.predicate;
            int i = this.retries + 1;
            this.retries = i;
            if (!dVar.a(Integer.valueOf(i), th)) {
                this.actual.onError(th);
            } else {
                subscribeNext();
            }
        } catch (Throwable th2) {
            a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        this.sa.update(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            while (!this.sa.isDisposed()) {
                this.source.subscribe(this);
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }
}
