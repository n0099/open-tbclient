package io.reactivex.internal.operators.completable;

import f.a.b;
import f.a.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final b actual;
    public int index;
    public final SequentialDisposable sd = new SequentialDisposable();
    public final c[] sources;

    public CompletableConcatArray$ConcatInnerObserver(b bVar, c[] cVarArr) {
        this.actual = bVar;
        this.sources = cVarArr;
    }

    public void next() {
        if (!this.sd.isDisposed() && getAndIncrement() == 0) {
            c[] cVarArr = this.sources;
            while (!this.sd.isDisposed()) {
                int i = this.index;
                this.index = i + 1;
                if (i == cVarArr.length) {
                    this.actual.onComplete();
                    return;
                }
                cVarArr[i].a(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // f.a.b
    public void onComplete() {
        next();
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.b
    public void onSubscribe(f.a.t.b bVar) {
        this.sd.replace(bVar);
    }
}
