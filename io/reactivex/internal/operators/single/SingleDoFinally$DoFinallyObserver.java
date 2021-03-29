package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.t.b;
import f.a.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class SingleDoFinally$DoFinallyObserver<T> extends AtomicInteger implements r<T>, b {
    public static final long serialVersionUID = 4109457741734051389L;
    public final r<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68084d;
    public final a onFinally;

    public SingleDoFinally$DoFinallyObserver(r<? super T> rVar, a aVar) {
        this.actual = rVar;
        this.onFinally = aVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68084d.dispose();
        runFinally();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f68084d.isDisposed();
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68084d, bVar)) {
            this.f68084d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
        runFinally();
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
