package io.reactivex.internal.operators.maybe;

import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeFlatMapCompletable<T> extends io.reactivex.a {
    final h<? super T, ? extends e> mapper;
    final o<T> source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(cVar, this.mapper);
        cVar.onSubscribe(flatMapCompletableObserver);
        this.source.a(flatMapCompletableObserver);
    }

    /* loaded from: classes7.dex */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2177128922851101253L;
        final c actual;
        final h<? super T, ? extends e> mapper;

        FlatMapCompletableObserver(c cVar, h<? super T, ? extends e> hVar) {
            this.actual = cVar;
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

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                e eVar = (e) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    eVar.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                onError(th);
            }
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
