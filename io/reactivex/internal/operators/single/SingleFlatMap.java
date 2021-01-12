package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class SingleFlatMap<T, R> extends w<R> {
    final h<? super T, ? extends aa<? extends R>> mapper;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        this.source.a(new SingleFlatMapCallback(yVar, this.mapper));
    }

    /* loaded from: classes5.dex */
    static final class SingleFlatMapCallback<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
        private static final long serialVersionUID = 3258103020495908596L;
        final y<? super R> actual;
        final h<? super T, ? extends aa<? extends R>> mapper;

        SingleFlatMapCallback(y<? super R> yVar, h<? super T, ? extends aa<? extends R>> hVar) {
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

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                aa aaVar = (aa) io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    aaVar.a(new a(this, this.actual));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.O(th);
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* loaded from: classes5.dex */
        static final class a<R> implements y<R> {
            final y<? super R> actual;
            final AtomicReference<io.reactivex.disposables.b> qdJ;

            a(AtomicReference<io.reactivex.disposables.b> atomicReference, y<? super R> yVar) {
                this.qdJ = atomicReference;
                this.actual = yVar;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this.qdJ, bVar);
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
}
