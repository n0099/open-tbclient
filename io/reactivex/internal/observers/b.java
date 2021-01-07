package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.f;
import io.reactivex.u;
/* loaded from: classes5.dex */
public final class b<T> implements u<T> {
    final f<T> arbiter;
    io.reactivex.disposables.b s;

    public b(f<T> fVar) {
        this.arbiter = fVar;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.arbiter.d(bVar);
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        this.arbiter.a((f<T>) t, this.s);
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        this.arbiter.a(th, this.s);
    }

    @Override // io.reactivex.u
    public void onComplete() {
        this.arbiter.e(this.s);
    }
}
