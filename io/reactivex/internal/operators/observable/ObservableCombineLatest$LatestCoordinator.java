package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.f.a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements b {
    public static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final o<? super R> actual;
    public volatile boolean cancelled;
    public final h<? super Object[], ? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicThrowable errors = new AtomicThrowable();
    public Object[] latest;
    public final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    public final a<Object[]> queue;

    public ObservableCombineLatest$LatestCoordinator(o<? super R> oVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
        this.actual = oVar;
        this.combiner = hVar;
        this.delayError = z;
        this.latest = new Object[i];
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = new ObservableCombineLatest$CombinerObserver[i];
        for (int i3 = 0; i3 < i; i3++) {
            observableCombineLatest$CombinerObserverArr[i3] = new ObservableCombineLatest$CombinerObserver<>(this, i3);
        }
        this.observers = observableCombineLatest$CombinerObserverArr;
        this.queue = new a<>(i2);
    }

    public void cancelSources() {
        for (ObservableCombineLatest$CombinerObserver<T, R> observableCombineLatest$CombinerObserver : this.observers) {
            observableCombineLatest$CombinerObserver.dispose();
        }
    }

    public void clear(a<?> aVar) {
        synchronized (this) {
            this.latest = null;
        }
        aVar.clear();
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
            clear(this.queue);
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        a<Object[]> aVar = this.queue;
        o<? super R> oVar = this.actual;
        boolean z = this.delayError;
        int i = 1;
        while (!this.cancelled) {
            if (!z && this.errors.get() != null) {
                cancelSources();
                clear(aVar);
                oVar.onError(this.errors.terminate());
                return;
            }
            boolean z2 = this.done;
            Object[] poll = aVar.poll();
            boolean z3 = poll == null;
            if (z2 && z3) {
                clear(aVar);
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    oVar.onComplete();
                    return;
                } else {
                    oVar.onError(terminate);
                    return;
                }
            } else if (z3) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                try {
                    Object obj = (R) this.combiner.apply(poll);
                    f.b.x.b.a.b(obj, "The combiner returned a null value");
                    oVar.onNext(obj);
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    this.errors.addThrowable(th);
                    cancelSources();
                    clear(aVar);
                    oVar.onError(this.errors.terminate());
                    return;
                }
            }
        }
        clear(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r2 == r0.length) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void innerComplete(int i) {
        synchronized (this) {
            Object[] objArr = this.latest;
            if (objArr == null) {
                return;
            }
            boolean z = objArr[i] == null;
            if (!z) {
                int i2 = this.complete + 1;
                this.complete = i2;
            }
            this.done = true;
            if (z) {
                cancelSources();
            }
            drain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (r1 == r4.length) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void innerError(int i, Throwable th) {
        if (this.errors.addThrowable(th)) {
            boolean z = true;
            if (this.delayError) {
                synchronized (this) {
                    Object[] objArr = this.latest;
                    if (objArr == null) {
                        return;
                    }
                    boolean z2 = objArr[i] == null;
                    if (!z2) {
                        int i2 = this.complete + 1;
                        this.complete = i2;
                    }
                    this.done = true;
                    z = z2;
                }
            }
            if (z) {
                cancelSources();
            }
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: f.b.x.f.a<java.lang.Object[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void innerNext(int i, T t) {
        boolean z;
        synchronized (this) {
            Object[] objArr = this.latest;
            if (objArr == null) {
                return;
            }
            Object obj = objArr[i];
            int i2 = this.active;
            if (obj == null) {
                i2++;
                this.active = i2;
            }
            objArr[i] = t;
            if (i2 == objArr.length) {
                this.queue.offer(objArr.clone());
                z = true;
            } else {
                z = false;
            }
            if (z) {
                drain();
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(n<? extends T>[] nVarArr) {
        ObservableCombineLatest$CombinerObserver<T, R>[] observableCombineLatest$CombinerObserverArr = this.observers;
        int length = observableCombineLatest$CombinerObserverArr.length;
        this.actual.onSubscribe(this);
        for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
            nVarArr[i].subscribe(observableCombineLatest$CombinerObserverArr[i]);
        }
    }
}
