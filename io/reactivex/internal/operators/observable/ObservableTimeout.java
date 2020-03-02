package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeout<T, U, V> extends io.reactivex.internal.operators.observable.a<T, T> {
    final h<? super T, ? extends t<V>> itemTimeoutIndicator;
    final t<U> nyk;
    final t<? extends T> other;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a extends ObservableTimeoutTimed.b {
        void onTimeoutError(long j, Throwable th);
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        if (this.other == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(uVar, this.itemTimeoutIndicator);
            uVar.onSubscribe(timeoutObserver);
            timeoutObserver.startFirstTimeout(this.nyk);
            this.source.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(uVar, this.itemTimeoutIndicator, this.other);
        uVar.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startFirstTimeout(this.nyk);
        this.source.subscribe(timeoutFallbackObserver);
    }

    /* loaded from: classes7.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.disposables.b, a, u<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final u<? super T> actual;
        final h<? super T, ? extends t<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutObserver(u<? super T> uVar, h<? super T, ? extends t<?>> hVar) {
            this.actual = uVar;
            this.itemTimeoutIndicator = hVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            long j = get();
            if (j != Format.OFFSET_SAMPLE_RELATIVE && compareAndSet(j, j + 1)) {
                io.reactivex.disposables.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.actual.onNext(t);
                try {
                    t tVar = (t) io.reactivex.internal.functions.a.h(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                    TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j + 1, this);
                    if (this.task.replace(timeoutConsumer)) {
                        tVar.subscribe(timeoutConsumer);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    this.upstream.get().dispose();
                    getAndSet(Format.OFFSET_SAMPLE_RELATIVE);
                    this.actual.onError(th);
                }
            }
        }

        void startFirstTimeout(t<?> tVar) {
            if (tVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    tVar.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this.upstream);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, a, u<T> {
        private static final long serialVersionUID = -7508389464265974549L;
        final u<? super T> actual;
        t<? extends T> fallback;
        final h<? super T, ? extends t<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutFallbackObserver(u<? super T> uVar, h<? super T, ? extends t<?>> hVar, t<? extends T> tVar) {
            this.actual = uVar;
            this.itemTimeoutIndicator = hVar;
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
                io.reactivex.disposables.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.actual.onNext(t);
                try {
                    t tVar = (t) io.reactivex.internal.functions.a.h(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                    TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j + 1, this);
                    if (this.task.replace(timeoutConsumer)) {
                        tVar.subscribe(timeoutConsumer);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    this.upstream.get().dispose();
                    this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE);
                    this.actual.onError(th);
                }
            }
        }

        void startFirstTimeout(t<?> tVar) {
            if (tVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    tVar.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onError(th);
                this.task.dispose();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (this.index.getAndSet(Format.OFFSET_SAMPLE_RELATIVE) != Format.OFFSET_SAMPLE_RELATIVE) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this.upstream);
                t<? extends T> tVar = this.fallback;
                this.fallback = null;
                tVar.subscribe(new ObservableTimeoutTimed.a(this.actual, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, Format.OFFSET_SAMPLE_RELATIVE)) {
                DisposableHelper.dispose(this);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class TimeoutConsumer extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<Object> {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final a parent;

        TimeoutConsumer(long j, a aVar) {
            this.idx = j;
            this.parent = aVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) get();
            if (bVar != DisposableHelper.DISPOSED) {
                bVar.dispose();
                lazySet(DisposableHelper.DISPOSED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.onTimeoutError(this.idx, th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
