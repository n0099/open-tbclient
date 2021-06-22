package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class SingleDelay<T> extends Single<T> {
    public final boolean delayError;
    public final Scheduler scheduler;
    public final SingleSource<? extends T> source;
    public final long time;
    public final TimeUnit unit;

    /* loaded from: classes7.dex */
    public final class Delay implements SingleObserver<T> {
        public final SingleObserver<? super T> s;
        public final SequentialDisposable sd;

        /* loaded from: classes7.dex */
        public final class OnError implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final Throwable f72429e;

            public OnError(Throwable th) {
                this.f72429e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.s.onError(this.f72429e);
            }
        }

        /* loaded from: classes7.dex */
        public final class OnSuccess implements Runnable {
            public final T value;

            public OnSuccess(T t) {
                this.value = t;
            }

            /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
            @Override // java.lang.Runnable
            public void run() {
                Delay.this.s.onSuccess((T) this.value);
            }
        }

        public Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.sd = sequentialDisposable;
            this.s = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            SequentialDisposable sequentialDisposable = this.sd;
            Scheduler scheduler = SingleDelay.this.scheduler;
            OnError onError = new OnError(th);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onError, singleDelay.delayError ? singleDelay.time : 0L, SingleDelay.this.unit));
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            SequentialDisposable sequentialDisposable = this.sd;
            Scheduler scheduler = SingleDelay.this.scheduler;
            OnSuccess onSuccess = new OnSuccess(t);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onSuccess, singleDelay.time, singleDelay.unit));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = singleSource;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.source.subscribe(new Delay(sequentialDisposable, singleObserver));
    }
}
