package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes3.dex */
public final class FlowableTimer extends g<Long> {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> cVar) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(cVar);
        cVar.onSubscribe(timerSubscriber);
        timerSubscriber.setResource(this.scheduler.b(timerSubscriber, this.delay, this.unit));
    }

    /* loaded from: classes3.dex */
    static final class TimerSubscriber extends AtomicReference<io.reactivex.disposables.b> implements Runnable, d {
        private static final long serialVersionUID = -2809475196591179431L;
        final org.a.c<? super Long> actual;
        volatile boolean requested;

        TimerSubscriber(org.a.c<? super Long> cVar) {
            this.actual = cVar;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.requested = true;
            }
        }

        @Override // org.a.d
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (this.requested) {
                    this.actual.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.actual.onComplete();
                    return;
                }
                lazySet(EmptyDisposable.INSTANCE);
                this.actual.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }
}
