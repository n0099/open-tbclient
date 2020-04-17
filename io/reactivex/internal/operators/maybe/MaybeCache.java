package io.reactivex.internal.operators.maybe;

import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeCache<T> extends k<T> implements m<T> {
    static final CacheDisposable[] mST = new CacheDisposable[0];
    static final CacheDisposable[] mSU = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<o<T>> mSV;
    final AtomicReference<CacheDisposable<T>[]> observers;
    T value;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(mVar, this);
        mVar.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
                return;
            }
            o<T> andSet = this.mSV.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th = this.error;
            if (th != null) {
                mVar.onError(th);
                return;
            }
            Object obj = (T) this.value;
            if (obj != null) {
                mVar.onSuccess(obj);
            } else {
                mVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }

    @Override // io.reactivex.m
    public void onSuccess(T t) {
        CacheDisposable<T>[] andSet;
        this.value = t;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(mSU)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.m
    public void onError(Throwable th) {
        CacheDisposable<T>[] andSet;
        this.error = th;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(mSU)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }

    @Override // io.reactivex.m
    public void onComplete() {
        CacheDisposable<T>[] andSet;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(mSU)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onComplete();
            }
        }
    }

    boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            if (cacheDisposableArr == mSU) {
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
                        cacheDisposableArr2 = mST;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5791853038359966195L;
        final m<? super T> actual;

        CacheDisposable(m<? super T> mVar, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.actual = mVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }
}
