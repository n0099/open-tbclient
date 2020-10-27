package io.reactivex.internal.operators.maybe;

import io.reactivex.c.c;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends a<T, R> {
    final h<? super T, ? extends o<? extends U>> mapper;
    final c<? super T, ? super U, ? extends R> resultSelector;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapBiMainObserver(mVar, this.mapper, this.resultSelector));
    }

    /* loaded from: classes17.dex */
    static final class FlatMapBiMainObserver<T, U, R> implements io.reactivex.disposables.b, m<T> {
        final h<? super T, ? extends o<? extends U>> mapper;
        final InnerObserver<T, U, R> pEF;

        FlatMapBiMainObserver(m<? super R> mVar, h<? super T, ? extends o<? extends U>> hVar, c<? super T, ? super U, ? extends R> cVar) {
            this.pEF = new InnerObserver<>(mVar, cVar);
            this.mapper = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.pEF);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.pEF.get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.pEF, bVar)) {
                this.pEF.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.pEF, null)) {
                    this.pEF.value = t;
                    oVar.a(this.pEF);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                this.pEF.actual.onError(th);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.pEF.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.pEF.actual.onComplete();
        }

        /* loaded from: classes17.dex */
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
                    this.actual.onSuccess(io.reactivex.internal.functions.a.l(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
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
