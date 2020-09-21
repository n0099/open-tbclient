package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class ObservablePublishSelector<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {
    final h<? super q<T>, ? extends t<R>> oxg;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        PublishSubject ejL = PublishSubject.ejL();
        try {
            t tVar = (t) io.reactivex.internal.functions.a.k(this.oxg.apply(ejL), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(uVar);
            tVar.subscribe(targetObserver);
            this.source.subscribe(new a(ejL, targetObserver));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptyDisposable.error(th, uVar);
        }
    }

    /* loaded from: classes25.dex */
    static final class a<T, R> implements u<T> {
        final PublishSubject<T> oym;
        final AtomicReference<io.reactivex.disposables.b> oyn;

        a(PublishSubject<T> publishSubject, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.oym = publishSubject;
            this.oyn = atomicReference;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.oyn, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.oym.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.oym.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.oym.onComplete();
        }
    }

    /* loaded from: classes25.dex */
    static final class TargetObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<R> {
        private static final long serialVersionUID = 854110278590336484L;
        final u<? super R> actual;
        io.reactivex.disposables.b d;

        TargetObserver(u<? super R> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }
    }
}
