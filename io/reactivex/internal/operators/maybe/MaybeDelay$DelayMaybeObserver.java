package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.p;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<b> implements i<T>, b, Runnable {
    public static final long serialVersionUID = 5566860102500855068L;
    public final i<? super T> actual;
    public final long delay;
    public Throwable error;
    public final p scheduler;
    public final TimeUnit unit;
    public T value;

    public MaybeDelay$DelayMaybeObserver(i<? super T> iVar, long j, TimeUnit timeUnit, p pVar) {
        this.actual = iVar;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = pVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.i
    public void onComplete() {
        schedule();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.error = th;
        schedule();
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
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
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }
}
