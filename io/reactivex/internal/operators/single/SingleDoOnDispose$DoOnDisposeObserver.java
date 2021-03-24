package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.t.b;
import f.a.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<a> implements r<T>, b {
    public static final long serialVersionUID = -8583764624474935784L;
    public final r<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68080d;

    public SingleDoOnDispose$DoOnDisposeObserver(r<? super T> rVar, a aVar) {
        this.actual = rVar;
        lazySet(aVar);
    }

    @Override // f.a.t.b
    public void dispose() {
        a andSet = getAndSet(null);
        if (andSet != null) {
            try {
                andSet.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                f.a.a0.a.f(th);
            }
            this.f68080d.dispose();
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f68080d.isDisposed();
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68080d, bVar)) {
            this.f68080d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
