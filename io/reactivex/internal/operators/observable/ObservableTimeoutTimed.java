package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeoutTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final t<? extends T> other;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface b {
        void onTimeout(long j);
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        if (this.other == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(uVar, this.timeout, this.unit, this.scheduler.dJi());
            uVar.onSubscribe(timeoutObserver);
            timeoutObserver.startTimeout(0L);
            this.source.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(uVar, this.timeout, this.unit, this.scheduler.dJi(), this.other);
        uVar.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startTimeout(0L);
        this.source.subscribe(timeoutFallbackObserver);
    }

    /* loaded from: classes7.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.disposables.b, b, u<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final u<? super T> actual;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar) {
            this.actual = uVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            long j = get();
            if (j != Format.OFFSET_SAMPLE_RELATIVE && compareAndSet(j, j + 1)) {
                this.task.get().dispose();
                this.actual.onNext(t);
                startTimeout(j + 1);
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.c(new c(j, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c implements Runnable {
        final long idx;
        final b nyx;

        c(long j, b bVar) {
            this.idx = j;
            this.nyx = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.nyx.onTimeout(this.idx);
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, b, u<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final u<? super T> actual;
        t<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutFallbackObserver(u<? super T> uVar, long j, TimeUnit timeUnit, v.c cVar, t<? extends T> tVar) {
            this.actual = uVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = tVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Format.OFFSET_SAMPLE_RELATIVE && this.index.compareAndSet(j, j + 1)) {
                this.task.get().dispose();
                this.actual.onNext(t);
                startTimeout(j + 1);
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.c(new c(j, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this.upstream);
                t<? extends T> tVar = this.fallback;
                this.fallback = null;
                tVar.subscribe(new a(this.actual, this));
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements u<T> {
        final u<? super T> actual;
        final AtomicReference<io.reactivex.disposables.b> nyw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(u<? super T> uVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.actual = uVar;
            this.nyw = atomicReference;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.nyw, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
