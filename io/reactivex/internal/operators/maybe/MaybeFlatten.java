package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {
    final h<? super T, ? extends o<? extends R>> mapper;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapMaybeObserver(mVar, this.mapper));
    }

    /* loaded from: classes17.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4375739915521278546L;
        final m<? super R> actual;
        io.reactivex.disposables.b d;
        final h<? super T, ? extends o<? extends R>> mapper;

        FlatMapMaybeObserver(m<? super R> mVar, h<? super T, ? extends o<? extends R>> hVar) {
            this.actual = mVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                o oVar = (o) io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (!isDisposed()) {
                    oVar.a(new a());
                }
            } catch (Exception e) {
                io.reactivex.exceptions.a.J(e);
                this.actual.onError(e);
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

        /* loaded from: classes17.dex */
        final class a implements m<R> {
            a() {
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.actual.onSuccess(r);
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.actual.onError(th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                FlatMapMaybeObserver.this.actual.onComplete();
            }
        }
    }
}
