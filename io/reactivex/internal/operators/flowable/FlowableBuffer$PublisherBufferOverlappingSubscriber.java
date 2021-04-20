package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.e;
import f.b.x.i.b;
import f.b.x.i.i;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements g<T>, d, e {
    public static final long serialVersionUID = -7370244972039324525L;
    public final c<? super C> actual;
    public final Callable<C> bufferSupplier;
    public volatile boolean cancelled;
    public boolean done;
    public int index;
    public long produced;
    public d s;
    public final int size;
    public final int skip;
    public final AtomicBoolean once = new AtomicBoolean();
    public final ArrayDeque<C> buffers = new ArrayDeque<>();

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(c<? super C> cVar, int i, int i2, Callable<C> callable) {
        this.actual = cVar;
        this.size = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
    }

    @Override // f.b.w.e
    public boolean getAsBoolean() {
        return this.cancelled;
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        long j = this.produced;
        if (j != 0) {
            b.e(this, j);
        }
        i.c(this.actual, this.buffers, this, this);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        ArrayDeque<C> arrayDeque = this.buffers;
        int i = this.index;
        int i2 = i + 1;
        if (i == 0) {
            try {
                C call = this.bufferSupplier.call();
                f.b.x.b.a.b(call, "The bufferSupplier returned a null buffer");
                arrayDeque.offer(call);
            } catch (Throwable th) {
                f.b.u.a.a(th);
                cancel();
                onError(th);
                return;
            }
        }
        C peek = arrayDeque.peek();
        if (peek != null && peek.size() + 1 == this.size) {
            arrayDeque.poll();
            peek.add(t);
            this.produced++;
            this.actual.onNext(peek);
        }
        Iterator<C> it = arrayDeque.iterator();
        while (it.hasNext()) {
            it.next().add(t);
        }
        if (i2 == this.skip) {
            i2 = 0;
        }
        this.index = i2;
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
        if (!SubscriptionHelper.validate(j) || i.e(j, this.actual, this.buffers, this, this)) {
            return;
        }
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.s.request(b.c(this.size, b.d(this.skip, j - 1)));
            return;
        }
        this.s.request(b.d(this.skip, j));
    }
}
