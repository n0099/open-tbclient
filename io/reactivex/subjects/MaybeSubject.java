package io.reactivex.subjects;

import f.a.h;
import f.a.i;
import f.a.t.b;
import f.a.x.b.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSubject<T> extends h<T> implements i<T> {
    public static final MaybeDisposable[] i = new MaybeDisposable[0];
    public static final MaybeDisposable[] j = new MaybeDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public T f68108g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f68109h;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f68107f = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f68106e = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements b {
        public static final long serialVersionUID = -7650903191002190468L;
        public final i<? super T> actual;

        public MaybeDisposable(i<? super T> iVar, MaybeSubject<T> maybeSubject) {
            this.actual = iVar;
            lazySet(maybeSubject);
        }

        @Override // f.a.t.b
        public void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
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
        MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(iVar, this);
        iVar.onSubscribe(maybeDisposable);
        if (c(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                d(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f68109h;
        if (th != null) {
            iVar.onError(th);
            return;
        }
        Object obj = (T) this.f68108g;
        if (obj == null) {
            iVar.onComplete();
        } else {
            iVar.onSuccess(obj);
        }
    }

    public boolean c(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.f68106e.get();
            if (maybeDisposableArr == j) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.f68106e.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.MaybeSubject$MaybeDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void d(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.f68106e.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (maybeDisposableArr[i3] == maybeDisposable) {
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
                maybeDisposableArr2 = i;
            } else {
                MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i2);
                System.arraycopy(maybeDisposableArr, i2 + 1, maybeDisposableArr3, i2, (length - i2) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!this.f68106e.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    @Override // f.a.i
    public void onComplete() {
        if (this.f68107f.compareAndSet(false, true)) {
            for (MaybeDisposable<T> maybeDisposable : this.f68106e.getAndSet(j)) {
                maybeDisposable.actual.onComplete();
            }
        }
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f68107f.compareAndSet(false, true)) {
            this.f68109h = th;
            for (MaybeDisposable<T> maybeDisposable : this.f68106e.getAndSet(j)) {
                maybeDisposable.actual.onError(th);
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (this.f68106e.get() == j) {
            bVar.dispose();
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        a.b(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f68107f.compareAndSet(false, true)) {
            this.f68108g = t;
            for (MaybeDisposable<T> maybeDisposable : this.f68106e.getAndSet(j)) {
                maybeDisposable.actual.onSuccess(t);
            }
        }
    }
}
