package io.reactivex.internal.operators.flowable;

import f.b.r;
import f.b.t.b;
import f.b.u.a;
import f.b.w.d;
import f.b.x.c.f;
import f.b.x.e.a.l;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b, l {
    public static final long serialVersionUID = -6178010334400373240L;
    public final r<? super Boolean> actual;
    public final d<? super T, ? super T> comparer;
    public final AtomicThrowable error = new AtomicThrowable();
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;
    public T v1;
    public T v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(r<? super Boolean> rVar, int i, d<? super T, ? super T> dVar) {
        this.actual = rVar;
        this.comparer = dVar;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // f.b.t.b
    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        if (getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    @Override // f.b.x.e.a.l
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            f<T> fVar = this.first.queue;
            f<T> fVar2 = this.second.queue;
            if (fVar != null && fVar2 != null) {
                while (!isDisposed()) {
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
                        this.actual.onSuccess(Boolean.TRUE);
                        return;
                    } else if (z && z3 && z2 != z4) {
                        cancelAndClear();
                        this.actual.onSuccess(Boolean.FALSE);
                        return;
                    } else if (!z2 && !z4) {
                        try {
                            if (!this.comparer.a(t, t2)) {
                                cancelAndClear();
                                this.actual.onSuccess(Boolean.FALSE);
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
            } else if (isDisposed()) {
                this.first.clear();
                this.second.clear();
                return;
            } else if (this.error.get() != null) {
                cancelAndClear();
                this.actual.onError(this.error.terminate());
                return;
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // f.b.x.e.a.l
    public void innerError(Throwable th) {
        if (this.error.addThrowable(th)) {
            drain();
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(this.first.get());
    }

    public void subscribe(g.d.b<? extends T> bVar, g.d.b<? extends T> bVar2) {
        bVar.subscribe(this.first);
        bVar2.subscribe(this.second);
    }
}
