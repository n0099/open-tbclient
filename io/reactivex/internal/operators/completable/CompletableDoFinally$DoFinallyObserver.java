package io.reactivex.internal.operators.completable;

import f.a.b;
import f.a.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableDoFinally$DoFinallyObserver extends AtomicInteger implements b, f.a.t.b {
    public static final long serialVersionUID = 4109457741734051389L;
    public final b actual;

    /* renamed from: d  reason: collision with root package name */
    public f.a.t.b f68028d;
    public final a onFinally;

    public CompletableDoFinally$DoFinallyObserver(b bVar, a aVar) {
        this.actual = bVar;
        this.onFinally = aVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68028d.dispose();
        runFinally();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f68028d.isDisposed();
    }

    @Override // f.a.b
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.a.b
    public void onSubscribe(f.a.t.b bVar) {
        if (DisposableHelper.validate(this.f68028d, bVar)) {
            this.f68028d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }
}
