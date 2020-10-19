package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class SingleSubscribeOn<T> extends w<T> {
    final v scheduler;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(yVar, this.source);
        yVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.scheduler.F(subscribeOnObserver));
    }

    /* loaded from: classes17.dex */
    static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T>, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final y<? super T> actual;
        final aa<? extends T> source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(y<? super T> yVar, aa<? extends T> aaVar) {
            this.actual = yVar;
            this.source = aaVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
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

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }
}
