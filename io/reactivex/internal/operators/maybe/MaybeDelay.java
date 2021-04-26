package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {
    public final long delay;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: classes7.dex */
    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        public static final long serialVersionUID = 5566860102500855068L;
        public final MaybeObserver<? super T> actual;
        public final long delay;
        public Throwable error;
        public final Scheduler scheduler;
        public final TimeUnit unit;
        public T value;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = maybeObserver;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            schedule();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.error = th;
            schedule();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.value = t;
            schedule();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        public void schedule() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new DelayMaybeObserver(maybeObserver, this.delay, this.unit, this.scheduler));
    }
}
