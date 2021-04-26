package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {
    public static final CompletableDisposable[] EMPTY = new CompletableDisposable[0];
    public static final CompletableDisposable[] TERMINATED = new CompletableDisposable[0];
    public Throwable error;
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicReference<CompletableDisposable[]> observers = new AtomicReference<>(EMPTY);

    /* loaded from: classes7.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        public static final long serialVersionUID = -7650903191002190468L;
        public final CompletableObserver actual;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.actual = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    public boolean add(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.observers.get();
            if (completableDisposableArr == TERMINATED) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.observers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.observers.get() == TERMINATED && this.error == null;
    }

    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.observers.get() == TERMINATED && this.error != null;
    }

    public int observerCount() {
        return this.observers.get().length;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.observers.getAndSet(TERMINATED)) {
                completableDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            for (CompletableDisposable completableDisposable : this.observers.getAndSet(TERMINATED)) {
                completableDisposable.actual.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (this.observers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    public void remove(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.observers.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (completableDisposableArr[i3] == completableDisposable) {
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
                completableDisposableArr2 = EMPTY;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i2);
                System.arraycopy(completableDisposableArr, i2 + 1, completableDisposableArr3, i2, (length - i2) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (add(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                remove(completableDisposable);
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
