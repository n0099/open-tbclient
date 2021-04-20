package io.reactivex.internal.operators.completable;

import f.b.b;
import f.b.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableDoFinally$DoFinallyObserver extends AtomicInteger implements b, f.b.t.b {
    public static final long serialVersionUID = 4109457741734051389L;
    public final b actual;

    /* renamed from: d  reason: collision with root package name */
    public f.b.t.b f69034d;
    public final a onFinally;

    public CompletableDoFinally$DoFinallyObserver(b bVar, a aVar) {
        this.actual = bVar;
        this.onFinally = aVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.f69034d.dispose();
        runFinally();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69034d.isDisposed();
    }

    @Override // f.b.b
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // f.b.b
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.b.b
    public void onSubscribe(f.b.t.b bVar) {
        if (DisposableHelper.validate(this.f69034d, bVar)) {
            this.f69034d = bVar;
            this.actual.onSubscribe(this);
        }
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
