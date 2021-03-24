package io.reactivex.internal.operators.maybe;

import f.a.j;
import f.a.r;
import f.a.t.b;
import f.a.u.a;
import f.a.w.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b {
    public final r<? super Boolean> actual;
    public final d<? super T, ? super T> isEqual;
    public final MaybeEqualSingle$EqualObserver<T> observer1;
    public final MaybeEqualSingle$EqualObserver<T> observer2;

    public MaybeEqualSingle$EqualCoordinator(r<? super Boolean> rVar, d<? super T, ? super T> dVar) {
        super(2);
        this.actual = rVar;
        this.isEqual = dVar;
        this.observer1 = new MaybeEqualSingle$EqualObserver<>(this);
        this.observer2 = new MaybeEqualSingle$EqualObserver<>(this);
    }

    @Override // f.a.t.b
    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() == 0) {
            Object obj = this.observer1.value;
            Object obj2 = this.observer2.value;
            if (obj != null && obj2 != null) {
                try {
                    this.actual.onSuccess(Boolean.valueOf(this.isEqual.a(obj, obj2)));
                    return;
                } catch (Throwable th) {
                    a.a(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
        }
    }

    public void error(MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver, Throwable th) {
        if (getAndSet(0) > 0) {
            MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver2 = this.observer1;
            if (maybeEqualSingle$EqualObserver == maybeEqualSingle$EqualObserver2) {
                this.observer2.dispose();
            } else {
                maybeEqualSingle$EqualObserver2.dispose();
            }
            this.actual.onError(th);
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.observer1.get());
    }

    public void subscribe(j<? extends T> jVar, j<? extends T> jVar2) {
        jVar.a(this.observer1);
        jVar2.a(this.observer2);
    }
}
