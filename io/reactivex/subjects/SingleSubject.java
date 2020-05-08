package io.reactivex.subjects;

import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleSubject<T> extends w<T> implements y<T> {
    static final SingleDisposable[] mWQ = new SingleDisposable[0];
    static final SingleDisposable[] mWR = new SingleDisposable[0];
    Throwable error;
    T value;
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<SingleDisposable<T>[]> observers = new AtomicReference<>(mWQ);

    SingleSubject() {
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.observers.get() == mWR) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.y
    public void onSuccess(T t) {
        io.reactivex.internal.functions.a.h(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.value = t;
            for (SingleDisposable<T> singleDisposable : this.observers.getAndSet(mWR)) {
                singleDisposable.actual.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.y
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.h(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            for (SingleDisposable<T> singleDisposable : this.observers.getAndSet(mWR)) {
                singleDisposable.actual.onError(th);
            }
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(yVar, this);
        yVar.onSubscribe(singleDisposable);
        if (a(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                b(singleDisposable);
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

    boolean a(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.observers.get();
            if (singleDisposableArr == mWR) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.observers.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    void b(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.observers.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = mWQ;
                    } else {
                        singleDisposableArr2 = new SingleDisposable[length - 1];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, i);
                        System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final y<? super T> actual;

        SingleDisposable(y<? super T> yVar, SingleSubject<T> singleSubject) {
            this.actual = yVar;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
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
