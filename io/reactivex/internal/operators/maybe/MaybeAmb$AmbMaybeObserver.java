package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.t.a;
import f.b.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class MaybeAmb$AmbMaybeObserver<T> extends AtomicBoolean implements i<T>, b {
    public static final long serialVersionUID = -7044685185359438206L;
    public final i<? super T> actual;
    public final a set = new a();

    public MaybeAmb$AmbMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get();
    }

    @Override // f.b.i
    public void onComplete() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onComplete();
        }
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onError(th);
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        this.set.b(bVar);
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onSuccess(t);
        }
    }
}
