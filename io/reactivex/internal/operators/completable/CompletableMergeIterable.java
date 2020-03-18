package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableMergeIterable extends a {
    final Iterable<? extends e> nym;

    @Override // io.reactivex.a
    public void b(c cVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        cVar.onSubscribe(aVar);
        try {
            Iterator it = (Iterator) io.reactivex.internal.functions.a.h(this.nym.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(cVar, aVar, atomicInteger);
            while (!aVar.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (!aVar.isDisposed()) {
                            try {
                                e eVar = (e) io.reactivex.internal.functions.a.h(it.next(), "The iterator returned a null CompletableSource");
                                if (!aVar.isDisposed()) {
                                    atomicInteger.getAndIncrement();
                                    eVar.a(mergeCompletableObserver);
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.H(th);
                                aVar.dispose();
                                mergeCompletableObserver.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        mergeCompletableObserver.onComplete();
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.H(th2);
                    aVar.dispose();
                    mergeCompletableObserver.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.H(th3);
            cVar.onError(th3);
        }
    }

    /* loaded from: classes7.dex */
    static final class MergeCompletableObserver extends AtomicBoolean implements c {
        private static final long serialVersionUID = -7730517613164279224L;
        final c actual;
        final io.reactivex.disposables.a set;
        final AtomicInteger wip;

        MergeCompletableObserver(c cVar, io.reactivex.disposables.a aVar, AtomicInteger atomicInteger) {
            this.actual = cVar;
            this.set = aVar;
            this.wip = atomicInteger;
        }

        @Override // io.reactivex.c
        public void onSubscribe(b bVar) {
            this.set.a(bVar);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }
    }
}
