package io.reactivex.subjects;

import f.a.d0.a;
import f.a.o;
import io.reactivex.internal.observers.DeferredScalarDisposable;
/* loaded from: classes7.dex */
public final class AsyncSubject<T> extends a<T> {

    /* loaded from: classes7.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> parent;

        public AsyncDisposable(o<? super T> oVar, AsyncSubject<T> asyncSubject) {
            super(oVar);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.c(this);
            }
        }

        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (isDisposed()) {
                f.a.a0.a.f(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    public abstract void c(AsyncDisposable<T> asyncDisposable);
}
