package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.r;
import f.b.s;
import f.b.t.b;
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
        public final r<? super T> f69059e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<b> f69060f;

        public a(r<? super T> rVar, AtomicReference<b> atomicReference) {
            this.f69059e = rVar;
            this.f69060f = atomicReference;
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.f69059e.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f69060f, bVar);
        }

        @Override // f.b.r
        public void onSuccess(T t) {
            this.f69059e.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(r<? super T> rVar, s<? extends T> sVar) {
        this.actual = rVar;
        this.other = sVar;
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
        b bVar = get();
        if (bVar == DisposableHelper.DISPOSED || !compareAndSet(bVar, null)) {
            return;
        }
        this.other.a(new a(this.actual, this));
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
