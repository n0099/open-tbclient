package io.reactivex.subjects;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class AsyncSubject<T> extends b<T> {
    static final AsyncDisposable[] nBp = new AsyncDisposable[0];
    static final AsyncDisposable[] nBq = new AsyncDisposable[0];
    Throwable error;
    final AtomicReference<AsyncDisposable<T>[]> subscribers;
    T value;

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.subscribers.get() == nBq) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        io.reactivex.internal.functions.a.h(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != nBq) {
            this.value = t;
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.h(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == nBq) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.value = null;
        this.error = th;
        for (AsyncDisposable<T> asyncDisposable : this.subscribers.getAndSet(nBq)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.u
    public void onComplete() {
        int i = 0;
        if (this.subscribers.get() != nBq) {
            T t = this.value;
            AsyncDisposable<T>[] andSet = this.subscribers.getAndSet(nBq);
            if (t == null) {
                int length = andSet.length;
                while (i < length) {
                    andSet[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i < length2) {
                andSet[i].complete(t);
                i++;
            }
        }
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(uVar, this);
        uVar.onSubscribe(asyncDisposable);
        if (a(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                b(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            uVar.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            asyncDisposable.complete(t);
        } else {
            asyncDisposable.onComplete();
        }
    }

    boolean a(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.subscribers.get();
            if (asyncDisposableArr == nBq) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    void b(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.subscribers.get();
            int length = asyncDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncDisposableArr[i2] == asyncDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncDisposableArr2 = nBp;
                    } else {
                        asyncDisposableArr2 = new AsyncDisposable[length - 1];
                        System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, i);
                        System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(u<? super T> uVar, AsyncSubject<T> asyncSubject) {
            super(uVar);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.b(this);
            }
        }

        void onComplete() {
            if (!isDisposed()) {
                this.actual.onComplete();
            }
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                io.reactivex.e.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
