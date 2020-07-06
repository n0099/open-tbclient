package io.reactivex.subjects;

import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class PublishSubject<T> extends b<T> {
    static final PublishDisposable[] nOM = new PublishDisposable[0];
    static final PublishDisposable[] nON = new PublishDisposable[0];
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(nON);

    public static <T> PublishSubject<T> dQg() {
        return new PublishSubject<>();
    }

    PublishSubject() {
    }

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(uVar, this);
        uVar.onSubscribe(publishDisposable);
        if (a(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                b(publishDisposable);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            uVar.onError(th);
        } else {
            uVar.onComplete();
        }
    }

    boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            if (publishDisposableArr == nOM) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.subscribers.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            if (publishDisposableArr != nOM && publishDisposableArr != nON) {
                int length = publishDisposableArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishDisposableArr[i2] == publishDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = nON;
                    } else {
                        publishDisposableArr2 = new PublishDisposable[length - 1];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.subscribers.get() == nOM) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        io.reactivex.internal.functions.a.k(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != nOM) {
            for (PublishDisposable<T> publishDisposable : this.subscribers.get()) {
                publishDisposable.onNext(t);
            }
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.k(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == nOM) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.error = th;
        for (PublishDisposable<T> publishDisposable : this.subscribers.getAndSet(nOM)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (this.subscribers.get() != nOM) {
            for (PublishDisposable<T> publishDisposable : this.subscribers.getAndSet(nOM)) {
                publishDisposable.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 3562861878281475070L;
        final u<? super T> actual;
        final PublishSubject<T> parent;

        PublishDisposable(u<? super T> uVar, PublishSubject<T> publishSubject) {
            this.actual = uVar;
            this.parent = publishSubject;
        }

        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.e.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }
}
