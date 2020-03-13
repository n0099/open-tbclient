package io.reactivex.internal.operators.maybe;

import io.reactivex.c.c;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends a<T, R> {
    final h<? super T, ? extends o<? extends U>> mapper;
    final c<? super T, ? super U, ? extends R> resultSelector;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapBiMainObserver(mVar, this.mapper, this.resultSelector));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapBiMainObserver<T, U, R> implements io.reactivex.disposables.b, m<T> {
        final h<? super T, ? extends o<? extends U>> mapper;
        final InnerObserver<T, U, R> nxQ;

        FlatMapBiMainObserver(m<? super R> mVar, h<? super T, ? extends o<? extends U>> hVar, c<? super T, ? super U, ? extends R> cVar) {
            this.nxQ = new InnerObserver<>(mVar, cVar);
            this.mapper = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.nxQ);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.nxQ.get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.nxQ, bVar)) {
                this.nxQ.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.nxQ, null)) {
                    this.nxQ.value = t;
                    oVar.a(this.nxQ);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.nxQ.actual.onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.nxQ.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.nxQ.actual.onComplete();
        }

        /* loaded from: classes7.dex */
        static final class InnerObserver<T, U, R> extends AtomicReference<io.reactivex.disposables.b> implements m<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final m<? super R> actual;
            final c<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(m<? super R> mVar, c<? super T, ? super U, ? extends R> cVar) {
                this.actual = mVar;
                this.resultSelector = cVar;
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.actual.onSuccess(io.reactivex.internal.functions.a.h(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    this.actual.onError(th);
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
    }
}
