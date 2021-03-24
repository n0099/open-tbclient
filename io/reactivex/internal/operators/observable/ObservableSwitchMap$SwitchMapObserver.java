package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements o<T>, b {
    public static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED;
    public static final long serialVersionUID = -3491074160481096299L;
    public final o<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final h<? super T, ? extends n<? extends R>> mapper;
    public b s;
    public volatile long unique;
    public final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
    public final AtomicThrowable errors = new AtomicThrowable();

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver = new ObservableSwitchMap$SwitchMapInnerObserver<>(null, -1L, 1);
        CANCELLED = observableSwitchMap$SwitchMapInnerObserver;
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(o<? super R> oVar, h<? super T, ? extends n<? extends R>> hVar, int i, boolean z) {
        this.actual = oVar;
        this.mapper = hVar;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.dispose();
        disposeInner();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver2 = this.active.get();
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver3 = CANCELLED;
        if (observableSwitchMap$SwitchMapInnerObserver2 == observableSwitchMap$SwitchMapInnerObserver3 || (observableSwitchMap$SwitchMapInnerObserver = (ObservableSwitchMap$SwitchMapInnerObserver) this.active.getAndSet(observableSwitchMap$SwitchMapInnerObserver3)) == CANCELLED || observableSwitchMap$SwitchMapInnerObserver == null) {
            return;
        }
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x000b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        o<? super R> oVar = this.actual;
        int i = 1;
        while (!this.cancelled) {
            boolean z = false;
            if (this.done) {
                boolean z2 = this.active.get() == null;
                if (this.delayErrors) {
                    if (z2) {
                        Throwable th = this.errors.get();
                        if (th != null) {
                            oVar.onError(th);
                            return;
                        } else {
                            oVar.onComplete();
                            return;
                        }
                    }
                } else if (this.errors.get() != null) {
                    oVar.onError(this.errors.terminate());
                    return;
                } else if (z2) {
                    oVar.onComplete();
                    return;
                }
            }
            ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver = this.active.get();
            if (observableSwitchMap$SwitchMapInnerObserver != null) {
                a<R> aVar = observableSwitchMap$SwitchMapInnerObserver.queue;
                if (observableSwitchMap$SwitchMapInnerObserver.done) {
                    boolean isEmpty = aVar.isEmpty();
                    if (this.delayErrors) {
                        if (isEmpty) {
                            this.active.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                        }
                    } else if (this.errors.get() != null) {
                        oVar.onError(this.errors.terminate());
                        return;
                    } else if (isEmpty) {
                        this.active.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                    }
                }
                while (!this.cancelled) {
                    if (observableSwitchMap$SwitchMapInnerObserver == this.active.get()) {
                        if (!this.delayErrors && this.errors.get() != null) {
                            oVar.onError(this.errors.terminate());
                            return;
                        }
                        boolean z3 = observableSwitchMap$SwitchMapInnerObserver.done;
                        Object obj = (R) aVar.poll();
                        boolean z4 = obj == null;
                        if (z3 && z4) {
                            this.active.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                        } else if (!z4) {
                            oVar.onNext(obj);
                        } else if (!z) {
                            continue;
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver, Throwable th) {
        if (observableSwitchMap$SwitchMapInnerObserver.index == this.unique && this.errors.addThrowable(th)) {
            if (!this.delayErrors) {
                this.s.dispose();
            }
            observableSwitchMap$SwitchMapInnerObserver.done = true;
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (!this.done && this.errors.addThrowable(th)) {
            this.done = true;
            drain();
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver;
        long j = this.unique + 1;
        this.unique = j;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver2 = this.active.get();
        if (observableSwitchMap$SwitchMapInnerObserver2 != null) {
            observableSwitchMap$SwitchMapInnerObserver2.cancel();
        }
        try {
            n<? extends R> apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The ObservableSource returned is null");
            n<? extends R> nVar = apply;
            ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver3 = new ObservableSwitchMap$SwitchMapInnerObserver<>(this, j, this.bufferSize);
            do {
                observableSwitchMap$SwitchMapInnerObserver = this.active.get();
                if (observableSwitchMap$SwitchMapInnerObserver == CANCELLED) {
                    return;
                }
            } while (!this.active.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, observableSwitchMap$SwitchMapInnerObserver3));
            nVar.subscribe(observableSwitchMap$SwitchMapInnerObserver3);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.s.dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
