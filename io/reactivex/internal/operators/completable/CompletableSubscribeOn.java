package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableSubscribeOn extends a {
    final v scheduler;
    final e source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(cVar, this.source);
        cVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.scheduler.H(subscribeOnObserver));
    }

    /* loaded from: classes7.dex */
    static final class SubscribeOnObserver extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final c actual;
        final e source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(c cVar, e eVar) {
            this.actual = cVar;
            this.source = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
