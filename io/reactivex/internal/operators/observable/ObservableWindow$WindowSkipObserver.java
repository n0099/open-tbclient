package io.reactivex.internal.operators.observable;

import f.b.l;
import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableWindow$WindowSkipObserver<T> extends AtomicBoolean implements o<T>, b, Runnable {
    public static final long serialVersionUID = 3366976432059579510L;
    public final o<? super l<T>> actual;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public long firstEmission;
    public long index;
    public b s;
    public final long skip;
    public final AtomicInteger wip = new AtomicInteger();
    public final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

    public ObservableWindow$WindowSkipObserver(o<? super l<T>> oVar, long j, long j2, int i) {
        this.actual = oVar;
        this.count = j;
        this.skip = j2;
        this.capacityHint = i;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.cancelled = true;
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.b.o
    public void onComplete() {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onComplete();
        }
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        while (!arrayDeque.isEmpty()) {
            arrayDeque.poll().onError(th);
        }
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
        long j = this.index;
        long j2 = this.skip;
        if (j % j2 == 0 && !this.cancelled) {
            this.wip.getAndIncrement();
            UnicastSubject<T> d2 = UnicastSubject.d(this.capacityHint, this);
            arrayDeque.offer(d2);
            this.actual.onNext(d2);
        }
        long j3 = this.firstEmission + 1;
        Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
        while (it.hasNext()) {
            it.next().onNext(t);
        }
        if (j3 >= this.count) {
            arrayDeque.poll().onComplete();
            if (arrayDeque.isEmpty() && this.cancelled) {
                this.s.dispose();
                return;
            }
            this.firstEmission = j3 - j2;
        } else {
            this.firstEmission = j3;
        }
        this.index = j + 1;
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.wip.decrementAndGet() == 0 && this.cancelled) {
            this.s.dispose();
        }
    }
}
