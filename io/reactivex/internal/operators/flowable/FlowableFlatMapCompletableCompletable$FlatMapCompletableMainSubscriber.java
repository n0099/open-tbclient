package io.reactivex.internal.operators.flowable;

import f.a.c;
import f.a.g;
import f.a.t.a;
import f.a.t.b;
import f.a.w.h;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements g<T>, b {
    public static final long serialVersionUID = 8443155186132538303L;
    public final f.a.b actual;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final h<? super T, ? extends c> mapper;
    public final int maxConcurrency;
    public d s;
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
            FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        @Override // f.a.b
        public void onError(Throwable th) {
            FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th);
        }

        @Override // f.a.b
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber(f.a.b bVar, h<? super T, ? extends c> hVar, boolean z, int i) {
        this.actual = bVar;
        this.mapper = hVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
        lazySet(1);
    }

    @Override // f.a.t.b
    public void dispose() {
        this.disposed = true;
        this.s.cancel();
        this.set.dispose();
    }

    public void innerComplete(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
        this.set.c(innerObserver);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        onError(th);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    @Override // g.d.c
    public void onComplete() {
        if (decrementAndGet() == 0) {
            Throwable terminate = this.errors.terminate();
            if (terminate != null) {
                this.actual.onError(terminate);
            } else {
                this.actual.onComplete();
            }
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.s.request(1L);
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                    return;
                } else {
                    return;
                }
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

    @Override // g.d.c
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
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            if (i == Integer.MAX_VALUE) {
                dVar.request(Long.MAX_VALUE);
            } else {
                dVar.request(i);
            }
        }
    }
}
