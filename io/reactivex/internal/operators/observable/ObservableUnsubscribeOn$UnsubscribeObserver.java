package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.p;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements o<T>, b {
    public static final long serialVersionUID = 1015244841293359600L;
    public final o<? super T> actual;
    public b s;
    public final p scheduler;

    /* loaded from: classes7.dex */
    public final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableUnsubscribeOn$UnsubscribeObserver.this.s.dispose();
        }
    }

    public ObservableUnsubscribeOn$UnsubscribeObserver(o<? super T> oVar, p pVar) {
        this.actual = oVar;
        this.scheduler = pVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.scheduler.c(new a());
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get();
    }

    @Override // f.a.o
    public void onComplete() {
        if (get()) {
            return;
        }
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (get()) {
            f.a.a0.a.f(th);
        } else {
            this.actual.onError(th);
        }
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (get()) {
            return;
        }
        this.actual.onNext(t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
