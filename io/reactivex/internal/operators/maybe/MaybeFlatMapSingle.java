package io.reactivex.internal.operators.maybe;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.w;
import io.reactivex.y;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapSingle<T, R> extends w<R> {
    final h<? super T, ? extends aa<? extends R>> mapper;
    final o<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        this.source.a(new FlatMapMaybeObserver(yVar, this.mapper));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4827726964688405508L;
        final y<? super R> actual;
        final h<? super T, ? extends aa<? extends R>> mapper;

        FlatMapMaybeObserver(y<? super R> yVar, h<? super T, ? extends aa<? extends R>> hVar) {
            this.actual = yVar;
            this.mapper = hVar;
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
            try {
                aa aaVar = (aa) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null SingleSource");
                if (!isDisposed()) {
                    aaVar.a(new a(this, this.actual));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onError(new NoSuchElementException());
        }
    }

    /* loaded from: classes7.dex */
    static final class a<R> implements y<R> {
        final y<? super R> actual;
        final AtomicReference<io.reactivex.disposables.b> mRB;

        a(AtomicReference<io.reactivex.disposables.b> atomicReference, y<? super R> yVar) {
            this.mRB = atomicReference;
            this.actual = yVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.mRB, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(R r) {
            this.actual.onSuccess(r);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }
}
