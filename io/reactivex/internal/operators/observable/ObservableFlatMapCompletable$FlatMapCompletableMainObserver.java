package io.reactivex.internal.operators.observable;

import f.a.c;
import f.a.o;
import f.a.t.a;
import f.a.t.b;
import f.a.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements o<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public final o<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68062d;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final h<? super T, ? extends c> mapper;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final a set = new a();

    /* loaded from: classes7.dex */
    public final class InnerObserver extends AtomicReference<b> implements f.a.b, b {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        @Override // f.a.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.a.b
        public void onComplete() {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        @Override // f.a.b
        public void onError(Throwable th) {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerError(this, th);
        }

        @Override // f.a.b
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(o<? super T> oVar, h<? super T, ? extends c> hVar, boolean z) {
        this.actual = oVar;
        this.mapper = hVar;
        this.delayErrors = z;
        lazySet(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public void clear() {
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        this.disposed = true;
        this.f68062d.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
        this.set.c(innerObserver);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        onError(th);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public boolean isDisposed() {
        return this.f68062d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public boolean isEmpty() {
        return true;
    }

    @Override // f.a.o
    public void onComplete() {
        if (decrementAndGet() == 0) {
            Throwable terminate = this.errors.terminate();
            if (terminate != null) {
                this.actual.onError(terminate);
            } else {
                this.actual.onComplete();
            }
        }
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.actual.onError(this.errors.terminate());
                return;
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        try {
            c apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null CompletableSource");
            c cVar = apply;
            getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.disposed || !this.set.b(innerObserver)) {
                return;
            }
            cVar.a(innerObserver);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.f68062d.dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68062d, bVar)) {
            this.f68062d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.c
    public int requestFusion(int i) {
        return i & 2;
    }
}
