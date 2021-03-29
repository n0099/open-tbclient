package io.reactivex.internal.operators.maybe;

import f.a.h;
import f.a.i;
import f.a.j;
import f.a.t.b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeCache<T> extends h<T> implements i<T> {
    public static final CacheDisposable[] i = new CacheDisposable[0];
    public static final CacheDisposable[] j = new CacheDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<j<T>> f68039e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f68040f;

    /* renamed from: g  reason: collision with root package name */
    public T f68041g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f68042h;

    /* loaded from: classes7.dex */
    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements b {
        public static final long serialVersionUID = -5791853038359966195L;
        public final i<? super T> actual;

        public CacheDisposable(i<? super T> iVar, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.actual = iVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.d(this);
            }
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @Override // f.a.h
    public void b(i<? super T> iVar) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(iVar, this);
        iVar.onSubscribe(cacheDisposable);
        if (c(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                d(cacheDisposable);
                return;
            }
            j<T> andSet = this.f68039e.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
            }
        } else if (cacheDisposable.isDisposed()) {
        } else {
            Throwable th = this.f68042h;
            if (th != null) {
                iVar.onError(th);
                return;
            }
            Object obj = (T) this.f68041g;
            if (obj != null) {
                iVar.onSuccess(obj);
            } else {
                iVar.onComplete();
            }
        }
    }

    public boolean c(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f68040f.get();
            if (cacheDisposableArr == j) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f68040f.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.maybe.MaybeCache$CacheDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void d(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f68040f.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (cacheDisposableArr[i3] == cacheDisposable) {
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
                cacheDisposableArr2 = i;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i2);
                System.arraycopy(cacheDisposableArr, i2 + 1, cacheDisposableArr3, i2, (length - i2) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.f68040f.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // f.a.i
    public void onComplete() {
        CacheDisposable<T>[] andSet;
        for (CacheDisposable<T> cacheDisposable : this.f68040f.getAndSet(j)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onComplete();
            }
        }
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        CacheDisposable<T>[] andSet;
        this.f68042h = th;
        for (CacheDisposable<T> cacheDisposable : this.f68040f.getAndSet(j)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        CacheDisposable<T>[] andSet;
        this.f68041g = t;
        for (CacheDisposable<T> cacheDisposable : this.f68040f.getAndSet(j)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t);
            }
        }
    }
}
