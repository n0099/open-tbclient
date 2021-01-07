package io.reactivex.internal.operators.maybe;

import io.reactivex.aa;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeFlatMapSingleElement<T, R> extends k<R> {
    final h<? super T, ? extends aa<? extends R>> mapper;
    final o<T> source;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapMaybeObserver(mVar, this.mapper));
    }

    /* loaded from: classes5.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4827726964688405508L;
        final m<? super R> actual;
        final h<? super T, ? extends aa<? extends R>> mapper;

        FlatMapMaybeObserver(m<? super R> mVar, h<? super T, ? extends aa<? extends R>> hVar) {
            this.actual = mVar;
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
                ((aa) io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper returned a null SingleSource")).a(new a(this, this.actual));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.O(th);
                onError(th);
            }
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

    /* loaded from: classes5.dex */
    static final class a<R> implements y<R> {
        final m<? super R> actual;
        final AtomicReference<io.reactivex.disposables.b> qil;

        a(AtomicReference<io.reactivex.disposables.b> atomicReference, m<? super R> mVar) {
            this.qil = atomicReference;
            this.actual = mVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.qil, bVar);
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
