package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.i.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class ObservableWithLatestFromMany$WithLatestFromObserver<T, R> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 1577321883966341961L;
    public final o<? super R> actual;
    public final h<? super Object[], R> combiner;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b> f69233d;
    public volatile boolean done;
    public final AtomicThrowable error;
    public final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    public final AtomicReferenceArray<Object> values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(o<? super R> oVar, h<? super Object[], R> hVar, int i) {
        this.actual = oVar;
        this.combiner = hVar;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = new ObservableWithLatestFromMany$WithLatestInnerObserver[i];
        for (int i2 = 0; i2 < i; i2++) {
            observableWithLatestFromMany$WithLatestInnerObserverArr[i2] = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, i2);
        }
        this.observers = observableWithLatestFromMany$WithLatestInnerObserverArr;
        this.values = new AtomicReferenceArray<>(i);
        this.f69233d = new AtomicReference<>();
        this.error = new AtomicThrowable();
    }

    public void cancelAllBut(int i) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        for (int i2 = 0; i2 < observableWithLatestFromMany$WithLatestInnerObserverArr.length; i2++) {
            if (i2 != i) {
                observableWithLatestFromMany$WithLatestInnerObserverArr[i2].dispose();
            }
        }
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this.f69233d);
        for (ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver : this.observers) {
            observableWithLatestFromMany$WithLatestInnerObserver.dispose();
        }
    }

    public void innerComplete(int i, boolean z) {
        if (z) {
            return;
        }
        this.done = true;
        cancelAllBut(i);
        e.a(this.actual, this, this.error);
    }

    public void innerError(int i, Throwable th) {
        this.done = true;
        DisposableHelper.dispose(this.f69233d);
        cancelAllBut(i);
        e.c(this.actual, th, this, this.error);
    }

    public void innerNext(int i, Object obj) {
        this.values.set(i, obj);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f69233d.get());
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.a(this.actual, this, this.error);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.c(this.actual, th, this, this.error);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        int i = 0;
        objArr[0] = t;
        while (i < length) {
            Object obj = atomicReferenceArray.get(i);
            if (obj == null) {
                return;
            }
            i++;
            objArr[i] = obj;
        }
        try {
            R apply = this.combiner.apply(objArr);
            f.b.x.b.a.b(apply, "combiner returned a null value");
            e.e(this.actual, apply, this, this.error);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f69233d, bVar);
    }

    public void subscribe(n<?>[] nVarArr, int i) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        AtomicReference<b> atomicReference = this.f69233d;
        for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
            nVarArr[i2].subscribe(observableWithLatestFromMany$WithLatestInnerObserverArr[i2]);
        }
    }
}
