package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.u.a;
import f.a.w.h;
import f.a.x.c.f;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements g<T> {
    public static final long serialVersionUID = -3096000382929934955L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public int consumed;
    public Iterator<? extends R> current;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;
    public f<T> queue;
    public d s;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableFlattenIterable$FlattenIterableSubscriber(c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar, int i) {
        this.actual = cVar;
        this.mapper = hVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<?> cVar, f<?> fVar) {
        if (this.cancelled) {
            this.current = null;
            fVar.clear();
            return true;
        } else if (z) {
            if (this.error.get() == null) {
                if (z2) {
                    cVar.onComplete();
                    return true;
                }
                return false;
            }
            Throwable b2 = ExceptionHelper.b(this.error);
            this.current = null;
            fVar.clear();
            cVar.onError(b2);
            return true;
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean z) {
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

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f7, code lost:
        if (r13 != r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f9, code lost:
        r5 = r18.done;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ff, code lost:
        if (r3.isEmpty() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0101, code lost:
        if (r6 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010a, code lost:
        if (checkTerminated(r5, r15, r2, r3) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010c, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010f, code lost:
        if (r13 == 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0118, code lost:
        if (r9 == Long.MAX_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011a, code lost:
        r18.requested.addAndGet(-r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (r6 != null) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<?> cVar = this.actual;
        f<T> fVar = this.queue;
        boolean z = this.fusionMode != 1;
        Iterator<? extends R> it = this.current;
        int i = 1;
        while (true) {
            if (it == null) {
                boolean z2 = this.done;
                try {
                    T poll = fVar.poll();
                    if (checkTerminated(z2, poll == null, cVar, fVar)) {
                        return;
                    }
                    if (poll != null) {
                        try {
                            it = this.mapper.apply(poll).iterator();
                            if (!it.hasNext()) {
                                consumedOne(z);
                                it = null;
                            } else {
                                this.current = it;
                            }
                        } catch (Throwable th) {
                            a.a(th);
                            this.s.cancel();
                            ExceptionHelper.a(this.error, th);
                            cVar.onError(ExceptionHelper.b(this.error));
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    a.a(th2);
                    this.s.cancel();
                    ExceptionHelper.a(this.error, th2);
                    Throwable b2 = ExceptionHelper.b(this.error);
                    this.current = null;
                    fVar.clear();
                    cVar.onError(b2);
                    return;
                }
            }
            if (it != null) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    } else if (checkTerminated(this.done, false, cVar, fVar)) {
                        return;
                    } else {
                        try {
                            Object obj = (R) it.next();
                            f.a.x.b.a.b(obj, "The iterator returned a null value");
                            cVar.onNext(obj);
                            if (checkTerminated(this.done, false, cVar, fVar)) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
                                    consumedOne(z);
                                    this.current = null;
                                    it = null;
                                    break;
                                }
                            } catch (Throwable th3) {
                                a.a(th3);
                                this.current = null;
                                this.s.cancel();
                                ExceptionHelper.a(this.error, th3);
                                cVar.onError(ExceptionHelper.b(this.error));
                                return;
                            }
                        } catch (Throwable th4) {
                            a.a(th4);
                            this.current = null;
                            this.s.cancel();
                            ExceptionHelper.a(this.error, th4);
                            cVar.onError(ExceptionHelper.b(this.error));
                            return;
                        }
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        Iterator<? extends R> it = this.current;
        if (it == null) {
            return this.queue.isEmpty();
        }
        return !it.hasNext();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (!this.done && ExceptionHelper.a(this.error, th)) {
            this.done = true;
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0 && !this.queue.offer(t)) {
            onError(new MissingBackpressureException("Queue is full?!"));
        } else {
            drain();
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof f.a.x.c.d) {
                f.a.x.c.d dVar2 = (f.a.x.c.d) dVar;
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
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
        R next = it.next();
        f.a.x.b.a.b(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.current = null;
        }
        return next;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public int requestFusion(int i) {
        return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
    }
}
