package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.r;
import f.b.t.b;
import f.b.w.d;
import f.b.x.e.c.k;
import f.b.x.f.a;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b {
    public static final long serialVersionUID = -6178010334400373240L;
    public final r<? super Boolean> actual;
    public volatile boolean cancelled;
    public final d<? super T, ? super T> comparer;
    public final n<? extends T> first;
    public final k<T>[] observers;
    public final ArrayCompositeDisposable resources;
    public final n<? extends T> second;
    public T v1;
    public T v2;

    public ObservableSequenceEqualSingle$EqualCoordinator(r<? super Boolean> rVar, int i, n<? extends T> nVar, n<? extends T> nVar2, d<? super T, ? super T> dVar) {
        this.actual = rVar;
        this.first = nVar;
        this.second = nVar2;
        this.comparer = dVar;
        this.observers = r3;
        k<T>[] kVarArr = {new k<>(this, 0, i), new k<>(this, 1, i)};
        this.resources = new ArrayCompositeDisposable(2);
    }

    public void cancel(a<T> aVar, a<T> aVar2) {
        this.cancelled = true;
        aVar.clear();
        aVar2.clear();
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() == 0) {
            k<T>[] kVarArr = this.observers;
            kVarArr[0].f68662f.clear();
            kVarArr[1].f68662f.clear();
        }
    }

    /* JADX DEBUG: Type inference failed for r11v0. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r8v1. Raw type applied. Possible types: T, ? super T */
    public void drain() {
        Throwable th;
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        k<T>[] kVarArr = this.observers;
        k<T> kVar = kVarArr[0];
        a<T> aVar = kVar.f68662f;
        k<T> kVar2 = kVarArr[1];
        a<T> aVar2 = kVar2.f68662f;
        int i = 1;
        while (!this.cancelled) {
            boolean z = kVar.f68664h;
            if (z && (th2 = kVar.i) != null) {
                cancel(aVar, aVar2);
                this.actual.onError(th2);
                return;
            }
            boolean z2 = kVar2.f68664h;
            if (z2 && (th = kVar2.i) != null) {
                cancel(aVar, aVar2);
                this.actual.onError(th);
                return;
            }
            if (this.v1 == null) {
                this.v1 = aVar.poll();
            }
            boolean z3 = this.v1 == null;
            if (this.v2 == null) {
                this.v2 = aVar2.poll();
            }
            boolean z4 = this.v2 == null;
            if (z && z2 && z3 && z4) {
                this.actual.onSuccess(Boolean.TRUE);
                return;
            } else if (z && z2 && z3 != z4) {
                cancel(aVar, aVar2);
                this.actual.onSuccess(Boolean.FALSE);
                return;
            } else {
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.a((T) this.v1, (T) this.v2)) {
                            cancel(aVar, aVar2);
                            this.actual.onSuccess(Boolean.FALSE);
                            return;
                        }
                        this.v1 = null;
                        this.v2 = null;
                    } catch (Throwable th3) {
                        f.b.u.a.a(th3);
                        cancel(aVar, aVar2);
                        this.actual.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
        aVar.clear();
        aVar2.clear();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(b bVar, int i) {
        return this.resources.setResource(i, bVar);
    }

    public void subscribe() {
        k<T>[] kVarArr = this.observers;
        this.first.subscribe(kVarArr[0]);
        this.second.subscribe(kVarArr[1]);
    }
}
