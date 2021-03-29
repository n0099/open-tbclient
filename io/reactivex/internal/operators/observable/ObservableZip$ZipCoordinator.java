package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import f.a.x.e.c.n;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableZip$ZipCoordinator<T, R> extends AtomicInteger implements b {
    public static final long serialVersionUID = 2983708048395377667L;
    public final o<? super R> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public final n<T, R>[] observers;
    public final T[] row;
    public final h<? super Object[], ? extends R> zipper;

    public ObservableZip$ZipCoordinator(o<? super R> oVar, h<? super Object[], ? extends R> hVar, int i, boolean z) {
        this.actual = oVar;
        this.zipper = hVar;
        this.observers = new n[i];
        this.row = (T[]) new Object[i];
        this.delayError = z;
    }

    public void cancel() {
        clear();
        cancelSources();
    }

    public void cancelSources() {
        for (n<T, R> nVar : this.observers) {
            nVar.a();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, o<? super R> oVar, boolean z3, n<?, ?> nVar) {
        if (this.cancelled) {
            cancel();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = nVar.f67518h;
                    cancel();
                    if (th != null) {
                        oVar.onError(th);
                    } else {
                        oVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = nVar.f67518h;
            if (th2 != null) {
                cancel();
                oVar.onError(th2);
                return true;
            } else if (z2) {
                cancel();
                oVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void clear() {
        for (n<T, R> nVar : this.observers) {
            nVar.f67516f.clear();
        }
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
            clear();
        }
    }

    public void drain() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        n<T, R>[] nVarArr = this.observers;
        o<? super R> oVar = this.actual;
        T[] tArr = this.row;
        boolean z = this.delayError;
        int i = 1;
        while (true) {
            int i2 = 0;
            int i3 = 0;
            for (n<T, R> nVar : nVarArr) {
                if (tArr[i3] == null) {
                    boolean z2 = nVar.f67517g;
                    T poll = nVar.f67516f.poll();
                    boolean z3 = poll == null;
                    if (checkTerminated(z2, z3, oVar, z, nVar)) {
                        return;
                    }
                    if (z3) {
                        i2++;
                    } else {
                        tArr[i3] = poll;
                    }
                } else if (nVar.f67517g && !z && (th = nVar.f67518h) != null) {
                    cancel();
                    oVar.onError(th);
                    return;
                }
                i3++;
            }
            if (i2 != 0) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                try {
                    Object obj = (R) this.zipper.apply(tArr.clone());
                    a.b(obj, "The zipper returned a null value");
                    oVar.onNext(obj);
                    Arrays.fill(tArr, (Object) null);
                } catch (Throwable th2) {
                    f.a.u.a.a(th2);
                    cancel();
                    oVar.onError(th2);
                    return;
                }
            }
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(f.a.n<? extends T>[] nVarArr, int i) {
        n<T, R>[] nVarArr2 = this.observers;
        int length = nVarArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            nVarArr2[i2] = new n<>(this, i);
        }
        lazySet(0);
        this.actual.onSubscribe(this);
        for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
            nVarArr[i3].subscribe(nVarArr2[i3]);
        }
    }
}
