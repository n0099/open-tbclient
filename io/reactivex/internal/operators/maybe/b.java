package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
/* loaded from: classes17.dex */
public final class b<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {
    final h<? super T, ? extends R> mapper;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        this.source.a(new a(mVar, this.mapper));
    }

    /* loaded from: classes17.dex */
    static final class a<T, R> implements io.reactivex.disposables.b, m<T> {
        final m<? super R> actual;
        io.reactivex.disposables.b d;
        final h<? super T, ? extends R> mapper;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(m<? super R> mVar, h<? super T, ? extends R> hVar) {
            this.actual = mVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.d;
            this.d = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
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
                this.actual.onSuccess(io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper returned a null item"));
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
