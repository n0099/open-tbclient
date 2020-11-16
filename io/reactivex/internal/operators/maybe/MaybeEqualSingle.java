package io.reactivex.internal.operators.maybe;

import io.reactivex.c.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeEqualSingle<T> extends w<Boolean> {
    final d<? super T, ? super T> isEqual;
    final o<? extends T> pPA;
    final o<? extends T> pPB;

    @Override // io.reactivex.w
    protected void b(y<? super Boolean> yVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(yVar, this.isEqual);
        yVar.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.pPA, this.pPB);
    }

    /* loaded from: classes5.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        final y<? super Boolean> actual;
        final d<? super T, ? super T> isEqual;
        final EqualObserver<T> observer1;
        final EqualObserver<T> observer2;

        EqualCoordinator(y<? super Boolean> yVar, d<? super T, ? super T> dVar) {
            super(2);
            this.actual = yVar;
            this.isEqual = dVar;
            this.observer1 = new EqualObserver<>(this);
            this.observer2 = new EqualObserver<>(this);
        }

        void subscribe(o<? extends T> oVar, o<? extends T> oVar2) {
            oVar.a(this.observer1);
            oVar2.a(this.observer2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.observer1.get());
        }

        void done() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj != null && obj2 != null) {
                    try {
                        this.actual.onSuccess(Boolean.valueOf(this.isEqual.j(obj, obj2)));
                        return;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.J(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
            }
        }

        void error(EqualObserver<T> equalObserver, Throwable th) {
            if (getAndSet(0) > 0) {
                if (equalObserver == this.observer1) {
                    this.observer2.dispose();
                } else {
                    this.observer1.dispose();
                }
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class EqualObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final EqualCoordinator<T> parent;
        Object value;

        EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.parent = equalCoordinator;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.parent.done();
        }
    }
}
