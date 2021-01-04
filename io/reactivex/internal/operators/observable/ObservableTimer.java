package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ObservableTimer extends q<Long> {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super Long> uVar) {
        TimerObserver timerObserver = new TimerObserver(uVar);
        uVar.onSubscribe(timerObserver);
        timerObserver.setResource(this.scheduler.b(timerObserver, this.delay, this.unit));
    }

    /* loaded from: classes3.dex */
    static final class TimerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final u<? super Long> actual;

        TimerObserver(u<? super Long> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                this.actual.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.actual.onComplete();
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }
}
