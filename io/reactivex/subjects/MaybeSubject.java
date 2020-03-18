package io.reactivex.subjects;

import io.reactivex.k;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSubject<T> extends k<T> implements m<T> {
    static final MaybeDisposable[] nDg = new MaybeDisposable[0];
    static final MaybeDisposable[] nDh = new MaybeDisposable[0];
    Throwable error;
    T value;
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<MaybeDisposable<T>[]> observers = new AtomicReference<>(nDg);

    MaybeSubject() {
    }

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.observers.get() == nDh) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.m
    public void onSuccess(T t) {
        io.reactivex.internal.functions.a.h(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.value = t;
            for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(nDh)) {
                maybeDisposable.actual.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.m
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.h(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(nDh)) {
                maybeDisposable.actual.onError(th);
            }
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    @Override // io.reactivex.m
    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(nDh)) {
                maybeDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(mVar, this);
        mVar.onSubscribe(maybeDisposable);
        if (a(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                b(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            mVar.onError(th);
            return;
        }
        Object obj = (T) this.value;
        if (obj == null) {
            mVar.onComplete();
        } else {
            mVar.onSuccess(obj);
        }
    }

    boolean a(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.observers.get();
            if (maybeDisposableArr == nDh) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.observers.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    void b(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.observers.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (maybeDisposableArr[i2] == maybeDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = nDg;
                    } else {
                        maybeDisposableArr2 = new MaybeDisposable[length - 1];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, i);
                        System.arraycopy(maybeDisposableArr, i + 1, maybeDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final m<? super T> actual;

        MaybeDisposable(m<? super T> mVar, MaybeSubject<T> maybeSubject) {
            this.actual = mVar;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
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
