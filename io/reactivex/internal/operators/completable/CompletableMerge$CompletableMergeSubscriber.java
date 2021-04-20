package io.reactivex.internal.operators.completable;

import f.b.c;
import f.b.g;
import f.b.t.a;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements g<c>, b {
    public static final long serialVersionUID = -2108443387387077490L;
    public final f.b.b actual;
    public final boolean delayErrors;
    public final int maxConcurrency;
    public d s;
    public final a set = new a();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes7.dex */
    public final class MergeInnerObserver extends AtomicReference<b> implements f.b.b, b {
        public static final long serialVersionUID = 251330541679988317L;

        public MergeInnerObserver() {
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
            CompletableMerge$CompletableMergeSubscriber.this.innerComplete(this);
        }

        @Override // f.b.b
        public void onError(Throwable th) {
            CompletableMerge$CompletableMergeSubscriber.this.innerError(this, th);
        }

        @Override // f.b.b
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public CompletableMerge$CompletableMergeSubscriber(f.b.b bVar, int i, boolean z) {
        this.actual = bVar;
        this.maxConcurrency = i;
        this.delayErrors = z;
        lazySet(1);
    }

    @Override // f.b.t.b
    public void dispose() {
        this.s.cancel();
        this.set.dispose();
    }

    public void innerComplete(MergeInnerObserver mergeInnerObserver) {
        this.set.c(mergeInnerObserver);
        if (decrementAndGet() == 0) {
            Throwable th = this.error.get();
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onComplete();
            }
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.s.request(1L);
        }
    }

    public void innerError(MergeInnerObserver mergeInnerObserver, Throwable th) {
        this.set.c(mergeInnerObserver);
        if (!this.delayErrors) {
            this.s.cancel();
            this.set.dispose();
            if (this.error.addThrowable(th)) {
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.error.terminate());
                    return;
                }
                return;
            }
            f.b.a0.a.f(th);
        } else if (this.error.addThrowable(th)) {
            if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    @Override // g.d.c
    public void onComplete() {
        if (decrementAndGet() == 0) {
            if (this.error.get() != null) {
                this.actual.onError(this.error.terminate());
            } else {
                this.actual.onComplete();
            }
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (!this.delayErrors) {
            this.set.dispose();
            if (this.error.addThrowable(th)) {
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.error.terminate());
                    return;
                }
                return;
            }
            f.b.a0.a.f(th);
        } else if (this.error.addThrowable(th)) {
            if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            }
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.g, g.d.c
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // g.d.c
    public void onNext(c cVar) {
        getAndIncrement();
        MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
        this.set.b(mergeInnerObserver);
        cVar.a(mergeInnerObserver);
    }
}
