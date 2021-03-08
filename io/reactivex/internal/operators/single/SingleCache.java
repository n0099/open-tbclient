package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class SingleCache<T> extends w<T> implements y<T> {
    static final CacheDisposable[] qre = new CacheDisposable[0];
    static final CacheDisposable[] qrf = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final aa<? extends T> source;
    T value;
    final AtomicInteger wip;

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(yVar, this);
        yVar.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
            }
            if (this.wip.getAndIncrement() == 0) {
                this.source.a(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            yVar.onError(th);
        } else {
            yVar.onSuccess((T) this.value);
        }
    }

    boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            if (cacheDisposableArr == qrf) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = qre;
                    } else {
                        cacheDisposableArr2 = new CacheDisposable[length - 1];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }

    @Override // io.reactivex.y
    public void onSuccess(T t) {
        CacheDisposable<T>[] andSet;
        this.value = t;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(qrf)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.y
    public void onError(Throwable th) {
        CacheDisposable<T>[] andSet;
        this.error = th;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(qrf)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7514387411091976596L;
        final y<? super T> actual;
        final SingleCache<T> parent;

        CacheDisposable(y<? super T> yVar, SingleCache<T> singleCache) {
            this.actual = yVar;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }
    }
}
