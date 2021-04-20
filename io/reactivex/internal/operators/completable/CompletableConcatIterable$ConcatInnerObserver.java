package io.reactivex.internal.operators.completable;

import f.b.b;
import f.b.c;
import f.b.x.b.a;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final b actual;
    public final SequentialDisposable sd = new SequentialDisposable();
    public final Iterator<? extends c> sources;

    public CompletableConcatIterable$ConcatInnerObserver(b bVar, Iterator<? extends c> it) {
        this.actual = bVar;
        this.sources = it;
    }

    public void next() {
        if (!this.sd.isDisposed() && getAndIncrement() == 0) {
            Iterator<? extends c> it = this.sources;
            while (!this.sd.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onComplete();
                        return;
                    }
                    try {
                        c next = it.next();
                        a.b(next, "The CompletableSource returned is null");
                        next.a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        f.b.u.a.a(th);
                        this.actual.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    f.b.u.a.a(th2);
                    this.actual.onError(th2);
                    return;
                }
            }
        }
    }

    @Override // f.b.b
    public void onComplete() {
        next();
    }

    @Override // f.b.b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.b
    public void onSubscribe(f.b.t.b bVar) {
        this.sd.replace(bVar);
    }
}
