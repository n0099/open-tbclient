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
public final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements g<T>, d, Runnable {
    public static final long serialVersionUID = -2365647875069161133L;
    public final c<? super e<T>> actual;
    public final int bufferSize;
    public long index;
    public final AtomicBoolean once;
    public d s;
    public final long size;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowExactSubscriber(c<? super e<T>> cVar, long j, int i) {
        super(1);
        this.actual = cVar;
        this.size = j;
        this.once = new AtomicBoolean();
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
        unicastProcessor.onNext(t);
        if (j2 == this.size) {
            this.index = 0L;
            this.window = null;
            unicastProcessor.onComplete();
            return;
        }
        this.index = j2;
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
            this.s.request(b.d(this.size, j));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.s.cancel();
        }
    }
}
