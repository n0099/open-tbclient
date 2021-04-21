package io.reactivex.internal.operators.observable;

import f.b.c;
import f.b.o;
import f.b.t.a;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements o<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public final o<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69215d;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final h<? super T, ? extends c> mapper;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final a set = new a();

    /* loaded from: classes7.dex */
    public final class InnerObserver extends AtomicReference<b> implements f.b.b, b {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        @Override // f.b.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.b.b
        public void onComplete() {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        @Override // f.b.b
        public void onError(Throwable th) {
            ObservableFlatMapCompletable$FlatMapCompletableMainObserver.this.innerError(this, th);
        }

        @Override // f.b.b
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

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public void clear() {
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        this.disposed = true;
        this.f69215d.dispose();
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

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public boolean isDisposed() {
        return this.f69215d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public boolean isEmpty() {
        return true;
    }

    @Override // f.b.o
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

    @Override // f.b.o
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
        f.b.a0.a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        try {
            c apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The mapper returned a null CompletableSource");
            c cVar = apply;
            getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.disposed || !this.set.b(innerObserver)) {
                return;
            }
            cVar.a(innerObserver);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.f69215d.dispose();
            onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69215d, bVar)) {
            this.f69215d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.c
    public int requestFusion(int i) {
        return i & 2;
    }
}
