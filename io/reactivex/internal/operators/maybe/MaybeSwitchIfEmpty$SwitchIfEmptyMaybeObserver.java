package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.j;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -2223459372976438024L;
    public final i<? super T> actual;
    public final j<? extends T> other;

    /* loaded from: classes7.dex */
    public static final class a<T> implements i<T> {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f69057e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<b> f69058f;

        public a(i<? super T> iVar, AtomicReference<b> atomicReference) {
            this.f69057e = iVar;
            this.f69058f = atomicReference;
        }

        @Override // f.b.i
        public void onComplete() {
            this.f69057e.onComplete();
        }

        @Override // f.b.i
        public void onError(Throwable th) {
            this.f69057e.onError(th);
        }

        @Override // f.b.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f69058f, bVar);
        }

        @Override // f.b.i
        public void onSuccess(T t) {
            this.f69057e.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(i<? super T> iVar, j<? extends T> jVar) {
        this.actual = iVar;
        this.other = jVar;
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
