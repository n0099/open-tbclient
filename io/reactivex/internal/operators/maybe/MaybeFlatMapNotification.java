package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeFlatMapNotification<T, R> extends a<T, R> {
    final Callable<? extends o<? extends R>> onCompleteSupplier;
    final h<? super Throwable, ? extends o<? extends R>> onErrorMapper;
    final h<? super T, ? extends o<? extends R>> onSuccessMapper;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new FlatMapMaybeObserver(mVar, this.onSuccessMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* loaded from: classes5.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4375739915521278546L;
        final m<? super R> actual;
        io.reactivex.disposables.b d;
        final Callable<? extends o<? extends R>> onCompleteSupplier;
        final h<? super Throwable, ? extends o<? extends R>> onErrorMapper;
        final h<? super T, ? extends o<? extends R>> onSuccessMapper;

        FlatMapMaybeObserver(m<? super R> mVar, h<? super T, ? extends o<? extends R>> hVar, h<? super Throwable, ? extends o<? extends R>> hVar2, Callable<? extends o<? extends R>> callable) {
            this.actual = mVar;
            this.onSuccessMapper = hVar;
            this.onErrorMapper = hVar2;
            this.onCompleteSupplier = callable;
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
                ((o) io.reactivex.internal.functions.a.h(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).a(new a());
            } catch (Exception e) {
                io.reactivex.exceptions.a.I(e);
                this.actual.onError(e);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            try {
                ((o) io.reactivex.internal.functions.a.h(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).a(new a());
            } catch (Exception e) {
                io.reactivex.exceptions.a.I(e);
                this.actual.onError(new CompositeException(th, e));
            }
        }

        @Override // io.reactivex.m
        public void onComplete() {
            try {
                ((o) io.reactivex.internal.functions.a.h(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).a(new a());
            } catch (Exception e) {
                io.reactivex.exceptions.a.I(e);
                this.actual.onError(e);
            }
        }

        /* loaded from: classes5.dex */
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
