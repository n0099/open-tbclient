package io.reactivex.internal.operators.observable;

import f.b.c;
import f.b.o;
import f.b.t.a;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T> extends AtomicInteger implements b, o<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public final f.b.b actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69069d;
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
            ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver.this.innerComplete(this);
        }

        @Override // f.b.b
        public void onError(Throwable th) {
            ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver.this.innerError(this, th);
        }

        @Override // f.b.b
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(f.b.b bVar, h<? super T, ? extends c> hVar, boolean z) {
        this.actual = bVar;
        this.mapper = hVar;
        this.delayErrors = z;
        lazySet(1);
    }

    @Override // f.b.t.b
    public void dispose() {
        this.disposed = true;
        this.f69069d.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
        this.set.c(innerObserver);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        onError(th);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69069d.isDisposed();
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
            this.f69069d.dispose();
            onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69069d, bVar)) {
            this.f69069d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
