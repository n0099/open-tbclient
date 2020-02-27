package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableDelay extends a {
    final long delay;
    final boolean delayError;
    final v scheduler;
    final e source;
    final TimeUnit unit;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        this.source.a(new Delay(cVar, this.delay, this.unit, this.scheduler, this.delayError));
    }

    /* loaded from: classes7.dex */
    static final class Delay extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final c downstream;
        Throwable error;
        final v scheduler;
        final TimeUnit unit;

        Delay(c cVar, long j, TimeUnit timeUnit, v vVar, boolean z) {
            this.downstream = cVar;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
            this.delayError = z;
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.b(this, this.delay, this.unit));
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.b(this, this.delayError ? this.delay : 0L, this.unit));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            this.error = null;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}
