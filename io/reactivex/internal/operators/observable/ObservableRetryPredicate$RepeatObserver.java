package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.u.a;
import f.a.w.i;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableRetryPredicate$RepeatObserver<T> extends AtomicInteger implements o<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final o<? super T> actual;
    public final i<? super Throwable> predicate;
    public long remaining;
    public final SequentialDisposable sa;
    public final n<? extends T> source;

    public ObservableRetryPredicate$RepeatObserver(o<? super T> oVar, long j, i<? super Throwable> iVar, SequentialDisposable sequentialDisposable, n<? extends T> nVar) {
        this.actual = oVar;
        this.sa = sequentialDisposable;
        this.source = nVar;
        this.predicate = iVar;
        this.remaining = j;
    }

    @Override // f.a.o
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j == 0) {
            this.actual.onError(th);
            return;
        }
        try {
            if (!this.predicate.test(th)) {
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
