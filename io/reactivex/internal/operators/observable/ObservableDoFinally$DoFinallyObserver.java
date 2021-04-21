package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.w.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
/* loaded from: classes7.dex */
public final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements o<T> {
    public static final long serialVersionUID = 4109457741734051389L;
    public final o<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69214d;
    public final a onFinally;
    public f.b.x.c.b<T> qd;
    public boolean syncFused;

    public ObservableDoFinally$DoFinallyObserver(o<? super T> oVar, a aVar) {
        this.actual = oVar;
        this.onFinally = aVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        this.f69214d.dispose();
        runFinally();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public boolean isDisposed() {
        return this.f69214d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // f.b.o
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.actual.onError(th);
        runFinally();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69214d, bVar)) {
            this.f69214d = bVar;
            if (bVar instanceof f.b.x.c.b) {
                this.qd = (f.b.x.c.b) bVar;
            }
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public T poll() throws Exception {
        T poll = this.qd.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.c
    public int requestFusion(int i) {
        f.b.x.c.b<T> bVar = this.qd;
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
                f.b.u.a.a(th);
                f.b.a0.a.f(th);
            }
        }
    }
}
