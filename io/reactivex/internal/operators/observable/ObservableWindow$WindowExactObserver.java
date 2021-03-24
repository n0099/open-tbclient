package io.reactivex.internal.operators.observable;

import f.a.l;
import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements o<T>, b, Runnable {
    public static final long serialVersionUID = -7481782523886138128L;
    public final o<? super l<T>> actual;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public b s;
    public long size;
    public UnicastSubject<T> window;

    public ObservableWindow$WindowExactObserver(o<? super l<T>> oVar, long j, int i) {
        this.actual = oVar;
        this.count = j;
        this.capacityHint = i;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.cancelled = true;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onError(th);
        }
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        UnicastSubject<T> unicastSubject = this.window;
        if (unicastSubject == null && !this.cancelled) {
            unicastSubject = UnicastSubject.d(this.capacityHint, this);
            this.window = unicastSubject;
            this.actual.onNext(unicastSubject);
        }
        if (unicastSubject != null) {
            unicastSubject.onNext(t);
            long j = this.size + 1;
            this.size = j;
            if (j >= this.count) {
                this.size = 0L;
                this.window = null;
                unicastSubject.onComplete();
                if (this.cancelled) {
                    this.s.dispose();
                }
            }
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelled) {
            this.s.dispose();
        }
    }
}
