package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.r;
import f.a.s;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 4603919676453758899L;
    public final r<? super T> actual;
    public final s<? extends T> other;

    /* loaded from: classes7.dex */
    public static final class a<T> implements r<T> {

        /* renamed from: e  reason: collision with root package name */
        public final r<? super T> f68053e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<b> f68054f;

        public a(r<? super T> rVar, AtomicReference<b> atomicReference) {
            this.f68053e = rVar;
            this.f68054f = atomicReference;
        }

        @Override // f.a.r
        public void onError(Throwable th) {
            this.f68053e.onError(th);
        }

        @Override // f.a.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f68054f, bVar);
        }

        @Override // f.a.r
        public void onSuccess(T t) {
            this.f68053e.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(r<? super T> rVar, s<? extends T> sVar) {
        this.actual = rVar;
        this.other = sVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.i
    public void onComplete() {
        b bVar = get();
        if (bVar == DisposableHelper.DISPOSED || !compareAndSet(bVar, null)) {
            return;
        }
        this.other.a(new a(this.actual, this));
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
