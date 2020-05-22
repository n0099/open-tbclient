package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.i;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends io.reactivex.internal.operators.flowable.a<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    @Override // io.reactivex.g
    public void a(org.a.c<? super C> cVar) {
        if (this.size == this.skip) {
            this.nmU.a((j) new a(cVar, this.size, this.bufferSupplier));
        } else if (this.skip > this.size) {
            this.nmU.a((j) new PublisherBufferSkipSubscriber(cVar, this.size, this.skip, this.bufferSupplier));
        } else {
            this.nmU.a((j) new PublisherBufferOverlappingSubscriber(cVar, this.size, this.skip, this.bufferSupplier));
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T, C extends Collection<? super T>> implements j<T>, org.a.d {
        final org.a.c<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;
        org.a.d s;
        final int size;

        a(org.a.c<? super C> cVar, int i, Callable<C> callable) {
            this.actual = cVar;
            this.size = i;
            this.bufferSupplier = callable;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.s.request(io.reactivex.internal.util.b.N(j, this.size));
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                C c = this.buffer;
                if (c == null) {
                    try {
                        c = (C) io.reactivex.internal.functions.a.k(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                        this.buffer = c;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                c.add(t);
                int i = this.index + 1;
                if (i == this.size) {
                    this.index = 0;
                    this.buffer = null;
                    this.actual.onNext(c);
                    return;
                }
                this.index = i;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.buffer;
                if (c != null && !c.isEmpty()) {
                    this.actual.onNext(c);
                }
                this.actual.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -5616169793639412593L;
        final org.a.c<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;
        org.a.d s;
        final int size;
        final int skip;

        PublisherBufferSkipSubscriber(org.a.c<? super C> cVar, int i, int i2, Callable<C> callable) {
            this.actual = cVar;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.s.request(io.reactivex.internal.util.b.M(io.reactivex.internal.util.b.N(j, this.size), io.reactivex.internal.util.b.N(this.skip - this.size, j - 1)));
                    return;
                }
                this.s.request(io.reactivex.internal.util.b.N(this.skip, j));
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                C c = this.buffer;
                int i = this.index;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        c = (C) io.reactivex.internal.functions.a.k(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                        this.buffer = c;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                if (c != null) {
                    c.add(t);
                    if (c.size() == this.size) {
                        this.buffer = null;
                        this.actual.onNext(c);
                    }
                }
                this.index = i2 == this.skip ? 0 : i2;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.buffer;
                this.buffer = null;
                if (c != null) {
                    this.actual.onNext(c);
                }
                this.actual.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements io.reactivex.c.e, j<T>, org.a.d {
        private static final long serialVersionUID = -7370244972039324525L;
        final org.a.c<? super C> actual;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        int index;
        long produced;
        org.a.d s;
        final int size;
        final int skip;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        PublisherBufferOverlappingSubscriber(org.a.c<? super C> cVar, int i, int i2, Callable<C> callable) {
            this.actual = cVar;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.c.e
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && !i.a(j, this.actual, this.buffers, this, this)) {
                if (!this.once.get() && this.once.compareAndSet(false, true)) {
                    this.s.request(io.reactivex.internal.util.b.M(this.size, io.reactivex.internal.util.b.N(this.skip, j - 1)));
                    return;
                }
                this.s.request(io.reactivex.internal.util.b.N(this.skip, j));
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayDeque<C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                ArrayDeque<C> arrayDeque = this.buffers;
                int i = this.index;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        arrayDeque.offer((Collection) io.reactivex.internal.functions.a.k(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.L(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.size) {
                    arrayDeque.poll();
                    collection.add(t);
                    this.produced++;
                    this.actual.onNext(collection);
                }
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t);
                }
                this.index = i2 == this.skip ? 0 : i2;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                long j = this.produced;
                if (j != 0) {
                    io.reactivex.internal.util.b.c(this, j);
                }
                i.a(this.actual, this.buffers, this, this);
            }
        }
    }
}
