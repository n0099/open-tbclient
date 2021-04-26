package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
@Experimental
/* loaded from: classes7.dex */
public final class CompletableCache extends Completable implements CompletableObserver {
    public static final InnerCompletableCache[] EMPTY = new InnerCompletableCache[0];
    public static final InnerCompletableCache[] TERMINATED = new InnerCompletableCache[0];
    public Throwable error;
    public final AtomicReference<InnerCompletableCache[]> observers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean once = new AtomicBoolean();
    public final CompletableSource source;

    /* loaded from: classes7.dex */
    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        public static final long serialVersionUID = 8943152917179642732L;
        public final CompletableObserver actual;

        public InnerCompletableCache(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public CompletableCache(CompletableSource completableSource) {
        this.source = completableSource;
    }

    public boolean add(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            if (innerCompletableCacheArr == TERMINATED) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        InnerCompletableCache[] andSet;
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        InnerCompletableCache[] andSet;
        this.error = th;
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.actual.onError(th);
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
    }

    public void remove(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (innerCompletableCacheArr[i3] == innerCompletableCache) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = EMPTY;
            } else {
                InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i2);
                System.arraycopy(innerCompletableCacheArr, i2 + 1, innerCompletableCacheArr3, i2, (length - i2) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (add(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                remove(innerCompletableCache);
            }
            if (this.once.compareAndSet(false, true)) {
                this.source.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }
}
