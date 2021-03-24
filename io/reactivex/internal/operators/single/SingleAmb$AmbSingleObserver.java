package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.t.a;
import f.a.t.b;
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

    @Override // f.a.r
    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.s.onError(th);
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        this.set.b(bVar);
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.s.onSuccess(t);
        }
    }
}
