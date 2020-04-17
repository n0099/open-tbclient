package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservablePublishSelector<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {
    final h<? super q<T>, ? extends t<R>> mSn;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        PublishSubject dDr = PublishSubject.dDr();
        try {
            t tVar = (t) io.reactivex.internal.functions.a.h(this.mSn.apply(dDr), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(uVar);
            tVar.subscribe(targetObserver);
            this.source.subscribe(new a(dDr, targetObserver));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            EmptyDisposable.error(th, uVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class a<T, R> implements u<T> {
        final PublishSubject<T> mTy;
        final AtomicReference<io.reactivex.disposables.b> mTz;

        a(PublishSubject<T> publishSubject, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.mTy = publishSubject;
            this.mTz = atomicReference;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mTz, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.mTy.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.mTy.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.mTy.onComplete();
        }
    }

    /* loaded from: classes7.dex */
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
