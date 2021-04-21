package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.d;
import f.b.x.e.c.j;
import f.b.x.f.a;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSequenceEqual$EqualCoordinator<T> extends AtomicInteger implements b {
    public static final long serialVersionUID = -6178010334400373240L;
    public final o<? super Boolean> actual;
    public volatile boolean cancelled;
    public final d<? super T, ? super T> comparer;
    public final n<? extends T> first;
    public final j<T>[] observers;
    public final ArrayCompositeDisposable resources;
    public final n<? extends T> second;
    public T v1;
    public T v2;

    public ObservableSequenceEqual$EqualCoordinator(o<? super Boolean> oVar, int i, n<? extends T> nVar, n<? extends T> nVar2, d<? super T, ? super T> dVar) {
        this.actual = oVar;
        this.first = nVar;
        this.second = nVar2;
        this.comparer = dVar;
        this.observers = r3;
        j<T>[] jVarArr = {new j<>(this, 0, i), new j<>(this, 1, i)};
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
            j<T>[] jVarArr = this.observers;
            jVarArr[0].f68658f.clear();
            jVarArr[1].f68658f.clear();
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
        j<T>[] jVarArr = this.observers;
        j<T> jVar = jVarArr[0];
        a<T> aVar = jVar.f68658f;
        j<T> jVar2 = jVarArr[1];
        a<T> aVar2 = jVar2.f68658f;
        int i = 1;
        while (!this.cancelled) {
            boolean z = jVar.f68660h;
            if (z && (th2 = jVar.i) != null) {
                cancel(aVar, aVar2);
                this.actual.onError(th2);
                return;
            }
            boolean z2 = jVar2.f68660h;
            if (z2 && (th = jVar2.i) != null) {
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
                this.actual.onNext(Boolean.TRUE);
                this.actual.onComplete();
                return;
            } else if (z && z2 && z3 != z4) {
                cancel(aVar, aVar2);
                this.actual.onNext(Boolean.FALSE);
                this.actual.onComplete();
                return;
            } else {
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.a((T) this.v1, (T) this.v2)) {
                            cancel(aVar, aVar2);
                            this.actual.onNext(Boolean.FALSE);
                            this.actual.onComplete();
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
        j<T>[] jVarArr = this.observers;
        this.first.subscribe(jVarArr[0]);
        this.second.subscribe(jVarArr[1]);
    }
}
