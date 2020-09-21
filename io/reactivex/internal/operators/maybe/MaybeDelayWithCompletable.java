package io.reactivex.internal.operators.maybe;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class MaybeDelayWithCompletable<T> extends k<T> {
    final e oxQ;
    final o<T> source;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.oxQ.a(new OtherObserver(mVar, this.source));
    }

    /* loaded from: classes25.dex */
    static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b {
        private static final long serialVersionUID = 703409937383992161L;
        final m<? super T> actual;
        final o<T> source;

        OtherObserver(m<? super T> mVar, o<T> oVar) {
            this.actual = mVar;
            this.source = oVar;
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.source.a(new a(this, this.actual));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* loaded from: classes25.dex */
    static final class a<T> implements m<T> {
        final m<? super T> actual;
        final AtomicReference<io.reactivex.disposables.b> oww;

        a(AtomicReference<io.reactivex.disposables.b> atomicReference, m<? super T> mVar) {
            this.oww = atomicReference;
            this.actual = mVar;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.oww, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
