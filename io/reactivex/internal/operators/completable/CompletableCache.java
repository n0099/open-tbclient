package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class CompletableCache extends a implements c {
    static final InnerCompletableCache[] pDj = new InnerCompletableCache[0];
    static final InnerCompletableCache[] pDk = new InnerCompletableCache[0];
    Throwable error;
    final AtomicReference<InnerCompletableCache[]> observers;
    final AtomicBoolean once;
    final e source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(cVar);
        cVar.onSubscribe(innerCompletableCache);
        if (a(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                b(innerCompletableCache);
            }
            if (this.once.compareAndSet(false, true)) {
                this.source.a(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            cVar.onError(th);
        } else {
            cVar.onComplete();
        }
    }

    @Override // io.reactivex.c
    public void onSubscribe(b bVar) {
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        InnerCompletableCache[] andSet;
        this.error = th;
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(pDk)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.actual.onError(th);
            }
        }
    }

    @Override // io.reactivex.c
    public void onComplete() {
        InnerCompletableCache[] andSet;
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(pDk)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.actual.onComplete();
            }
        }
    }

    boolean a(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            if (innerCompletableCacheArr == pDk) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    void b(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = pDj;
                    } else {
                        innerCompletableCacheArr2 = new InnerCompletableCache[length - 1];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, i);
                        System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public final class InnerCompletableCache extends AtomicBoolean implements b {
        private static final long serialVersionUID = 8943152917179642732L;
        final c actual;

        InnerCompletableCache(c cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.b(this);
            }
        }
    }
}
