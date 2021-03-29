package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
/* loaded from: classes7.dex */
public final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements o<T> {
    public static final long serialVersionUID = 4109457741734051389L;
    public final o<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68061d;
    public final a onFinally;
    public f.a.x.c.b<T> qd;
    public boolean syncFused;

    public ObservableDoFinally$DoFinallyObserver(o<? super T> oVar, a aVar) {
        this.actual = oVar;
        this.onFinally = aVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        this.f68061d.dispose();
        runFinally();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public boolean isDisposed() {
        return this.f68061d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // f.a.o
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68061d, bVar)) {
            this.f68061d = bVar;
            if (bVar instanceof f.a.x.c.b) {
                this.qd = (f.a.x.c.b) bVar;
            }
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public T poll() throws Exception {
        T poll = this.qd.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.c
    public int requestFusion(int i) {
        f.a.x.c.b<T> bVar = this.qd;
        if (bVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i);
        if (requestFusion != 0) {
            this.syncFused = requestFusion == 1;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }
}
