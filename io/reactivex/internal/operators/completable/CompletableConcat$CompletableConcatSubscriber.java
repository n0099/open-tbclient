package io.reactivex.internal.operators.completable;

import f.b.c;
import f.b.e;
import f.b.g;
import f.b.t.b;
import f.b.u.a;
import f.b.x.c.f;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements g<c>, b {
    public static final long serialVersionUID = 9032184911934499404L;
    public volatile boolean active;
    public final f.b.b actual;
    public int consumed;
    public volatile boolean done;
    public final int limit;
    public final int prefetch;
    public f<c> queue;
    public d s;
    public int sourceFused;
    public final ConcatInnerObserver inner = new ConcatInnerObserver(this);
    public final AtomicBoolean once = new AtomicBoolean();

    /* loaded from: classes7.dex */
    public static final class ConcatInnerObserver extends AtomicReference<b> implements f.b.b {
        public static final long serialVersionUID = -5454794857847146511L;
        public final CompletableConcat$CompletableConcatSubscriber parent;

        public ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber completableConcat$CompletableConcatSubscriber) {
            this.parent = completableConcat$CompletableConcatSubscriber;
        }

        @Override // f.b.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // f.b.b
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // f.b.b
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public CompletableConcat$CompletableConcatSubscriber(f.b.b bVar, int i) {
        this.actual = bVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // f.b.t.b
    public void dispose() {
        this.s.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!isDisposed()) {
            if (!this.active) {
                boolean z = this.done;
                try {
                    c poll = this.queue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        if (this.once.compareAndSet(false, true)) {
                            this.actual.onComplete();
                            return;
                        }
                        return;
                    } else if (!z2) {
                        this.active = true;
                        poll.a(this.inner);
                        request();
                    }
                } catch (Throwable th) {
                    a.a(th);
                    innerError(th);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th) {
        if (this.once.compareAndSet(false, true)) {
            this.s.cancel();
            this.actual.onError(th);
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.inner.get());
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.inner);
            this.actual.onError(th);
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            int i = this.prefetch;
            long j = i == Integer.MAX_VALUE ? Long.MAX_VALUE : i;
            if (dVar instanceof f.b.x.c.d) {
                f.b.x.c.d dVar2 = (f.b.x.c.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceFused = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceFused = requestFusion;
                    this.queue = dVar2;
                    this.actual.onSubscribe(this);
                    dVar.request(j);
                    return;
                }
            }
            if (this.prefetch == Integer.MAX_VALUE) {
                this.queue = new f.b.x.f.a(e.a());
            } else {
                this.queue = new SpscArrayQueue(this.prefetch);
            }
            this.actual.onSubscribe(this);
            dVar.request(j);
        }
    }

    public void request() {
        if (this.sourceFused != 1) {
            int i = this.consumed + 1;
            if (i == this.limit) {
                this.consumed = 0;
                this.s.request(i);
                return;
            }
            this.consumed = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // g.d.c
    public void onNext(c cVar) {
        if (this.sourceFused == 0 && !this.queue.offer(cVar)) {
            onError(new MissingBackpressureException());
        } else {
            drain();
        }
    }
}
