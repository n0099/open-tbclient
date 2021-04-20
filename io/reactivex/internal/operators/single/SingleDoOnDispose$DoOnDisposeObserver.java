package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.b;
import f.b.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<a> implements r<T>, b {
    public static final long serialVersionUID = -8583764624474935784L;
    public final r<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69091d;

    public SingleDoOnDispose$DoOnDisposeObserver(r<? super T> rVar, a aVar) {
        this.actual = rVar;
        lazySet(aVar);
    }

    @Override // f.b.t.b
    public void dispose() {
        a andSet = getAndSet(null);
        if (andSet != null) {
            try {
                andSet.run();
            } catch (Throwable th) {
                f.b.u.a.a(th);
                f.b.a0.a.f(th);
            }
            this.f69091d.dispose();
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69091d.isDisposed();
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69091d, bVar)) {
            this.f69091d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
