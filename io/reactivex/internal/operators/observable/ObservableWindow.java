package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.u;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public final class ObservableWindow<T> extends a<T, q<T>> {
    final int capacityHint;
    final long count;
    final long skip;

    @Override // io.reactivex.q
    public void a(u<? super q<T>> uVar) {
        if (this.count == this.skip) {
            this.source.subscribe(new WindowExactObserver(uVar, this.count, this.capacityHint));
        } else {
            this.source.subscribe(new WindowSkipObserver(uVar, this.count, this.skip, this.capacityHint));
        }
    }

    /* loaded from: classes25.dex */
    static final class WindowExactObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T>, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final u<? super q<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        io.reactivex.disposables.b s;
        long size;
        UnicastSubject<T> window;

        WindowExactObserver(u<? super q<T>> uVar, long j, int i) {
            this.actual = uVar;
            this.count = j;
            this.capacityHint = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject == null && !this.cancelled) {
                unicastSubject = UnicastSubject.c(this.capacityHint, this);
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

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.s.dispose();
            }
        }
    }

    /* loaded from: classes25.dex */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, u<T>, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final u<? super q<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        long firstEmission;
        long index;
        io.reactivex.disposables.b s;
        final long skip;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        WindowSkipObserver(u<? super q<T>> uVar, long j, long j2, int i) {
            this.actual = uVar;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> c = UnicastSubject.c(this.capacityHint, this);
                arrayDeque.offer(c);
                this.actual.onNext(c);
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

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.s.dispose();
            }
        }
    }
}
