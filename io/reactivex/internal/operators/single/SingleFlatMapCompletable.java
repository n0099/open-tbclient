package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class SingleFlatMapCompletable<T> extends io.reactivex.a {
    final h<? super T, ? extends e> mapper;
    final aa<T> source;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(cVar, this.mapper);
        cVar.onSubscribe(flatMapCompletableObserver);
        this.source.a(flatMapCompletableObserver);
    }

    /* loaded from: classes4.dex */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<b> implements c, b, y<T> {
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
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                e eVar = (e) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    eVar.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
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
