package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -5616169793639412593L;
    public final c<? super C> actual;
    public C buffer;
    public final Callable<C> bufferSupplier;
    public boolean done;
    public int index;
    public d s;
    public final int size;
    public final int skip;

    public FlowableBuffer$PublisherBufferSkipSubscriber(c<? super C> cVar, int i, int i2, Callable<C> callable) {
        this.actual = cVar;
        this.size = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        C c2 = this.buffer;
        this.buffer = null;
        if (c2 != null) {
            this.actual.onNext(c2);
        }
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        C c2 = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        if (i == 0) {
            try {
                C call = this.bufferSupplier.call();
                f.a.x.b.a.b(call, "The bufferSupplier returned a null buffer");
                c2 = call;
                this.buffer = c2;
            } catch (Throwable th) {
                f.a.u.a.a(th);
                cancel();
                onError(th);
                return;
            }
        }
        if (c2 != null) {
            c2.add(t);
            if (c2.size() == this.size) {
                this.buffer = null;
                this.actual.onNext(c2);
            }
        }
        if (i2 == this.skip) {
            i2 = 0;
        }
        this.index = i2;
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.s.request(b.c(b.d(j, this.size), b.d(this.skip - this.size, j - 1)));
                return;
            }
            this.s.request(b.d(this.skip, j));
        }
    }
}
