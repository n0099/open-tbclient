package io.reactivex.internal.operators.single;

import f.b.a0.a;
import f.b.r;
import f.b.t.b;
import f.b.w.h;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class SingleZipArray$ZipCoordinator<T, R> extends AtomicInteger implements b {
    public static final long serialVersionUID = -5556924161382950569L;
    public final r<? super R> actual;
    public final SingleZipArray$ZipSingleObserver<T>[] observers;
    public final Object[] values;
    public final h<? super Object[], ? extends R> zipper;

    public SingleZipArray$ZipCoordinator(r<? super R> rVar, int i, h<? super Object[], ? extends R> hVar) {
        super(i);
        this.actual = rVar;
        this.zipper = hVar;
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = new SingleZipArray$ZipSingleObserver[i];
        for (int i2 = 0; i2 < i; i2++) {
            singleZipArray$ZipSingleObserverArr[i2] = new SingleZipArray$ZipSingleObserver<>(this, i2);
        }
        this.observers = singleZipArray$ZipSingleObserverArr;
        this.values = new Object[i];
    }

    @Override // f.b.t.b
    public void dispose() {
        if (getAndSet(0) > 0) {
            for (SingleZipArray$ZipSingleObserver<T> singleZipArray$ZipSingleObserver : this.observers) {
                singleZipArray$ZipSingleObserver.dispose();
            }
        }
    }

    public void disposeExcept(int i) {
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = this.observers;
        int length = singleZipArray$ZipSingleObserverArr.length;
        for (int i2 = 0; i2 < i; i2++) {
            singleZipArray$ZipSingleObserverArr[i2].dispose();
        }
        while (true) {
            i++;
            if (i >= length) {
                return;
            }
            singleZipArray$ZipSingleObserverArr[i].dispose();
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
                f.b.x.b.a.b(apply, "The zipper returned a null value");
                this.actual.onSuccess(apply);
            } catch (Throwable th) {
                f.b.u.a.a(th);
                this.actual.onError(th);
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() <= 0;
    }
}
