package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.a;
import f.b.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class SingleAmb$AmbSingleObserver<T> extends AtomicBoolean implements r<T> {
    public static final long serialVersionUID = -1944085461036028108L;
    public final r<? super T> s;
    public final a set;

    public SingleAmb$AmbSingleObserver(r<? super T> rVar, a aVar) {
        this.s = rVar;
        this.set = aVar;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.s.onError(th);
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        this.set.b(bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.s.onSuccess(t);
        }
    }
}
