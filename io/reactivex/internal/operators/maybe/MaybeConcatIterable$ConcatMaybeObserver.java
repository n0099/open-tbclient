package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.j;
import f.a.t.b;
import f.a.x.b.a;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeConcatIterable$ConcatMaybeObserver<T> extends AtomicInteger implements i<T>, d {
    public static final long serialVersionUID = 3520831347801429610L;
    public final c<? super T> actual;
    public long produced;
    public final Iterator<? extends j<? extends T>> sources;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable disposables = new SequentialDisposable();
    public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

    public MaybeConcatIterable$ConcatMaybeObserver(c<? super T> cVar, Iterator<? extends j<? extends T>> it) {
        this.actual = cVar;
        this.sources = it;
    }

    @Override // g.d.d
    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference<Object> atomicReference = this.current;
        c<? super T> cVar = this.actual;
        SequentialDisposable sequentialDisposable = this.disposables;
        while (!sequentialDisposable.isDisposed()) {
            Object obj = atomicReference.get();
            if (obj != null) {
                boolean z = true;
                if (obj != NotificationLite.COMPLETE) {
                    long j = this.produced;
                    if (j != this.requested.get()) {
                        this.produced = j + 1;
                        atomicReference.lazySet(null);
                        cVar.onNext(obj);
                    } else {
                        z = false;
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (z && !sequentialDisposable.isDisposed()) {
                    try {
                        if (this.sources.hasNext()) {
                            try {
                                j<? extends T> next = this.sources.next();
                                a.b(next, "The source Iterator returned a null MaybeSource");
                                next.a(this);
                            } catch (Throwable th) {
                                f.a.u.a.a(th);
                                cVar.onError(th);
                                return;
                            }
                        } else {
                            cVar.onComplete();
                        }
                    } catch (Throwable th2) {
                        f.a.u.a.a(th2);
                        cVar.onError(th2);
                        return;
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // f.a.i
    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        this.disposables.replace(bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.current.lazySet(t);
        drain();
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.a.x.i.b.a(this.requested, j);
            drain();
        }
    }
}
