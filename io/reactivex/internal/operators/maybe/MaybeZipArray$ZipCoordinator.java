package io.reactivex.internal.operators.maybe;

import f.a.a0.a;
import f.a.i;
import f.a.t.b;
import f.a.w.h;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements b {
    public static final long serialVersionUID = -5556924161382950569L;
    public final i<? super R> actual;
    public final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    public final Object[] values;
    public final h<? super Object[], ? extends R> zipper;

    public MaybeZipArray$ZipCoordinator(i<? super R> iVar, int i, h<? super Object[], ? extends R> hVar) {
        super(i);
        this.actual = iVar;
        this.zipper = hVar;
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = new MaybeZipArray$ZipMaybeObserver[i];
        for (int i2 = 0; i2 < i; i2++) {
            maybeZipArray$ZipMaybeObserverArr[i2] = new MaybeZipArray$ZipMaybeObserver<>(this, i2);
        }
        this.observers = maybeZipArray$ZipMaybeObserverArr;
        this.values = new Object[i];
    }

    @Override // f.a.t.b
    public void dispose() {
        if (getAndSet(0) > 0) {
            for (MaybeZipArray$ZipMaybeObserver<T> maybeZipArray$ZipMaybeObserver : this.observers) {
                maybeZipArray$ZipMaybeObserver.dispose();
            }
        }
    }

    public void disposeExcept(int i) {
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = this.observers;
        int length = maybeZipArray$ZipMaybeObserverArr.length;
        for (int i2 = 0; i2 < i; i2++) {
            maybeZipArray$ZipMaybeObserverArr[i2].dispose();
        }
        while (true) {
            i++;
            if (i >= length) {
                return;
            }
            maybeZipArray$ZipMaybeObserverArr[i].dispose();
        }
    }

    public void innerComplete(int i) {
        if (getAndSet(0) > 0) {
            disposeExcept(i);
            this.actual.onComplete();
        }
    }

    public void innerError(Throwable th, int i) {
        if (getAndSet(0) > 0) {
            disposeExcept(i);
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }

    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super java.lang.Object[] */
    public void innerSuccess(T t, int i) {
        this.values[i] = t;
        if (decrementAndGet() == 0) {
            try {
                R apply = this.zipper.apply(this.values);
                f.a.x.b.a.b(apply, "The zipper returned a null value");
                this.actual.onSuccess(apply);
            } catch (Throwable th) {
                f.a.u.a.a(th);
                this.actual.onError(th);
            }
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() <= 0;
    }
}
