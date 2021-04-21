package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.t.b;
import f.b.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class MaybeDoFinally$DoFinallyObserver<T> extends AtomicInteger implements i<T>, b {
    public static final long serialVersionUID = 4109457741734051389L;
    public final i<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69196d;
    public final a onFinally;

    public MaybeDoFinally$DoFinallyObserver(i<? super T> iVar, a aVar) {
        this.actual = iVar;
        this.onFinally = aVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.f69196d.dispose();
        runFinally();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69196d.isDisposed();
    }

    @Override // f.b.i
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69196d, bVar)) {
            this.f69196d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
        runFinally();
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th) {
                f.b.u.a.a(th);
                f.b.a0.a.f(th);
            }
        }
    }
}
