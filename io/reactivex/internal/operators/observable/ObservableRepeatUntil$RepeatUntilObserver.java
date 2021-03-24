package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.u.a;
import f.a.w.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements o<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final o<? super T> actual;
    public final SequentialDisposable sd;
    public final n<? extends T> source;
    public final e stop;

    public ObservableRepeatUntil$RepeatUntilObserver(o<? super T> oVar, e eVar, SequentialDisposable sequentialDisposable, n<? extends T> nVar) {
        this.actual = oVar;
        this.sd = sequentialDisposable;
        this.source = nVar;
        this.stop = eVar;
    }

    @Override // f.a.o
    public void onComplete() {
        try {
            if (this.stop.getAsBoolean()) {
                this.actual.onComplete();
            } else {
                subscribeNext();
            }
        } catch (Throwable th) {
            a.a(th);
            this.actual.onError(th);
        }
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        this.sd.replace(bVar);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i = 1;
            do {
                this.source.subscribe(this);
                i = addAndGet(-i);
            } while (i != 0);
        }
    }
}
