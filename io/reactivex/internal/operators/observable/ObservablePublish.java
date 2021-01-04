package io.reactivex.internal.operators.observable;

import io.reactivex.b.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ObservablePublish<T> extends io.reactivex.c.a<T> {
    final AtomicReference<a<T>> current;
    final t<T> qil;
    final t<T> source;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.qil.subscribe(uVar);
    }

    @Override // io.reactivex.c.a
    public void a(g<? super io.reactivex.disposables.b> gVar) {
        a<T> aVar;
        while (true) {
            aVar = this.current.get();
            if (aVar != null && !aVar.isDisposed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.current);
            if (this.current.compareAndSet(aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z = !aVar.shouldConnect.get() && aVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(aVar);
            if (z) {
                this.source.subscribe(aVar);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            throw ExceptionHelper.Q(th);
        }
    }

    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.disposables.b, u<T> {
        static final InnerDisposable[] qim = new InnerDisposable[0];
        static final InnerDisposable[] qin = new InnerDisposable[0];
        final AtomicReference<a<T>> current;
        final AtomicReference<io.reactivex.disposables.b> s = new AtomicReference<>();
        final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference<>(qim);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        a(AtomicReference<a<T>> atomicReference) {
            this.current = atomicReference;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.observers.get() != qin && this.observers.getAndSet(qin) != qin) {
                this.current.compareAndSet(this, null);
                DisposableHelper.dispose(this.s);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.observers.get() == qin;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.s, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.current.compareAndSet(this, null);
            InnerDisposable<T>[] andSet = this.observers.getAndSet(qin);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.current.compareAndSet(this, null);
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(qin)) {
                innerDisposable.child.onComplete();
            }
        }

        void a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = qim;
                        } else {
                            innerDisposableArr2 = new InnerDisposable[length - 1];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -1100270633763673112L;
        final u<? super T> child;

        InnerDisposable(u<? super T> uVar) {
            this.child = uVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == this;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((a) andSet).a(this);
            }
        }

        void setParent(a<T> aVar) {
            if (!compareAndSet(null, aVar)) {
                aVar.a(this);
            }
        }
    }
}
