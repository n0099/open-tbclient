package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeOnErrorNext<T> extends a<T, T> {
    final boolean allowFatal;
    final h<? super Throwable, ? extends o<? extends T>> resumeFunction;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new OnErrorNextMaybeObserver(mVar, this.resumeFunction, this.allowFatal));
    }

    /* loaded from: classes5.dex */
    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 2026620218879969836L;
        final m<? super T> actual;
        final boolean allowFatal;
        final h<? super Throwable, ? extends o<? extends T>> resumeFunction;

        OnErrorNextMaybeObserver(m<? super T> mVar, h<? super Throwable, ? extends o<? extends T>> hVar, boolean z) {
            this.actual = mVar;
            this.resumeFunction = hVar;
            this.allowFatal = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                o oVar = (o) io.reactivex.internal.functions.a.l(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                DisposableHelper.replace(this, null);
                oVar.a(new a(this.actual, this));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }

        /* loaded from: classes5.dex */
        static final class a<T> implements m<T> {
            final m<? super T> actual;
            final AtomicReference<io.reactivex.disposables.b> d;

            a(m<? super T> mVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.actual = mVar;
                this.d = atomicReference;
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.d, bVar);
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
}
