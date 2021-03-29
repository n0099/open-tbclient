package io.reactivex.subjects;

import f.a.q;
import f.a.r;
import f.a.t.b;
import f.a.x.b.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleSubject<T> extends q<T> implements r<T> {
    public static final SingleDisposable[] i = new SingleDisposable[0];
    public static final SingleDisposable[] j = new SingleDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public T f68117g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f68118h;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f68116f = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f68115e = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements b {
        public static final long serialVersionUID = -7650903191002190468L;
        public final r<? super T> actual;

        public SingleDisposable(r<? super T> rVar, SingleSubject<T> singleSubject) {
            this.actual = rVar;
            lazySet(singleSubject);
        }

        @Override // f.a.t.b
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.d(this);
            }
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: T, ? super T */
    @Override // f.a.q
    public void b(r<? super T> rVar) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(rVar, this);
        rVar.onSubscribe(singleDisposable);
        if (c(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                d(singleDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f68118h;
        if (th != null) {
            rVar.onError(th);
        } else {
            rVar.onSuccess((T) this.f68117g);
        }
    }

    public boolean c(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f68115e.get();
            if (singleDisposableArr == j) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f68115e.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.SingleSubject$SingleDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void d(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f68115e.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (singleDisposableArr[i3] == singleDisposable) {
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
                singleDisposableArr2 = i;
            } else {
                SingleDisposable[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i2);
                System.arraycopy(singleDisposableArr, i2 + 1, singleDisposableArr3, i2, (length - i2) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!this.f68115e.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f68116f.compareAndSet(false, true)) {
            this.f68118h = th;
            for (SingleDisposable<T> singleDisposable : this.f68115e.getAndSet(j)) {
                singleDisposable.actual.onError(th);
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (this.f68115e.get() == j) {
            bVar.dispose();
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        a.b(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f68116f.compareAndSet(false, true)) {
            this.f68117g = t;
            for (SingleDisposable<T> singleDisposable : this.f68115e.getAndSet(j)) {
                singleDisposable.actual.onSuccess(t);
            }
        }
    }
}
