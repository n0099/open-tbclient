package io.reactivex.internal.operators.flowable;

import f.a.u.a;
import f.a.w.d;
import f.a.x.c.f;
import f.a.x.e.a.l;
import g.d.b;
import g.d.c;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableSequenceEqual$EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements l {
    public static final long serialVersionUID = -6178010334400373240L;
    public final d<? super T, ? super T> comparer;
    public final AtomicThrowable error;
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;
    public T v1;
    public T v2;
    public final AtomicInteger wip;

    public FlowableSequenceEqual$EqualCoordinator(c<? super Boolean> cVar, int i, d<? super T, ? super T> dVar) {
        super(cVar);
        this.comparer = dVar;
        this.wip = new AtomicInteger();
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        if (this.wip.getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // f.a.x.e.a.l
    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            f<T> fVar = this.first.queue;
            f<T> fVar2 = this.second.queue;
            if (fVar != null && fVar2 != null) {
                while (!isCancelled()) {
                    if (this.error.get() != null) {
                        cancelAndClear();
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    boolean z = this.first.done;
                    T t = this.v1;
                    if (t == null) {
                        try {
                            t = fVar.poll();
                            this.v1 = t;
                        } catch (Throwable th) {
                            a.a(th);
                            cancelAndClear();
                            this.error.addThrowable(th);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                    boolean z2 = t == null;
                    boolean z3 = this.second.done;
                    T t2 = this.v2;
                    if (t2 == null) {
                        try {
                            t2 = fVar2.poll();
                            this.v2 = t2;
                        } catch (Throwable th2) {
                            a.a(th2);
                            cancelAndClear();
                            this.error.addThrowable(th2);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                    boolean z4 = t2 == null;
                    if (z && z3 && z2 && z4) {
                        complete(Boolean.TRUE);
                        return;
                    } else if (z && z3 && z2 != z4) {
                        cancelAndClear();
                        complete(Boolean.FALSE);
                        return;
                    } else if (!z2 && !z4) {
                        try {
                            if (!this.comparer.a(t, t2)) {
                                cancelAndClear();
                                complete(Boolean.FALSE);
                                return;
                            }
                            this.v1 = null;
                            this.v2 = null;
                            this.first.request();
                            this.second.request();
                        } catch (Throwable th3) {
                            a.a(th3);
                            cancelAndClear();
                            this.error.addThrowable(th3);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                }
                this.first.clear();
                this.second.clear();
                return;
            } else if (isCancelled()) {
                this.first.clear();
                this.second.clear();
                return;
            } else if (this.error.get() != null) {
                cancelAndClear();
                this.actual.onError(this.error.terminate());
                return;
            }
            i = this.wip.addAndGet(-i);
        } while (i != 0);
    }

    @Override // f.a.x.e.a.l
    public void innerError(Throwable th) {
        if (this.error.addThrowable(th)) {
            drain();
        } else {
            f.a.a0.a.f(th);
        }
    }

    public void subscribe(b<? extends T> bVar, b<? extends T> bVar2) {
        bVar.subscribe(this.first);
        bVar2.subscribe(this.second);
    }
}
