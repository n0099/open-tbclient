package io.reactivex.internal.operators.single;

import f.b.a0.a;
import f.b.r;
import f.b.s;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<b> implements r<T>, Runnable, b {
    public static final long serialVersionUID = 37497744973048446L;
    public final r<? super T> actual;
    public final TimeoutFallbackObserver<T> fallback;
    public s<? extends T> other;
    public final AtomicReference<b> task = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements r<T> {
        public static final long serialVersionUID = 2071387740092105509L;
        public final r<? super T> actual;

        public TimeoutFallbackObserver(r<? super T> rVar) {
            this.actual = rVar;
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // f.b.r
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public SingleTimeout$TimeoutMainObserver(r<? super T> rVar, s<? extends T> sVar) {
        this.actual = rVar;
        this.other = sVar;
        if (sVar != null) {
            this.fallback = new TimeoutFallbackObserver<>(rVar);
        } else {
            this.fallback = null;
        }
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
        if (timeoutFallbackObserver != null) {
            DisposableHelper.dispose(timeoutFallbackObserver);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper && compareAndSet(bVar, disposableHelper)) {
            DisposableHelper.dispose(this.task);
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
            return;
        }
        DisposableHelper.dispose(this.task);
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
            return;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        s<? extends T> sVar = this.other;
        if (sVar == null) {
            this.actual.onError(new TimeoutException());
            return;
        }
        this.other = null;
        sVar.a(this.fallback);
    }
}
