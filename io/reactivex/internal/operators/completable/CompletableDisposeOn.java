package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class CompletableDisposeOn extends Completable {
    public final Scheduler scheduler;
    public final CompletableSource source;

    /* loaded from: classes7.dex */
    public static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72269d;
        public volatile boolean disposed;
        public final CompletableObserver s;
        public final Scheduler scheduler;

        public CompletableObserverImplementation(CompletableObserver completableObserver, Scheduler scheduler) {
            this.s = completableObserver;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.scheduler.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.disposed) {
                return;
            }
            this.s.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.disposed) {
                RxJavaPlugins.onError(th);
            } else {
                this.s.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72269d, disposable)) {
                this.f72269d = disposable;
                this.s.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f72269d.dispose();
            this.f72269d = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.source = completableSource;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableObserverImplementation(completableObserver, this.scheduler));
    }
}
