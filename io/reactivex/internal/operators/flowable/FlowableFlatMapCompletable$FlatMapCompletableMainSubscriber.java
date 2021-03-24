package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.t.a;
import f.a.t.b;
import f.a.w.h;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements g<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final h<? super T, ? extends f.a.c> mapper;
    public final int maxConcurrency;
    public d s;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final a set = new a();

    /* loaded from: classes7.dex */
    public final class InnerConsumer extends AtomicReference<b> implements f.a.b, b {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerConsumer() {
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
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        @Override // f.a.b
        public void onError(Throwable th) {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th);
        }

        @Override // f.a.b
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(c<? super T> cVar, h<? super T, ? extends f.a.c> hVar, boolean z, int i) {
        this.actual = cVar;
        this.mapper = hVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
        lazySet(1);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
        this.set.dispose();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
        this.set.c(innerConsumer);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
        this.set.c(innerConsumer);
        onError(th);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        return true;
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
            cancel();
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
            f.a.c apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null CompletableSource");
            f.a.c cVar = apply;
            getAndIncrement();
            InnerConsumer innerConsumer = new InnerConsumer();
            if (this.cancelled || !this.set.b(innerConsumer)) {
                return;
            }
            cVar.a(innerConsumer);
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public int requestFusion(int i) {
        return i & 2;
    }
}
