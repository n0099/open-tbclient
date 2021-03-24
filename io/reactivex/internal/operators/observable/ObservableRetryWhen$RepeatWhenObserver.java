package io.reactivex.internal.operators.observable;

import f.a.d0.a;
import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.x.i.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableRetryWhen$RepeatWhenObserver<T> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 802743776666017014L;
    public volatile boolean active;
    public final o<? super T> actual;
    public final a<Throwable> signaller;
    public final n<T> source;
    public final AtomicInteger wip = new AtomicInteger();
    public final AtomicThrowable error = new AtomicThrowable();
    public final ObservableRetryWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b> f68067d = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public final class InnerRepeatObserver extends AtomicReference<b> implements o<Object> {
        public static final long serialVersionUID = 3254781284376480842L;

        public InnerRepeatObserver() {
        }

        @Override // f.a.o
        public void onComplete() {
            ObservableRetryWhen$RepeatWhenObserver.this.innerComplete();
        }

        @Override // f.a.o
        public void onError(Throwable th) {
            ObservableRetryWhen$RepeatWhenObserver.this.innerError(th);
        }

        @Override // f.a.o
        public void onNext(Object obj) {
            ObservableRetryWhen$RepeatWhenObserver.this.innerNext();
        }

        @Override // f.a.o
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableRetryWhen$RepeatWhenObserver(o<? super T> oVar, a<Throwable> aVar, n<T> nVar) {
        this.actual = oVar;
        this.signaller = aVar;
        this.source = nVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this.f68067d);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.f68067d);
        e.a(this.actual, this, this.error);
    }

    public void innerError(Throwable th) {
        DisposableHelper.dispose(this.f68067d);
        e.c(this.actual, th, this, this.error);
    }

    public void innerNext() {
        subscribeNext();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f68067d.get());
    }

    @Override // f.a.o
    public void onComplete() {
        DisposableHelper.dispose(this.inner);
        e.a(this.actual, this, this.error);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.active = false;
        this.signaller.onNext(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        e.e(this.actual, t, this, this.error);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.replace(this.f68067d, bVar);
    }

    public void subscribeNext() {
        if (this.wip.getAndIncrement() == 0) {
            while (!isDisposed()) {
                if (!this.active) {
                    this.active = true;
                    this.source.subscribe(this);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
