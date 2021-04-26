package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class CompletableDelay extends Completable {
    public final long delay;
    public final boolean delayError;
    public final Scheduler scheduler;
    public final CompletableSource source;
    public final TimeUnit unit;

    /* loaded from: classes7.dex */
    public final class Delay implements CompletableObserver {
        public final CompletableObserver s;
        public final CompositeDisposable set;

        /* loaded from: classes7.dex */
        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.s.onComplete();
            }
        }

        /* loaded from: classes7.dex */
        public final class OnError implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final Throwable f68235e;

            public OnError(Throwable th) {
                this.f68235e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.s.onError(this.f68235e);
            }
        }

        public Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnComplete onComplete = new OnComplete();
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onComplete, completableDelay.delay, completableDelay.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnError onError = new OnError(th);
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onError, completableDelay.delayError ? completableDelay.delay : 0L, CompletableDelay.this.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.s.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }
}
