package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class FlowableFlattenIterable<T, R> extends a<T, R> {
    final h<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> cVar) {
        if (this.pMK instanceof Callable) {
            try {
                Object call = ((Callable) this.pMK).call();
                if (call == null) {
                    EmptySubscription.complete(cVar);
                    return;
                }
                try {
                    FlowableFromIterable.a(cVar, this.mapper.apply(call).iterator());
                    return;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    EmptySubscription.error(th, cVar);
                    return;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                EmptySubscription.error(th2, cVar);
                return;
            }
        }
        this.pMK.a((j) new FlattenIterableSubscriber(cVar, this.mapper, this.prefetch));
    }

    /* loaded from: classes17.dex */
    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements j<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        int fusionMode;
        final int limit;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        io.reactivex.internal.a.g<T> queue;
        org.a.d s;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        FlattenIterableSubscriber(org.a.c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar, int i) {
            this.actual = cVar;
            this.mapper = hVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = dVar2;
                        this.actual.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode == 0 && !this.queue.offer(t)) {
                    onError(new MissingBackpressureException("Queue is full?!"));
                } else {
                    drain();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.done && ExceptionHelper.addThrowable(this.error, th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00ea A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0006 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            Iterator<? extends R> it;
            int addAndGet;
            long j;
            if (getAndIncrement() == 0) {
                org.a.c<?> cVar = this.actual;
                io.reactivex.internal.a.g<T> gVar = this.queue;
                boolean z = this.fusionMode != 1;
                Iterator<? extends R> it2 = this.current;
                int i = 1;
                while (true) {
                    if (it2 == null) {
                        boolean z2 = this.done;
                        try {
                            T poll = gVar.poll();
                            if (!checkTerminated(z2, poll == null, cVar, gVar)) {
                                if (poll != null) {
                                    try {
                                        it = this.mapper.apply(poll).iterator();
                                        if (!it.hasNext()) {
                                            it2 = null;
                                            consumedOne(z);
                                        } else {
                                            this.current = it;
                                            if (it == null) {
                                                long j2 = this.requested.get();
                                                long j3 = 0;
                                                while (true) {
                                                    if (j3 == j2) {
                                                        j = j3;
                                                        it2 = it;
                                                        break;
                                                    } else if (!checkTerminated(this.done, false, cVar, gVar)) {
                                                        try {
                                                            cVar.onNext((Object) io.reactivex.internal.functions.a.l(it.next(), "The iterator returned a null value"));
                                                            if (!checkTerminated(this.done, false, cVar, gVar)) {
                                                                j3++;
                                                                try {
                                                                    if (!it.hasNext()) {
                                                                        consumedOne(z);
                                                                        this.current = null;
                                                                        j = j3;
                                                                        it2 = null;
                                                                        break;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    io.reactivex.exceptions.a.J(th);
                                                                    this.current = null;
                                                                    this.s.cancel();
                                                                    ExceptionHelper.addThrowable(this.error, th);
                                                                    cVar.onError(ExceptionHelper.terminate(this.error));
                                                                    return;
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        } catch (Throwable th2) {
                                                            io.reactivex.exceptions.a.J(th2);
                                                            this.current = null;
                                                            this.s.cancel();
                                                            ExceptionHelper.addThrowable(this.error, th2);
                                                            cVar.onError(ExceptionHelper.terminate(this.error));
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                if (j == j2) {
                                                    if (checkTerminated(this.done, gVar.isEmpty() && it2 == null, cVar, gVar)) {
                                                        return;
                                                    }
                                                }
                                                if (j != 0 && j2 != Long.MAX_VALUE) {
                                                    this.requested.addAndGet(-j);
                                                }
                                                if (it2 != null) {
                                                    it = it2;
                                                } else {
                                                    continue;
                                                }
                                            }
                                            addAndGet = addAndGet(-i);
                                            if (addAndGet != 0) {
                                                return;
                                            }
                                            i = addAndGet;
                                            it2 = it;
                                        }
                                    } catch (Throwable th3) {
                                        io.reactivex.exceptions.a.J(th3);
                                        this.s.cancel();
                                        ExceptionHelper.addThrowable(this.error, th3);
                                        cVar.onError(ExceptionHelper.terminate(this.error));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th4) {
                            io.reactivex.exceptions.a.J(th4);
                            this.s.cancel();
                            ExceptionHelper.addThrowable(this.error, th4);
                            Throwable terminate = ExceptionHelper.terminate(this.error);
                            this.current = null;
                            gVar.clear();
                            cVar.onError(terminate);
                            return;
                        }
                    }
                    it = it2;
                    if (it == null) {
                    }
                    addAndGet = addAndGet(-i);
                    if (addAndGet != 0) {
                    }
                }
            }
        }

        void consumedOne(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.s.request(i);
                    return;
                }
                this.consumed = i;
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar, io.reactivex.internal.a.g<?> gVar) {
            if (this.cancelled) {
                this.current = null;
                gVar.clear();
                return true;
            }
            if (z) {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    gVar.clear();
                    cVar.onError(terminate);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            Iterator<? extends R> it = this.current;
            if (it == null) {
                return this.queue.isEmpty();
            }
            return !it.hasNext();
        }

        @Override // io.reactivex.internal.a.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) io.reactivex.internal.functions.a.l(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }
}
