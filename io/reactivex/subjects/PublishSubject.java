package io.reactivex.subjects;

import f.b.d0.a;
import f.b.o;
import f.b.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class PublishSubject<T> extends a<T> {

    /* loaded from: classes7.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements b {
        public static final long serialVersionUID = 3562861878281475070L;
        public final o<? super T> actual;
        public final PublishSubject<T> parent;

        public PublishDisposable(o<? super T> oVar, PublishSubject<T> publishSubject) {
            this.actual = oVar;
            this.parent = publishSubject;
        }

        @Override // f.b.t.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.c(this);
            }
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                f.b.a0.a.f(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }
    }

    public abstract void c(PublishDisposable<T> publishDisposable);
}
