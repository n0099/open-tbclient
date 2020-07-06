package io.reactivex.subjects;

import io.reactivex.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableSubject extends io.reactivex.a implements c {
    static final CompletableDisposable[] nOI = new CompletableDisposable[0];
    static final CompletableDisposable[] nOJ = new CompletableDisposable[0];
    Throwable error;
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicReference<CompletableDisposable[]> observers = new AtomicReference<>(nOI);

    CompletableSubject() {
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.observers.get() == nOJ) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.k(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            for (CompletableDisposable completableDisposable : this.observers.getAndSet(nOJ)) {
                completableDisposable.actual.onError(th);
            }
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    @Override // io.reactivex.c
    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.observers.getAndSet(nOJ)) {
                completableDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.a
    protected void b(c cVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(cVar, this);
        cVar.onSubscribe(completableDisposable);
        if (a(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                b(completableDisposable);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            cVar.onError(th);
        } else {
            cVar.onComplete();
        }
    }

    boolean a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.observers.get();
            if (completableDisposableArr == nOJ) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    void b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.observers.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (completableDisposableArr[i2] == completableDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = nOI;
                    } else {
                        completableDisposableArr2 = new CompletableDisposable[length - 1];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, i);
                        System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final c actual;

        CompletableDisposable(c cVar, CompletableSubject completableSubject) {
            this.actual = cVar;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
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
