package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import g.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class SingleFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements r<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public final c<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public b f69241d;
    public volatile Iterator<? extends R> it;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public final AtomicLong requested = new AtomicLong();

    public SingleFlatMapIterableFlowable$FlatMapIterableObserver(c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
        this.actual = cVar;
        this.mapper = hVar;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        this.cancelled = true;
        this.f69241d.dispose();
        this.f69241d = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public void clear() {
        this.it = null;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super R> cVar = this.actual;
        Iterator<? extends R> it = this.it;
        if (this.outputFused && it != null) {
            cVar.onNext(null);
            cVar.onComplete();
            return;
        }
        int i = 1;
        while (true) {
            if (it != null) {
                long j = this.requested.get();
                if (j == Long.MAX_VALUE) {
                    slowPath(cVar, it);
                    return;
                }
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        Object obj = (R) it.next();
                        a.b(obj, "The iterator returned a null value");
                        cVar.onNext(obj);
                        if (this.cancelled) {
                            return;
                        }
                        j2++;
                        try {
                            if (!it.hasNext()) {
                                cVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            f.b.u.a.a(th);
                            cVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        f.b.u.a.a(th2);
                        cVar.onError(th2);
                        return;
                    }
                }
                if (j2 != 0) {
                    f.b.x.i.b.e(this.requested, j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (it == null) {
                it = this.it;
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public boolean isEmpty() {
        return this.it == null;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.f69241d = DisposableHelper.DISPOSED;
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69241d, bVar)) {
            this.f69241d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        try {
            Iterator<? extends R> it = this.mapper.apply(t).iterator();
            if (!it.hasNext()) {
                this.actual.onComplete();
                return;
            }
            this.it = it;
            drain();
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.actual.onError(th);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public R poll() throws Exception {
        Iterator<? extends R> it = this.it;
        if (it != null) {
            R next = it.next();
            a.b(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return next;
        }
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: R, ? super R */
    public void slowPath(c<? super R> cVar, Iterator<? extends R> it) {
        while (!this.cancelled) {
            try {
                cVar.onNext((R) it.next());
                if (this.cancelled) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        cVar.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    f.b.u.a.a(th);
                    cVar.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                f.b.u.a.a(th2);
                cVar.onError(th2);
                return;
            }
        }
    }
}
