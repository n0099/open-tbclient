package io.reactivex.internal.operators.flowable;

import f.b.e;
import f.b.g;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableWindow$WindowSkipSubscriber<T> extends AtomicInteger implements g<T>, d, Runnable {
    public static final long serialVersionUID = -8792836352386833856L;
    public final c<? super e<T>> actual;
    public final int bufferSize;
    public final AtomicBoolean firstRequest;
    public long index;
    public final AtomicBoolean once;
    public d s;
    public final long size;
    public final long skip;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowSkipSubscriber(c<? super e<T>> cVar, long j, long j2, int i) {
        super(1);
        this.actual = cVar;
        this.size = j;
        this.skip = j2;
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.bufferSize = i;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // g.d.c
    public void onComplete() {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(th);
        }
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        long j = this.index;
        UnicastProcessor<T> unicastProcessor = this.window;
        if (j == 0) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.f(this.bufferSize, this);
            this.window = unicastProcessor;
            this.actual.onNext(unicastProcessor);
        }
        long j2 = j + 1;
        if (unicastProcessor != null) {
            unicastProcessor.onNext(t);
        }
        if (j2 == this.size) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        if (j2 == this.skip) {
            this.index = 0L;
        } else {
            this.index = j2;
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                this.s.request(b.c(b.d(this.size, j), b.d(this.skip - this.size, j - 1)));
                return;
            }
            this.s.request(b.d(this.skip, j));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.s.cancel();
        }
    }
}
