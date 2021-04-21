package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.b;
import f.b.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class SingleDoFinally$DoFinallyObserver<T> extends AtomicInteger implements r<T>, b {
    public static final long serialVersionUID = 4109457741734051389L;
    public final r<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69237d;
    public final a onFinally;

    public SingleDoFinally$DoFinallyObserver(r<? super T> rVar, a aVar) {
        this.actual = rVar;
        this.onFinally = aVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.f69237d.dispose();
        runFinally();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69237d.isDisposed();
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69237d, bVar)) {
            this.f69237d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
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
