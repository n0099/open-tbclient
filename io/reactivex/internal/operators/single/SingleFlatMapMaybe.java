package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class SingleFlatMapMaybe<T, R> extends k<R> {
    final h<? super T, ? extends o<? extends R>> mapper;
    final aa<? extends T> source;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapSingleObserver(mVar, this.mapper));
    }

    /* loaded from: classes25.dex */
    static final class FlatMapSingleObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
        private static final long serialVersionUID = -5843758257109742742L;
        final m<? super R> actual;
        final h<? super T, ? extends o<? extends R>> mapper;

        FlatMapSingleObserver(m<? super R> mVar, h<? super T, ? extends o<? extends R>> hVar) {
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

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    oVar.a(new a(this, this.actual));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }

    /* loaded from: classes25.dex */
    static final class a<R> implements m<R> {
        final m<? super R> actual;
        final AtomicReference<io.reactivex.disposables.b> oww;

        a(AtomicReference<io.reactivex.disposables.b> atomicReference, m<? super R> mVar) {
            this.oww = atomicReference;
            this.actual = mVar;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.oww, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(R r) {
            this.actual.onSuccess(r);
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
