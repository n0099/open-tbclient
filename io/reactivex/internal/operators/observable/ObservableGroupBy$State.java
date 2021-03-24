package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.x.f.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableGroupBy$State<T, K> extends AtomicInteger implements b, n<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    public final a<T> queue;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicReference<o<? super T>> actual = new AtomicReference<>();

    public ObservableGroupBy$State(int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k, boolean z) {
        this.queue = new a<>(i);
        this.parent = observableGroupBy$GroupByObserver;
        this.key = k;
        this.delayError = z;
    }

    public boolean checkTerminated(boolean z, boolean z2, o<? super T> oVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error;
                    this.actual.lazySet(null);
                    if (th != null) {
                        oVar.onError(th);
                    } else {
                        oVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                oVar.onError(th2);
                return true;
            } else if (z2) {
                this.actual.lazySet(null);
                oVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        a<T> aVar = this.queue;
        boolean z = this.delayError;
        o<? super T> oVar = this.actual.get();
        int i = 1;
        while (true) {
            if (oVar != null) {
                while (true) {
                    boolean z2 = this.done;
                    Object obj = (T) aVar.poll();
                    boolean z3 = obj == null;
                    if (checkTerminated(z2, z3, oVar, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    oVar.onNext(obj);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (oVar == null) {
                oVar = this.actual.get();
            }
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        drain();
    }

    @Override // f.a.n
    public void subscribe(o<? super T> oVar) {
        if (this.once.compareAndSet(false, true)) {
            oVar.onSubscribe(this);
            this.actual.lazySet(oVar);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), oVar);
    }
}
