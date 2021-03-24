package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.a;
import f.a.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class MaybeAmb$AmbMaybeObserver<T> extends AtomicBoolean implements i<T>, b {
    public static final long serialVersionUID = -7044685185359438206L;
    public final i<? super T> actual;
    public final a set = new a();

    public MaybeAmb$AmbMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get();
    }

    @Override // f.a.i
    public void onComplete() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onComplete();
        }
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onError(th);
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        this.set.b(bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onSuccess(t);
        }
    }
}
