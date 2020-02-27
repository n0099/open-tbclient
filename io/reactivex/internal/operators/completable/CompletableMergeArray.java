package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableMergeArray extends a {
    final e[] sources;

    @Override // io.reactivex.a
    public void b(c cVar) {
        e[] eVarArr;
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(cVar, new AtomicBoolean(), aVar, this.sources.length + 1);
        cVar.onSubscribe(aVar);
        for (e eVar : this.sources) {
            if (!aVar.isDisposed()) {
                if (eVar == null) {
                    aVar.dispose();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                eVar.a(innerCompletableObserver);
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }

    /* loaded from: classes7.dex */
    static final class InnerCompletableObserver extends AtomicInteger implements c {
        private static final long serialVersionUID = -8360547806504310570L;
        final c actual;
        final AtomicBoolean once;
        final io.reactivex.disposables.a set;

        InnerCompletableObserver(c cVar, AtomicBoolean atomicBoolean, io.reactivex.disposables.a aVar, int i) {
            this.actual = cVar;
            this.once = atomicBoolean;
            this.set = aVar;
            lazySet(i);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            this.set.a(bVar);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }
    }
}
