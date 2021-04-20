package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.p;
import f.b.t.b;
import f.b.x.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeoutTimed<T> extends f.b.x.e.c.a<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public static final b f69080e = new a();

    /* loaded from: classes7.dex */
    public static final class TimeoutTimedObserver<T> extends AtomicReference<b> implements o<T>, b {
        public static final long serialVersionUID = -8387234228317808253L;
        public final o<? super T> actual;
        public volatile boolean done;
        public volatile long index;
        public b s;
        public final long timeout;
        public final TimeUnit unit;
        public final p.c worker;

        /* loaded from: classes7.dex */
        public final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final long f69081e;

            public a(long j) {
                this.f69081e = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f69081e == TimeoutTimedObserver.this.index) {
                    TimeoutTimedObserver.this.done = true;
                    TimeoutTimedObserver.this.s.dispose();
                    DisposableHelper.dispose(TimeoutTimedObserver.this);
                    TimeoutTimedObserver.this.actual.onError(new TimeoutException());
                    TimeoutTimedObserver.this.worker.dispose();
                }
            }
        }

        public TimeoutTimedObserver(o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar) {
            this.actual = oVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // f.b.t.b
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // f.b.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            dispose();
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            if (this.done) {
                f.b.a0.a.f(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // f.b.o
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            this.actual.onNext(t);
            scheduleTimeout(j);
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        public void scheduleTimeout(long j) {
            b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            if (compareAndSet(bVar, ObservableTimeoutTimed.f69080e)) {
                DisposableHelper.replace(this, this.worker.c(new a(j), this.timeout, this.unit));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class TimeoutTimedOtherObserver<T> extends AtomicReference<b> implements o<T>, b {
        public static final long serialVersionUID = -4619702551964128179L;
        public final o<? super T> actual;
        public final e<T> arbiter;
        public volatile boolean done;
        public volatile long index;
        public final n<? extends T> other;
        public b s;
        public final long timeout;
        public final TimeUnit unit;
        public final p.c worker;

        /* loaded from: classes7.dex */
        public final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final long f69083e;

            public a(long j) {
                this.f69083e = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f69083e == TimeoutTimedOtherObserver.this.index) {
                    TimeoutTimedOtherObserver.this.done = true;
                    TimeoutTimedOtherObserver.this.s.dispose();
                    DisposableHelper.dispose(TimeoutTimedOtherObserver.this);
                    TimeoutTimedOtherObserver.this.subscribeNext();
                    TimeoutTimedOtherObserver.this.worker.dispose();
                }
            }
        }

        public TimeoutTimedOtherObserver(o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar, n<? extends T> nVar) {
            this.actual = oVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.other = nVar;
            this.arbiter = new e<>(oVar, this, 8);
        }

        @Override // f.b.t.b
        public void dispose() {
            this.s.dispose();
            this.worker.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // f.b.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.arbiter.c(this.s);
            this.worker.dispose();
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            if (this.done) {
                f.b.a0.a.f(th);
                return;
            }
            this.done = true;
            this.arbiter.d(th, this.s);
            this.worker.dispose();
        }

        @Override // f.b.o
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            if (this.arbiter.e(t, this.s)) {
                scheduleTimeout(j);
            }
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                if (this.arbiter.f(bVar)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        public void scheduleTimeout(long j) {
            b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            if (compareAndSet(bVar, ObservableTimeoutTimed.f69080e)) {
                DisposableHelper.replace(this, this.worker.c(new a(j), this.timeout, this.unit));
            }
        }

        public void subscribeNext() {
            this.other.subscribe(new f.b.x.d.a(this.arbiter));
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements b {
        @Override // f.b.t.b
        public void dispose() {
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return true;
        }
    }
}
